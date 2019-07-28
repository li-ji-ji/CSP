package cn.lhj.csp.admin.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.lhj.csp.admin.dto.AssoActivityFormDto;
import cn.lhj.csp.admin.dto.AssoManagemrntDto;
import cn.lhj.csp.admin.dto.AssoSchoolDto;
import cn.lhj.csp.admin.dto.AssoSchoolUnitDto;
import cn.lhj.csp.admin.po.asso.CspAssoActivity;
import cn.lhj.csp.admin.po.asso.CspAssoManagement;
import cn.lhj.csp.admin.po.asso.CspAssoStudent;



@FeignClient(name="csp-asso")
public interface AssoManagementApiInterface {

	/*
	 *	社团管理
	 */
	
	//查询所有社团
	@RequestMapping(value="/getAll")
	public List<CspAssoManagement> getAll()throws Exception;
	//分页查询所有社团
	@RequestMapping(value="/getAllAssoLimit")
	public List<CspAssoManagement> getAllAssoLimit(@RequestParam("page")Integer page,@RequestParam("count")Integer count)throws Exception;
	//分页查询已成立社团
	@RequestMapping(value="/getExistedAssoLimit")
	public List<CspAssoManagement> getExistedAssoLimit(@RequestParam("page")Integer page,@RequestParam("count")Integer count) throws Exception;
	//分页查询待审核社团
	@RequestMapping(value="/getCheckingAssoLimit")
	public List<CspAssoManagement> getCheckingAssoLimit(@RequestParam("page")Integer page,@RequestParam("count")Integer count) throws Exception;
	//根据社团ID查询社团信息
	@RequestMapping(value="/getAssoById")
	public Object getAssoById(@RequestParam("id")Integer id)throws Exception;
	//根据社团编号查询社团
	@RequestMapping(value="/getAssoByAssoId")
	public Object getAssoByAssoId(@RequestParam("assoId")String assoId)throws Exception;
	//添加社团
	@RequestMapping(value="/insertOne")
	public int insertOne(@RequestBody AssoManagemrntDto asso)throws Exception;
	//删除单个社团
	@RequestMapping(value="/deleteOne")
	public int deleteOne(@RequestParam("id")Integer id)throws Exception;
	//批量删除社团
	@RequestMapping("/deleteList")
	public int deleteList(@RequestParam("deleteList") List<Integer> deleteList)throws Exception;
	//更新单个社团信息
	@RequestMapping(value="/updateOne")
	public int updateOne(@RequestBody AssoManagemrntDto asso)throws Exception;
	//批量审核社团
	@RequestMapping(value="/setCheckedAssoList")
	public int setCheckedAssoList(@RequestParam("checkList") List<Integer> checkList)throws Exception;
	
	/*
	 *	 指导老师管理
	 */
	
	//查询所有指导老师
	@RequestMapping("/getGuiderAll")
	public List<Object> getGuiderAll() throws Exception;
	//根据ID查询指导老师
	@RequestMapping("/getGuiderById")
	public Object getGuiderById(@RequestParam("id")Integer id)throws Exception;
	//根据工号查询指导老师 
	@RequestMapping("/getGuiderByTid")
	public Object getGuiderByTid(@RequestParam("tId")String tId) throws Exception;
	//根据姓名查询指导老师
	@RequestMapping("/getGuiderByName")
	public List<Object> getGuiderByName(@RequestParam("tName")String tName)throws Exception;
	//添加指导老师
	@RequestMapping("/insertGuiderOne")
	public int insertGuiderOne(@RequestBody Object guider)throws Exception;
	//根据ID删除指导老师
	@RequestMapping("/deleteGuiderOneById")
	public int deleteGuiderOneById(@RequestParam("id")Integer id)throws Exception;
	//根据工号删除指导老师
	@RequestMapping("/deleteGuiderOneByTid")
	public int deleteGuiderOneByTid(@RequestParam("tId")String tId)throws Exception;
	//批量删除指导老师
	@RequestMapping("/deleteGuiderListById")
	public int deleteGuiderListById(@RequestParam("idList")List<Integer> idList)throws Exception;
	//修改指导老师信息
	@RequestMapping("/updateGuiderOne")
	public int updateGuiderOne(Object guider) throws Exception;
	
