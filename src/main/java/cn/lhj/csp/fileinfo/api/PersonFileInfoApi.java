package cn.lhj.csp.fileinfo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.lhj.csp.fileinfo.po.PersonFileinfo;
import cn.lhj.csp.fileinfo.service.PersonFileInfoService;

@RestController
@CrossOrigin
public class PersonFileInfoApi {

	@Autowired
	private PersonFileInfoService personFileInfoService;

	@RequestMapping("/api/personFileInfo/getAll")
	public List<PersonFileinfo> getAll() {
		return personFileInfoService.getAll();
	}

	@RequestMapping("/api/personFileInfo/insert")
	public String insert(@RequestBody PersonFileinfo personFileinfo) {
		return personFileInfoService.insert(personFileinfo);
	}

	@RequestMapping("/api/personFileInfo/delete")
	public String delete(@RequestParam("id") Integer id) {
		return personFileInfoService.delete(id);
	}

	@RequestMapping("/api/personFileInfo/update")
	public String update(@RequestBody PersonFileinfo personFileinfo) {
		return personFileInfoService.update(personFileinfo);
	}

	@RequestMapping("/api/personFileInfo/findById")
	public PersonFileinfo findById(@RequestParam("id") Integer id) {
		return personFileInfoService.findById(id);
	}

	@RequestMapping("/api/personFileInfo/findByStudentId")
	public List<PersonFileinfo> findByStudentId(@RequestParam("studentId") Integer studentId) {
		return personFileInfoService.findByStudentId(studentId);
	}
}
