package cn.lhj.csp.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.lhj.csp.admin.dto.AssoSchoolDto;
import cn.lhj.csp.admin.feign.AssoManagementApiInterface;
import cn.lhj.csp.admin.po.asso.CspAssoSchool;

@Controller
@RequestMapping("/assoSchool")
public class CspAssoSchoolController {
	
	@Autowired
	private AssoManagementApiInterface assoSchool;
	
	//跳转到学校列表
	@RequestMapping("/toSchoolTbale")
	public String toSchoolTbale(Model model)throws Exception{
		List<CspAssoSchool> schoolList=assoSchool.getAssoSchoolAll();
		model.addAttribute("schoolList",schoolList);
		return "ftl/asso/school/Table";
	}
	
	//删除单条学校信息
	@RequestMapping("/deleteOneFromTable")
	public String deleteOneFromTable(@RequestParam("id") Integer id)throws Exception{
		assoSchool.deleteAssoSchoolOneById(id);
		return "redirect:toSchoolTbale";
	}
	
	//跳转到学校信息修改表单
	@RequestMapping("/toEditForm")
	public String toEditSchool(@RequestParam("id") Integer id,Model model)throws Exception{
		Object school=assoSchool.getAssoSchoolById(id);
		model.addAttribute("school", school);
		return "ftl/asso/school/EditForm";
	}
	
	//跳转到学校添加表单
	@RequestMapping("/toAddSchool")
	public String toAddSchool(Model model)throws Exception{
		return "ftl/asso/school/AddForm";
	}
	
	//添加单条学校信息
	@RequestMapping("/insertSchoolOne")
	public String insertSchoolOne(AssoSchoolDto school)throws Exception{
		System.out.println(school.getSchoolName());
		assoSchool.insertAssoSchoolOne(school);
		return "redirect:toSchoolTbale";
	}
	
	//更新单条学校信息
	@RequestMapping("/updateSchoolOne")
	public String updateSchoolOne(AssoSchoolDto school)throws Exception{
		System.out.println(school.getSchoolName());
		assoSchool.updateAssoSchoolOne(school);
		return "redirect:toSchoolTbale";
	}
	
	//批量删除学校信息
	@RequestMapping("/deleteSchoolList")
	public int deleteSchoolList(@RequestParam("idList") List<Integer> idList)throws Exception{
		return assoSchool.deleteAssoSchoolListById(idList);
	}
}
