//package cn.lhj.csp.admin.api;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import cn.lhj.csp.admin.feign.AssoManagementApiInterface;
//import cn.lhj.csp.admin.po.asso.CspAssoStudent;
//
//@RestController
//@RequestMapping("/feign/api")
//@CrossOrigin
//public class AssoStudentFeignAPI {
//
//	@Autowired
//	private AssoManagementApiInterface assoStudentApi;
//	
//	//查询所有学生信息
//	@RequestMapping("/getStuAllApi")
//	public List<CspAssoStudent> getStuAllApi()throws Exception{
//		return assoStudentApi.getStuAll();
//	}
//	
//}
