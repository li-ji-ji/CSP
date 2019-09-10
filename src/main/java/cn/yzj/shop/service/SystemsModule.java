package cn.yzj.shop.service;

import java.util.List;

import cn.yzj.shop.po.SystemModule;

public interface SystemsModule extends ShopService{
    /**
                    * 添加菜单
     * @param systemModule
     * @return
     * @throws Exception
     */
    public boolean addSystemModule(SystemModule systemModule)throws Exception;
    
}
