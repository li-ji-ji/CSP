package cn.lhj.csp.fileinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lhj.csp.fileinfo.mapper.PrinterMapper;
import cn.lhj.csp.fileinfo.po.Printer;
import cn.lhj.csp.fileinfo.po.PrinterExample;
import cn.lhj.csp.fileinfo.service.PrinterInfoService;


@Service
public class PrinterInfoServiceImpl implements PrinterInfoService{

	@Autowired
	private PrinterMapper printerMapper;
	
	@Override
	public List<Printer> getAll() {
		// TODO Auto-generated method stub
		return printerMapper.selectByExample(null);
	}

	@Override
	public String insert(Printer printer) {
		// TODO Auto-generated method stub
		printerMapper.insertSelective(printer);
		return "插入成功";
	}

	@Override
	public String delete(Integer id) {
		// TODO Auto-generated method stub
		printerMapper.deleteByPrimaryKey(id);
		return "删除成功";
	}

	@Override
	public String update(Printer printer) {
		// TODO Auto-generated method stub
		printerMapper.updateByPrimaryKeySelective(printer);
		return "修改成功";
	}

	@Override
	public Printer findById(Integer id) {
		// TODO Auto-generated method stub
		return printerMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Printer> findByPrintShopName(String printShopName) {
		// TODO Auto-generated method stub
		PrinterExample example = new PrinterExample();
		PrinterExample.Criteria criteria = example.createCriteria();
		criteria.andPrintShopNameEqualTo(printShopName);
		return printerMapper.selectByExample(example);
	}

}
