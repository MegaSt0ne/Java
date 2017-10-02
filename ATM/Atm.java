/**
 * 
 */
package edu.cmu.heinz.ij95713.Atm;

import java.util.Scanner;

import edu.cmu.heinz.ij95713.Atm.Atm.Transaction;

/**
 * Purpose: Class Atm includes following classes:
 * CashDispenser, DepositUnit, ReceiptPrinter, 
 * CardReader, IOUnit
 * @author Xiaokai Jin
 * @version 1.0
 */
public class Atm {

	/**
	 * Constructor
	 * @author Xiaokai Jin
	 */
	public Atm(BankServer bs) {
		aBankServer = bs;
		aReceiptPrinter = new ReceiptPrinter();
		aCardReader = new CardReader();
		aCashDispenser = new CashDispenser();
		aDepositUnit = new DepositUnit();
		aIOUnit = new IOUnit();
		sc = new Scanner(System.in);
	}

	/**
	 * @return the sc
	 */
	public Scanner getSc() {
		return sc;
	}

	/**
	 * @param sc the sc to set
	 */
	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	/**
	 * @return the aBankServer
	 */
	public BankServer getaBankServer() {
		return aBankServer;
	}

	/**
	 * @param aBankServer the aBankServer to set
	 */
	public void setaBankServer(BankServer aBankServer) {
		this.aBankServer = aBankServer;
	}

	/**
	 * @return the aCashDispenser
	 */
	public CashDispenser getaCashDispenser() {
		return aCashDispenser;
	}

	/**
	 * @param aCashDispenser the aCashDispenser to set
	 */
	public void setaCashDispenser(CashDispenser aCashDispenser) {
		this.aCashDispenser = aCashDispenser;
	}

	/**
	 * @return the aReceiptPrinter
	 */
	public ReceiptPrinter getaReceiptPrinter() {
		return aReceiptPrinter;
	}

	/**
	 * @param aReceiptPrinter the aReceiptPrinter to set
	 */
	public void setaReceiptPrinter(ReceiptPrinter aReceiptPrinter) {
		this.aReceiptPrinter = aReceiptPrinter;
	}

	/**
	 * @return the aDepositUnit
	 */
	public DepositUnit getaDepositUnit() {
		return aDepositUnit;
	}

	/**
	 * @param aDepositUnit the aDepositUnit to set
	 */
	public void setaDepositUnit(DepositUnit aDepositUnit) {
		this.aDepositUnit = aDepositUnit;
	}

	/**
	 * @return the aIOUnit
	 */
	public IOUnit getaIOUnit() {
		return aIOUnit;
	}

	/**
	 * @param aIOUnit the aIOUnit to set
	 */
	public void setaIOUnit(IOUnit aIOUnit) {
		this.aIOUnit = aIOUnit;
	}

	/**
	 * @return the aCardReader
	 */
	public CardReader getaCardReader() {
		return aCardReader;
	}

	/**
	 * @param aCardReader the aCardReader to set
	 */
	public void setaCardReader(CardReader aCardReader) {
		this.aCardReader = aCardReader;
	}

	/**
	 * handleTransaction handles a user transaction.
	 */
	public void handleTransaction() {
		//local variables
		int count = 0;
		String accountId = "";
		accountId = aCardReader.readCard();	//get account Id
		double amount = 0.0;

		//Ask the user to enter the account number and read it	
		search:
			while (true) {
				//Verify the pin
				if (aBankServer.verifyPin(accountId, 
						aIOUnit.obtainCustomerPin())) {
					//obtain transaction type from user
					switch (aIOUnit.obtainTransaction()) {
					case DEPOSIT:
						amount = aIOUnit.obtainAmount();
						aBankServer.doDeposit(accountId, amount);
						aDepositUnit.takeDepositEnvelope();

						aReceiptPrinter.printReceipt("Deposit of $" + amount + "is made to account " + accountId);
						aReceiptPrinter.printReceipt("New balance on account is " + aBankServer.doQuery(accountId));

						break search;
					case WITHDRAW:
						amount = aIOUnit.obtainAmount();
						if (aBankServer.verifyFunds(accountId, amount)) {
							aBankServer.doWithdraw(accountId, (int) amount); 
							aCashDispenser.dispenseCash((int) amount); 

							aReceiptPrinter.printReceipt("Withdraw of $" + (int) amount + " is made from acount " + accountId);
							aReceiptPrinter.printReceipt("New balance on account is " + aBankServer.doQuery(accountId));
						} else {
							aReceiptPrinter.printReceipt("You don't have enough funds in the account");
						}
						break search;
					case QUERY:
						amount = aBankServer.doQuery(accountId);
						aReceiptPrinter.printReceipt("The amount on " + accountId + " is $" + amount);
						break search;
					case CANCEL:
						aReceiptPrinter.printReceipt("Transaction cancelled");
						break search;
					default:
						break search;
					}
				} else {
					count++;
					//After the third trials, if the user cannot provide the correct
					//pin, confiscate the card and finish the session.
					if ( count == 3 ) {
						break;
					} else {
						continue;
					}
				}
			}
		//After the third trials, if the user cannot provide the correct
		//pin, confiscate the card and finish the session.		
		if ( count == 3) {
			aCardReader.confiscateCard();
		} else {
			aCardReader.releaseCard();
		}
	}

