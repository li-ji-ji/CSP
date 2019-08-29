package cn.lhj.csp.fileinfo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.lhj.csp.fileinfo.feign.FileInfoApiInterface;
import cn.lhj.csp.fileinfo.po.PersonFileinfo;

@RestController
public class PersonFileInfoApi {
			
			@Autowired
			private FileInfoApiInterface fileInfoApiInterface;
			
			@RequestMapping("/api/personFileInfo/getAll")
			public List<PersonFileinfo> getAll() {
				return fileInfoApiInterface.getAllPersonFileInfo();
			}
			
			@RequestMapping("/api/personFileInfo/insert")
			public String insert(@RequestBody PersonFileinfo personFileinfo) {
				return fileInfoApiInterface.insertPersonFileInfo(personFileinfo);
			}
			
			@RequestMapping("/api/personFileInfo/delete")
			public String delete(@RequestParam("id") Integer id) {
				return fileInfoApiInterface.deletePersonFileInfo(id);
			}
			
			@RequestMapping("/api/personFileInfo/update")
			public String update(@RequestBody PersonFileinfo personFileinfo) {
				return fileInfoApiInterface.updatePersonFileInfo(personFileinfo);
			}
			
			@RequestMapping("/api/personFileInfo/findById")
			public PersonFileinfo findById(@RequestParam("id") Integer id) {
				return fileInfoApiInterface.findByIdPersonFileInfo(id);
			}
}
