package cn.lhj.csp.fileinfo.service;

import java.util.List;

import cn.lhj.csp.fileinfo.po.FileInfo;


public interface FileInfoService {
	
		public List<FileInfo> getAll();
		
		public void insert(FileInfo fileInfo);
		
		public void delete(Integer id);
		
		public void update(FileInfo fileInfo);
		
		public FileInfo getById(Integer id);
}
