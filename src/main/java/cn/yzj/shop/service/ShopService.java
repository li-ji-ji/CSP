package cn.yzj.shop.service;

import java.io.Serializable;

import cn.yzj.shop.po.Msg;

public interface ShopService<T extends Serializable,ID extends Serializable> {
	/**
	 * 通用增加方法
	 * @param <ID> 泛型参数
	 * * @param id
	 * @return Msg 消息对象
	 */
	public  Msg add(ID id)throws Exception;
	/**
	 * 通用删除方法
	 * @param <ID> 泛型参数
	 * @param id
	 * @return Msg 消息对象
	 */
	public  Msg delete(ID id)throws Exception;
	/**
	 * 通用修改方法
	 * @param <ID> 泛型参数
	 * @param id
	 * @return Msg 消息对象
	 */
	public  Msg updata(ID id)throws Exception;
	/**
	 * 通用查询方法(有参)
	 * @param <ID>泛型参数
	 * @param id
	 * @return T 返回的泛型对象
	 */
	public  T find(ID id)throws Exception;
	/**
	 * 通用查询方法(查询所有)
	 * @param <ID>泛型参数
	 * @param id
	 * @return T 返回的泛型对象
	 */
	public  T find()throws Exception;
	/**
	 *  数据表分页通用方法(有参)
	 * @param limit
	 * @param page
	 * @param id 泛型参数
	 * @return t 泛型返回值
	 */
	public T dataPage(int limit,int page,ID id)throws Exception;
	/**
	 * 数据表分页通用方法(无参)
	 * @param limti
	 * @param page
	 * @return T 泛型返回值
	 */
	public T dataPage(int limit,int page)throws Exception;
	
}
