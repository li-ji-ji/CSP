package cn.lhj.csp.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.lhj.csp.admin.dto.AssoActivityFormDto;
import cn.lhj.csp.admin.feign.AssoManagementApiInterface;
import cn.lhj.csp.admin.po.asso.CspAssoManagement;
import cn.lhj.csp.admin.po.asso.CspAssoStudent;

@Controller
@RequestMapping("/assoAct")
public class CspAssoActivityController {
	
	@Autowired
	private AssoManagementApiInterface assoAct;
	
	//跳转到所有活动页面
	@RequestMapping("/toActTable")
	public String toActTable(Model model) throws Exception {
		Object activityList=assoAct.getActivityAll();
		model.addAttribute("activityList", activityList);
		return "ftl/asso/activity/Table";
	}
	
	//跳转到社团活动页面
	@RequestMapping("/toAssoActTable")
	public String toAssoActTable(@RequestParam("assoId") String assoId,Model model) throws Exception {
		Object activityList=assoAct.getActivityByAId(assoId);
		model.addAttribute("activityList", activityList);
		return "ftl/asso/activity/Table";
	}
	
	//删除单个活动
	@RequestMapping("/deleteActivityOneById")
	public String deleteActivityOneById(@RequestParam("id") Integer id)throws Exception{
		assoAct.deleteActivityOneById(id);
		return "redirect:toActTable";
	}
	
	//跳转到修改页面
	@RequestMapping("/toActEditForm")
	public String toActEditForm(@RequestParam("id") Integer id,Model model)throws Exception{
		AssoActivityFormDto assoActivityForm=assoAct.getAssoActFormDto(id);
		model.addAttribute("assoActivityForm", assoActivityForm);
		return "ftl/asso/activity/EditForm";
	}
	
	//更新单个活动数据
	@RequestMapping("/updateActOne")
	public String updateActOne( AssoActivityFormDto act)throws Exception{
		assoAct.updateActivityOne(act);
		return "redirect:toActTable";
	}
	
	//更新活动状态为开启
	@RequestMapping("/updateActivityStatusOpen")
	public String updateActivityStatusOpen(@RequestParam("id") Integer id)throws Exception{
		assoAct.updateActivityStatusOpen(id);
		return "redirect:toActTable";
	}
	//更新活动状态为结束
	@RequestMapping("/updateActivityStatusClose")
	public String updateActivityStatusClose(@RequestParam("id") Integer id)throws Exception{
		assoAct.updateActivityStatusClose(id);
		return "redirect:toActTable";
	}
	
	//跳转到添加页面
	@RequestMapping("/toActAddForm")
	public String toActEditForm(Model model)throws Exception{
		List<CspAssoManagement> assoList=assoAct.getAll();
		List<CspAssoStudent> stuList=assoAct.getStuAll();
		model.addAttribute("assoList", assoList);
		model.addAttribute("stuList", stuList);
		return "ftl/asso/activity/AddForm";
	}
	
	//添加一个新的活动
	@RequestMapping("/insertActivity")
	public String insertActicity(AssoActivityFormDto act)throws Exception{
		assoAct.insertActicity(act);
		return "redirect:toActTable";
	}
}
