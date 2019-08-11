package cn.lhj.csp.config.service;

import java.util.List;

import cn.lhj.csp.config.po.ConfigCategory;

public interface ConfigCategoryService {
		
		public List<ConfigCategory> getAll();
		
		public void insert(ConfigCategory configCategory);
		
		public void delete(Integer id);
		
		public void update(ConfigCategory configCategory);
		
		public ConfigCategory findById(Integer id);
}
