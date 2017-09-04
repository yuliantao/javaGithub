/**   
* @Title: OrdersCustom.java
* @Package cn.ylt.mybatisStandard.po
* @Description: TODO(用一句话描述该文件做什么)
* @author A18ccms A18ccms_gmail_com   
* @date 2017年8月31日 下午4:18:51
* @version V1.0   
*/
package cn.ylt.ssm.po;

import java.util.Date;

/** 
* @类名: OrdersCustom 
* @描述: TODO(这里用一句话描述这个类的作用) 
* @作者 余联涛  
* @时间 2017年8月31日 下午4:18:51 
* @版本 v0.0.1
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
