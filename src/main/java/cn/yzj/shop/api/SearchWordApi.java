package cn.yzj.shop.api;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.yzj.shop.po.Msg;
import cn.yzj.shop.po.SearchWord;
import cn.yzj.shop.service.SearchWordService;

@RestController
@RequestMapping("/api")
public class SearchWordApi {

	@Autowired
	private SearchWordService searchWordService;
	
	//获取所有搜索关键词,按搜索次数降序
	@RequestMapping("/getAllSearchWord")
	public Serializable getAllSearchWord() throws Exception{
		
		return searchWordService.find();
	}
	
	//根据实体修改一条关键词
	@RequestMapping("/updateSearchWord")
	public Msg updateFriendLink(SearchWord searchWord) throws Exception{
		return searchWordService.updata(searchWord);
	}
	
	//根据关键词ID查询一条信息
	@RequestMapping("/getSearchWordById")
	public Serializable getFriendLinkById(@RequestParam("id") Integer id) throws Exception {
		return searchWordService.find(id);
	}
	
	//根据实体添加一条搜索关键词
	@RequestMapping("/addSearchWord")
	public Msg addFriendLink(SearchWord searchWord) throws Exception {
		return searchWordService.add(searchWord);
	}
	
	//根据ID删除一条搜索关键词
	@RequestMapping("/deleteSearchWord")
	public Msg deleteSearchWord(@RequestParam("id") Integer id) throws Exception{
		return searchWordService.delete(id);
	}
	
	//批量删除搜索关键词
	@RequestMapping("/batchDeleteSearchWord")
	public Msg batchDeleteSearchWord(@RequestParam("idList") List<Integer> idList) throws Exception {
		return searchWordService.batchDeleteSearchWord(idList);
	}
	
	//根据字段模糊查询搜索关键词信息
	@RequestMapping("/findSearchWordByFieldLike")
	public List<SearchWord> findSearchWordByFieldLike(@RequestParam("field") String field,@RequestParam("content") String content) throws Exception {
		return searchWordService.findSearchWordByFieldLike(field, content);
	}
	
}
