package cn.ylt.mybatisStandard.po;

import java.util.Date;
import java.util.List;

//集成Serializable目的是为了二级缓存，缓存位置可以是内存也可以是文件，多种类型的
public class Orders //implements Serializable 
{
	
	private int id;
	private int user_id;
	private String number;
	private Date createtime;
	private String note;
	private User user;
	private List<OrderDetail> orderdetails;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
		
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}		
	public List<OrderDetail> getOrderdetails() {
		return orderdetails;
	}
	public void setOrderdetails(List<OrderDetail> orderdetails) {
		this.orderdetails = orderdetails;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", user_id=" + user_id + ", number=" + number + ", createtime=" + createtime
				+ ", note=" + note + "]";
	}

}
