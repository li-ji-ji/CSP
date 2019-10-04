package cn.lhj.csp.fileinfo.service;

import java.util.List;

import cn.lhj.csp.fileinfo.po.FolderInfo;

public interface FolderInfoService {
	
	public List<FolderInfo> getAll();
	
	public void insert(FolderInfo folderInfo);
	
	public void delete(Integer id);
	
	public void update(FolderInfo folderInfo);
	
	public FolderInfo getById(Integer id);
}
