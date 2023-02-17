package in.conceptarchitect.banking;

import in.conceptarchitect.banking.exceptions.BankingException;
import in.conceptarchitect.banking.exceptions.InsufficientBalanceException;
import in.conceptarchitect.banking.exceptions.InvalidCredentialsException;
import in.conceptarchitect.banking.exceptions.InvalidDenominationException;
import in.conceptarchitect.utils.Encrypt;

public abstract class BankAccount {
	
	int accountNumber;
	String name;
	String password;
	private double balance;
	boolean active;
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	//static double interestRate;
	
	//static int lastId=0;
	
	@Deprecated
	public BankAccount(int accountNumber, String name, String password, double amount, double interestRate) {
		
		this(accountNumber,name,password,amount);
		
	}
	
	public BankAccount(int accountNumber, String name, String password, double amount) {
		
		this.accountNumber=accountNumber;
		this.name = name;
		setPassword(password);
		this.balance = amount; 
		this.active=true;
		
	}
	
	

	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", name=" + name + ", balance=" + balance
				 + "]";
	}



	public void deposit(double amount) throws InvalidDenominationException {
		
		validateAmount(amount);
		balance+=amount;
		
	}
	
	public void withdraw(double amount,String password) throws InvalidCredentialsException, InvalidDenominationException, InsufficientBalanceException  {
		
		authenticate(password);
		validateAmount(amount);
		
		var max=getMaxWithdrawableAmount();
		if(amount>max)
			throw new InsufficientBalanceException(accountNumber, amount-max);
		
		balance-=amount;
		
		
	}
	
	private void validateAmount(double amount) throws InvalidDenominationException {
		// TODO Auto-generated method stub
		if(amount<0)
			throw new InvalidDenominationException(accountNumber, "Amount Must Be greater than 0");
	}

	public void authenticate(String password) throws InvalidCredentialsException {
		Encrypt en=new Encrypt();
		if(!this.password.equals(en.encrypt(password)))
			//throw new RuntimeException("Invalid Credentials");
			throw new InvalidCredentialsException(accountNumber);
			
	}
	
	public void changePassword(String oldPassword, String newPassword) throws InvalidCredentialsException {
		authenticate(oldPassword);
		setPassword(newPassword);
		
	}
	
	public abstract double getMaxWithdrawableAmount();

	public  void creditInterest(double interestRate) {
		balance+= balance*interestRate/1200;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	



	public int getAccountNumber() {
		return accountNumber;
	}



	public double getBalance() {
		return balance;
	}

	
	private void setPassword(String password) {
		Encrypt en=new Encrypt();
		this.password= en.encrypt(password);
	}
	
	

	public void close(String password) {
		// TODO Auto-generated method stub
		authenticate(password);
			
		
		if(getBalance()<0)
			throw new InsufficientBalanceException(accountNumber, -getBalance(),"You need to clear your dues to close the account");
		setActive(false);

			
	}

	
	
	
	
	
}
