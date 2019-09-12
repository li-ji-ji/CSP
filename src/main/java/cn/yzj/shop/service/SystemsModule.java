package cn.yzj.shop.service;

import java.util.List;

import cn.yzj.shop.po.SelectChildren;
import cn.yzj.shop.po.SelectTreeDTO;
import cn.yzj.shop.po.SystemModule;
/*
 * 
 *yzj
 *2019
 *2019年9月12日
 */
public interface SystemsModule extends ShopService{
    /**
                   *   获取下拉树模型有url
     * @return
     * @throws Exception
     */
	
    public List<SelectTreeDTO> getSelectTree()throws Exception;
    /**
     *   获取下拉树模型码云没有url
    * @return
    * @throws Exception
    */
    public List<SelectTreeDTO> getSelectTreeNo() throws Exception;
    
}
