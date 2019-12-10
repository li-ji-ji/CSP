package cn.lhj.csp.fileinfo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.lhj.csp.fileinfo.po.ShopCart;
import cn.lhj.csp.fileinfo.service.ShopCartInfoService;

@RestController
@CrossOrigin
public class ShopCartInfoApi {
	
		@Autowired
		private ShopCartInfoService shopCartInfoService;
		
		@RequestMapping("/api/shopCart/getAll")
		public List<ShopCart> getAll(){
			return shopCartInfoService.getAll();
		}
		
		@RequestMapping("/api/shopCart/findByStudentId")
		public List<ShopCart> findByStudentIdShopCart(@RequestParam("studentId")Integer studentId){
			return shopCartInfoService.selectByStudentId(studentId);
		}
		
		@RequestMapping("/api/shopCart/insert")
		public void insert(@RequestBody ShopCart shopCart) {
			shopCartInfoService.insert(shopCart);
		}
		
		@RequestMapping("/api/shopCart/delete")
		public void delete(@RequestParam("id")Integer id) {
			shopCartInfoService.delete(id);
		}
}
