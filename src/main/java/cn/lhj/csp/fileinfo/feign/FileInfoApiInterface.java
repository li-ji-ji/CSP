package cn.lhj.csp.fileinfo.feign;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import cn.lhj.csp.fileinfo.po.FileInfo;
import cn.lhj.csp.fileinfo.po.FolderInfo;
import cn.lhj.csp.fileinfo.po.PrintOrder;
import cn.lhj.csp.fileinfo.po.PrintShop;
import cn.lhj.csp.fileinfo.po.Printer;
import cn.lhj.csp.fileinfo.po.PersonFileinfo;
import feign.Headers;
import feign.RequestLine;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;

@CrossOrigin
@FeignClient(name = "csp-fileinfo")
public interface FileInfoApiInterface {

	@RequestMapping("/api/fileinfo/getAll")
	public List<FileInfo> getAll();

	@RequestMapping("/api/fileinfo/insert")
	public void insert(@RequestBody FileInfo fileInfo);

	@RequestMapping("/api/fileinfo/delete")
	public void delete(@RequestParam(value = "id") Integer id);

	@RequestMapping("/api/fileinfo/update")
	public void update(@RequestBody FileInfo fileInfo);

	@RequestMapping("/api/fileinfo/getById")
	public FileInfo getById(@RequestParam(value = "id") Integer id);

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

	@RequestMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public Map<String, Object> uploadFile(@RequestPart("file") MultipartFile file,
			@RequestParam("folderName") String folderName) throws IOException;
	
	@RequestMapping("/api/printOrder/getAll")
	public List<PrintOrder> getAllPrintOrder();

	@RequestMapping("/api/printOrder/insert")
	public void insertPrintOrder(@RequestBody PrintOrder printOrder);

	@RequestMapping("/api/printOrder/delete")
	public void deletePrintOrder(@RequestParam(value = "id") Integer id);

	@RequestMapping("/api/printOrder/update")
	public void updatePrintOrder(@RequestBody PrintOrder printOrder);

	@RequestMapping("/api/printOrder/findById")
	public PrintOrder findByIdPrintOrder(@RequestParam(value = "id") Integer id);

	@RequestMapping("/api/printer/getAll")
	public List<Printer> getAllPrinter();
	
	@RequestMapping("/api/printer/insert")
	public String insertPrinter(@RequestBody Printer printer);
	
	@RequestMapping("/api/printer/delete")
	public String deletePrinter(@RequestParam(value = "id")Integer id);
	
	@RequestMapping("/api/printer/update")
	public String updatePrinter(@RequestBody Printer printer);
	
	@RequestMapping("/api/printer/findById")
	public Printer findByIdPrinter(@RequestParam(value = "id")Integer id);
	
	@RequestMapping("/api/printShop/getAll")
	public List<PrintShop> getAllPrintShop();
	
	@RequestMapping("/api/printShop/layuiGetAll")
	public List<PrintShop> getLayuiGetAllPrintShop();
	
	@RequestMapping("/api/printShop/insert")
	public String insertPrintShop(@RequestBody PrintShop printShop);
	
	@RequestMapping("/api/printShop/delete")
	public String deletePrintShop(@RequestParam(value = "id") Integer id);
	
	@RequestMapping("/api/printShop/update")
	public String updatePrintShop(@RequestBody PrintShop printShop);
	
	@RequestMapping("/api/printShop/findById")
	public PrintShop findByIdPrintShop(@RequestParam(value = "id") Integer id);
	
	/**
	 * 个人文件信息
	 */
	
	@RequestMapping("/api/personFileInfo/getAll")
	public List<PersonFileinfo> getAllPersonFileInfo();
	
	@RequestMapping("/api/personFileInfo/insert")
	public String insertPersonFileInfo(@RequestBody PersonFileinfo personFileinfo);
	
	@RequestMapping("/api/personFileInfo/delete")
	public String deletePersonFileInfo(@RequestParam("id") Integer id);
	
	@RequestMapping("/api/personFileInfo/update")
	public String updatePersonFileInfo(@RequestBody PersonFileinfo personFileinfo);
	
	@RequestMapping("/api/personFileInfo/findById")
	public PersonFileinfo findByIdPersonFileInfo(@RequestParam("id") Integer id);
	
	@RequestMapping("/api/personFileInfo/findByStudentId")
	public List<PersonFileinfo> findByStudentIdPersonFileInfo(@RequestParam("studentId") Integer studentId);
}
