package cn.yzj.shop.service.implement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.yzj.shop.mapper.Region2Mapper;
import cn.yzj.shop.po.Msg;
import cn.yzj.shop.po.Region2;
import cn.yzj.shop.po.Region2DTO;
import cn.yzj.shop.po.Region2Example;
import cn.yzj.shop.service.Region2Service;
import cn.yzj.shop.systemclass.Code;

public class Region2ServiceImp implements Region2Service {

	@Autowired
	private Region2Mapper region2Mapper;

	Msg msg = new Msg();

	@Override
	public Msg add(Serializable id) {
		// TODO Auto-generated method stub

		if (region2Mapper.insertSelective((Region2) id) > 0) {
			msg.setCode(Code.SUCCESS);
		}
		return msg;
	}

	@Override
	public Msg delete(Serializable id) {
		// TODO Auto-generated method stub
		if (region2Mapper.deleteByPrimaryKey((Integer) id) > 0) {
			msg.setCode(Code.SUCCESS);
		}
		return msg;
	}

	@Override
	public Msg updata(Serializable id) {
		// TODO Auto-generated method stub
		if (region2Mapper.updateByPrimaryKeySelective((Region2) id) > 0) {
			msg.setCode(Code.SUCCESS);
		}
		return msg;
	}

	@Override
	public Serializable find(Serializable pid) {
		// TODO Auto-generated method stub
		List<Region2> region2s = new ArrayList<Region2>();
		Region2Example example = new Region2Example();
		example.createCriteria().andParentIdEqualTo((Integer) pid);
		region2s = region2Mapper.selectByExample(example);
		return (Serializable) region2s;
	}

	@Override
	public Serializable find() {
		// TODO Auto-generated method stub
		List<Region2DTO> region2DTO = new ArrayList<Region2DTO>();
		List<Region2> region2 = new ArrayList<Region2>();
		Region2Example example = new Region2Example();
		example.createCriteria().andParentIdEqualTo(0);
		return (Serializable) region2Mapper.countByExample(null);
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

}
