/**
 * 
 */
package edu.cmu.heinz.ij95713.Atm;

/**
 * Test class Account & class BankServer
 * @author Xiaokai Jin
 * @version 1.0
 */
public class Homework3_2 {

	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		BankServer bs = new BankServer(); //create a bank server object
		Atm a = new Atm(bs); //create a ATM object
		a.handleTransaction();
	}

}