	class CashDispenser {

		/**
		 * dispenseCash takes an integer amount as the parameter and
		 * prints a message saying that money in the provided amount
		 * is dispensed
		 * @param amount
		 */
		public void dispenseCash(int amount) {
			System.out.println("$" + amount + " money is dispensed");
		}
	}

	class DepositUnit {

		/**
		 * takeDepositEnvelope prints a message saying that envelope is successfully received
		 */
		public void takeDepositEnvelope() {
			System.out.println("Envelope successfully received");
		}
	}

	class ReceiptPrinter {

		/** PrintReceipt takes a parameter of String type 
		 * and simply prints that parameter to the console
		 * @param s
		 */
		public void printReceipt(String str) {
			System.out.println(str);
		}
	}

	class CardReader {

		/**
		 * readCard() asks for the account number from the user, 
		 * reads it and returns it
		 * @return number
		 */
		public String readCard() {
			String number = "";
			System.out.println("Enter the card number: ");
			number = sc.nextLine();	
			return number;
		}

		/**
		 * confiscateCard() prints out a message saying that the card is confiscated
		 */
		public void confiscateCard() {
			System.out.println("Card is confiscated");
		}

		/**
		 * releaseCard prints out a message saying that the card is released
		 */
		public void releaseCard() {
			System.out.println("Card is released");
		}
	}

	class IOUnit{

		/**
		 * obtainCustomerPin prompts the user for a pin, reads and returns it
		 * @return pin
		 */
		public String obtainCustomerPin() {
			String pin = "";
			System.out.println("Enter your pin number: ");
			pin = sc.nextLine();
			return pin;
		}

		/**
		 * obtainTransaction prompts the user to select a transaction from a menu,
		 * reads the input and returns the selected transaction
		 * @return Transaction
		 */
		public Transaction obtainTransaction() {
			String mode = "";
			System.out.println("Select transaction: Enter Deposit, Withdraw, Query or Cancel: ");
			mode = sc.nextLine().toUpperCase(); //Uppercase user input
			Transaction Tmode = Enum.valueOf(Transaction.class, mode);
			return Tmode;	
		}

		/**
		 * obtainAmount prompts the unser for an amount, reads and returns it
		 * @return amount
		 */
		public double obtainAmount() {
			double amount = 0.0;
			System.out.println("Enter the amount: ");
			amount = sc.nextDouble();
			return amount;
		}
	}

	/**
	 * enumerate objects:
	 * DEPOSIT, WITHDRAW, QUERY, CANCEL
	 */
	static enum Transaction{
		DEPOSIT, WITHDRAW, QUERY, CANCEL;			
	}		

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Atm [sc=" + sc + ", aBankServer=" + aBankServer + ", aCashDispenser=" + aCashDispenser
				+ ", aReceiptPrinter=" + aReceiptPrinter + ", aDepositUnit=" + aDepositUnit + ", aIOUnit=" + aIOUnit
				+ ", aCardReader=" + aCardReader + "]";
	}
	/*
	 * instance variables
	 */
	private Scanner sc;
	private BankServer aBankServer;
	private CashDispenser aCashDispenser;
	private ReceiptPrinter aReceiptPrinter;
	private DepositUnit aDepositUnit;
	private IOUnit aIOUnit;
	private CardReader aCardReader;
}

