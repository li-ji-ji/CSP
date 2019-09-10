package cn.yzj.shop.service.implement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yzj.shop.mapper.SystemModuleMapper;
import cn.yzj.shop.po.Msg;
import cn.yzj.shop.po.SystemModule;
import cn.yzj.shop.po.SystemModuleDTO;
import cn.yzj.shop.po.SystemModuleExample;
import cn.yzj.shop.service.SystemsModule;
import cn.yzj.shop.systemclass.Code;
@Service
public class SystemsModuleImp implements SystemsModule {

@Autowired 
private SystemModuleMapper systemModuleMapper;

@Override
public boolean addSystemModule(SystemModule systemModule) throws Exception {
	boolean isok=false;
	if(systemModuleMapper.insertSelective(systemModule)>0) {
		isok=true;
	}
	return isok;
}
@Override
public Msg add(Serializable id) {
	Msg msg=new Msg();
	if(systemModuleMapper.insertSelective((SystemModule) id)>0) {
		msg.setCode(Code.SUCCESS);
	}
	System.out.println(msg);
	return msg;
}
@Override
public Msg delete(Serializable id) {
	// TODO 自动生成的方法存根
	return null;
}
@Override
public Msg updata(Serializable id) {
	// TODO 自动生成的方法存根
	return null;
}
/**
 * 通过pid查询子菜单
 */
@Override
public Serializable find(Serializable pid) {
	List<SystemModule> systemModules=new ArrayList<SystemModule>();
	SystemModuleExample example=new SystemModuleExample();
	example.createCriteria().andParentIdEqualTo((Short) pid);
	systemModules=systemModuleMapper.selectByExample(example);
	return (Serializable) systemModules;
}
@Override
public Serializable dataPage(int limti, int page, Serializable id) {
	// TODO 自动生成的方法存根
	return null;
}
@Override
public Serializable dataPage(int limti, int page) {
	// TODO 自动生成的方法存根
	return null;
}
/**
 * 获取所有后台级菜单菜单模型
 * return List<SystemModule>
 */
@Override
public Serializable find() {
	List<SystemModule> systemsModules=new ArrayList<SystemModule>();
	SystemModuleExample example=new SystemModuleExample();
	example.setOrderByClause("orderby ASC");
	example.createCriteria().andVisibleEqualTo(true);
	systemsModules=systemModuleMapper.selectByExample(example);
	List<Object> model=new ArrayList<Object>();
	for (SystemModule systemModule : systemsModules) {
		if(systemModule.getParentId()==0) {
			SystemModuleDTO item=new SystemModuleDTO();
			item.setModId(systemModule.getModId());
			item.setAct(systemModule.getAct());
			item.setCtl(systemModule.getCtl());
			item.setIcon(systemModule.getIcon());
			item.setLevel(systemModule.getLevel());
			item.setModule(systemModule.getModule());
			item.setOrderby(systemModule.getOrderby());
			item.setParentId(systemModule.getParentId());
			item.setTitle(systemModule.getTitle());
			item.setVisible(systemModule.getVisible());
			item.setUrl(systemModule.getUrl());
			for (SystemModule systemModule2 : systemsModules) {
				if(systemModule2.getParentId()==item.getModId()) {
					SystemModuleDTO secondItem=new SystemModuleDTO();

					secondItem.setModId(systemModule2.getModId());
					secondItem.setAct(systemModule2.getAct());
					secondItem.setCtl(systemModule2.getCtl());
					secondItem.setIcon(systemModule2.getIcon());
					secondItem.setLevel(systemModule2.getLevel());
					secondItem.setModule(systemModule2.getModule());
					secondItem.setOrderby(systemModule2.getOrderby());
					secondItem.setParentId(systemModule2.getParentId());
					secondItem.setTitle(systemModule2.getTitle());
					secondItem.setVisible(systemModule2.getVisible());
					secondItem.setUrl(systemModule2.getUrl());
					
					
					item.getSystemModuleDTOs().add(secondItem);
					for (SystemModule systemModule3 : systemsModules) {
						SystemModuleDTO thirdItem=new SystemModuleDTO();
						if(systemModule3.getParentId()==secondItem.getModId()) {

							
							thirdItem.setModId(systemModule3.getModId());
							thirdItem.setAct(systemModule3.getAct());
							thirdItem.setCtl(systemModule3.getCtl());
							thirdItem.setIcon(systemModule3.getIcon());
							thirdItem.setLevel(systemModule3.getLevel());
							thirdItem.setModule(systemModule3.getModule());
							thirdItem.setOrderby(systemModule3.getOrderby());
							thirdItem.setParentId(systemModule3.getParentId());
							thirdItem.setTitle(systemModule3.getTitle());
							thirdItem.setVisible(systemModule3.getVisible());
							thirdItem.setUrl(systemModule3.getUrl());
							secondItem.getSystemModuleDTOs().add(thirdItem);
						}
					}
				}
			}
		  model.add(item);
		}
	}
	return (Serializable) model;
}

}
