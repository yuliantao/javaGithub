/**   
* @Title: OrdersCustom.java
* @Package cn.ylt.mybatisStandard.po
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author A18ccms A18ccms_gmail_com   
* @date 2017��8��31�� ����4:18:51
* @version V1.0   
*/
package cn.ylt.ssm.po;

import java.util.Date;

/** 
* @����: OrdersCustom 
* @����: TODO(������һ�仰��������������) 
* @���� ������  
* @ʱ�� 2017��8��31�� ����4:18:51 
* @�汾 v0.0.1
*  
*/
public class OrdersCustom extends Orders{

	private String username;
	private Character sex;
	private String address;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Character getSex() {
		return sex;
	}
	public void setSex(Character sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "OrdersCustom [username=" + username + ", sex=" + sex + ", address=" + address + "]";
	}
	
}
