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
import cn.lhj.csp.fileinfo.po.PrintOrder;

@RestController
public class PrintOrderApi {
		
		@Autowired
		private FileInfoApiInterface fileInfoApiInterface;
		
		@RequestMapping("/api/printOrder/getAll")
		public List<PrintOrder> getAll(){
			return fileInfoApiInterface.getAllPrintOrder();
		}
		
		@RequestMapping("/api/printOrder/insert")
		public void insert(@RequestBody PrintOrder printOrder) {
			fileInfoApiInterface.insertPrintOrder(printOrder);
		}
		
		@RequestMapping("/api/printOrder/delete")
		public void delete(Integer id) {
			fileInfoApiInterface.deletePrintOrder(id);
		}
		
		@RequestMapping("/api/printOrder/update")
		public void update(@RequestBody PrintOrder printOrder) {
			fileInfoApiInterface.updatePrintOrder(printOrder);
		}
		
		@RequestMapping("/api/printOrder/findById")
		public PrintOrder findById(Integer id) {
			return fileInfoApiInterface.findByIdPrintOrder(id);
		}
		
		@RequestMapping("/print/upload")
	    public Map<String,Object> uploadPrintOrder(@RequestParam("file") MultipartFile multfile,@RequestParam(required = false, defaultValue = "其他")String folderName)throws Exception{
			return fileInfoApiInterface.uploadPrintOrder(multfile, folderName);
		}
}
