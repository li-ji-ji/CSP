//package cn.lhj.csp.admin.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import cn.lhj.csp.admin.dto.AssoSchoolUnitDto;
//import cn.lhj.csp.admin.feign.AssoManagementApiInterface;
//import cn.lhj.csp.admin.po.asso.CspAssoSchoolUnit;
//
//@Controller
//@RequestMapping("/schoolUnit")
//public class CspAssoSchoolUnitController {
//
//	@Autowired
//	private AssoManagementApiInterface assoSchoolUnit;
//	
//	//跳转到所有部门列表
//	@RequestMapping("/toSchoolUnitTable")
//	public String toSchoolUnitTable(Model model)throws Exception{
//		List<CspAssoSchoolUnit> schoolUnit=assoSchoolUnit.getUnitAll();
//		model.addAttribute("schoolUnit",schoolUnit);
//		return "ftl/asso/schoolUnit/Table";
//	}
//	
//	//根据学校跳转到附属部门列表
//	@RequestMapping("/toUnitOfSchoolTable")
//	public String toUnitOfSchoolTable(@RequestParam("schoolNo") String schoolNo,Model model)throws Exception{
//		List<CspAssoSchoolUnit> schoolUnit=assoSchoolUnit.getUnitByPNo(schoolNo);
//		model.addAttribute("schoolUnit",schoolUnit);
//		return "ftl/asso/schoolUnit/Table";
//	}
//	
//	//跳转到添加页面
//	@RequestMapping("/toAddUnit")
//	public String toAddForm()throws Exception{
//		return "ftl/asso/schoolUnit/AddForm";
//	}
//	
//	//跳转到修改页面
//	@RequestMapping("/toEditUnit")
//	public String toEditUnit(@RequestParam("id") Integer id,Model model)throws Exception{
//		Object schoolUnit=assoSchoolUnit.getUnitById(id);
//		model.addAttribute("schoolUnit", schoolUnit);
//		return "ftl/asso/schoolUnit/EditForm";
//	}
//	
//	//删除单个部门
//	@RequestMapping("/deleteUnitOne")
//	public String deleteUnitOne(@RequestParam("id") Integer id)throws Exception{
//		assoSchoolUnit.deleteUnitOne(id);
//		return "redirect:toSchoolUnitTable";
//	}
//	
//	
//	//添加单个学校部门
//	@RequestMapping("/insertUnitOne")
//	public String insertUnitOne(AssoSchoolUnitDto unit)throws Exception{
//		assoSchoolUnit.insertUnitOne(unit);
//		return "redirect:toSchoolUnitTable";
//	}
//	
//	//修改单个学校部门
//	@RequestMapping("/updateUnitOne")
//	public String updateUnitOne(AssoSchoolUnitDto unit)throws Exception{
//		return "redirect:toSchoolUnitTable";
//	}
//}
