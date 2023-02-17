package in.conceptarchitect.banking;

import in.conceptarchitect.banking.exceptions.ClosedAccountException;
import in.conceptarchitect.banking.exceptions.InvalidAccountException;

public class Bank {

	private String name;
	private double interestRate;
	
	BankAccount [] accounts = new BankAccount[10];

	public Bank(String bankName, double interestRate) {
		// TODO Auto-generated constructor stub
		this.name=bankName;
		this.interestRate=interestRate;
		 
	} 
 
	public String getName() {
		// TODO Auto-generated method stub 
		return name;
	}

	public double getInterestRate() {
		// TODO Auto-generated method stub
		return interestRate;
	}
	int lastId=0;
	public int openAccount(String name, String password, double amount) {
		// TODO Auto-generated method stub
		lastId++;
		var account=new SavingsAccount(lastId, name, password, amount);
		
		
		accounts[lastId]=account;
		
		return account.getAccountNumber();
	}

	public double closeAccount(int accountNumber, String password) {
		// TODO Auto-generated method stub
		var account=getAccount(accountNumber);
		account.close(password);
		
		return account.getBalance();
	}

	public void creditInterest() {
		// TODO Auto-generated method stub
		for(int i=1;i<=lastId;i++) {
			accounts[i].creditInterest(interestRate);
		}
		
	}

	public double getBalance(int accountNumber, String password) {
		// TODO Auto-generated method stub
		var account= getAccount(accountNumber);
		account.authenticate(password);
		return account.getBalance();
	}
	
	
	public void transfer(int sourceAccount, String password, double amount, int targetAccount) {
		var source= getAccount(sourceAccount);
		var target=getAccount(targetAccount);
		
		source.withdraw(amount, password);
		target.deposit(amount);
		
			
	}




	private BankAccount getAccount(int accountNumber) {
		// TODO Auto-generated method stub
		if(accountNumber<1 || accountNumber>lastId)
			throw new InvalidAccountException(accountNumber);
		
		var account=accounts[accountNumber];
		if(!account.isActive())
			throw new ClosedAccountException(accountNumber);
		else
			return account;
	
	}

	public void setInterestRate(double interestRate) {
		if(this.interestRate==0) {
			this.interestRate=interestRate;
			return;
		}
			
		var delta =this.interestRate/10;
		if(interestRate>= this.interestRate- delta && interestRate<=this.interestRate+delta)
			this.interestRate = interestRate;
	}

	public String getAccountDetails(int accountNumber, String password) {
		// TODO Auto-generated method stub
		var account=getAccount(accountNumber);
		if(account!=null )
		{
			account.authenticate(password);
			return account.toString();
		}
		else
			return null;
				
	}

	public void deposit(int accountNumber, int amount) {
		// TODO Auto-generated method stub
		var account=getAccount(accountNumber);
		
		account.deposit(amount);
			
	}

	public void withdraw(int accountNumber,String password, int amount) {
		// TODO Auto-generated method stub
		var account=getAccount(accountNumber);
		account.withdraw(amount, password);
		
	}

}
