/* Date: 20170901 Version: 1.0
 * Program Purpose: 1.	Write a program to calculate the number of years 
 * required for a person to retire.
 * Class used: RetirePeople Class
 * Author: Xiaokai Jin
 */

import java.math.*;

public class Homework1_2 {
	
	public static void main(String[] args) {
		//random retirement goal 150,000 - 200,000
		double goal = ( 50_001 * Math.random() + 150_000 );
		
		//initial balance 0
		double balance = 0;
		
		//random contribution 0 - 10,000
		double contribution = 0;
		
		//random inflation
		double inflationRate; 
		
		//random return rate
		double returnRate; 
		
		//gain
		double gain = 0;
		
		//counter
		int yearNum = 0;
		
		//initialize 
		Homework1_2_retirePeople retiree = new Homework1_2_retirePeople(goal, balance, contribution, gain);
		
		while ( retiree.getCurrentBalance() < retiree.getRetirementGoal() ) {
			//inflation rate & return rate
			inflationRate = 0.04 * Math.random();
			returnRate = 0.05 * Math.random();
			
			contribution = ( 10_001 * Math.random() );
			retiree.setContributionPerYear(contribution);
			
			//add contribution from this year to the current balance
			retiree.setCurrentBalance( retiree.getCurrentBalance() + contribution );
			
			//get gain or loss this year
			retiree.setGainPerYear( retiree.getCurrentBalance() *  ( inflationRate - returnRate ));
			
			//current balance adjusted after inflation rate & return rate
			retiree.setCurrentBalance( retiree.getCurrentBalance() + retiree.getGainPerYear());
			
			//output
			yearNum++;
			System.out.printf("Your summary for year %d: \n", yearNum);
			System.out.printf("Contribution: $%,.0f  gain out of real interest: $%,.0f  new Balance: $%,.0f \n \n", 
					retiree.getContributionPerYear(), retiree.getGainPerYear(), retiree.getCurrentBalance());
		}
		System.out.printf("The retirement goal is $%,.0f. It takes %d years to retire.", goal, yearNum);
	}

}
