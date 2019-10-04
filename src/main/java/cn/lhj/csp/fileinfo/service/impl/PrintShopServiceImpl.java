package cn.lhj.csp.fileinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lhj.csp.fileinfo.mapper.PrintShopMapper;
import cn.lhj.csp.fileinfo.po.PrintShop;
import cn.lhj.csp.fileinfo.po.PrintShopExample;
import cn.lhj.csp.fileinfo.service.PrintShopService;


@Service
public class PrintShopServiceImpl implements PrintShopService{
	
	@Autowired
	private PrintShopMapper printShopMapper;
	
	@Override
	public List<PrintShop> getAll() {
		// TODO Auto-generated method stub
		return printShopMapper.selectByExample(null);
	}

	@Override
	public String insert(PrintShop printShop) {
		// TODO Auto-generated method stub
		printShopMapper.insert(printShop);
		return "插入成功";
	}

	@Override
	public String delete(Integer id) {
		// TODO Auto-generated method stub
		printShopMapper.deleteByPrimaryKey(id);
		return "删除成功";
	}

	@Override
	public String update(PrintShop printShop) {
		// TODO Auto-generated method stub
		printShopMapper.updateByPrimaryKeySelective(printShop);
		return "修改成功";
	}

	@Override
	public PrintShop findById(Integer id) {
		// TODO Auto-generated method stub
		return printShopMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<PrintShop> findByLocation(String location) {
		// TODO Auto-generated method stub
		PrintShopExample example = new PrintShopExample();
		PrintShopExample.Criteria criteria = example.createCriteria();
		criteria.andLocationEqualTo(location);
		return printShopMapper.selectByExample(example);
	}

}
