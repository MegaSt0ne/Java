/**
 * 
 */
package edu.cmu.heinz.ij95713.Orders;

/**
 * Purpose: OrderItem Class can the cost of each order item and print order item information
 * @version: 1.0
 * @author: Xiaokai Jin Date: 2017/09/15 
 */
public class OrderItem {
	
	/**
	 * Constructor1
	 * @param upc
	 * @param quantity
	 * @param price
	 */
	public OrderItem(String myUpc, int myQuantity, int myPrice) {
		upc = myUpc;
		quantity = myQuantity;
		price = myPrice;
	}
	/**
	 * @return the upc
	 */
	public String getUpc() {
		return upc;
	}
	/**
	 * @param upc the upc to set
	 */
	public void setUpc(String upc) {
		this.upc = upc;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * get cost of each order item
	 * @return the multiplication of quantity and price
	 */
	public int getCost() {
		return getQuantity() * getPrice();
	}
	
	/**
	 * output order item information
	 * @return UPC: , Quantity: , Price: 
	 */
	@Override
	public String toString() {
		return "UPC: " + getUpc() + ", " + "Quantity: " + getQuantity() + ", " 
				+ "Price: " + getPrice();
	}

	/*
	 * instance variables
	 */
	private String upc;	   //UPC
	private int quantity;  //Quantity
	private int price;     //Price
}
