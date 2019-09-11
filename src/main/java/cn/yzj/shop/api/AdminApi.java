package cn.yzj.shop.api;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.yzj.shop.po.Msg;
import cn.yzj.shop.po.SelectTreeDTO;
import cn.yzj.shop.po.SystemModule;
import cn.yzj.shop.service.SystemsModule;

@RestController
@RequestMapping("/api")
public class AdminApi {
	@Autowired
	private SystemsModule systemsModule;
	/**
	 * 数据表分页查询
	 */
	@RequestMapping("/getSystemModuleByPid")
	public Object getSystemModuleAll(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit,
			@RequestParam(value = "pid", defaultValue = "0") short pid) throws Exception {
		return systemsModule.dataPage(limit, page, pid);
	}

	/**
	 * 添加菜单
	 * 
	 * @param systemModule
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addSystemModule")
	public Msg addSystemModule(SystemModule module) throws Exception {
		return systemsModule.add((Serializable) module);
	}
	/**
	 *   获取下拉树模型
	* @return
	* @throws Exception
	*/
	@RequestMapping("/getSelectTree")
	public List<SelectTreeDTO> getSelectTree() throws Exception {
		return systemsModule.getSelectTree();
	}
}
