package cn.lhj.csp.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lhj.csp.admin.feign.AssoManagementApiInterface;
import cn.lhj.csp.admin.po.asso.CspAssoStudent;

@Controller
@RequestMapping("/csp/assoStu")
public class CspAssoStudentController {
	
	@Autowired
	private AssoManagementApiInterface assoStudent;
	
	//跳转到学生列表
	@RequestMapping("/toStuTable")
	public String toStuTable(Model model)throws Exception{
		List<CspAssoStudent> stuList=assoStudent.getStuAll();
		//System.out.println(stuList.toString());
		model.addAttribute("stuList", stuList);
		return "ftl/asso/student/Table";
	}
	
	//跳转到编辑表单
	@RequestMapping("/toStuEdit")
	public String toEditForm(@RequestParam("id")Integer id,Model model)throws Exception{
		Object stu=assoStudent.getStuById(id);
		model.addAttribute("stu", stu);	
		return "ftl/asso/student/EditForm";
	}
	
	//删除单个学生
	@RequestMapping("/deleteStuOne")
	public String deleteStuOne(@RequestParam("id") Integer id)throws Exception{
		assoStudent.deleteStuOneById(id);
		return "redirect:toStuTable";
	}
	
	//批量删除学生
	@RequestMapping("/deleteStuList")
	@ResponseBody
	public int deleteStuList(@RequestParam("idList") List<Integer>idList)throws Exception{
		return assoStudent.deleteStuListById(idList);
	}
}
