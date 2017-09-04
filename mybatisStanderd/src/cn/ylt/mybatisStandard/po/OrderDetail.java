package cn.ylt.mybatisStandard.po;


public class OrderDetail {
	private int id;
	private int orders_id;
	private int items_id;
	private int items_cum;
	private Items items;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrders_id() {
		return orders_id;
	}
	public void setOrders_id(int orders_id) {
		this.orders_id = orders_id;
	}
	public int getItems_id() {
		return items_id;
	}
	public void setItems_id(int items_id) {
		this.items_id = items_id;
	}
	public int getItems_cum() {
		return items_cum;
	}
	public void setItems_cum(int items_cum) {
		this.items_cum = items_cum;
	}
	public Items getItems() {
		return items;
	}
	public void setItems(Items items) {
		this.items = items;
	}
	
}
