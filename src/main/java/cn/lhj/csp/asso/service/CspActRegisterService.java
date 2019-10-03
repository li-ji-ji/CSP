package cn.lhj.csp.asso.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.lhj.csp.asso.po.CspActRegister;

@Service
public interface CspActRegisterService {

/*------------------------------------------查询---------------------------------------------------*/
	//查询所有签到记录
	public List<CspActRegister> getActRegAll()throws Exception;
	//根据活动编号查询签到记录
	public List<CspActRegister> getActRegByActId(String actId)throws Exception;
	//根据学生学号查询签到记录
	public List<CspActRegister> getActRegByStuId(String stuId)throws Exception;
	//根据活动编号以及学生学号查询签到记录
	public CspActRegister getActRegByActIdAndStuId(String actId,String stuId)throws Exception;
	
/*------------------------------------------查询---------------------------------------------------*/
/*------------------------------------------删除---------------------------------------------------*/
	//根据ID删除签到记录
	public int delActRegById(Integer id) throws Exception;
/*------------------------------------------删除---------------------------------------------------*/
/*------------------------------------------添加---------------------------------------------------*/
	//添加一条签到记录
	public int addActRegOne(CspActRegister register) throws Exception;
/*------------------------------------------添加---------------------------------------------------*/
/*------------------------------------------修改---------------------------------------------------*/
	//根据活动ID和学生学号修改签到状态
	public int setRegStatusByActIdAndStuId(String actId,String stuId,Integer status)throws Exception;
/*------------------------------------------修改---------------------------------------------------*/
	
}
