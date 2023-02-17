package testapp04.bankaccountdemo;

import in.conceptarchitect.banking.ATM;
import in.conceptarchitect.banking.Bank;

public class Program {
	public static void main(String[]args) {
		
		var bank=new Bank("ICICI",12);
		String password="p@ss";
		double amount=20000;
		bank.openAccount("Vivek", password, amount);
		bank.openAccount("Sanjay", password, amount);
		bank.openAccount("Aman", password, amount);
		
		ATM atm=new ATM(bank);
		
		atm.start();
	}
}
