package cn.lhj.csp.fileinfo.api;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import cn.lhj.csp.fileinfo.po.FileInfo;
import cn.lhj.csp.fileinfo.service.FileInfoService;

@RestController
@CrossOrigin
public class FileInfoApi {

	@Autowired
	private FileInfoService fileInfoService;
	
	

	@RequestMapping("/api/fileinfo/getAll")
	public List<FileInfo> getAll() {
		return fileInfoService.getAll();
	}

	@RequestMapping("/api/fileinfo/insert")
	public void insert(@RequestBody FileInfo fileInfo) {
		fileInfoService.insert(fileInfo);
	}

	@RequestMapping("/api/fileinfo/delete")
	public void delete(Integer id) {
		fileInfoService.delete(id);
	}

	@RequestMapping("/api/fileinfo/update")
	public void update(@RequestBody FileInfo fileInfo) {
		fileInfoService.update(fileInfo);
	}

	@RequestMapping("/api/fileinfo/getById")
	public FileInfo getById(Integer id) {
		return fileInfoService.getById(id);
	}

}
