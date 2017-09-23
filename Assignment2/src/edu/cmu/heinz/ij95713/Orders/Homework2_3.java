/**
 * 
 */
package edu.cmu.heinz.ij95713.Orders;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 * Purpose: test driver
 * 			1. Create an array of four Order objects
 * 			2. Prompt the user to enter the UPC code
 * 			3. Print out the total cost in all the orders
 * @version: 1.0
 * @author: Xiaokai Jin Date: 2017/09/15 
 */
public class Homework2_3 {

	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		Random rand = new Random();						//random number generator
		Scanner sc = new Scanner(System.in);			//scanner object
		
		//create an instance of Order class
		Order order1 = new Order();
		//create an instance of RushOrder class with one day delivery
		RushOrder rushOrder1 = new RushOrder(1);
		//create an instance of RushOrder class with two-day delivery
		RushOrder rushOrder2 = new RushOrder(2);
		//create an instance of RushOrder class with three-day delivery
		RushOrder rushOrder3 = new RushOrder(3);

		//assign different orders into an array of four Order Objects
		Order[] orders = new Order[4];
		orders[0] = order1;			//assign it to the 1st element
		orders[1] = rushOrder1;		//assign it to the 2nd element
		orders[2] = rushOrder2;		//assign it to the 3rd element
		orders[3] = rushOrder3;		//assign it to the 4th element

		//Prompt the user to enter the UPC code for an order item
		//or enter "done" to quit.
		while(true) {
			String UPC;  									//UPC value
			String strQuantity;								//quantity String
			int quantity;									//quantity of the order item
			int deliveryDay;								//delivery day
			int price;										//price of the order item

			System.out.println("Enter the UPC or done: ");	//prompt user to enter a UPC		
			UPC = sc.nextLine();							//take user's input
			if ( UPC.equals("done")) {
				break;
			} else {
				System.out.println("Enter quantity: ");
				strQuantity = sc.nextLine();				//take user's input
				quantity = Integer.parseInt(strQuantity);	//transfer string into integer
				price = ( rand.nextInt(51) + 50);			//random number from 50 to 100
				deliveryDay = ( rand.nextInt(7) + 1);		//random number from 1 to 7

				// According to different delivery day, put order items into corresponding array element
				if (deliveryDay == 1) {
					rushOrder1.addOrderItem(new OrderItem(UPC, quantity, price));				
				} else if (deliveryDay == 2) {
					rushOrder2.addOrderItem(new OrderItem(UPC, quantity, price));				
				} else if (deliveryDay == 3) {
					rushOrder3.addOrderItem(new OrderItem(UPC, quantity, price));			
				} else {
					order1.addOrderItem(new OrderItem(UPC, quantity, price));					
				}
			}
		}

		//print results
		int counter = 0;  
		int subtotal = 0;	//sub-total price for all the order items in each order
		int total = 0;		//total price for the all the order items
		
		//loop each order
		for (Order myOrder : orders) {
			counter++;
			
			//based on different delivery day, print different headlines
			switch (counter) {
			case 1:
				System.out.println("Your order: Standard order with 7 day delivery");	
				break;
			case 2:
				System.out.println("Your order: RushOrder to deliver in 1 day");	
				break;
			case 3:
				System.out.println("Your order: RushOrder to deliver in 2 day");				
				break;
			case 4:
				System.out.println("Your order: RushOrder to deliver in 3 day");				
				break;
			}
			//loop each order item
			for (OrderItem myOrderItem : myOrder.getOrderList()) {
				System.out.println(myOrderItem);
				subtotal += myOrderItem.getCost();								//get cost of each order item
			}
			System.out.println("Your subtotal for this order: " + subtotal);	//print sub-total price for each order
			System.out.println();												//blank line
			total += subtotal;													//aggregate total price
			subtotal = 0;														//initialize sub-total price for each order
		}
		System.out.println("Your total for all the orders: " + total);			//print total price for all the orders
	}
}
