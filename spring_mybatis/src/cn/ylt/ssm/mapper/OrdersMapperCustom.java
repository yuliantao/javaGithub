package cn.ylt.ssm.mapper;

import java.util.List;

import cn.ylt.ssm.po.Orders;
import cn.ylt.ssm.po.OrdersCustom;
import cn.ylt.ssm.po.User;

/** 
* @类名: OrdersMapperCustom 
* @描述: TODO(这里用一句话描述这个类的作用) 
* @作者 余联涛  
* @时间 2017年8月31日 下午8:30:43 
* @版本 v0.0.1
*  
*/
public interface OrdersMapperCustom {

	/**
	 * 查找所有的订单和用户
	 */
	public List<OrdersCustom> findOrdersUser() throws Exception;
	
	/**
	 * 
	 * 通过resultmap实现一对一关系查询
	 */
	public List<Orders> findOrdersUserwithRM() throws Exception;
	
	/**
	 * 
	 * 查询订单，用户，和订单明细
	 */
	public List<Orders> findOrdersUserAndDetails() throws Exception;
	
	/**
	 * 
	 * 查询用户的商品信息
	 */
	public List<User> findUserAndItemsResultMap() throws Exception;
	
	/**
	 * 
	 * 查询订单关联用户，用户信息延迟加载
	 */
	public List<Orders> findOrdersUserLazyLoading() throws Exception;
	
}
