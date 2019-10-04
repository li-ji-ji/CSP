package cn.lhj.csp.fileinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lhj.csp.fileinfo.mapper.PrintOrderMapper;
import cn.lhj.csp.fileinfo.po.PrintOrder;
import cn.lhj.csp.fileinfo.po.PrintOrderExample;
import cn.lhj.csp.fileinfo.service.PrintOrderService;


@Service
public class PrintOrderServiceImpl implements PrintOrderService{

	@Autowired
	private PrintOrderMapper printOrderMapper;
	
	@Override
	public List<PrintOrder> getAll() {
		// TODO Auto-generated method stub
		return printOrderMapper.selectByExample(null);
	}

	@Override
	public int insert(PrintOrder printOrder) {
		// TODO Auto-generated method stub
		return printOrderMapper.insertSelective(printOrder);
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return printOrderMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int update(PrintOrder printOrder) {
		// TODO Auto-generated method stub
		return printOrderMapper.updateByPrimaryKeySelective(printOrder);
	}

	@Override
	public PrintOrder findById(Integer id) {
		// TODO Auto-generated method stub
		return printOrderMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<PrintOrder> findByStudentId(Integer studentId) {
		// TODO Auto-generated method stub
		PrintOrderExample example = new PrintOrderExample();
		PrintOrderExample.Criteria criteria = example.createCriteria();
		criteria.andStudentIdEqualTo(studentId);
		return printOrderMapper.selectByExample(example);
	}

	@Override
	public PrintOrder selectByOrderNo(String orderNo) {
		// TODO Auto-generated method stub
		return printOrderMapper.selectByOrderNo(orderNo);
	}

	@Override
	public List<PrintOrder> selectListByOrderNo(String orderNo) {
		// TODO Auto-generated method stub
		return printOrderMapper.selectListByOrderNo(orderNo);
	}

	@Override
	public List<PrintOrder> findByStatus(String status) {
		// TODO Auto-generated method stub
		PrintOrderExample example = new PrintOrderExample();
		PrintOrderExample.Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(status);
		return printOrderMapper.selectByExample(example);
	}

}
