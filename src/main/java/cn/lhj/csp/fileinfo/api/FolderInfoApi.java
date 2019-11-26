package cn.lhj.csp.fileinfo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.lhj.csp.fileinfo.po.FolderInfo;
import cn.lhj.csp.fileinfo.service.FolderInfoService;

@RestController
@CrossOrigin
public class FolderInfoApi {

	@Autowired
	private FolderInfoService folderInfoService;
	
	@RequestMapping("/api/folderinfo/getAll")
	public List<FolderInfo> getFolderAll(){
		return folderInfoService.getAll();
	}
	
	@RequestMapping("/api/folderinfo/insert")
	public void insertFolder(@RequestBody FolderInfo folderInfo) {
		folderInfoService.insert(folderInfo);
	}
	
	@RequestMapping("/api/folderinfo/delete")
	public void deleteFolder(Integer id) {
		folderInfoService.delete(id);
	}
	
	@RequestMapping("/api/folderinfo/update")
	public void updateFolder(@RequestBody FolderInfo folderInfo) {
		folderInfoService.update(folderInfo);
	}
	
	@RequestMapping("/api/folderinfo/getById")
	public FolderInfo getFolderById(Integer id) {
		return folderInfoService.getById(id);
	}
}
