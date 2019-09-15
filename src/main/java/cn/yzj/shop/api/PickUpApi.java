package cn.yzj.shop.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.yzj.shop.po.Msg;
import cn.yzj.shop.po.PickUp;
import cn.yzj.shop.service.PickUpService;

@RestController
@RequestMapping("/api/pickUp")
public class PickUpApi {
		
		@Autowired
		private PickUpService pickUpService;
		
		@RequestMapping("/getAll")
		public List<PickUp> getAll() throws Exception{
			return (List<PickUp>)pickUpService.find();
		}
		
		@RequestMapping("/insert")
		public Msg insert(@RequestBody PickUp pickUp) throws Exception {
			return pickUpService.add(pickUp);
		}
		
		@RequestMapping("/delete")
		public Msg delete(@RequestParam("id")Integer id) throws Exception {
			return pickUpService.delete(id);
		}
		
		@RequestMapping("/update")
		public Msg update(@RequestBody PickUp pickUp) throws Exception {
			return pickUpService.updata(pickUp);
		}
		
		@RequestMapping("findById")
		public PickUp findById(@RequestParam("id")Integer id) throws Exception {
			return (PickUp) pickUpService.find(id);
		}
}
