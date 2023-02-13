package in.conceptarchitect.banking;

import in.conceptarchitect.utils.Encrypt;

public class BankAccount {
	
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



	public boolean deposit(double amount) {
		if(amount>0) {
			balance+=amount;
			return true;
		}else {
			//System.out.println("deposit failed. for "+amount);
			return false;
		}
	}
	
	public BankingStatus withdraw(double amount,String password) {
		if(amount<0)
			return BankingStatus.invalidAmount;//System.out.println("withdraw failed for negative amount");
		else if(amount>balance)
			return BankingStatus.insufficientBalance;//System.out.println("insufficient balance");
		else if(!authenticate(password))
			return BankingStatus.invalidCredentials;//System.out.println("invalid credentials");
		else {
			balance-=amount;
			return BankingStatus.success;//System.out.println("Please collect your cash");
		}
		
	}
	
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
	
	public boolean authenticate(String password) {
		Encrypt en=new Encrypt();
		return this.password.equals(en.encrypt(password));
	}
	
	public boolean changePassword(String oldPassword, String newPassword) {
		if(authenticate(oldPassword)) {
			setPassword(newPassword);
			return true;
		}
		else
			return false;
	}

	
	
	
	
	
}
