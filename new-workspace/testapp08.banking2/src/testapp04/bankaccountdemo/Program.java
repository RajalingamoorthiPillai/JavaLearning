package testapp04.bankaccountdemo;

import in.conceptarchitect.banking.BankAccount;
import in.conceptarchitect.banking.BankingStatus;
import in.conceptarchitect.utils.Encrypt;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String password="p@ss";
		var amount=20000;
		var a1=new BankAccount(1, "Vivek", password, amount,12);
		
		var p=new Program();
		p.welcome();
		 
		
		
		depositTests("Deposit fails for negative amount", a1, -1, false);
		depositTests("Deposit succeeds for positive non zero amount",a1,100,true);
		
		withdrawTests("Withdraw should fail for negative amount",a1,-1,password, BankingStatus.invalidAmount);
		withdrawTests("Withdraw should fail for wrong password", a1, 1, "wrong password",BankingStatus.invalidCredentials);
		withdrawTests("Withdrw shoudl fail for insufficent balance",a1, amount+1, password, BankingStatus.insufficientBalance);
		withdrawTests("Withdraw should pass for happy case",a1,1,password,BankingStatus.success);
		
		
		
		
	}
	
	void welcome() {
		System.out.println("Hello World");
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





	static void depositTests(String message,BankAccount account, double amount, boolean expectedResult) {
		var actualResult= account.deposit(amount);
		if(actualResult==expectedResult) {
			System.out.println("PASSED:\t"+message);
		} else {
			System.out.println("FAILED:\t"+message);
			System.out.printf("\texpected was %s, got %s\n",expectedResult,actualResult);
		}
	}

}
