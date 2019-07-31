package cn.lhj.csp.region.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.lhj.csp.admin.feign.AdminMenuApiInterface;
import cn.lhj.csp.region.po.Region2;
import cn.lhj.csp.region.po.Region2Example;

@Controller
@RequestMapping("/region")
public class Region2Controller {

	 @Autowired
	 private AdminMenuApiInterface regionApiInterface;
	 
	 
	 
	 //跳到地区列表
	 @RequestMapping("/index")
		public String index() {
			return "ftl/region/regionManage";
	}
	 
	 @RequestMapping(value="/toedit")
		public String toEdit(Model model,Integer id,String operation){
			
			if (operation.equals("edit")) {
				
				Region2 region=regionApiInterface.selectByPrimaryKey(id);
				int parentId=region.getParentId();
				if(parentId==0) {
					region.setParentName("中国");
		    	}
		    	else {
		    		region.setParentName(regionApiInterface.findNameByParentId(parentId));
		    	}
				
				Region2Example example=new Region2Example();
				int count=regionApiInterface.countByExample(example);
				Integer page=1;
				Integer limit=50;
				String keyWord="nullable";
				List<Region2> data=regionApiInterface.queryAllDataFromTable(page,limit,keyWord);
			    for(Region2 item:data) {
			    	if(item.getParentId()==0) {
			    		item.setParentName("中国");
			    	}
			    	else {
			    		item.setParentName(regionApiInterface.findNameByParentId(item.getParentId()));
			    	}
			    }
			    
			 
				
				
				model.addAttribute("region",region);
				model.addAttribute("regions",data);
				
				
				
				return "ftl/region/edit";
			}
			else if(operation.equals("add")) {
				Region2 region=regionApiInterface.selectByPrimaryKey(id);
				int parentId=region.getParentId();
				if(parentId==0) {
					region.setParentName("中国");
		    	}
		    	else {
		    		region.setParentName(regionApiInterface.findNameByParentId(parentId));
		    	}
				
				model.addAttribute("region",region);
				
				return "ftl/region/add";
			}
			
			else if(operation.equals("addany")) {
				
				Region2Example example=new Region2Example();
				int count=regionApiInterface.countByExample(example);
				Integer page=1;
				Integer limit=50;
				String keyWord="nullable";
				List<Region2> data=regionApiInterface.queryAllDataFromTable(page,limit,keyWord);
			    for(Region2 item:data) {
			    	if(item.getParentId()==0) {
			    		item.setParentName("中国");
			    	}
			    	else {
			    		item.setParentName(regionApiInterface.findNameByParentId(item.getParentId()));
			    	}
			    }
				
				
				model.addAttribute("regions",data);
				
				return "ftl/region/addany";
			}
			
				
			
			return "ftl/region/edit";
		}
		
		
		
		@RequestMapping(value="/edit")
		public String edit(Region2 region2){
			if(region2.getId()!=null){
				regionApiInterface.updateByPrimaryKey(region2);
				
				//若有子地区，更新其子地区信息,递归方法
				recursiveUpdate(region2);
				
				
				
			}
		
			
			
			return "redirect:index";
		}
		
		@Transactional
		public void recursiveUpdate(Region2 region2) {
			List<Region2> regions=regionApiInterface.selectSingleStageById(region2.getId());
			if(regions!=null) {
				for(Region2 region:regions) {
					region.setLevel(region2.getLevel()+1);
					regionApiInterface.updateByPrimaryKey(region);
					recursiveUpdate(region);

					 
				}
			}
		}
		
		@RequestMapping(value="/add")
		public String add(Region2 region2){
			
			regionApiInterface.insertSelective(region2);
			
			return "redirect:index";
		}
		
		
		@RequestMapping(value="/delete")
		public String delete(Integer id){
			Region2 region2=regionApiInterface.selectByPrimaryKey(id);
			
			//若有子地区，删除其子地区信息,递归方法
			recursiveDelete(region2);
			
			return "redirect:index";
		}
		
		@Transactional
		public void recursiveDelete(Region2 region2) {
			List<Region2> regions=regionApiInterface.selectSingleStageById(region2.getId());
			if(regions!=null) {
				for(Region2 region:regions) {
					recursiveDelete(region);
				}
			}
			regionApiInterface.deleteByPrimaryKey(region2.getId());
		}
	 
	 
	 
	
}
