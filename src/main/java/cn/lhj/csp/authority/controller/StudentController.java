package cn.lhj.csp.authority.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.lhj.csp.authority.feign.StudentRemote;
import cn.lhj.csp.authority.po.Student;

@Controller
@RequestMapping("/authority/student")
public class StudentController {
	@Autowired
	private StudentRemote studentRemote;
	
	
	@RequestMapping("/index")
	public String index() {
		System.out.println("bg --->> student  ---> index");
		return "ftl/student/list";
	}
	
	@RequestMapping("/delete")
	public String delete(Integer id) throws Exception {
		studentRemote.delete(id);
		return "redirect:index";
	}
	
	@RequestMapping("/toedit")
	public String toEdit(Model model, Integer id) throws Exception {
		System.out.println("bg --->> student  ---> toedit --->> sn: "+id);
		Student student = studentRemote.toEdit(id);
		System.out.println(student);
		model.addAttribute("student",student);
		return "ftl/student/edit";
	}
	
	@RequestMapping("/onedit")
	public String edit(Student student) throws Exception {
		System.out.println("bg --->> student  ---> onedit --->> student: ");
		System.out.println("student:"+student);
		studentRemote.edit(student);
		return "redirect:index";
	}
	
	@RequestMapping("/batchdelete")
	public String batchDelete(String jsonStr) {
		studentRemote.batchDelete(jsonStr);
		return "redirect:index";
	}

	@RequestMapping("/all")
	@ResponseBody
	public Map<String, Object>  all(@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "10") int limit) throws Exception{
		System.out.println("bg --->> student  ---> all");
		return studentRemote.all(page, limit);
	}
	
	@RequestMapping(value = "/excelimport", method = RequestMethod.POST)
	public String excelImport(@RequestParam("file") MultipartFile file) throws Exception {
		System.out.println("bg --->> student  ---> excelImport");
		studentRemote.excelImport(file);
		return "redirect:index";
	}
	
}
