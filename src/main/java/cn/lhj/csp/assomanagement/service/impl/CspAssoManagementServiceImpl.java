package cn.lhj.csp.assomanagement.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.lhj.csp.assomanagement.dto.AssoDetailDto;
import cn.lhj.csp.assomanagement.mapper.AssoGuiderMapper;
import cn.lhj.csp.assomanagement.mapper.CspAssoManagementMapper;
import cn.lhj.csp.assomanagement.po.CspAssoManagement;
import cn.lhj.csp.assomanagement.po.CspAssoManagementExample;
import cn.lhj.csp.assomanagement.po.CspAssoStuRelation;
import cn.lhj.csp.assomanagement.po.CspAssoStudent;
import cn.lhj.csp.assomanagement.service.CspAssoManagementService;
import cn.lhj.csp.assomanagement.service.CspAssoSchoolUnitService;
import cn.lhj.csp.assomanagement.service.CspAssoStuRelationService;
import cn.lhj.csp.assomanagement.service.CspAssoStudentService;
import cn.lhj.csp.assomanagement.utils.RandomAssoId;

@Service
public class CspAssoManagementServiceImpl implements CspAssoManagementService {

	@Autowired
	private CspAssoManagementMapper cspAssoManagementMapper;
	
	@Autowired
	private AssoGuiderMapper assoGuiderMapper;
	
	@Autowired
	private CspAssoSchoolUnitService cspSchoolUnitService;

	@Autowired
	private CspAssoStuRelationService cspAssoStuRelationService;
	
	@Autowired
	private CspAssoStudentService cspAssoStudentService;
	
	//查询所有社团
	@Override
	public List<CspAssoManagement> getAll() throws Exception {
		return cspAssoManagementMapper.selectByExample(null);
	}

	//分页查询社团
	@Override
	public List<CspAssoManagement> getAllAssoLimit(Integer page,Integer count) throws Exception {
		PageHelper.startPage(page,count);
		return cspAssoManagementMapper.selectByExample(null);
	}

	//分页查询已成立社团
	@Override
	public List<CspAssoManagement> getExistedAssoLimit(Integer page,Integer count) throws Exception{
		PageHelper.startPage(page,count);
		CspAssoManagementExample example=new CspAssoManagementExample();
		CspAssoManagementExample.Criteria criteria=example.createCriteria();
		criteria.andAssoStatusEqualTo(1);
		return cspAssoManagementMapper.selectByExample(example);
	}
	
	//分页查询待审核社团
	@Override
	public List<CspAssoManagement> getCheckingAssoLimit(Integer page,Integer count) throws Exception{
		PageHelper.startPage(page,count);
		CspAssoManagementExample example=new CspAssoManagementExample();
		CspAssoManagementExample.Criteria criteria=example.createCriteria();
		criteria.andAssoExaminedEqualTo(0);
		return cspAssoManagementMapper.selectByExample(example);
	}
	
	//根据社团ID查询社团信息
	@Override
	public CspAssoManagement getAssoById(Integer id)throws Exception{
		return cspAssoManagementMapper.selectByPrimaryKey(id);
	}
	
	//根据社团编号查询社团
	@Override
	public CspAssoManagement getAssoByAssoId(String assoId)throws Exception{
		CspAssoManagementExample example=new CspAssoManagementExample();
		CspAssoManagementExample.Criteria criteria=example.createCriteria();
		criteria.andAssoIdEqualTo(assoId);
		try {
			CspAssoManagement asso=cspAssoManagementMapper.selectByExample(example).get(0);
			return asso;
		} catch (Exception e) {
			return null;
		}
	}
	
	//添加社团
	@Override
	public int insertOne(CspAssoManagement asso) throws Exception {
		Date now=new Date();
		RandomAssoId randomAssoId=new RandomAssoId(); //根据日期生成随机ID
		String assoId=randomAssoId.getRandomAssoId(now);
		while(getAssoByAssoId(assoId)!=null){
			//判断随机ID是否重复
			assoId=randomAssoId.getRandomAssoId(now); 
		}
		asso.setAssoGuiderName(assoGuiderMapper.selectByPrimaryKey(asso.getAssoGuiderId()).gettName());
		asso.setAssoEstablishmentTime(now);//传入申请日期
		asso.setAssoAffiliateName(cspSchoolUnitService.getUnitByNo(asso.getAssoAffiliateNo()).getUnitName());
		asso.setAssoId(assoId);
		try {
			cspAssoManagementMapper.insertSelective(asso);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	//删除单个社团
	@Override
	public int deleteOne(Integer id) throws Exception {
		try {
			cspAssoManagementMapper.deleteByPrimaryKey(id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	//更新单个社团信息
	@Override
	public int updateOne(CspAssoManagement asso)throws Exception{
		if(asso.getAssoExamined()==null) {
			asso.setAssoExamined(0);
		}
		if(asso.getAssoStatus()==null) {
			asso.setAssoStatus(0);
		}
		try {
			asso.setAssoAffiliateName(cspSchoolUnitService.getUnitByNo(asso.getAssoAffiliateNo()).getUnitName());
			asso.setAssoGuiderName(assoGuiderMapper.selectByPrimaryKey(asso.getAssoGuiderId()).gettName());
			cspAssoManagementMapper.updateByPrimaryKeySelective(asso);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	//更新社团审核状态和成立状态
	public int updateAssoExisted(Integer id)throws Exception{
		CspAssoManagement asso=new CspAssoManagement();
		Date now=new Date();
		asso.setAssoEstablishmentTime(now); //传入成立时间
		asso.setId(id);
		asso.setAssoExamined(1);
		asso.setAssoStatus(1);
		try {
			cspAssoManagementMapper.updateByPrimaryKeySelective(asso);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	//批量删除社团
	public int deleteList(List<Integer> deleteList)throws Exception{
		try {
			for(Integer id:deleteList) {
				cspAssoManagementMapper.deleteByPrimaryKey(id);
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	//批量审核社团
	public int setCheckedAssoList(List<Integer> checkList)throws Exception{
		try {
			for(Integer id:checkList) {
				updateAssoExisted(id);
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	//查询社团详细信息
	public AssoDetailDto getAssoDetail(String assoId) throws Exception {
		CspAssoManagement asso=getAssoByAssoId(assoId);
		AssoDetailDto assoDetail=new AssoDetailDto();
		BeanUtils.copyProperties(asso, assoDetail); 
		//System.out.println(assoDetail.toString());
		assoDetail.setMemberNum(cspAssoStuRelationService.countRelationByAId(assoId));
		List<CspAssoStuRelation> relationList=cspAssoStuRelationService.getASRelationByAId(assoId);
		List<CspAssoStudent> stuList=new ArrayList<>();
		for(CspAssoStuRelation relation:relationList) {
			CspAssoStudent stu=cspAssoStudentService.getBySId(relation.getStuId());
			stuList.add(stu);
		}
		//System.out.println(stuList);
		assoDetail.setMemberList(stuList);
		//System.out.println(assoDetail.toString());
		return assoDetail;
	}
}