	/*
	 * 学校管理
	 * */
	//查询所有学校
	@RequestMapping("/getAssoSchoolAll")
	public List<Object> getAssoSchoolAll() throws Exception;
	//根据ID查询学校
	@RequestMapping("/getAssoSchoolById")
	public Object getAssoSchoolById(@RequestParam("id")Integer id) throws Exception;
	//根据学校编号查询学校
	@RequestMapping("/getAssoSchoolBySNo")
	public Object getAssoSchoolBySNo(@RequestParam("sno")String sno) throws Exception;
	//根据省份编号查询学校
	@RequestMapping("/getAssoSchoolByProId")
	public List<Object> getAssoSchoolByProId(@RequestParam("proId")Integer proId) throws Exception;
	//根据城市编号查询学校
	@RequestMapping("/getAssoSchoolByCityId")
	public List<Object> getAssoSchoolByCityId(@RequestParam("cityId")Integer cityId) throws Exception;
	//根据学校名称查询学校
	@RequestMapping("/getAssoSchoolByName")
	public List<Object> getAssoSchoolByName(@RequestParam("name")String name) throws Exception;
	//增加一个学校
	@RequestMapping("/insertAssoSchoolOne")
	public int insertAssoSchoolOne(@RequestBody AssoSchoolDto school) throws Exception;
	//根据ID删除一个学校
	@RequestMapping("/deleteAssoSchoolOneById")
	public int deleteAssoSchoolOneById(@RequestParam("id")Integer id) throws Exception;
	//根据ID批量删除学校
	@RequestMapping("/deleteAssoSchoolListById")
	public int deleteAssoSchoolListById(@RequestParam("idList")List<Integer> idList) throws Exception;
	//根据学校编号删除一个学校
	@RequestMapping("/deleteAssoSchoolOneByNo")
	public int deleteAssoSchoolOneByNo(@RequestParam("no")String no) throws Exception;
	//根据学校编号批量删除学校
	@RequestMapping("/deleteAssoSchoolListByNo")
	public int deleteAssoSchoolListByNo(@RequestParam("noList")List<String> noList) throws Exception;
	//更新单个学校信息
	@RequestMapping("/updateAssoSchoolOne")
	public int updateAssoSchoolOne(@RequestBody AssoSchoolDto school) throws Exception;
	
	
	
	/*
	 * 学校单位管理
	 * */
	
	//查询所有学校单位
	@RequestMapping("/getUnitAll")
	public List<Object> getUnitAll()throws Exception;
	//根据ID查询学校单位
	@RequestMapping("/getUnitById")
	public Object getUnitById(@RequestParam("id")Integer id) throws Exception;
	//根据单位编号查询学校单位
	@RequestMapping("/getUnitByNo")
	public Object getUnitByNo(@RequestParam("no")String no) throws Exception;
	//根据上级单位查询学校单位
	@RequestMapping("/getUnitByPNo")
	public List<Object> getUnitByPNo(@RequestParam("pno")String pno) throws Exception;
	//删除单个学校部门
	@RequestMapping("/deleteUnitOne")
	public int deleteUnitOne(@RequestParam("id") Integer id)throws Exception;
	//添加单个学校部门
	@RequestMapping("/insertUnitOne")
	public int insertUnitOne(@RequestBody AssoSchoolUnitDto unit)throws Exception;
	
	/*
	 *	 学生管理
	 */
	//获取所有学生列表
	@RequestMapping("/getStuAll")
	public List<CspAssoStudent> getStuAll() throws Exception;
	//根据ID查询单个学生信息
	@RequestMapping("/getStuById")
	public CspAssoStudent getStuById(@RequestParam("id")Integer id)throws Exception;
	//根据学生学号查询单个学生信息
	@RequestMapping("/getStuBySId")
	public CspAssoStudent getStuBySId(@RequestParam("sid")String sid)throws Exception;	
	//根据学生姓名查询学生列表
	@RequestMapping("/getStuListByName")
	public List<CspAssoStudent> getStuListByName(@RequestParam("name")String name)throws Exception;
	//根据学生年段查询学生列表
	@RequestMapping("/getStuListByGrade")
	public List<CspAssoStudent> getStuListByGrade(@RequestParam("grade")Integer grade) throws Exception;	
	//根据学生专业班级查询学生列表
	@RequestMapping("/getStuListByMajor")
	public List<CspAssoStudent> getStuListByMajor(@RequestParam("major")String major) throws Exception;
	//根据学生性别查询学生列表
	@RequestMapping("/getStuListBySex")
	public List<CspAssoStudent> getStuListBySex(@RequestParam("sex")int sex) throws Exception;
	//根据学生当前参与活动ID获取学生列表
	@RequestMapping("/getStuListByActId")
	public List<CspAssoStudent> getStuListByActId(@RequestParam("actId")String actId) throws Exception;	
	//根据学生当前参与活动名称获取学生列表
	@RequestMapping("/getStuListByActName")
	public List<CspAssoStudent> getStuListByActName(@RequestParam("actName")String actName) throws Exception;
	//插入一条新的学生信息
	@RequestMapping("/insertStuOne")
	public int insertStuOne(@RequestBody Object student) throws Exception;
	//根据ID删除一条学生信息
	@RequestMapping("/deleteStuOneById")
	public int deleteStuOneById(@RequestParam("id")Integer id) throws Exception;	
	//根据ID删除多条学生信息
	@RequestMapping("/deleteStuListById")
	public int deleteStuListById(@RequestParam("idList")List<Integer> idList) throws Exception;
	//根据学生学号删除单条学生信息
	@RequestMapping("/deleteStuOneBySId")
	public int deleteStuOneBySId(@RequestParam("sid")String sid) throws Exception;
	//根据学生学号删除多条学生信息
	@RequestMapping("/deleteStuListBySId")
	public int deleteStuListBySId(@RequestParam("sidList")List<String> sidList) throws Exception;
	//更新单条学生信息
	@RequestMapping("/updateStuOne")
	public int updateStuOne(@RequestBody Object student) throws Exception;
	
