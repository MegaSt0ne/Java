package edu.cmu.heinz.ij95713.Atm;
 
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Objects;
import java.util.Scanner;

public class BankServer {

	/**
	 * constructor
	 * @param account
	 */
	public BankServer() {
		accountList = new Hashtable<>();	//initialize accounts list
		loadAccounts("accounts.dat");		//load accounts information
	}

	/**
	 * Verify the pin for the account. If account doesn't exist,
	 * it returns false
	 * Assuming the card number and account id will be the same
	 * @param cardNumber
	 * @param pin
	 * @return
	 */
	public boolean verifyPin(String cardNumber, String pin) {
		boolean result = false;
		if (accountList.containsKey(cardNumber)) {
			//account id exist in file
			if (accountList.get(cardNumber).getPin().equals(pin)) {
				//pin matches
				return result = true;
			}
		} 
		return result;
	}

	/**
	 * doWithdraw() invokes withdraw() method on the account, if exists
	 * To keep logic consistent, card number is used to check the existence
	 * of the account instead of customer number. 
	 * Assuming the card number and account id will be the same
	 * 
	 * casting the type of parameter amount from integer to double 
	 * @param cardNumber
	 * @param amount
	 */
	public void doWithdraw(String cardNumber, int amount) {
		if (accountList.containsKey(cardNumber)) {
			accountList.get(cardNumber).withdraw((double) amount);
		}
	}

	/**
	 * doDeposit() invokes deposit() method on the account, if exists
	 * To keep logic consistent, card number is used to check the existence
	 * of the account instead of customer number
	 * Assuming the card number and account id will be the same
	 * @param cardNumber
	 * @param amount
	 */
	public void doDeposit(String cardNumber, double amount) {
		if (accountList.containsKey(cardNumber)) {
			accountList.get(cardNumber).deposit(amount);
		}
	}

	/**
	 * doQuery returns the balance of the account.
	 * If account doesn't exist, it returns 0.
	 * To keep logic consistent, card number is used to check the existence
	 * of the account instead of customer number
	 * Assuming the card number and account id will be the same
	 * @param custNumber
	 * @return amount
	 */
	public double doQuery(String cardNumber) {
		double amount = 0.0;
		if (accountList.containsKey(cardNumber)) {
			amount = accountList.get(cardNumber).getBalance();
		}
		return amount;
	}

	/**
	 * VerifyFunds will search for the account and if it exists
	 * make sure its balance is  greater than or equal to the amount
	 * Assuming the card number and account id will be the same
	 * @param cardNumber
	 * @param amount
	 * @return result
	 */
	public boolean verifyFunds(String cardNumber, double amount) {
		boolean result = false;
		if (accountList.containsKey(cardNumber)) {
			if (accountList.get(cardNumber).getBalance() >= amount) {
				result = true;
			}
		}
		return result;
	}


