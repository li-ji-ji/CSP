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
import feign.Headers;
import feign.RequestLine;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;

@CrossOrigin
@FeignClient(name = "csp-fileinfo", configuration = FileInfoApiInterface.MultipartSupportConfig.class)
@Headers({"Content-Type: application/json","Accept: application/json"})
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

	@RequestMapping("/printOrder/update")
	public void updatePrintOrder(@RequestBody PrintOrder printOrder);

	@RequestMapping("/api/printOrder/findById")
	public PrintOrder findByIdPrintOrder(@RequestParam(value = "id") Integer id);

	@RequestMapping(value = "/print/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public Map<String, Object> uploadPrintOrder(@RequestPart("file") MultipartFile multfile,
			@RequestParam(required = false, defaultValue = "其他") String folderName) throws Exception;

	@RequestMapping(value="/print/test",method = RequestMethod.POST,produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String printtest(@RequestPart(value = "file", required = false) MultipartFile file);
	
	@Scope("prototype")
	@Primary
	@Configuration
	class MultipartSupportConfig {
		@Autowired
		private ObjectFactory<HttpMessageConverters> messageConverters;

		@Bean
		public Encoder feignFormEncoder() {
			return new SpringFormEncoder(new SpringEncoder(messageConverters));
		}
	}

	
}
