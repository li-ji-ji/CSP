package cn.lhj.csp.fileinfo.service;

import java.util.List;

import cn.lhj.csp.fileinfo.po.Printer;

public interface PrinterInfoService {
		
		public List<Printer> getAll();
		
		public String insert(Printer printer);
		
		public String delete(Integer id);
		
		public String update(Printer printer);
		
		public Printer findById(Integer id);
		
		public List<Printer> findByPrintShopName(String printShopName);
}
