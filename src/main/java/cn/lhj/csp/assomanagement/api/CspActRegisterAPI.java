package cn.lhj.csp.assomanagement.api;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.lhj.csp.assomanagement.po.CspActRegister;
import cn.lhj.csp.assomanagement.service.CspActRegisterService;

@RestController
@CrossOrigin
public class CspActRegisterAPI {

	@Autowired
	private CspActRegisterService actReg;
	
	/*------------------------------------------查询---------------------------------------------------*/
	//查询所有签到记录
	@RequestMapping("/getActRegAll")
	public List<CspActRegister> getActRegAll() throws Exception {
		return actReg.getActRegAll();
	}

	//根据活动编号查询签到记录
	@RequestMapping("/getActRegByActId")
	public List<CspActRegister> getActRegByActId(@RequestParam("actId")String actId) throws Exception {
		return actReg.getActRegByActId(actId);
	}

	//根据学生学号查询签到记录
	@RequestMapping("/getActRegByStuId")
	public List<CspActRegister> getActRegByStuId(@RequestParam("stuId")String stuId) throws Exception {
		return actReg.getActRegByActId(stuId);
	}

	//根据活动编号以及学生学号查询签到记录
	@RequestMapping("/getActRegByActIdAndStuId")
	public CspActRegister getActRegByActIdAndStuId(@RequestParam("actId")String actId,@RequestParam("stuId") String stuId) throws Exception {
		return actReg.getActRegByActIdAndStuId(actId, stuId);
	}

/*------------------------------------------查询---------------------------------------------------*/
	

/*------------------------------------------删除---------------------------------------------------*/
	//根据ID删除签到记录
	@RequestMapping("/delActRegById")
	public int delActRegById(@RequestParam("id")Integer id) throws Exception {
		return actReg.delActRegById(id);
	}

/*------------------------------------------删除---------------------------------------------------*/
	
	
/*------------------------------------------添加---------------------------------------------------*/
	//添加一条签到记录
	@RequestMapping("/addActRegOne")
	public int addActRegOne(@RequestParam("actId")String actId,@RequestParam("stuId")String stuId,@RequestParam("regImg")String registerImg) throws Exception {
		CspActRegister register=new CspActRegister();
		register.setActId(actId);
		register.setStuId(stuId);
		register.setRegisterImg(registerImg);
		Date now=new Date();
		register.setRegisterTime(now);
		return actReg.addActRegOne(register);
	}



/*------------------------------------------添加---------------------------------------------------*/
	
	

/*------------------------------------------修改---------------------------------------------------*/
	//根据活动ID和学生学号修改签到状态
	@RequestMapping("/setRegStatusByActIdAndStuId")
	public int setRegStatusByActIdAndStuId(@RequestParam("actId")String actId,@RequestParam("stuId")String stuId,@RequestParam("status")Integer status) throws Exception {
		return actReg.setRegStatusByActIdAndStuId(actId, stuId, status);
	}
/*------------------------------------------修改---------------------------------------------------*/
}
