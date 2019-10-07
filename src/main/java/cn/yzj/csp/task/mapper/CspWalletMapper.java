package cn.yzj.csp.task.mapper;

import cn.yzj.csp.task.po.CspWallet;

public interface CspWalletMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CspWallet record);

    int insertSelective(CspWallet record);

    CspWallet selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CspWallet record);

    int updateByPrimaryKey(CspWallet record);
    //添加
    CspWallet selectByOpenid(String openid);
    //openid 查找钱包添加行锁
    CspWallet selectByOpenidlock(String openid);
    //学生id查找钱包添加行锁
    CspWallet selectByPrimaryKeyLock(Integer id);
    
    int insertSelectiveReturnId(CspWallet wallet);
}