package cn.lhj.csp.config.vm;

import java.util.List;

import cn.lhj.csp.config.po.Config;

public class ConfigVm {


	private String type;
	private List<Config> configs;

	public List<Config> getConfigs() {
		return configs;
	}

	public void setConfigs(List<Config> configs) {
		this.configs = configs;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ConfigVm [type=" + type + ", configs=" + configs + "]";
	}
		
}
