package cn.yzj.csp.task.service.Interface;

import java.util.List;

import cn.yzj.csp.task.po.Express;

public interface ExpressInterface {
	public int insertExpress(Express express) throws Exception;

	public int insertExpressList(String expresses) throws Exception;

	public List<List<Express>> selectBySuperiortaskId(String ids) throws Exception;

//	public boolean updateById(Tasktype tasktype)throws Exception;
	public List<Express> findExpressAll() throws Exception;
	
	public List<Express> findExpressByPid(String ids)throws Exception;

}
