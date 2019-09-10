package cn.yzj.shop.po;

import java.util.ArrayList;
import java.util.List;

public class SystemModuleDTO extends SystemModule {
	private List<SystemModuleDTO> systemModuleDTOs=new ArrayList<SystemModuleDTO>();

	public List<SystemModuleDTO> getSystemModuleDTOs() {
		return systemModuleDTOs;
	}

	public void setSystemModuleDTOs(List<SystemModuleDTO> systemModuleDTOs) {
		this.systemModuleDTOs = systemModuleDTOs;
	}

	

}
