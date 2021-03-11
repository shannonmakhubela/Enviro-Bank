package com.eviro.assessment.grad001.ShannonMakhubela;
import java.util.*;
import java.math.*;

public class SystemDB {
	
	private ArrayList<SavingsAccount> savings_accounts;
	private ArrayList<CurrentAccount> current_accounts;

	private static SystemDB db_instance = null;

	private SystemDB(){
		this.savings_accounts = new ArrayList<SavingsAccount>();
		this.current_accounts = new ArrayList<CurrentAccount>();
	}

	public static SystemDB getInstance(){
		if(db_instance == null)
			db_instance = new SystemDB();

		return db_instance;
	}


	//define a function to add SA 
	public void addSavings(){
		
		savings_accounts.add(new SavingsAccount(101, "1", new BigDecimal(2000)));
		savings_accounts.add(new SavingsAccount(102, "1", new BigDecimal(5000)));
	}
	
	// Add to CA
	public void addCurrentAccount(){
		
		current_accounts.add(new CurrentAccount(103, "3", new BigDecimal(1000), new BigDecimal(10000)));
		current_accounts.add(new CurrentAccount(104, "4", new BigDecimal(-5000), new BigDecimal(20000)));
	}

	public ArrayList<SavingsAccount> getSavings_accounts() {
		return savings_accounts;
	}
	
	//getters and setters

	public void setSavings_accounts(ArrayList<SavingsAccount> savings_accounts) {
		this.savings_accounts = savings_accounts;
	}

	public ArrayList<CurrentAccount> getCurrent_accounts() {
		return current_accounts;
	}

	public void setCurrent_accounts(ArrayList<CurrentAccount> current_accounts) {
		this.current_accounts = current_accounts;
	}
	

}
