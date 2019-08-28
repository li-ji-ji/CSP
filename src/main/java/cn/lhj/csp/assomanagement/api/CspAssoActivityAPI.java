package cn.lhj.csp.assomanagement.api;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.lhj.csp.assomanagement.dto.AssoActivityFormDto;
import cn.lhj.csp.assomanagement.po.CspAssoActivity;
import cn.lhj.csp.assomanagement.po.CspAssoActivityExample;
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
	@RequestMapping("/getActivityByActId")
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
	public List<CspAssoActivity> getActivityByAIdLimit(@RequestParam("assoId")String assoId,@RequestParam("page")Integer page,@RequestParam("count")Integer count) throws Exception {
		return cspAssoActivityService.getActivityByAIdLimit(assoId, page, count);
	}
	// 根据活动负责人编号查询活动
	@RequestMapping("/getActivityByOId")
	public List<CspAssoActivity> getActivityByOId(@RequestParam("oId") String oId) throws Exception {
		return cspAssoActivityService.getActivityByOId(oId);
	}
	//根据时间查询未开始活动
	@RequestMapping("/getActByStartTime")
	public List<CspAssoActivity> getActByStartTime(@RequestParam("startTime")String getStartTime) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		Date startTime = sdf.parse(getStartTime); 
		return cspAssoActivityService.getActByStartTime(startTime);
	}
	//根据时间查询未开始活动（分页）
	@RequestMapping("/getActByStartTimeLimit")
	public List<CspAssoActivity> getActByStartTimeLimit(@RequestParam("startTime")String getStartTime,@RequestParam("page")Integer page,@RequestParam("count")Integer count) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		Date startTime = sdf.parse(getStartTime); 
		return cspAssoActivityService.getActByStartTimeLimit(startTime, page, count);
	}
	//根据当前时间以及报名状态查询未开始活动
	@RequestMapping("/getActByStartTimeAndPartStatus")
	public List<CspAssoActivity> getActByStartTimeAndPartStatus(@RequestParam("partStatus")Integer partStatus) throws Exception{
		Date startTime=new Date();
		return cspAssoActivityService.getActByStartTimeAndPartStatus(startTime,partStatus);
	}
	//根据时间以及报名状态查询未开始活动（分页）
	@RequestMapping("/getActByStartTimeAndPartStatusLimit")
	public List<CspAssoActivity> getActByStartTimeAndPartStatusLimit(@RequestParam("partStatus")Integer partStatus,@RequestParam("page")Integer page,@RequestParam("count")Integer count) throws Exception{
		Date startTime=new Date();
		return cspAssoActivityService.getActByStartTimeAndPartStatusLimit(startTime,partStatus, page, count);
	}
	//根据当前时间查询未开始活动（分页）
	@RequestMapping("/getActByStartTimeNowAndPartStatusLimit")
	public List<CspAssoActivity> getActByStartTimeAndNowLimit(@RequestParam("partStatus")Integer partStatus,@RequestParam("page")Integer page,@RequestParam("count")Integer count) throws Exception{
		Date startTime=new Date();
		return cspAssoActivityService.getActByStartTimeLimit(startTime, page, count);
	}
	//根据时间查询已结束活动
	@RequestMapping("/getActByFinishTime")
	public List<CspAssoActivity> getActByFinishTime(@RequestParam("finishTime")String getfinishTime) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		Date finishTime = sdf.parse(getfinishTime); 
		return cspAssoActivityService.getActByFinishTime(finishTime);
	}

	//根据时间查询已结束活动（分页）
	@RequestMapping("/getActByFinishTimeLimit")
	public List<CspAssoActivity> getActByFinishTimeLimit(@RequestParam("finishTime")String getfinishTime,@RequestParam("page")Integer page,@RequestParam("count")Integer count) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		Date finishTime = sdf.parse(getfinishTime); 
		return cspAssoActivityService.getActByFinishTimeLimit(finishTime, page, count);
	}
	//根据当前时间查询已结束活动
	@RequestMapping("/getActByFinishTimeAndNow")
	public List<CspAssoActivity> getActByFinishTimeAndNow() throws Exception{
		Date finishTime = new Date();
		return cspAssoActivityService.getActByFinishTime(finishTime);
	}

	//根据当前时间查询已结束活动（分页）
	@RequestMapping("/getActByFinishTimeAndNowLimit")
	public List<CspAssoActivity> getActByFinishTimeAndNowLimit(@RequestParam("page")Integer page,@RequestParam("count")Integer count) throws Exception{
		Date finishTime = new Date(); 
		return cspAssoActivityService.getActByFinishTimeLimit(finishTime, page, count);
	}
	//根据学生学号查询已报名进行中活动
	@RequestMapping("/getActByStuIdStarted")
	public List<CspAssoActivity> getActByStuIdStarted(@RequestParam("stuId")String stuId)throws Exception{
		return cspAssoActivityService.getActByStuIdStarted(stuId);
	}
	//根据学生学号查询已报名未开始活动
	@RequestMapping("/getActByStuIdSigned")
	public List<CspAssoActivity> getActByStuIdSigned(@RequestParam("stuId")String stuId)throws Exception{
		return cspAssoActivityService.getActByStuIdSigned(stuId);
	}
	//根据学生学号查询已报名已结束活动
	@RequestMapping("/getActByStuIdFinished")
	public List<CspAssoActivity> getActByStuIdFinished(@RequestParam("stuId")String stuId)throws Exception{
		return cspAssoActivityService.getActByStuIdFinished(stuId);
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
