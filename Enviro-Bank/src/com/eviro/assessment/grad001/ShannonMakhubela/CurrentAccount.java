/*
 * @author Shannon Makhubela
 */
package com.eviro.assessment.grad001.ShannonMakhubela;
import java.math.*;

public class CurrentAccount implements AccountService {
	
	private int id ;
	private String account_num ;
	private BigDecimal balance ;
	private BigDecimal overdraft;
	private final BigDecimal overdraft_limit = new BigDecimal(100000) ;
	
	// Constructor.
	public CurrentAccount(int id , String account_num , BigDecimal balance , BigDecimal overdraft) {
		//initialize
		
		this.id = id ;
		this.account_num = account_num ;
		this.balance = balance ;
		this.overdraft = overdraft ;
		
	}
	// withdraw function.
	@Override
	public void withdraw(String accountNum , BigDecimal req_Amount) throws WithdrawalAmountTooLargeException {
		
		
		if(getOverdraft_Limit().compareTo(getOverdraft()) > 0) {
			// (balance + limit)
			if(req_Amount.compareTo(getBalance().add(getOverdraft_Limit())) < 0) {
				//withdraw.
				BigDecimal temp = getBalance().subtract(req_Amount);
				setBalance(temp); //set balance to new balance remaining
				 
			}else {
				//withdraw_mount > (balance + overdraft limit)
				throw new WithdrawalAmountTooLargeException( " You eligible for " + getBalance().add(getOverdraft_Limit())+" and less" );
			}
		}else {
			// you have reached overdraft limit
			throw new WithdrawalAmountTooLargeException(" You have reached overdraft limit" );
		}
		
	}
	
	
	
	// getters and setters.
	//id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//account
	public String getAccount_num() {
		return account_num;
	}
	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}
	// balance
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	//overdraft_limkit
	public BigDecimal getOverdraft_Limit() {
		return overdraft_limit;
	}
	
	//overdraft
	public BigDecimal getOverdraft() {
		return overdraft;
	}
	public void setOverdraft(BigDecimal overdraft) {
		this.overdraft = overdraft;
	}
	

}
