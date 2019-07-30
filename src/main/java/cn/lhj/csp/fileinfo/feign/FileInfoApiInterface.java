package cn.lhj.csp.fileinfo.feign;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.lhj.csp.fileinfo.po.FileInfo;
import cn.lhj.csp.fileinfo.po.FolderInfo;
import cn.lhj.csp.fileinfo.po.PrintOrder;


@CrossOrigin
@FeignClient(name= "csp-fileinfo")
public interface FileInfoApiInterface {
		
	@RequestMapping("/api/fileinfo/getAll")
	public List<FileInfo> getAll();
	
	@RequestMapping("/api/fileinfo/insert")
	public void insert(@RequestBody FileInfo fileInfo);
	
	@RequestMapping("/api/fileinfo/delete")
	public void delete(@RequestParam(value = "id")Integer id);
	
	@RequestMapping("/api/fileinfo/update")
	public void update(@RequestBody FileInfo fileInfo);
	
	@RequestMapping("/api/fileinfo/getById")
	public FileInfo getById(@RequestParam(value = "id")Integer id);
	
	@RequestMapping("/api/folderinfo/getAll")
	public List<FolderInfo> getFolderAll();

	@RequestMapping("/api/folderinfo/insert")
	public void insertFolder(@RequestBody FolderInfo folderInfo);

	@RequestMapping("/api/folderinfo/delete")
	public void deleteFolder(@RequestParam(value = "id") Integer id);

	@RequestMapping("/api/folderinfo/update")
	public void updateFolder(@RequestBody FolderInfo folderInfo);

	@RequestMapping("/api/folderinfo/getById")
	public FolderInfo getFolderById(@RequestParam(value = "id") Integer id);

	@RequestMapping("/file/upload")
    public Map<String,Object> uploadFile(@RequestParam("file") MultipartFile multfile,@RequestParam(required = false, defaultValue = "其他")String folderName)throws Exception;
	
	@RequestMapping("/api/printOrder/getAll")
	public List<PrintOrder> getAllPrintOrder();
	
	@RequestMapping("/api/printOrder/insert")
	public void insertPrintOrder(@RequestBody PrintOrder printOrder);
	
	@RequestMapping("/api/printOrder/delete")
	public void deletePrintOrder(@RequestParam(value = "id") Integer id);
	
	@RequestMapping("/printOrder/update")
	public void updatePrintOrder(@RequestBody PrintOrder printOrder);
	
	@RequestMapping("/api/printOrder/findById")
	public PrintOrder findByIdPrintOrder(@RequestParam(value = "id") Integer id);
	
	@RequestMapping("/print/upload")
    public Map<String,Object> uploadPrintOrder(@RequestParam("file") MultipartFile multfile,@RequestParam(required = false, defaultValue = "其他")String folderName)throws Exception;
}
