package cn.lhj.csp.fileinfo.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.lhj.csp.fileinfo.feign.FileInfoApiInterface;
import cn.lhj.csp.fileinfo.po.FileInfo;

@RestController
public class FileInfoApi {
		
		@Autowired
		private FileInfoApiInterface fileInfoApiInterface;
		
		@RequestMapping("/api/fileinfo/getAll")
		public List<FileInfo> getAll(){
			return fileInfoApiInterface.getAll();
		}
		
		@RequestMapping("/api/fileinfo/insert")
		public void insert(@RequestBody FileInfo fileInfo) {
			fileInfoApiInterface.insert(fileInfo);
		}
		
		@RequestMapping("/api/fileinfo/delete")
		public void delete(Integer id) {
			fileInfoApiInterface.delete(id);
		}
		
		@RequestMapping("/api/fileinfo/update")
		public void update(@RequestBody FileInfo fileInfo) {
			fileInfoApiInterface.update(fileInfo);
		}
		
		@RequestMapping("/api/fileinfo/getById")
		public FileInfo getById(Integer id) {
			return fileInfoApiInterface.getById(id);
		}
		
		@RequestMapping("/file/upload")
	    public Map<String,Object> uploadFile(@RequestParam("file") MultipartFile multfile,@RequestParam(required = false, defaultValue = "其他")String folderName)throws Exception{
			return fileInfoApiInterface.uploadFile(multfile, folderName);
		}
		
}
