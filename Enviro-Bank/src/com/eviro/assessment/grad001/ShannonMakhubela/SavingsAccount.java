package com.eviro.assessment.grad001.ShannonMakhubela;
import java.math.*;

public class SavingsAccount {
	
	private int id ;
	private final BigDecimal Min = new BigDecimal(1000); ;
	private String accountnum;
	private BigDecimal balance ;
	
	public SavingsAccount(int id,String accountnum, BigDecimal balance) {
		this.id = id ;
		this.accountnum = accountnum ;
		this.balance = balance ;
	}
	
	//withdraw function.
	public void withdraw(String accountnum , BigDecimal Req_Amaount) throws WithdrawalAmountTooLargeException {
		
		//check balance.
		BigDecimal temp = getBalance().subtract(Req_Amaount) ;
		if( Min.compareTo(temp) <= 0) {
			setBalance(temp); //set the new Account Balance
		}else {
			 throw new WithdrawalAmountTooLargeException("Amount entered is more than available.");
		}
		
	}
	
	
	//get and setters.
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountnum() {
		return accountnum;
	}
	public void setAccountnum(String accountnum) {
		this.accountnum = accountnum;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	

}