	/**
	 * loadAccounts() reads a input file that contains the account information and
	 * creates the account objects.
	 * @param filename
	 * @throws FileNotFoundException 
	 */
	@SuppressWarnings("deprecation")
	private void loadAccounts(String filename) {
		//local variables
		String[] accountInfo = null;
		String accountType = "";
		
		//call the file to read
		try {
			scanner = new Scanner(new File(filename));			
			// read account information from file
			while (scanner.hasNextLine()) {
				accountInfo = scanner.nextLine().split("\\|");
				accountType = accountInfo[0]; //account type
				
				//create and put account info into hashtable list
				if (accountType.equals("S")) {
					accountList.put(accountInfo[1], 							//key account id
							new SavingsAccount(accountInfo[1],  				//account id
							accountInfo[2], 									//customer id
							accountInfo[3], 									//pin
							Double.parseDouble(accountInfo[4]), 				//balance
							Double.parseDouble(accountInfo[5])					//interest rate
							));
				} else {
					accountList.put(accountInfo[1],								//key account id
							new CheckingAccount(accountInfo[1], 				//account id
							accountInfo[2], 									//customer id
							accountInfo[3], 									//pin
							Double.parseDouble(accountInfo[4]), 				//balance
							Double.parseDouble(accountInfo[5]),					//last amount
							new Date(Integer.parseInt(accountInfo[6]) - 1900, 	//year
									Integer.parseInt(accountInfo[7]) - 1, 		//month
									Integer.parseInt(accountInfo[8]))));		//date
				}
			}
			scanner.close();	//close scanner
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/*
	 * instance variables
	 */
	private Hashtable<String, Account> accountList;
	private Scanner scanner;

	class Account {

		/**
		 * Constructor
		 * @param accountId
		 * @param customerId
		 * @param pin
		 * @param balance
		 */
		public Account(String accountId, String customerId, String pin, double balance) {
			this.accountId = accountId;
			this.customerId = customerId;
			this.pin = pin;
			this.balance = balance;
		}

		/**
		 * deposit money in the account
		 * @param amount
		 */
		public void deposit(double amount) {
			balance += amount;
		}

		/**
		 * withdraw money from the account
		 * @param amount
		 */
		public void withdraw(double amount) {
			balance -= amount;
		}
		
		/**
		 * @return the balance
		 */
		public double getBalance() {
			return balance;
		}

		/**
		 * @return the accountId
		 */
		public String getAccountId() {
			return accountId;
		}

		/**
		 * @return the customerId
		 */
		public String getCustomerId() {
			return customerId;
		}

		/**
		 * @return the pin
		 */
		public String getPin() {
			return pin;
		}

		/**
		 * @param accountId the accountId to set
		 */
		public void setAccountId(String accountId) {
			this.accountId = accountId;
		}

		/**
		 * @param customerId the customerId to set
		 */
		public void setCustomerId(String customerId) {
			this.customerId = customerId;
		}

		/**
		 * @param pin the pin to set
		 */
		public void setPin(String pin) {
			this.pin = pin;
		}

		/**
		 * @param balance the balance to set
		 */
		public void setBalance(double balance) {
			this.balance = balance;
		}
				
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Account [accountId=" + accountId + ", customerId=" + customerId + ", pin=" + pin + ", balance="
					+ balance + "]";
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 * Override equals method
		 */
		@Override
		public boolean equals(Object otherObject) {
			// a quick test to see if the objects are identical
			if (this == otherObject) return true;
			// must return false if the explicit parameter is null
			if (otherObject == null) return false;
			// if the classes don't match, they can't be equal
			if (getClass() != otherObject.getClass()) return false;
			// now we know otherObject is a non-null Account
			Account other = (Account) otherObject;
			// test whether the fields have identical values
			// assuming the accountId is unique
			return Objects.equals(accountId, other.accountId);
		}

		/*
		 * instance variables
		 */
		private String accountId;
		private String customerId;
		private String pin;
		private double balance;
	}

	class SavingsAccount extends Account{

		/**
		 * Constructor
		 * @param accountId
		 * @param customerId
		 * @param pin
		 * @param balance
		 * @param interestRate
		 */
		public SavingsAccount(String accountId, String customerId, String pin, double balance, double interestRate) {
			super(accountId, customerId, pin, balance);
			this.interestRate = interestRate;
		}
		

		/**
		 * @return the interestRate
		 */
		public double getInterestRate() {
			return interestRate;
		}

		/**
		 * @param interestRate the interestRate to set
		 */
		public void setInterestRate(double interestRate) {
			this.interestRate = interestRate;
		}

		/**
		 * add Monthly Interest rate to the balance
		 */
		public void applyMonthlyInterest() {
			deposit(getBalance() * interestRate / 12);
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "SavingsAccount [interestRate=" + interestRate + "]";
		}

		/* (non-Javadoc)
		 * @see edu.cmu.heinz.ij95713.Atm.BankServer.Account#equals(java.lang.Object)
		 * Override equals method
		 */
		@Override
		public boolean equals(Object otherObject) {
			if (!super.equals(otherObject)) return false;
			SavingsAccount other = (SavingsAccount) otherObject;
			return interestRate == other.interestRate;
		}

		/*
		 * instance variables
		 */
		private double interestRate;
	}

	class CheckingAccount extends Account{

		/**
		 * Constructor
		 * @param accountId
		 * @param customerId
		 * @param pin
		 * @param balance
		 * @param lastDepositDate
		 * @param lastDepositAmount
		 */
		public CheckingAccount(String accountId, String customerId, String pin, double balance, double lastDepositAmount,
				Date lastDepositDate) {
			super(accountId, customerId, pin, balance);
			this.lastDepositDate = lastDepositDate;
			this.lastDepositAmount = lastDepositAmount;
		}

		/**
		 * @return the lastDepositDate
		 */
		public Date getLastDepositDate() {
			return lastDepositDate;
		}

		/**
		 * @param lastDepositDate the lastDepositDate to set
		 */
		public void setLastDepositDate(Date lastDepositDate) {
			this.lastDepositDate = lastDepositDate;
		}

		/**
		 * @return the lastDepositAmount
		 */
		public double getLastDepositAmount() {
			return lastDepositAmount;
		}

		/**
		 * @param lastDepositAmount the lastDepositAmount to set
		 */
		public void setLastDepositAmount(double lastDepositAmount) {
			this.lastDepositAmount = lastDepositAmount;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "CheckingAccount [lastDepositDate=" + lastDepositDate + ", lastDepositAmount=" + lastDepositAmount
					+ "]";
		}

		/* (non-Javadoc)
		 * @see edu.cmu.heinz.ij95713.Atm.BankServer.Account#deposit(double)
		 */
		@Override
		public void deposit(double amount) {
			super.deposit(amount);
			lastDepositAmount = amount;
			lastDepositDate = new Date();
		}

		/* (non-Javadoc)
		 * @see edu.cmu.heinz.ij95713.Atm.BankServer.Account#equals(java.lang.Object)
		 * Override equals method
		 */
		@Override
		public boolean equals(Object otherObject) {
			if (!super.equals(otherObject)) return false;
			CheckingAccount other = (CheckingAccount) otherObject;
			return Objects.equals(lastDepositDate, other.lastDepositDate) 
					&& lastDepositAmount == other.lastDepositAmount;
		}

		/*
		 * instance variables
		 */
		private Date lastDepositDate;
		private double lastDepositAmount;
	}
}
