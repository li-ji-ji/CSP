package cn.yzj.shop.service.implement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.yzj.shop.mapper.SystemModuleMapper;
import cn.yzj.shop.po.LayUIJSON;
import cn.yzj.shop.po.Msg;
import cn.yzj.shop.po.SelectChildren;
import cn.yzj.shop.po.SelectTreeDTO;
import cn.yzj.shop.po.SystemModule;
import cn.yzj.shop.po.SystemModuleDTO;
import cn.yzj.shop.po.SystemModuleExample;
import cn.yzj.shop.service.SystemsModule;
import cn.yzj.shop.systemclass.Code;
@Service
public class SystemsModuleImp implements SystemsModule {

@Autowired 
private SystemModuleMapper systemModuleMapper;

/**
 * 添加菜单
* @param systemModule
* @return
* @throws Exception
*/
@Override
public Msg add(Serializable id) {
	Msg msg=new Msg();
	if(systemModuleMapper.insertSelective((SystemModule) id)>0) {
		msg.setCode(Code.SUCCESS.getCode());
		msg.setMsg("菜单添加"+Code.SUCCESS.getMsg());
	}
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
 * 通过pid查询子菜单模型
 */
@Override
public Serializable find(Serializable pid) {
	List<SystemModule> systemModules=new ArrayList<SystemModule>();
	SystemModuleExample example=new SystemModuleExample();
	example.createCriteria().andParentIdEqualTo((Short) pid);
	systemModules=systemModuleMapper.selectByExample(example);
	return (Serializable) systemModules;
}
/**
 * 数据表分页查询
 */
@Override
public Serializable dataPage(int limit, int page, Serializable id) {
	PageHelper.startPage(page, limit);
	SystemModuleExample example=new SystemModuleExample();
	example.createCriteria().andParentIdEqualTo((Short) id);
	List<SystemModule> modules =systemModuleMapper.selectByExample(example)   ;
	PageInfo<SystemModule> pageInfo = new PageInfo<SystemModule>(modules);
	long count = pageInfo.getTotal();
	LayUIJSON uijson = new LayUIJSON();
	uijson.setCount(count);
	uijson.setData(modules);
	return uijson;
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
/**
 *   获取下拉树模型
* @return
* @throws Exception
*/
@Override
public List<SelectTreeDTO> getSelectTree() throws Exception {
	List<SystemModule> systemsModules=new ArrayList<SystemModule>();
	SystemModuleExample example=new SystemModuleExample();
	example.setOrderByClause("orderby ASC");
	example.createCriteria().andVisibleEqualTo(true);
	systemsModules=systemModuleMapper.selectByExample(example);
	List<SelectTreeDTO> selectTreeDTOs=new ArrayList<SelectTreeDTO>(); 
	for (SystemModule systemModule : systemsModules) {
		if(systemModule.getParentId()==0) {
			SelectTreeDTO item =new SelectTreeDTO();
			item.setId(systemModule.getModId());
			item.setName(systemModule.getTitle());
			item.setUrl(systemModule.getUrl());
			item.setIcon(systemModule.getIcon());
			for (SystemModule systemModule2 : systemsModules) {
				if(systemModule2.getParentId()==item.getId()) {
					SelectTreeDTO secondItem=new SelectTreeDTO();
					secondItem.setId(systemModule2.getModId());
					secondItem.setName(systemModule2.getTitle());
					secondItem.setIcon(systemModule2.getIcon());
					secondItem.setUrl(systemModule2.getUrl());
					item.getChildren().add(secondItem);
					for (SystemModule systemModule3 : systemsModules) {
						if(systemModule3.getParentId()==secondItem.getId()) {
							SelectChildren thirdItem=new SelectChildren();
							thirdItem.setId(systemModule3.getModId());
							thirdItem.setName(systemModule3.getTitle());
							thirdItem.setIcon(systemModule3.getIcon());
							thirdItem.setUrl(systemModule3.getUrl());
							secondItem.getChildren().add(thirdItem);
						}
					}
				}
			}
			selectTreeDTOs.add(item);
		}
	}
	return selectTreeDTOs;
}
@Override
public Serializable dataPage(int limit, int page) {
	// TODO 自动生成的方法存根
	return null;
}


}
