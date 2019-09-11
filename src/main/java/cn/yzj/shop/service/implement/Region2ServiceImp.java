package cn.yzj.shop.service.implement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yzj.shop.mapper.Region2Mapper;
import cn.yzj.shop.po.Msg;
import cn.yzj.shop.po.Region2;
import cn.yzj.shop.po.Region2DTO;
import cn.yzj.shop.po.Region2DTOTWO;
import cn.yzj.shop.po.Region2Example;
import cn.yzj.shop.service.Region2Service;
import cn.yzj.shop.systemclass.Code;

@Service
public class Region2ServiceImp implements Region2Service {

	@Autowired
	private Region2Mapper region2Mapper;

	Msg msg = new Msg();

	@Override
	public Msg add(Serializable id) {
		// TODO Auto-generated method stub

		if (region2Mapper.insertSelective((Region2) id) > 0) {
			msg.setCode(Code.SUCCESS.getCode());
			msg.setMsg(Code.SUCCESS.getMsg());
		}
		return msg;
	}

	@Override
	public Msg delete(Serializable id) {
		// TODO Auto-generated method stub
		if (region2Mapper.deleteByPrimaryKey((Integer) id) > 0) {
			msg.setCode(Code.SUCCESS.getCode());
			msg.setMsg(Code.SUCCESS.getMsg());
		}
		return msg;
	}

	@Override
	public Msg updata(Serializable id) {
		// TODO Auto-generated method stub
		if (region2Mapper.updateByPrimaryKeySelective((Region2) id) > 0) {
			msg.setCode(Code.SUCCESS.getCode());
			msg.setMsg(Code.SUCCESS.getMsg());
		}
		return msg;
	}

	@Override
	public Serializable find(Serializable id) {
		// TODO Auto-generated method stub
		Region2Example example = new Region2Example();
		Region2Example.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo((Integer) id);
		List<Region2> region2s = region2Mapper.selectByExample(example);
		return (Serializable) region2s;
	}

	@Override
	public Serializable find() {
		// TODO Auto-generated method stub
		List<Region2DTOTWO> region2DTOTWOs = new ArrayList<Region2DTOTWO>();
		List<Region2> region2 = region2Mapper.selectByParentId(0);
		try {
			for (Region2 region21 : region2) {
				Region2DTOTWO region2DTOTWO = new Region2DTOTWO();
				region2DTOTWO.setRegion2(region21);
				List<Region2> region22 = region2Mapper.selectByParentId(region21.getId());
				List<Region2DTO> region2DTOs = new ArrayList<Region2DTO>();
				for (Region2 region23 : region22) {
					Region2DTO region2DTO = new Region2DTO();
					region2DTO.setRegion2(region23);
					List<Region2> region24 = region2Mapper.selectByParentId(region23.getId());
					region2DTO.setRegion2s(region24);
					region2DTOs.add(region2DTO);
				}
				region2DTOTWO.setRegion2DTO(region2DTOs);
				region2DTOTWOs.add(region2DTOTWO);
			}
		} catch (Exception e) {
		}
		return (Serializable) region2DTOTWOs;
	}

	@Override
	public Serializable dataPage(int limit, int page, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable dataPage(int limit, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Region2> selectByPid(Integer pid) {
		// TODO Auto-generated method stub
		return region2Mapper.selectByParentId(pid);
	}

}
