package cn.lhj.csp.fileinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lhj.csp.fileinfo.mapper.PersonFileinfoMapper;
import cn.lhj.csp.fileinfo.po.PersonFileinfo;
import cn.lhj.csp.fileinfo.po.PersonFileinfoExample;
import cn.lhj.csp.fileinfo.service.PersonFileInfoService;


@Service
public class PersonFileInfoServiceImpl implements PersonFileInfoService{
	
	@Autowired
	private PersonFileinfoMapper perFileInfoMapper;
	
	@Override
	public List<PersonFileinfo> getAll() {
		// TODO Auto-generated method stub
		return perFileInfoMapper.selectByExample(null);
	}

	@Override
	public String insert(PersonFileinfo personFileinfo) {
		// TODO Auto-generated method stub
		perFileInfoMapper.insert(personFileinfo);
		return "插入成功";
	}

	@Override
	public String delete(Integer id) {
		// TODO Auto-generated method stub
		perFileInfoMapper.deleteByPrimaryKey(id);
		return "删除成功";
	}

	@Override
	public String update(PersonFileinfo personFileinfo) {
		// TODO Auto-generated method stub
		perFileInfoMapper.updateByPrimaryKeySelective(personFileinfo);
		return "修改成功";
	}

	@Override
	public PersonFileinfo findById(Integer id) {
		// TODO Auto-generated method stub
		return perFileInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<PersonFileinfo> findByStudentId(Integer studentId) {
		// TODO Auto-generated method stub
		PersonFileinfoExample example = new PersonFileinfoExample();
		PersonFileinfoExample.Criteria criteria = example.createCriteria();
		criteria.andStudentIdEqualTo(studentId);
		return perFileInfoMapper.selectByExample(example);
	}

	@Override
	public List<PersonFileinfo> findByPrintOrderId(Integer orderId) {
		// TODO Auto-generated method stub
		return perFileInfoMapper.findByPrintOrderId(orderId);
	}

}
