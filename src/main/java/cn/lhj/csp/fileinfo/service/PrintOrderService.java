package cn.lhj.csp.fileinfo.service;

import java.util.List;

import cn.lhj.csp.fileinfo.po.PrintOrder;



public interface PrintOrderService {
	
		public List<PrintOrder> getAll();
		
		public int insert(PrintOrder printOrder);
		
		public int delete(Integer id);
		
		public int update(PrintOrder printOrder);
		
		public PrintOrder findById(Integer id);
		
		public List<PrintOrder> findByStudentId(Integer studentId);
		
		public PrintOrder selectByOrderNo(String orderNo);
		
		public List<PrintOrder> selectListByOrderNo(String orderNo);
		
		public List<PrintOrder> findByStatus(String status);
}
