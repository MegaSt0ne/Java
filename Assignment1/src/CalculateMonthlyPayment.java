/* Date: 20170901 Version: 1.0
 * Program Purpose: 1.	Write a Java program to calculate 
 * the monthly payment for a loan as follows. 
 * Author: Xiaokai Jin
 */

import java.util.*;
import java.math.*;


public class CalculateMonthlyPayment {
	
	private static final int PAYMENT_PER_YEAR = 12; 
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//input the principal
		System.out.println("Please enter your Principal?");
		double principal = scanner.nextDouble();
		
		//input the interest rate
		System.out.println("Please enter your Interest rate?");
		double interestRate = scanner.nextDouble();
		
		//input the number of years 
		System.out.println("Please enter your years?");
		int years = scanner.nextInt();

		double monthlyPayment = ( interestRate * ( principal / PAYMENT_PER_YEAR )) 
				/ ( 1 - Math.pow( ( ( interestRate / PAYMENT_PER_YEAR ) + 1 ), ( -1 * PAYMENT_PER_YEAR * years) ) );
		
		//output monthlyPayment
		System.out.printf("The monthly payment is: %,.2f \n", monthlyPayment);
		
		//output total payment after each year
		for ( int i = 1; i <= years ; i++ ) {
			System.out.printf("The total payment after %d year: %,.2f \n", i, monthlyPayment * 12 * i);
		}
		
		//output total interest paid during the course of the loan
		System.out.printf("The total interest paid during the course of the loan is: %,.2f \n", monthlyPayment * 12 * years - principal);
	}

}
