package cn.lhj.csp.fileinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lhj.csp.fileinfo.mapper.ShopCartMapper;
import cn.lhj.csp.fileinfo.po.ShopCart;
import cn.lhj.csp.fileinfo.po.ShopCartExample;
import cn.lhj.csp.fileinfo.service.ShopCartInfoService;


@Service
public class ShopCartInfoServiceImpl implements ShopCartInfoService{
	
	@Autowired
	private ShopCartMapper shopCartMapper;
	
	@Override
	public List<ShopCart> getAll() {
		// TODO Auto-generated method stub
		return shopCartMapper.selectByExample(null);
	}

	@Override
	public int insert(ShopCart shopCart) {
		// TODO Auto-generated method stub
		return shopCartMapper.insertSelective(shopCart);
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return shopCartMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int update(ShopCart shopCart) {
		// TODO Auto-generated method stub
		return shopCartMapper.updateByPrimaryKey(shopCart);
	}

	@Override
	public ShopCart findById(Integer id) {
		// TODO Auto-generated method stub
		return shopCartMapper.selectByPrimaryKey(id);
	}

	@Override
	public ShopCart selectByOrderNo(String orderNo) {
		// TODO Auto-generated method stub
		return shopCartMapper.selectByOrderNo(orderNo);
	}

	@Override
	public List<ShopCart> selectListByOrderNo(String orderNo) {
		// TODO Auto-generated method stub
		ShopCartExample example = new ShopCartExample();
		ShopCartExample.Criteria criteria = example.createCriteria();
		criteria.andOrderNoEqualTo(orderNo);
		return shopCartMapper.selectByExample(example);
	}

	@Override
	public List<ShopCart> selectByStudentId(Integer studentId) {
		// TODO Auto-generated method stub
		ShopCartExample example = new ShopCartExample();
		ShopCartExample.Criteria criteria = example.createCriteria();
		criteria.andStudentIdEqualTo(studentId);
		return shopCartMapper.selectByExample(example);
	}

	@Override
	public List<ShopCart> findByStatus(String status) {
		// TODO Auto-generated method stub
		ShopCartExample example = new ShopCartExample();
		ShopCartExample.Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(status);
		return shopCartMapper.selectByExample(example);
	}

}
