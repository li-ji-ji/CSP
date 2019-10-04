package cn.lhj.csp.fileinfo.service;

import java.util.List;

import cn.lhj.csp.fileinfo.po.PersonFileinfo;


public interface PersonFileInfoService {
		
		public List<PersonFileinfo> getAll();
		
		public String insert(PersonFileinfo personFileinfo);
		
		public String delete(Integer id);
		
		public String update(PersonFileinfo personFileinfo);
		
		public PersonFileinfo findById(Integer id);
		
		public List<PersonFileinfo> findByStudentId(Integer studentId);
		
		public List<PersonFileinfo> findByPrintOrderId(Integer orderId);
}
