package cn.lhj.csp.asso.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.lhj.csp.asso.dto.AssoDetailDto;
import cn.lhj.csp.asso.po.CspAssoManagement;
import cn.lhj.csp.asso.service.CspAssoManagementService;

@RestController
@CrossOrigin
@RequestMapping("/AssoManagement")
public class CspAssoManagementAPI {
	
	@Autowired
	private CspAssoManagementService cspAssoManagementService;
	
	//查询所有社团
	@RequestMapping("/getAll")
	public List<CspAssoManagement> getAll()throws Exception{
		return cspAssoManagementService.getAll();
	}
	
	//分页查询所有社团
	@RequestMapping("/getAllAssoLimit")
	public List<CspAssoManagement> getAllAssoLimit(@RequestParam("page")Integer page,@RequestParam("count")Integer count)throws Exception{
		return cspAssoManagementService.getAllAssoLimit(page,count);
	}
	
	//分页查询已成立社团
	@RequestMapping("/getExistedAssoLimit")
	public List<CspAssoManagement> getExistedAssoLimit(@RequestParam("page")Integer page,@RequestParam("count")Integer count) throws Exception{
		return cspAssoManagementService.getExistedAssoLimit(page, count);
	}
	
	//分页查询待审核社团
	@RequestMapping("/getCheckingAssoLimit")
	public List<CspAssoManagement> getCheckingAssoLimit(@RequestParam("page")Integer page,@RequestParam("count")Integer count) throws Exception{
		return cspAssoManagementService.getCheckingAssoLimit(page, count);
	}
	
	//根据社团ID查询社团信息
	@RequestMapping("/getAssoById")
	public CspAssoManagement getAssoById(@RequestParam("id")Integer id)throws Exception{
		return cspAssoManagementService.getAssoById(id);
	}
	
	//根据社团编号查询社团
	@RequestMapping("/getAssoByAssoId")
	public CspAssoManagement getAssoByAssoId(@RequestParam("assoId")String assoId)throws Exception{
		return cspAssoManagementService.getAssoByAssoId(assoId);
	}
	//添加社团
	@RequestMapping("/insertOne")
	public int insertOne(@RequestBody CspAssoManagement asso)throws Exception{
		return cspAssoManagementService.insertOne(asso);
	}
	
	//删除单个社团
	@RequestMapping("/deleteOne")
	public int deleteOne(@RequestParam("id")Integer id)throws Exception{
		return cspAssoManagementService.deleteOne(id);
	}
	
	//更新单个社团信息
	@RequestMapping("/updateOne")
	public int updateOne(@RequestBody CspAssoManagement asso)throws Exception{
		//CspAssoManagement asso=JSON.parseObject(getMsg, CspAssoManagement.class);
		//System.out.println(asso.toString());
		//System.out.println(asso.getAssoExamined());
		return cspAssoManagementService.updateOne(asso);
	}
	
	//批量审核社团
	@RequestMapping("/setCheckedAssoList")
	public int setCheckedAssoList(@RequestParam("checkList") List<Integer> checkList)throws Exception{
		return cspAssoManagementService.setCheckedAssoList(checkList);
	}
	
	//批量删除社团
	@RequestMapping("/deleteList")
	public int deleteList(@RequestParam("deleteList") List<Integer> deleteList)throws Exception{
		return cspAssoManagementService.deleteList(deleteList);
	}
	
	//查询社团详细信息
	@RequestMapping("/getAssoDetail")
	public AssoDetailDto getAssoDetail(@RequestParam("assoId")String assoId) throws Exception{
		return cspAssoManagementService.getAssoDetail(assoId);
	}
}
