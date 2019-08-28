package cn.lhj.csp.assomanagement.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.lhj.csp.assomanagement.po.CspAssoStuRelation;
import cn.lhj.csp.assomanagement.service.CspAssoStuRelationService;

@RestController
@CrossOrigin
public class CspAssoStuRelationApi {

	@Autowired
	private CspAssoStuRelationService assoStuService;
	
	//查询所有关系
	@RequestMapping("/getRelationAll")
	public List<CspAssoStuRelation> getRelationAll()throws Exception{
		return assoStuService.getASRelationAll();
	}
	
	//根据社团编号查询关系
	@RequestMapping("/getRelationByAId")
	public List<CspAssoStuRelation> getRelationByAId(@RequestParam("assoId") String assoId)throws Exception{
		return assoStuService.getASRelationByAId(assoId);
	}
	
	//根据学生学号查询关系
	@RequestMapping("/getRelationBySId")
	public List<CspAssoStuRelation> getRelationBySId(@RequestParam("stuId") String stuId)throws Exception{
		return assoStuService.getASRelationBySId(stuId);
	}
	
	//根据关系ID查询关系
	@RequestMapping("/getRelationById")
	public CspAssoStuRelation getRelationById(@RequestParam("id") Integer id)throws Exception{
		return assoStuService.getASRelationById(id);
	}
	
	//根据社团编号和学生编号查询关系
	@RequestMapping("/getRelationByASId")
	public CspAssoStuRelation selectRelationByASId(@RequestParam("assoId")String assoId,@RequestParam("stuId")String stuId)throws Exception{
		return assoStuService.getRelationByASId(assoId, stuId);
	}

	//根据社团编号查询关系条数
	@RequestMapping("/countRelationByAId")
	public int countRelationByAId(@RequestParam("assoId")String assoId) throws Exception {
		return assoStuService.countRelationByAId(assoId);
	}
	
	//根据学生学号查询关系条数
	@RequestMapping("/countRelationBySId")
	public int countRelationBySId(@RequestParam("stuId")String stuId) throws Exception{
		return assoStuService.countRelationBySId(stuId);
	}


	//增加单个关系
	@RequestMapping("/insertRelationOne")
	public int insertRelationOne(@RequestBody CspAssoStuRelation relation)throws Exception{
		return assoStuService.insertRelationOne(relation);
	}
	
	//根据社团编号和学生编号删除关系
	@RequestMapping("/deleteRelationByASId")
	public int deleteRelationByASId(@RequestParam("assoId")String assoId,@RequestParam("stuId")String stuId)throws Exception{
		return assoStuService.deleteRelationByASId(assoId, stuId);
	}
	
}
