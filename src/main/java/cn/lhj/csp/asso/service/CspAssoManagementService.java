package cn.lhj.csp.asso.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.lhj.csp.asso.dto.AssoDetailDto;
import cn.lhj.csp.asso.po.CspAssoManagement;

@Service
public interface CspAssoManagementService {

	//查询所有社团
	public List<CspAssoManagement> getAll()throws Exception;
	
	//分页查询所有社团
	public List<CspAssoManagement> getAllAssoLimit(Integer page,Integer count) throws Exception;
	
	//分页查询已成立社团
	public List<CspAssoManagement> getExistedAssoLimit(Integer page,Integer count) throws Exception;
	
	//分页查询待审核社团
	public List<CspAssoManagement> getCheckingAssoLimit(Integer page,Integer count) throws Exception; 
	
	//根据社团ID查询社团信息
	public CspAssoManagement getAssoById(Integer id)throws Exception;
	
	//根据社团编号查询社团
	public CspAssoManagement getAssoByAssoId(String assoId)throws Exception;
	
	//查看社团详细信息
	public AssoDetailDto getAssoDetail(String assoId)throws Exception;
	
	//添加社团
	public int insertOne(CspAssoManagement asso)throws Exception;
	
	//删除社团
	public int deleteOne(Integer id)throws Exception;
	
	//批量删除社团
	public int deleteList(List<Integer> deleteList)throws Exception;
	
	//更新社团信息
	public int updateOne(CspAssoManagement asso)throws Exception;
	
	
	//批量审核社团
	public int setCheckedAssoList(List<Integer> checkList)throws Exception;
	
	//更新社团审核状态和成立状态
	public int updateAssoExisted(Integer id)throws Exception;
}
