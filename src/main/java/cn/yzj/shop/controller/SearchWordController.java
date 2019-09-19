package cn.yzj.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.yzj.shop.po.Msg;
import cn.yzj.shop.po.SearchWord;
import cn.yzj.shop.service.SearchWordService;

@Controller
@RequestMapping("/searchword")
public class SearchWordController {

	@Autowired
	private SearchWordService searchWordService;
	
	//跳到搜索关键词列表
	@RequestMapping("/toSearchWordList")
	public String toSearchWordList(ModelMap modelmap) throws Exception{
		
		List<SearchWord> searchWords = (List<SearchWord>) searchWordService.find();
		modelmap.addAttribute("searchWords", searchWords);
		
		return "searchword/searchwordlist";
	}
	
	//跳到搜索关键词编辑
	@RequestMapping("/toSearchWordEdit")
	public String toSearchWordEdit(ModelMap modelmap,@RequestParam("id") Integer id) throws Exception{
		//根据关键词ID查询一条信息
		SearchWord searchWord = (SearchWord) searchWordService.find(id);
		modelmap.addAttribute("searchWord",searchWord);
		return "searchword/searchwordedit";
	}
	
	//修改关键词信息
	@RequestMapping("/updateSearchWord")
	public String updateSearchWord(SearchWord searchWord) throws Exception{
		
		Msg msg = searchWordService.updata(searchWord);
		System.out.println(msg.getCode()+"---"+msg.getMsg());
		
		return "redirect:toSearchWordList";
	}
	
	//跳到关键词添加
	@RequestMapping("/toSearchWordAdd")
	public String toSearchWordAdd(ModelMap modelmap) {
		
		
		return "searchword/searchwordadd";
	}
	
	//添加一条搜索关键词
	@RequestMapping("/addSearchWord")
	public String addSearchWord(SearchWord searchWord) throws Exception{
		
		Msg msg = searchWordService.add(searchWord);
		System.out.println(msg.getCode()+"---"+msg.getMsg());
		
		return "redirect:toSearchWordList";
	}
	
	//根据ID删除一条搜索关键词
	@RequestMapping("/deleteSearchWord")
	public String deleteSearchWord(@RequestParam("id") Integer id) throws Exception{
		Msg msg = searchWordService.delete(id);
		System.out.println(msg.getCode()+"---"+msg.getMsg());
		return "redirect:toSearchWordList";
	}
	
	//根据字段模糊查询搜索关键词信息
	@RequestMapping("/findSearchWordByFieldLike")
	public String findSearchWordByFieldLike(ModelMap modelmap,@RequestParam("field") String field,
			@RequestParam("content") String content) throws Exception {
		
		List<SearchWord> searchWords = (List<SearchWord>) searchWordService.findSearchWordByFieldLike(field, content);
		modelmap.addAttribute("searchWords", searchWords);
		
		return "searchword/searchwordlist";
	}
	
}