	/*
	 * 关系管理
	 */	
	//查询所有关系
	@RequestMapping("/getRelationAll")
	public List<Object> getRelationAll()throws Exception;
	//根据社团编号查询关系
	@RequestMapping("/getRelationByAId")
	public List<Object> getRelationByAId(@RequestParam("assoId") String assoId)throws Exception;	
	//根据学生学号查询关系
	@RequestMapping("/getRelationBySId")
	public List<Object> getRelationBySId(@RequestParam("stuId") Integer stuId)throws Exception;
	//根据关系ID查询关系
	@RequestMapping("/getRelationById")
	public Object getRelationById(@RequestParam("id") Integer id)throws Exception;
	//根据社团编号和学生编号查询关系
	@RequestMapping("/getRelationByASId")
	public Object selectRelationByASId(@RequestParam("assoId")String assoId,@RequestParam("stuId")Integer stuId)throws Exception;
	//根据社团编号和学生编号删除关系
	@RequestMapping("/deleteRelationByASId")
	public int deleteRelationByASId(@RequestParam("assoId")String assoId,@RequestParam("stuId")Integer stuId)throws Exception;
	//根据社团编号查询关系条数
	@RequestMapping("/countRelationByAId")
	public int countRelationByAId(@RequestParam("assoId")String assoId) throws Exception;
	//根据学生学号查询关系条数
	@RequestMapping("/countRelationBySId")
	public int countRelationBySId(@RequestParam("stuId")Integer stuId) throws Exception;
	
	/*
	 * 	 活动管理
	 */
	// 查询所有活动
	@RequestMapping("/getActivityAll")
	public List<Object> getActivityAll() throws Exception;
	// 根据活动状态查询活动
	@RequestMapping("/getActivityNotStart")
	public List<Object> getActivityNotStart(@RequestParam("status") Integer status) throws Exception;
	// 根据活动ID查询活动
	@RequestMapping("/getActivityById")
	public Object getActivityById(@RequestParam("id") Integer id) throws Exception;
	// 根据活动名称查询活动
	@RequestMapping("/getActivityByName")
	public List<Object> getActivityByName(@RequestParam("name") String name) throws Exception;
	// 根据活动编号查询活动
	@RequestMapping("/getActicityByActId")
	public Object getActicityByActId(@RequestParam("actId") String actId) throws Exception;
	// 根据社团编号查询活动
	@RequestMapping("/getActivityByAId")
	public List<Object> getActivityByAId(@RequestParam("assoId") String assoId) throws Exception;
	// 根据活动负责人编号查询活动
	@RequestMapping("/getActivityByOId")
	public List<Object> getActivityByOId(@RequestParam("oId") String oId) throws Exception;
	// 添加活动
	@RequestMapping("/insertActivity")
	public int insertActicity(@RequestBody AssoActivityFormDto act) throws Exception;
	// 根据ID删除单个活动
	@RequestMapping("/deleteActivityOneById")
	public int deleteActivityOneById(@RequestParam("id") Integer id) throws Exception;
	// 根据ID删除多个活动
	@RequestMapping("/deleteActivityListById")
	public int deleteActivityListById(@RequestParam("idList") List<Integer> idList) throws Exception;
	// 根据活动编号删除活动
	@RequestMapping("/deleteActivityByActId")
	public int deleteActivityByActId(@RequestParam("actId") String actId) throws Exception;
	// 更新活动
	@RequestMapping("/updateActivityOne")
	public int updateActivityOne(@RequestBody Object act) throws Exception;
	//更新活动状态为开启
	@RequestMapping("/updateActivityStatusOpen")
	public int updateActivityStatusOpen(@RequestParam("id") Integer id)throws Exception;
	//更新活动状态为结束
	@RequestMapping("/updateActivityStatusClose")
	public int updateActivityStatusClose(@RequestParam("id") Integer id)throws Exception;
	//根据活动ID查询活动表单相关信息（社团成员，社团列表 ）
	@RequestMapping("/getAssoActFormDto")
	public AssoActivityFormDto getAssoActFormDto(@RequestParam("id")Integer actId)throws Exception;
}
