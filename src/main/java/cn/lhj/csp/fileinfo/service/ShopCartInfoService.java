package cn.lhj.csp.fileinfo.service;

import java.util.List;

import cn.lhj.csp.fileinfo.po.ShopCart;

public interface ShopCartInfoService {
		
		public List<ShopCart> getAll();
		
		public int insert(ShopCart shopCart);
		
		public int delete(Integer id);
		
		public int update(ShopCart shopCart);
		
		public ShopCart findById(Integer id);
		
		public ShopCart selectByOrderNo(String orderNo);
		
		public List<ShopCart> selectListByOrderNo(String orderNo);
		
		public List<ShopCart> selectByStudentId(Integer studentId);
		
		public List<ShopCart> findByStatus(String status);
}
