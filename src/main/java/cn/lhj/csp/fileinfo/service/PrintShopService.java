package cn.lhj.csp.fileinfo.service;

import java.util.List;

import cn.lhj.csp.fileinfo.po.PrintShop;


public interface PrintShopService {
		
		public List<PrintShop> getAll();
		
		public String insert(PrintShop printShop);
		
		public String delete(Integer id);
		
		public String update(PrintShop printShop);
		
		public PrintShop findById(Integer id);
		
		public List<PrintShop> findByLocation(String location);
		
}
