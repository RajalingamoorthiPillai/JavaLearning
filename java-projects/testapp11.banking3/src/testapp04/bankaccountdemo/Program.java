package testapp04.bankaccountdemo;

import in.conceptarchitect.banking.BankAccount;
import in.conceptarchitect.banking.BankingStatus;
import in.conceptarchitect.banking.CurrentAccount;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String password="p@ssword";
		double amount=20000;
		var account=new CurrentAccount(1,"Vivek",password,amount);
		
		withdrawTests("Happy Path", account, 1, password,BankingStatus.success);
		withdrawTests("Insufficient Balance", account, amount+1, password, BankingStatus.insufficientBalance);
		
		
		withdrawTests("Invalid Credentials", account,1,"wrong apssword", BankingStatus.invalidCredentials);
		
		
	}
	
	private static void withdrawTests(String message, BankAccount account, double amount, String password,
			BankingStatus expected) {
		
		var actual = account.withdraw(amount, password);
		if(actual==expected) {
			System.out.println("PASSED:\t"+message);
		} else {
			System.out.printf("FAILED:\t%s\n\texpected: %s found: %s\n", message,expected,actual);
		}
		
		
	}

}
