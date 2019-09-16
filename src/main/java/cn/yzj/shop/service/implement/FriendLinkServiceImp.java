package cn.yzj.shop.service.implement;

/**
 * 友情链接实现类
 */
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yzj.shop.mapper.FriendLinkMapper;
import cn.yzj.shop.po.FriendLink;
import cn.yzj.shop.po.FriendLinkExample;
import cn.yzj.shop.po.Msg;
import cn.yzj.shop.service.FriendLinkService;
import cn.yzj.shop.systemclass.Code;

@Service
public class FriendLinkServiceImp implements FriendLinkService {

	@Autowired
	private FriendLinkMapper friendLinkMapper;
	
	Msg msg = new Msg();
	
	@Override
	public Msg add(Serializable id) throws Exception {
		//添加友情链接
		if (friendLinkMapper.insertSelective((FriendLink) id) >0 ) {
			msg.setCode(Code.SUCCESS.getCode());
			msg.setMsg(Code.SUCCESS.getMsg());
		}else {
			msg.setCode(Code.FAIL.getCode());
			msg.setMsg(Code.FAIL.getMsg());
		}
		return msg;
	}

	@Override
	public Msg delete(Serializable id) throws Exception {
		//根据linkId删除一条友情链接
		if(friendLinkMapper.deleteByPrimaryKey((Short) id)>0) {
			msg.setCode(Code.SUCCESS.getCode());
			msg.setMsg(Code.SUCCESS.getMsg());
		}else {
			msg.setCode(Code.FAIL.getCode());
			msg.setMsg(Code.FAIL.getMsg());
		}
		
		return msg;
	}

	@Override
	public Msg updata(Serializable id) throws Exception {
		//修改友情链接
		if (friendLinkMapper.updateByPrimaryKeySelective((FriendLink) id) > 0) {
			msg.setCode(Code.SUCCESS.getCode());
			msg.setMsg(Code.SUCCESS.getMsg());
		}else {
			msg.setCode(Code.FAIL.getCode());
			msg.setMsg(Code.FAIL.getMsg());
		}
		return msg;
	}

	@Override
	public Serializable find(Serializable id) throws Exception {
		//根据导航ID查询一条友情链接信息
		FriendLink friendLink = friendLinkMapper.selectByPrimaryKey((Short) id);
		return friendLink;
	}

	@Override
	public Serializable find() throws Exception {
		//获取所有友情链接,按排序升序
		FriendLinkExample example = new FriendLinkExample();
		example.setOrderByClause("orderby ASC");
		List<FriendLink> friendLinks = friendLinkMapper.selectByExample(example);
		return (Serializable) friendLinks;
	}

	@Override
	public Serializable dataPage(int limit, int page, Serializable id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable dataPage(int limit, int page) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Msg batchDeleteFriendLink(List<Short> idList) throws Exception {
		//批量删除友情链接
		FriendLinkExample example = new FriendLinkExample();
		example.createCriteria().andLinkIdIn(idList);
		if(friendLinkMapper.deleteByExample(example) > 0) {
			msg.setCode(Code.SUCCESS.getCode());
			msg.setMsg(Code.SUCCESS.getMsg());
		}else {
			msg.setCode(Code.FAIL.getCode());
			msg.setMsg(Code.FAIL.getMsg());
		}
		
		return msg;
	}

}
