package cn.lhj.csp.task.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.lhj.csp.task.service.ExpressSystem;
import cn.yzj.csp.task.po.Express;
import cn.yzj.csp.task.po.LayUIJSON;

@RestController
public class ExpressController {
	@Autowired
	private ExpressSystem expressSys;

	@RequestMapping("/insertExpress")
	public int insertExpress(Express express) throws Exception {

		return expressSys.insertExpress(express);
	}
	
	@RequestMapping("/insertExpressList")
	public int insertExpressList(@RequestParam("expresses")String expresses) throws Exception {
		
	
		return expressSys.insertExpressList(expresses);
		
	}
	/*
	 * 通过父id查找所有快递信息(批量查询,返回二维数组)
	 */
	@RequestMapping("/selectBySuperiortaskId")
	public List<List<Express>> selectBySuperiortaskId(@RequestParam("ids")String ids) throws Exception{
		
		return expressSys.selectBySuperiortaskId(ids);
		
	}
	/*
	 * 通过父id查询所有快递信息(单id查询)
	 * 
	 */
	@RequestMapping("taskAdmin/findExpressByPid")
	public LayUIJSON<Object> findExpressByPid(@RequestParam(value = "page",defaultValue ="1")int page,@RequestParam(value = "limit",defaultValue = "10")int limit,@RequestParam("pId")String pId) throws Exception{
		PageHelper.startPage(page, limit);
		List<Express> expresses= expressSys.findExpressByPid(pId);
		PageInfo<Express> pageInfo=new PageInfo<Express>(expresses);
		long count=pageInfo.getTotal();
		LayUIJSON<Object> uijson=new LayUIJSON<>();
		uijson.setCount((long)count);
		uijson.setDataWithTasks(expresses);
		return uijson;
	}
	
}
