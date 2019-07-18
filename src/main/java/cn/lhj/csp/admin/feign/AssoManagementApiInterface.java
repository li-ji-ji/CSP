package cn.lhj.csp.admin.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import cn.lhj.csp.admin.dto.AssoManagemrntDto;



@FeignClient(name="csp-admin-asso-management")
public interface AssoManagementApiInterface {

	/*
	 *	社团管理
	 */
	
	//查询所有社团
	@RequestMapping(value="/getAll")
	public List<Object> getAll()throws Exception;
	//分页查询所有社团
	@RequestMapping(value="/getAllAssoLimit")
	public List<Object> getAllAssoLimit(@RequestParam("page")Integer page,@RequestParam("count")Integer count)throws Exception;
	//分页查询已成立社团
	@RequestMapping(value="/getExistedAssoLimit")
	public List<Object> getExistedAssoLimit(@RequestParam("page")Integer page,@RequestParam("count")Integer count) throws Exception;
	//分页查询待审核社团
	@RequestMapping(value="/getCheckingAssoLimit")
	public List<Object> getCheckingAssoLimit(@RequestParam("page")Integer page,@RequestParam("count")Integer count) throws Exception;
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
	 *	 学生管理
	 */
	//获取所有学生列表
	@RequestMapping("/getStuAll")
	public List<Object> getStuAll() throws Exception;
	//根据ID查询单个学生信息
	@RequestMapping("/getStuById")
	public Object getStuById(@RequestParam("id")Integer id)throws Exception;
	//根据学生学号查询单个学生信息
	@RequestMapping("/getStuBySId")
	public Object getStuBySId(@RequestParam("sid")String sid)throws Exception;	
	//根据学生姓名查询学生列表
	@RequestMapping("/getStuListByName")
	public List<Object> getStuListByName(@RequestParam("name")String name)throws Exception;
	//根据学生年段查询学生列表
	@RequestMapping("/getStuListByGrade")
	public List<Object> getStuListByGrade(@RequestParam("grade")Integer grade) throws Exception;	
	//根据学生专业班级查询学生列表
	@RequestMapping("/getStuListByMajor")
	public List<Object> getStuListByMajor(@RequestParam("major")String major) throws Exception;
	//根据学生性别查询学生列表
	@RequestMapping("/getStuListBySex")
	public List<Object> getStuListBySex(@RequestParam("sex")int sex) throws Exception;
	//根据学生当前参与活动ID获取学生列表
	@RequestMapping("/getStuListByActId")
	public List<Object> getStuListByActId(@RequestParam("actId")String actId) throws Exception;	
	//根据学生当前参与活动名称获取学生列表
	@RequestMapping("/getStuListByActName")
	public List<Object> getStuListByActName(@RequestParam("actName")String actName) throws Exception;
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
}
