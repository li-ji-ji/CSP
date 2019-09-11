package cn.yzj.shop.service;

import java.util.List;

import cn.yzj.shop.po.SelectChildren;
import cn.yzj.shop.po.SelectTreeDTO;
import cn.yzj.shop.po.SystemModule;

public interface SystemsModule extends ShopService{
    /**
                   *   获取下拉树模型
     * @return
     * @throws Exception
     */
    public List<SelectTreeDTO> getSelectTree()throws Exception;
    
}
