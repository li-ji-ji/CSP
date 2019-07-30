package cn.lhj.csp.fileinfo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.lhj.csp.fileinfo.feign.FileInfoApiInterface;
import cn.lhj.csp.fileinfo.po.FolderInfo;

@RestController
public class FolderInfoApi {

	@Autowired
	private FileInfoApiInterface fileInfoApiInterface;
	
	@RequestMapping("/api/folderinfo/getAll")
	public List<FolderInfo> getFolderAll(){
		return fileInfoApiInterface.getFolderAll();
	}
	
	@RequestMapping("/api/folderinfo/insert")
	public void insertFolder(@RequestBody FolderInfo folderInfo) {
		fileInfoApiInterface.insertFolder(folderInfo);
	}
	
	@RequestMapping("/api/folderinfo/delete")
	public void deleteFolder(Integer id) {
		fileInfoApiInterface.deleteFolder(id);
	}
	
	@RequestMapping("/api/folderinfo/update")
	public void updateFolder(@RequestBody FolderInfo folderInfo) {
		fileInfoApiInterface.updateFolder(folderInfo);
	}
	
	@RequestMapping("/api/folderinfo/getById")
	public FolderInfo getFolderById(Integer id) {
		return fileInfoApiInterface.getFolderById(id);
	}
}
