package cn.lhj.csp.assomanagement.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.lhj.csp.assomanagement.dto.AssoActivityFormDto;
import cn.lhj.csp.assomanagement.po.CspAssoActivity;
import cn.lhj.csp.assomanagement.service.CspAssoActivityService;

@RestController
@CrossOrigin
public class CspAssoActivityAPI {

	@Autowired
	private CspAssoActivityService cspAssoActivityService;
	
	//查询所有活动条数
	@RequestMapping("/countActivityAll")
	public int countActivityAll()throws Exception{
		return cspAssoActivityService.countActivityAll();
	}
	// 查询所有活动
	@RequestMapping("/getActivityAll")
	public List<CspAssoActivity> getActivityAll() throws Exception {
		return cspAssoActivityService.getActivityAll();
	}
	
	// 查询所有活动（分页）
	@RequestMapping("/getActivityAllLimit")
	public List<CspAssoActivity> getActivityAllLimit(@RequestParam("page")Integer page,@RequestParam("count")Integer count) throws Exception {
		return cspAssoActivityService.getActivityAllLimit(page, count);
	}
	// 根据活动状态查询活动
	@RequestMapping("/getActivityByStatus")
	public List<CspAssoActivity> getActivityByStatus(@RequestParam("status") Integer status) throws Exception {
		return cspAssoActivityService.getActivityByStatus(status);
	}
	// 根据活动状态查询活动（分页）
	@RequestMapping("/getActivityByStatusLimit")
	public List<CspAssoActivity> getActivityByStatusLimit(@RequestParam("status") Integer status,@RequestParam("page")Integer page,@RequestParam("count")Integer count) throws Exception {
		return cspAssoActivityService.getActivityByStatusLimit(status, page, count);
	}
	// 根据活动ID查询活动
	@RequestMapping("/getActivityById")
	public CspAssoActivity getActivityById(@RequestParam("id") Integer id) throws Exception {
		return cspAssoActivityService.getActivityById(id);
	}

	// 根据活动名称查询活动
	@RequestMapping("/getActivityByName")
	public List<CspAssoActivity> getActivityByName(@RequestParam("name") String name) throws Exception {
		return cspAssoActivityService.getActivityByName(name);
	}

	// 根据活动编号查询活动
	@RequestMapping("/getActicityByActId")
	public CspAssoActivity getActicityByActId(@RequestParam("actId") String actId) throws Exception {
		return cspAssoActivityService.getActivityByActId(actId);
	}

	// 根据社团编号查询活动
	@RequestMapping("/getActivityByAId")
	public List<CspAssoActivity> getActivityByAId(@RequestParam("assoId") String assoId) throws Exception {
		System.out.println(cspAssoActivityService.getActivityByAId(assoId).toString());
		return cspAssoActivityService.getActivityByAId(assoId);
	}
	// 根据社团编号查询活动（分页 ）
	@RequestMapping("/getActivityByAIdLimit")
	public List<CspAssoActivity> getActivityByAIdLimit(@RequestParam("assoId") String assoId,@RequestParam("page")Integer page,@RequestParam("count")Integer count) throws Exception {
		return cspAssoActivityService.getActivityByAIdLimit(assoId, page, count);
	}
	// 根据活动负责人编号查询活动
	@RequestMapping("/getActivityByOId")
	public List<CspAssoActivity> getActivityByOId(@RequestParam("oId") String oId) throws Exception {
		return cspAssoActivityService.getActivityByOId(oId);
	}

	// 添加活动
	@RequestMapping("/insertActivity")
	public int insertActicity(@RequestBody CspAssoActivity act) throws Exception {
		System.out.println(act.getActivityAssoId());
		return cspAssoActivityService.insertActicity(act);
	}

	// 根据ID删除单个活动
	@RequestMapping("/deleteActivityOneById")
	public int deleteActivityOneById(@RequestParam("id") Integer id) throws Exception {
		return cspAssoActivityService.deleteActivityOneById(id);
	}

	// 根据ID删除多个活动
	@RequestMapping("/deleteActivityListById")
	public int deleteActivityListById(@RequestParam("idList") List<Integer> idList) throws Exception {
		return cspAssoActivityService.deleteActivityListById(idList);
	}

	// 根据活动编号删除活动
	@RequestMapping("/deleteActivityByActId")
	public int deleteActivityByActId(@RequestParam("actId") String actId) throws Exception {
		return cspAssoActivityService.deleteActivityByActId(actId);
	}

	// 更新活动
	@RequestMapping("/updateActivityOne")
	public int updateActivityOne(@RequestBody CspAssoActivity act) throws Exception {
		return cspAssoActivityService.updateActivityOne(act);
	}
	
	//更新活动状态为开启
	@RequestMapping("/updateActivityStatusOpen")
	public int updateActivityStatusOpen(@RequestParam("id") Integer id)throws Exception{
		return cspAssoActivityService.updateActivityStatusOpen(id);
	}
	//更新活动状态为结束
	@RequestMapping("/updateActivityStatusClose")
	public int updateActivityStatusClose(@RequestParam("id") Integer id)throws Exception{
		return cspAssoActivityService.updateActivityStatusClose(id);
	}
	
	//根据活动ID查询活动表单相关信息（社团成员，社团列表 ）
	@RequestMapping("/getAssoActFormDto")
	public AssoActivityFormDto getAssoActFormDto(@RequestParam("id")Integer actId)throws Exception{
		return cspAssoActivityService.getAssoActFormDto(actId);
	}
}
