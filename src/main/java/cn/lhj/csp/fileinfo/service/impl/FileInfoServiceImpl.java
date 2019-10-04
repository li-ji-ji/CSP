package cn.lhj.csp.fileinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lhj.csp.fileinfo.mapper.FileInfoMapper;
import cn.lhj.csp.fileinfo.po.FileInfo;
import cn.lhj.csp.fileinfo.service.FileInfoService;


@Service
public class FileInfoServiceImpl implements FileInfoService{

	@Autowired
	private FileInfoMapper fileInfoMapper;
	
	@Override
	public List<FileInfo> getAll() {
		// TODO Auto-generated method stub
		return fileInfoMapper.selectByExample(null);
	}

	@Override
	public void insert(FileInfo fileInfo) {
		// TODO Auto-generated method stub
		fileInfoMapper.insertSelective(fileInfo);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		fileInfoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(FileInfo fileInfo) {
		// TODO Auto-generated method stub
		fileInfoMapper.updateByPrimaryKeySelective(fileInfo);
	}

	@Override
	public FileInfo getById(Integer id) {
		// TODO Auto-generated method stub
		return fileInfoMapper.selectByPrimaryKey(id);
	}

}
