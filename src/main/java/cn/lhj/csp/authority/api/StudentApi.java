package cn.lhj.csp.authority.api;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.lhj.csp.authority.po.Student;
import cn.lhj.csp.authority.po.UserBinding;
import cn.lhj.csp.authority.service.StudentService;
import cn.lhj.csp.authority.util.ExcelUtil;

@RestController
@RequestMapping("/bg/studentapi")
public class StudentApi {
	@Autowired
	private StudentService studentService;

	@RequestMapping("/all")
	@ResponseBody
	public Map<String, Object> all(@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "10") int limit) throws Exception {
		System.out.println("student  -->> all");
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
	
	@RequestMapping("/selectStudentBatch")
	public List<Student> selectStudentBatch(@RequestParam("ids")String ids)throws Exception{
		return studentService.selectStudentBatch(ids);
	}
	
	@RequestMapping("/login")
	public Student login(@RequestParam("code")String code)throws Exception {
		return studentService.userLogin(code);
	}
	
	@RequestMapping("/binding")
	public Student binding(UserBinding userBinding) throws Exception {
		return studentService.binding(userBinding);
	}
	
	@RequestMapping("/toedit")
	public Student toEdit(Integer id) throws Exception {
		System.out.println(id);
		Student student = null;
		if (id != null && id > 0) {
			student = studentService.selectByPrimaryKey(id);
		}
		return student;
	}
	
	@RequestMapping("/updataUser")
	public boolean updataUser(Student student) {
		return studentService.updateByPrimaryKeySelective(student);
	}

	@RequestMapping("/onedit")
	public Integer edit(@RequestBody Student student) throws Exception {
		System.out.println(student);
		Integer row = null;
		if (student.getId() != null && student.getId() > 0) {
			row = studentService.updateByPrimaryKey(student);
		} else {
			row = studentService.insert(student);
		}
		return row;
	}

	@RequestMapping("/delete")
	public Integer delete(Integer id) throws Exception {
		Integer row = studentService.deleteByPrimaryKey(id);
		return row;
	}

	@RequestMapping("/batchdelete")
	public Integer batchDelete(String jsonStr) {
		Integer rows = 0;
		JSONArray jsonArray = JSON.parseArray(jsonStr);
		for (Object obj : jsonArray) {
			JSONObject dataObj = JSONObject.parseObject(obj.toString());
			String id = dataObj.getString("id");
			int idI = Integer.parseInt(id);
			int row = studentService.deleteByPrimaryKey(idI);
			rows += row;
		}
		return rows;
	}

	@RequestMapping(value = "/excelimport", method = RequestMethod.POST)
	public Integer excelImport(@RequestPart("file") MultipartFile file) throws Exception {
		System.out.println("excelimport-------------------------------");

		String name = file.getOriginalFilename();// 上传文件的真实名称
		String suffixName = name.substring(name.lastIndexOf("."));// 获取后缀名
		File excelFile = File.createTempFile("imagesFile-" + System.currentTimeMillis(), suffixName);
		file.transferTo(excelFile);

		ExcelUtil excelUtil = new ExcelUtil();
		List<Student> students = new ArrayList<Student>();
		students = excelUtil.importXLS(excelFile.toString());
		Integer rows = 0;
		System.out.println("students长度==" + students.size());
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

		return rows;
	}

	/**
	 * 删除临时文件
	 * 
	 * @param files
	 */
	private void deleteFile(File... files) {
		for (File file : files) {
			if (file.exists()) {
				file.delete();
			}
		}
	}
}
