import java.io.IOException;
import java.math.*;
import java.util.*;
import com.eviro.assessment.grad001.ShannonMakhubela.* ;

public class Main {
	
	public static void main(String[] args) throws WithdrawalAmountTooLargeException, InterruptedException, IOException {
		
		Scanner in = new Scanner(System.in); ;
		boolean run = true ; 
		int counter = 3 ;
		boolean account_check = false ;
		BigDecimal R_amount = null ; 
		int temp_r = 0 ;
		String accountN = "" ;
		
		SystemDB instance = SystemDB.getInstance();
		//add savings.
		instance.addSavings();
		//add current.
		instance.addCurrentAccount();
		
		//enter account type.
		System.out.print("Choose Account : 'A' -> Savings Account, 'B' -> Current Account :");
		String AT = "" ;
		try {
			 AT = in.nextLine().toUpperCase();
			 
		}catch( Exception ex) {
			ex.printStackTrace();
		}
		

		
		
		switch(AT)
		{
	     	case "A": //savings
	     		print("");
	     		print("-SAVINGS ACCOUNT-");
	     		
	     		while(run)
	     		{
	     			System.out.print("Enter Account Number : ");
	     			//enter account number.
	     		    try {
	     		         accountN = in.nextLine() ;
	     		        
	     		         }catch( Exception ex) 
	     		    {ex.printStackTrace();}
	     		    
	     			// check account.
	     		    account_check = check_savingsAccount(instance, accountN);
	     		    
	     			if( account_check)
	     			{
	     				//get account.
	     				SavingsAccount savings = get_savingsaccount(instance , accountN);
	     				
	     				//Request Amount.
	     				System.out.print("Enter Amount you wish to withdraw : ");
	     				try {
	     				     temp_r = in.nextInt();
	     				     
	     				     }catch( Exception ex) {
	     				    	 ex.printStackTrace(); run = false ;}
	     				
	     				if(temp_r > 0)
	     				{
	     					R_amount = new BigDecimal(temp_r);
	     					savings.withdraw(savings.getAccountnum(), R_amount);
	     					print("----------------------------------------------");
	     					print("Amount withdrawn :" + R_amount);
	     					print("Remainining balance :" + savings.getBalance());
	     					print("----------------------------------------------");
	     					in.close();
	     					run = false ;
	     				}
	     				else
	     				{
	     					print("You cannot withdraw negative amounts");
	     					run = false ;
	     					in.close();
	     				}
	     				
	     				
	     				
	     			}else {
	     				print("invalid account Entered");
	     				counter -- ;
	     			}
	     			if(counter <= 0) {
	     				in.close();
	     				run = false ;
	     				print(" You tried 3 times : logged off");
	     			}
	     		}
	     		
	     		break;
		    case "B": //Current.
		    	
	     		print("");
	     		print("-CURRENT ACCOUNT-");
	     		
	     		while(run)
	     		{
	     			System.out.print("Enter Account Number : ");
	     			//enter account number.
	     		    try {
	     		         accountN = in.nextLine();
	     		       
	     		         }catch( Exception ex) {ex.printStackTrace();}
	     			// check account.
	     		    account_check = check_currentAccount(instance, accountN);
	     		    
	     		    if(account_check)
	     		    {
	     		    	//get account.
	     		    	CurrentAccount current = get_currentaccount(instance , accountN);
	     		    	//request amount.
	     				System.out.print("Enter Amount you wish to withdraw : ");
	     				try {
	     				     temp_r = in.nextInt();}catch( Exception ex) {ex.printStackTrace(); run = false ;}
	     				if(temp_r > 0)
	     				{
	     					R_amount = new BigDecimal(temp_r);
	     					current.withdraw(current.getAccount_num(), R_amount);
	     					print("----------------------------------------------");
	     					print("Amount withdrawn :" + R_amount);
	     					print("Remainining balance :" + current.getBalance());
	     					print("----------------------------------------------");
	     					in.close();
	     					run = false ;
	     				}
	     				else
	     				{
	     					print("You cannot withdraw negative amounts");
	     					in.close();
	     					run = false ;
	     				}
	     		    	
	     		    	
	     		    }else {
	     				System.err.println("Invalid account entered!");
	     				counter -- ;
	     		    }
	     		    //check counter.
	     			if(counter <= 0) {
	     				in.close();
	     				run = false ;
	     				print(" You tried 3 times : logged off");
	     			}
	     		}
	     			
		    	break;
			default :
				in.close();
				System.err.println("Invalid Account type ");
				break;
				
				
		}
		
		
	}
	
	public static void print(String data) {
		System.out.println(data);
	}
	
	//get savings account.
	public static SavingsAccount get_savingsaccount(SystemDB instance, String accountN) {
		
		for(var i: instance.getSavings_accounts()) {
			if(i.getAccountnum().equals(accountN)) {
				return i ;
			}
		}
		return null;
	}
	//get current Account.
	public static CurrentAccount get_currentaccount(SystemDB instance, String accountN) {
		for(var i: instance.getCurrent_accounts()) {
			if(i.getAccount_num().equals(accountN)) {
				return i ;
			}
		}
		return null ;
	}
	//check savings account
	public static boolean check_savingsAccount(SystemDB instance, String accountN) {
		var res = false ;
		for(var i: instance.getSavings_accounts()) {
			if(i.getAccountnum().equals(accountN)) {
				res = true ;
			}
		}
		return res ;
	}
	//check current account.
	public static boolean check_currentAccount(SystemDB instance, String accountN) {
		var res = false ;
		for(var i: instance.getCurrent_accounts()) {
			if(i.getAccount_num().equals(accountN)) {
				res = true ;
			}
		}
		return res ;
	}
	
}
