package cn.yzj.shop.service.implement;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yzj.shop.mapper.PickUpMapper;
import cn.yzj.shop.po.Msg;
import cn.yzj.shop.po.PickUp;
import cn.yzj.shop.po.PickUpExample;
import cn.yzj.shop.service.PickUpService;
import cn.yzj.shop.systemclass.Code;

@Service
public class PickUpServiceImp implements PickUpService{
	
	@Autowired
	private PickUpMapper pickUpMapper;
	
	Msg msg = new Msg();
	
	@Override
	public Msg add(Serializable id) {
		// TODO Auto-generated method stub
		if(pickUpMapper.insertSelective((PickUp) id)>0) {
			msg.setCode(Code.SUCCESS.getCode());
			msg.setMsg(Code.SUCCESS.getMsg());
		}
		return msg;
	}

	@Override
	public Msg delete(Serializable id) {
		// TODO Auto-generated method stub
		if(pickUpMapper.deleteByPrimaryKey((Integer) id)>0) {
			msg.setCode(Code.SUCCESS.getCode());
			msg.setMsg(Code.SUCCESS.getMsg());
		}
		return msg;
	}

	@Override
	public Msg updata(Serializable id) {
		// TODO Auto-generated method stub
		if(pickUpMapper.updateByPrimaryKeySelective((PickUp) id)>0) {
			msg.setCode(Code.SUCCESS.getCode());
			msg.setMsg(Code.SUCCESS.getMsg());
		}
		return msg;
	}

	@Override
	public Serializable find(Serializable id) {
		// TODO Auto-generated method stub
		return pickUpMapper.selectByPrimaryKey((Integer) id);
	}

	@Override
	public Serializable find() {
		// TODO Auto-generated method stub
		List<PickUp> pickUps = pickUpMapper.selectByExample(null);
		return (Serializable) pickUps;
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
	public List<PickUp> selectByName(String name) {
		// TODO Auto-generated method stub
		PickUpExample example = new PickUpExample();
		PickUpExample.Criteria criteria = example.createCriteria();
		criteria.andPickupNameLike("%"+name+"%");
		return pickUpMapper.selectByExample(example);
	}

}
