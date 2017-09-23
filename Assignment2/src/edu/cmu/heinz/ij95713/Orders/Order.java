/**
 * 
 */
package edu.cmu.heinz.ij95713.Orders;

import java.util.ArrayList;

/**
 * Purpose: Order Class can calculate the total cost of all order items in the order 
 * 			and print order information
 * @version: 1.0
 * @author: Xiaokai Jin Date: 2017/09/15 
 */
public class Order {

	/**
	 * Constructor1
	 * @param orderItemList
	 */
	public Order(ArrayList<OrderItem> myOrderItemList) {
		orderItemList = myOrderItemList;
	}

	/**
	 * Constructor2
	 */
	public Order() {
		orderItemList = new ArrayList<OrderItem>();
	}


	/**
	 * @return the orderList
	 */
	public ArrayList<OrderItem> getOrderList() {
		return orderItemList;
	}

	/**
	 * @param orderList the orderList to set
	 */
	public void setOrderList(ArrayList<OrderItem> myOrderItemList) {
		orderItemList = myOrderItemList;
	}

	/**
	 * method addOrderItem() 
	 * takes an object of OrderItem and stores it in the list
	 * @param an object of Class OrderItem
	 */
	public void addOrderItem(OrderItem myOrderItem) {
		getOrderList().add(myOrderItem);
	}

	/**
	 * Calculate the total cost of all order items in the order
	 * @return the total cost of all order items in the order
	 */
	public int getTotal() {
		int cost = 0;  		//Initialize local variable

		//calculate the total cost of all order items in the order	
		for (OrderItem oi : getOrderList()) {
			cost += oi.getCost();
		}					
		return cost;
	}

	/**
	 * prints information about each order item
	 */
	public void printOrderItems() {
		for (OrderItem oi : getOrderList()) {
			System.out.println(oi);		//print information about each order item
		}
	}

	/**
	 * output information of each order
	 * @return order information
	 */
	@Override
	public String toString() {
		return "Order [orderItemList=" + orderItemList + "]";
	}

	/*
	 * instance variables
	 */
	private ArrayList<OrderItem> orderItemList;
}
