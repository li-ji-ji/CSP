//package cn.lhj.csp.admin.controller;
//
//import java.util.List;
//
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.alibaba.fastjson.JSON;
//
//import cn.lhj.csp.admin.dto.AssoManagemrntDto;
//import cn.lhj.csp.admin.dto.AssoSchoolDto;
//import cn.lhj.csp.admin.feign.AssoManagementApiInterface;
//import cn.lhj.csp.admin.po.asso.CspAssoGuider;
//import cn.lhj.csp.admin.po.asso.CspAssoManagement;
//import cn.lhj.csp.admin.po.asso.CspAssoSchool;
//import cn.lhj.csp.admin.po.asso.CspAssoSchoolUnit;
//import cn.lhj.csp.admin.po.asso.CspAssoStuRelation;
//
//@Controller
//@RequestMapping("/asso")
//public class CspAssoManagementPageController {
//
//	@Autowired
//	private AssoManagementApiInterface assoManagementApiInterface;
//	
//	//跳转到已成立社团列表
//	@RequestMapping("/toExistedAssoTable")
//	public String toExistedAssoTable(Model model) throws Exception{
//		List<CspAssoManagement> ExistedAssoList=assoManagementApiInterface.getExistedAssoLimit(1, 100);
//		model.addAttribute("AssoList",ExistedAssoList);
//		// System.out.println(ExistedAssoList.toString());
//		model.addAttribute("TableType", "ExistedTable");
//		return "ftl/asso/management/Table";
//	}
//	
//	//跳转到待审核社团列表
//	@RequestMapping("/toExamingAssoTable")
//	public String toExamingAssoTable(Model model) throws Exception{
//		List<CspAssoManagement> ExamingAssoList=assoManagementApiInterface.getCheckingAssoLimit(1, 100);
//		model.addAttribute("AssoList",ExamingAssoList);
//		// System.out.println(ExistedAssoList.toString());
//		model.addAttribute("TableType", "ExamingTable");
//		return "ftl/asso/management/Table";
//	}
//	
//	//删除单个社团
//	@RequestMapping("/deleteOneFromTable")
//	public String deleteOne(@RequestParam("id") String getMsg)throws Exception{
//		Integer id=Integer.valueOf(getMsg);
//		assoManagementApiInterface.deleteOne(id);
//		return "redirect:toExistedAssoTable";
//	}
//	
//	//跳转到添加表单
//	@RequestMapping("/toAdd")
//	public String toAdd(AssoManagemrntDto asso,Model model) throws Exception{
//		List<CspAssoGuider> assoGuiders=assoManagementApiInterface.getGuiderAll();
//		model.addAttribute("assoGuiders",assoGuiders);
//		List<CspAssoSchoolUnit> schoolUnit=assoManagementApiInterface.getUnitAll();
//		model.addAttribute("schoolUnit",schoolUnit);
//		return "ftl/asso/management/AddForm";
//	}
//	
//	//跳转到社团修改表单
//	@RequestMapping("/toEdit")
//	public String toedit(@RequestParam("id") Integer getMsg,Model model)throws Exception{
//		CspAssoManagement asso=assoManagementApiInterface.getAssoById(getMsg);
//		model.addAttribute("asso", asso);
//		List<CspAssoGuider> assoGuiders=assoManagementApiInterface.getGuiderAll();
//		model.addAttribute("assoGuiders",assoGuiders);
//		List<CspAssoSchoolUnit> schoolUnit=assoManagementApiInterface.getUnitAll();
//		model.addAttribute("schoolUnit",schoolUnit);
//		return "ftl/asso/management/EditForm";
//	}
//	
//	//更新社团信息
//	@RequestMapping("/updateOne")
//	public String updateOne(AssoManagemrntDto asso,Model model)throws Exception{
//		//getMsg="{\"getMsg\":\"aaa\"}";
//		//@RequestBody Object getMsg,
////		request.setCharacterEncoding("utf-8");
////        response.setContentType("text/html;charset=utf-8");
////        Map<String, String[]> getFormData=request.getParameterMap();
////        JSONObject assoJSON=new JSONObject();
////        for (Object key : getFormData.keySet()) {
////        	assoJSON.put(key.toString(), getFormData.get(key)[0]);
////        }
////        System.out.println(assoJSON.toString());
//		System.out.println(asso.toString());
//		assoManagementApiInterface.updateOne(asso);
//		
//        return "redirect:toExistedAssoTable";
//	}
//	
//	//批量删除社团
//	@RequestMapping("/deleteList")
//	@ResponseBody
//	public int deleteList(@RequestParam("deleteList") List<Integer> deleteList)throws Exception{
//		System.out.println(deleteList);
//		return assoManagementApiInterface.deleteList(deleteList);
//	}
//	
//	//添加社团
//	@RequestMapping("/insertOne")
//	public String insertOne(AssoManagemrntDto asso)throws Exception{
//		assoManagementApiInterface.insertOne(asso);
//		return "redirect:toExistedAssoTable";
//	}
//	
//	//批量审核社团
//	@RequestMapping("/setCheckedAssoList")
//	@ResponseBody
//	public int setCheckedAssoList(@RequestParam("checkList") List<Integer> checkList)throws Exception{
//		//返回成功值后由页面JS进行跳转
//		return assoManagementApiInterface.setCheckedAssoList(checkList);
//	}
//	
//	//查看社团详细信息
//	@RequestMapping("/getAssoDetail")
//	public String getAssoDetail(@RequestParam("id") Integer id,Model model)throws Exception{
//		Object getAsso=assoManagementApiInterface.getAssoById(id);
//		String json=JSON.toJSONString(getAsso);
//		//System.out.println(json);
//		AssoManagemrntDto asso=JSON.parseObject(json,AssoManagemrntDto.class);
//		//System.out.println(asso.toString());
//		int memberNum=assoManagementApiInterface.countRelationByAId(asso.getAssoId());//获取社团成员数目
//		//System.out.println(memberNum);
//		List<CspAssoStuRelation> memberList=assoManagementApiInterface.getRelationByAId(asso.getAssoId());
//		
//		return null;
//	}
//}
