package cn.lhj.csp.asso.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.lhj.csp.asso.po.CspActStuRelation;
import cn.lhj.csp.asso.service.CspActStuRelationService;
import cn.lhj.csp.asso.service.CspAssoActivityService;
import cn.lhj.csp.asso.service.CspAssoManagementService;


@RestController
@CrossOrigin
@RequestMapping("/ActStuRelation")
public class CspActStuRelationAPI {

	@Autowired
	private CspActStuRelationService actStu;
	@Autowired
	private CspAssoActivityService assoAct;
	@Autowired
	private CspAssoManagementService assoManage;
	
	// TODO 等待学生表整合完成
	
//	@Autowired
//	private StudentRemote stuRemote;
//	
	//查询所有关系条数
	@RequestMapping("/countRelationAll")
	public int countRelationAll()throws Exception{
		return actStu.countRelationAll();
	}
	//根据活动编号查询关系条数
	@RequestMapping("/countRelationByActId")
	public int countRelationByActId(@RequestParam("actId")String actId)throws Exception{
		return actStu.countRelationByActId(actId);
	}
	//根据学生学号查询关系条数
	@RequestMapping("/countRelationByStuId")
	public int countRelationByStuId(@RequestParam("stuId")String stuId)throws Exception{
		return actStu.countRelationByStuId(stuId);
	}
	//查询所有活动与学生关系
	@RequestMapping("/getActStuRelationAll")
	public List<CspActStuRelation> getActStuRelationAll()throws Exception{
		return actStu.getActStuRelationAll();
	}
	//查询所有活动与学生关系（分页）
	@RequestMapping("/getActStuRelationAllLimit")
	public List<CspActStuRelation> getActStuRelationAllLimit(@RequestParam("page")Integer page,@RequestParam("count")Integer count)throws Exception{
		return actStu.getActStuRelationAllLimit(page, count);
	}
	//根据ID查询活动与学生关系
	@RequestMapping("/getActStuRelationById")
	public CspActStuRelation getActStuRelationById(@RequestParam("id")Integer id)throws Exception{
		return actStu.getActStuRelationById(id);
	}
	//根据活动ID查询所有活动与学生关系
	@RequestMapping("/getActStuRelationByActId")
	public List<CspActStuRelation> getActStuRelationByActId(@RequestParam("actId")String actId)throws Exception{
		return actStu.getActStuRelationByActId(actId);
	}
	//根据活动ID查询所有活动与学生关系（分页）
	@RequestMapping("/getActStuRelationByActIdLimit")
	public List<CspActStuRelation> getActStuRelationByActIdLimit(@RequestParam("actId")String actId,@RequestParam("page")Integer page,@RequestParam("count")Integer count)throws Exception{
		return actStu.getActStuRelationByActIdLimit(actId, page, count);
	}
	//根据学生ID查询所有活动与学生关系
	@RequestMapping("/getActStuRelationByStuId")
	public List<CspActStuRelation> getActStuRelationByStuId(@RequestParam("stuId")String stuId)throws Exception{
		return actStu.getActStuRelationByStuId(stuId);
	}
	//根据学生ID查询所有活动与学生关系（分页）
	@RequestMapping("/getActStuRelationByStuIdLimit")
	public List<CspActStuRelation> getActStuRelationByStuIdLimit(@RequestParam("stuId")String stuId,@RequestParam("page")Integer page,@RequestParam("count")Integer count)throws Exception{
		return actStu.getActStuRelationByStuIdLimit(stuId, page, count);
	}
	//根据学生学号和活动编号查询关系
	@RequestMapping("/getActStuRelationByActIdAndStuId")
	public List<CspActStuRelation> getActStuRelationByActIdAndStuId(@RequestParam("actId")String actId,@RequestParam("stuId")String stuId) throws Exception {
		return actStu.getActStuRelationByActIdAndStuId(actId,stuId);
	}

	//根据学生学号查询已报名未开始记录
	@RequestMapping("/getActStuRelationSignedByStuId")
	public List<CspActStuRelation> getActStuRelationSignedByStuId(@RequestParam("stuId")String stuId) throws Exception{
		return actStu.getActStuRelationSignedByStuId(stuId);
	}
	//根据学生学号查询已报名未开始记录
	@RequestMapping("/getActStuRelationStartedByStuId")
	public List<CspActStuRelation> getActStuRelationStartedByStuId(@RequestParam("stuId")String stuId) throws Exception{
		return actStu.getActStuRelationStartedByStuId(stuId);
	}
	//根据学生学号查询已报名已结束记录
	@RequestMapping("/getActStuRelationFinishedByStuId")
	public List<CspActStuRelation> getActStuRelationFinishedByStuId(@RequestParam("stuId")String stuId) throws Exception{
		return actStu.getActStuRelationFinishedByStuId(stuId);
	}
	//添加单条活动与学生关系
	@RequestMapping("/addActStuRelationOne")
	public int addActStuRelationOne(@RequestParam("actId") String actId,@RequestParam("stuId")String stuId) throws Exception{
		CspActStuRelation relation=new CspActStuRelation();
		relation.setActId(actId);
		relation.setStuId(stuId);
		return actStu.addActStuRelationOne(relation);
	}
	//根据ID删除单条活动与学生关系
	@RequestMapping("/delActStuRelationOneById")
	public int delActStuRelationOneById(@RequestParam("id")Integer id)throws Exception{
		return actStu.delActStuRelationOneById(id);
	}
	//根据ID批量删除活动与学生关系
	@RequestMapping("/delActStuRelationListById")
	public int delActStuRelationListById(@RequestParam("idList")List<Integer> idList)throws Exception{
		return actStu.delActStuRelationListById(idList);
	}
	//修改单条活动与学生关系
	@RequestMapping("/setActStuRelationOne")
	public int setActStuRelationOne(@RequestBody CspActStuRelation relation) throws Exception{
		return actStu.setActStuRelationOne(relation);
	}
	//修改单条活动与学生关系状态为取消
	@RequestMapping("/setActStuRelationOneStatusCancel")
	public int setActStuRelationOneStatusCancel(@RequestParam("actId")String actId, @RequestParam("stuId")String stuId) throws Exception{
		return actStu.setActStuRelationOneStatusCancel(actId, stuId);
	}
	
}
