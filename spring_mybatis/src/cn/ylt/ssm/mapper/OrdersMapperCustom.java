package cn.ylt.ssm.mapper;

import java.util.List;

import cn.ylt.ssm.po.Orders;
import cn.ylt.ssm.po.OrdersCustom;
import cn.ylt.ssm.po.User;

/** 
* @����: OrdersMapperCustom 
* @����: TODO(������һ�仰��������������) 
* @���� ������  
* @ʱ�� 2017��8��31�� ����8:30:43 
* @�汾 v0.0.1
*  
*/
public interface OrdersMapperCustom {

	/**
	 * �������еĶ������û�
	 */
	public List<OrdersCustom> findOrdersUser() throws Exception;
	
	/**
	 * 
	 * ͨ��resultmapʵ��һ��һ��ϵ��ѯ
	 */
	public List<Orders> findOrdersUserwithRM() throws Exception;
	
	/**
	 * 
	 * ��ѯ�������û����Ͷ�����ϸ
	 */
	public List<Orders> findOrdersUserAndDetails() throws Exception;
	
	/**
	 * 
	 * ��ѯ�û�����Ʒ��Ϣ
	 */
	public List<User> findUserAndItemsResultMap() throws Exception;
	
	/**
	 * 
	 * ��ѯ���������û����û���Ϣ�ӳټ���
	 */
	public List<Orders> findOrdersUserLazyLoading() throws Exception;
	
}
