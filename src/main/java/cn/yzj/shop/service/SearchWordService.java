package cn.yzj.shop.service;

import java.util.List;

import cn.yzj.shop.po.Msg;
import cn.yzj.shop.po.SearchWord;

/**
 * 
 * @author jhj
 * @description 关键词搜索
 *
 */
public interface SearchWordService extends ShopService {
	//批量删除搜索关键词
	public Msg batchDeleteSearchWord(List<Integer> idList)throws Exception;
	
	//根据字段模糊查询搜索关键词信息
	public List<SearchWord> findSearchWordByFieldLike(String field,String content)throws Exception;
}
