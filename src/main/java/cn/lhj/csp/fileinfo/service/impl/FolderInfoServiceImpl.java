package cn.lhj.csp.fileinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lhj.csp.fileinfo.mapper.FolderInfoMapper;
import cn.lhj.csp.fileinfo.po.FolderInfo;
import cn.lhj.csp.fileinfo.service.FolderInfoService;


@Service
public class FolderInfoServiceImpl implements FolderInfoService{

	@Autowired
	private FolderInfoMapper folderInfoMapper;
	
	@Override
	public List<FolderInfo> getAll() {
		// TODO Auto-generated method stub
		return folderInfoMapper.selectByExample(null);
	}

	@Override
	public void insert(FolderInfo folderInfo) {
		// TODO Auto-generated method stub
		folderInfoMapper.insertSelective(folderInfo);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		folderInfoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(FolderInfo folderInfo) {
		// TODO Auto-generated method stub
		folderInfoMapper.updateByPrimaryKeySelective(folderInfo);
	}

	@Override
	public FolderInfo getById(Integer id) {
		// TODO Auto-generated method stub
		return folderInfoMapper.selectByPrimaryKey(id);
	}

}
