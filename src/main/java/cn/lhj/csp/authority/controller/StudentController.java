package cn.lhj.csp.authority.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.lhj.csp.authority.po.Student;
import cn.lhj.csp.authority.service.StudentService;
import cn.lhj.csp.authority.util.ExcelUtil;

@Controller
@RequestMapping("/bg/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/index")
	public String index() {
		return "student/list";
	}

	/**
	 * 跳转到编辑
	 * 
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toedit")
	public String toEdit(Model model, Integer sn) throws Exception {
		if (sn != null && sn > 0) {
			System.out.println(sn);
			Student student = studentService.selectByPrimaryKey(sn);
			model.addAttribute("student", student);
		}
		return "student/edit";
	}

	/**
	 * 添加,跟新记录
	 * 
	 * @param student
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/onedit")
	public String edit(Student student) throws Exception {
		System.out.println("student ->> onedit");
//		if (student.getSn() != null && student.getSn() > 0) {
//			studentService.updateByPrimaryKey(student);
//		} else {
//			System.out.println("-----------------------");
//			studentService.insert(student);
//		}
		return "redirect:index";
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String delete(Integer sn) throws Exception {
		System.out.println("微服务的删除的删除" + sn);
		int row = studentService.deleteByPrimaryKey(sn);
		return "redirect:index";
	}

	/**
	 * 批量删除
	 * 
	 * @param jsonStr
	 * @return
	 */
	@RequestMapping("/batchdelete")
	public String batchDelete(String jsonStr) {
		System.out.println("student -->> batchdelete");
		/**
		 * json字符串解析
		 */
		JSONArray jsonArray = JSON.parseArray(jsonStr);
		for (Object obj : jsonArray) {
			JSONObject dataObj = JSONObject.parseObject(obj.toString());
			String sn = dataObj.getString("sn");
			int snI = Integer.parseInt(sn);
			int row = studentService.deleteByPrimaryKey(snI);
		}
		return "redirect:index";
	}

	/**
	 * 列表数据渲染
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/all")
	@ResponseBody
	public Map<String, Object> all(@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "10") int limit) throws Exception {
		List<Student> data = studentService.select(page, limit);
		List<Student> datas = null;
		datas = studentService.selectByExample(null);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", datas.size());
		map.put("data", data);
		return map;
	}

	@RequestMapping(value = "/excelimport", method = RequestMethod.POST)
	public String excelImport(@RequestParam("file") MultipartFile file, HttpServletRequest servletRequest)
			throws IOException {
		System.out.println("StudentController -->> excelImport");

		// String path = servletRequest.getServletContext().getRealPath("/uploadFile");
		// System.out.println("文件名称" + file.getOriginalFilename());
		// 上传文件名
		// String name = file.getOriginalFilename();// 上传文件的真实名称
		// String suffixName = name.substring(name.lastIndexOf("."));// 获取后缀名
		// String hash = Integer.toHexString(new Random().nextInt());//
		// 自定义随机数（字母+数字）作为文件
		// String fileName = hash + suffixName;
		// File filepath = new File(path, fileName);
		// System.out.println("随机数文件名称" + filepath.getName());
		// if (!filepath.getParentFile().exists()) {
		// filepath.getParentFile().mkdirs();
		// }
		String name = file.getOriginalFilename();// 上传文件的真实名称
		String suffixName = name.substring(name.lastIndexOf("."));// 获取后缀名
		File excelFile = File.createTempFile("imagesFile-" + System.currentTimeMillis(), suffixName);
		file.transferTo(excelFile);

		// File tempFile = new File(path + File.separator + fileName);
		// try {
		// file.transferTo(tempFile);
		// } catch (IllegalStateException | IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println(tempFile.getPath());

		ExcelUtil excelUtil = new ExcelUtil();
		List<Student> students = new ArrayList<Student>();
		students = excelUtil.importXLS(excelFile.toString());
		Integer rows = 0;
		System.out.println("students长度==" + students.size());
//		System.out.println(students.get(391));
//		System.out.println(students.get(392));
//		System.out.println(students.get(393));

		/**
		 * // 插入方案一
		 */
//		for (Student student : students) {
//			int row = 0;
//			try {
//				row = studentService.insert(student);
//			} catch (Exception e) {
//				System.out.println("第" + rows + "行出错");
//				e.printStackTrace();
//				break;
//			}
//			rows += row;
//		}

		/**
		 * // 插入方案二
		 */
		
		try {
			rows = studentService.insertStudentInfoBatch(students);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("插入的students长度==" + rows);

//		String path = servletRequest.getServletContext().getRealPath("/uploadFile");
//		System.out.println("文件名称" + file.getOriginalFilename());
//		// 上传文件名
//		String name = file.getOriginalFilename();// 上传文件的真实名称
//		String suffixName = name.substring(name.lastIndexOf("."));// 获取后缀名
//		String hash = Integer.toHexString(new Random().nextInt());// 自定义随机数（字母+数字）作为文件
//		String fileName = hash + suffixName;
//		File filepath = new File(path, fileName);
//		System.out.println("随机数文件名称" + filepath.getName());
//		if (!filepath.getParentFile().exists()) {
//			filepath.getParentFile().mkdirs();
//		}
//		
//		File tempFile = new File(path + File.separator + fileName);
//		try {
//			file.transferTo(tempFile);
//		} catch (IllegalStateException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(tempFile.getPath());
//		ExcelUtil excelUtil = new ExcelUtil();
//		List<Student> students = new ArrayList<Student>();
//		students = excelUtil.importXLS(tempFile.toString());
//		for(int i = 0 ; i<students.size() ;i++) {
//			studentService.insert(students.get(i));
//		}
//		System.out.println("excel导入的model  students："+students);
		return "redirect:index";
	}
}
