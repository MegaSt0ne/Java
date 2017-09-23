/**
 * 
 */
package edu.cmu.heinz.ij95713.Orders;

import java.util.ArrayList;

/**
 * Purpose: RushOrder Class can Calculate the total cost of each rush order
 * 			and print rush order information
 * @version: 1.0
 * @author: Xiaokai Jin Date: 2017/09/15 
 */
public class RushOrder extends Order{

	/**
	 * Constructor1
	 * @param myOrderItemList
	 * @param deliveryDay
	 */
	public RushOrder(ArrayList<OrderItem> myOrderItemList, int myDeliveryDay) {
		super(myOrderItemList);
		deliveryDay = myDeliveryDay;
	}

	/**
	 * Constructor2
	 * @param deliveryDay
	 */
	public RushOrder(int myDeliveryDay) {
		super();
		deliveryDay = myDeliveryDay;
	}
	
	/**
	 * @return the deliveryDay
	 */
	public int getDeliveryDay() {
		return deliveryDay;
	}

	/**
	 * @param deliveryDay the deliveryDay to set
	 */
	public void setDeliveryDay(int deliveryDay) {
		this.deliveryDay = deliveryDay;
	}

	/**
	 * Calculate the total cost of each rush order
	 * first get the total cost, then adds the delivery charge
	 * @return cost
	 */
	@Override
	public int getTotal() {
		int cost = 0;	//initialize local variable
		
		//if no order item, then no cost
		if (getOrderList().size() > 0) {
			cost = super.getTotal();	//get the total cost without delivery charge
			
			//delivery fee
			if (deliveryDay == 1) {
				cost += 25;	//25 dollars delivery fee
			} else if (deliveryDay == 2) {
				cost += 15;	//15 dollars delivery fee
			} else if (deliveryDay == 3) {
				cost += 10;	//10 dollars delivery fee
			} else if (deliveryDay >= 4) {
				cost += 0;	//no delivery fee
			} else {
			}
		}
		return cost;
	}

	/**
	 * output rush order information
	 * @return rush order information
	 */
	@Override
	public String toString() {
		return "RushOrder [deliveryDay=" + deliveryDay + "]";
	}

	/*
	 * instance variables
	 */
	protected int deliveryDay;  //delivery day
}
