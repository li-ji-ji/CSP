package cn.yzj.shop.service.implement;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yzj.shop.mapper.SearchWordMapper;
import cn.yzj.shop.po.Msg;
import cn.yzj.shop.po.SearchWord;
import cn.yzj.shop.po.SearchWordExample;
import cn.yzj.shop.service.SearchWordService;
import cn.yzj.shop.systemclass.Code;

/**
 * 关键词搜索实现类
 */
@Service
public class SearchWordServiceImp implements SearchWordService{

	@Autowired
	private SearchWordMapper searchWordMapper; 
	
	Msg msg = new Msg();
	
	@Override
	public Msg add(Serializable id) throws Exception {
		//添加搜索关键词
		if (searchWordMapper.insertSelective((SearchWord) id) >0 ) {
			msg.setCode(Code.SUCCESS.getCode());
			msg.setMsg(Code.SUCCESS.getMsg());
		}else {
			msg.setCode(Code.FAIL.getCode());
			msg.setMsg(Code.FAIL.getMsg());
		}
		return msg;
	}

	@Override
	public Msg delete(Serializable id) throws Exception {
		//根据ID删除一条搜索关键词
		if(searchWordMapper.deleteByPrimaryKey((Integer) id)>0) {
			msg.setCode(Code.SUCCESS.getCode());
			msg.setMsg(Code.SUCCESS.getMsg());
		}else {
			msg.setCode(Code.FAIL.getCode());
			msg.setMsg(Code.FAIL.getMsg());
		}
		
		return msg;
	}

	@Override
	public Msg updata(Serializable id) throws Exception {
		//修改搜索关键词
		if (searchWordMapper.updateByPrimaryKeySelective((SearchWord) id) > 0) {
			msg.setCode(Code.SUCCESS.getCode());
			msg.setMsg(Code.SUCCESS.getMsg());
		}else {
			msg.setCode(Code.FAIL.getCode());
			msg.setMsg(Code.FAIL.getMsg());
		}
		return msg;
	}

	@Override
	public Serializable find(Serializable id) throws Exception {
		//根据关键词ID查询一条信息
		SearchWord searchWord = searchWordMapper.selectByPrimaryKey((Integer) id);
		return searchWord;
	}

	@Override
	public Serializable find() throws Exception {
		//获取所有搜索关键词,按搜索次数降序
		SearchWordExample example = new SearchWordExample();
		example.setOrderByClause("search_num DESC");
		List<SearchWord> searchWords = searchWordMapper.selectByExample(example);
		return (Serializable) searchWords;
	}

	@Override
	public Serializable dataPage(int limit, int page, Serializable id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable dataPage(int limit, int page) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Msg batchDeleteSearchWord(List<Integer> idList) throws Exception {
		//批量删除搜索关键词
		SearchWordExample example = new SearchWordExample();
		example.createCriteria().andIdIn(idList);
		if(searchWordMapper.deleteByExample(example) > 0) {
			msg.setCode(Code.SUCCESS.getCode());
			msg.setMsg(Code.SUCCESS.getMsg());
		}else {
			msg.setCode(Code.FAIL.getCode());
			msg.setMsg(Code.FAIL.getMsg());
		}
		
		return msg;
	}

	@Override
	public List<SearchWord> findSearchWordByFieldLike(String field,String content) throws Exception {
		//根据字段模糊查询搜索关键词信息,按搜索数量降序
		SearchWordExample example = new SearchWordExample();
		
		List<SearchWord> searchWords = null;
		
		if(field!=null&&"keywords".equals(field)) {
			example.createCriteria().andKeywordsLike("%"+content+"%");
		}
		if(field!=null&&"pinyinFull".equals(field)) {
			example.createCriteria().andPinyinFullLike("%"+content+"%");
		}
		if(field!=null&&"pinyinSimple".equals(field)) {
			example.createCriteria().andPinyinSimpleLike("%"+content+"%");
		}
		
		example.setOrderByClause("search_num DESC");
		searchWords = searchWordMapper.selectByExample(example);
		return searchWords;
		
	}

}
