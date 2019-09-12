package cn.yzj.shop.service.implement;
/**
 * 导航实现类
 */
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yzj.shop.mapper.NavigationMapper;
import cn.yzj.shop.po.Msg;
import cn.yzj.shop.po.Navigation;
import cn.yzj.shop.po.NavigationExample;
import cn.yzj.shop.service.NavigationService;
import cn.yzj.shop.systemclass.Code;

@Service
public class NavigationServiceImp implements NavigationService {

	@Autowired
	private NavigationMapper navigationMapper;
	
	Msg msg = new Msg();
	
	@Override
	public Msg add(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Msg delete(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Msg updata(Serializable id) {
		//修改导航信息
		if (navigationMapper.updateByPrimaryKeySelective((Navigation) id) > 0) {
			msg.setCode(Code.SUCCESS.getCode());
			msg.setMsg(Code.SUCCESS.getMsg());
		}else {
			msg.setCode(Code.FAIL.getCode());
			msg.setMsg(Code.FAIL.getMsg());
		}
		return msg;
	}

	@Override
	public Serializable find(Serializable id) {
		//根据导航ID查询一条导航信息
		Navigation navigation = navigationMapper.selectByPrimaryKey((Integer) id);
		return navigation;
	}

	@Override
	public Serializable find() {
		//根据导航ID和排序升序进行查询
		NavigationExample example = new NavigationExample();
		example.setOrderByClause("id ASC,sort ASC");
		List<Navigation> navigations = navigationMapper.selectByExample(example);
		return (Serializable)navigations;
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
