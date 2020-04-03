package com.atguigu3.bean;

import java.sql.Date;

public class Order {
	
	private int orderId;
	private Date orderDate;
	private String orderName;
	public Order(int orderId, Date orderDate, String orderName) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderName = orderName;
	}
	public Order() {
		super();
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", orderName=" + orderName + "]";
	}
	
	
}
