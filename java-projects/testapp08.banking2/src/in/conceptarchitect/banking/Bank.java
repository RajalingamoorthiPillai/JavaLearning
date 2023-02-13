package in.conceptarchitect.banking;

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
		var account=new BankAccount(lastId, name, password, amount);
		
		
		accounts[lastId]=account;
		
		return account.getAccountNumber();
	}

	public StatusResult closeAccount(int accountNumber, String password) {
		// TODO Auto-generated method stub
		if(accountNumber<1 || accountNumber>lastId)
			return new StatusResult(BankingStatus.invalidAccountNumber);
		
		var account= accounts[accountNumber];
		
		if(!account.isActive())
			return new StatusResult(BankingStatus.invalidAccountNumber);
		
		if(!account.authenticate(password))
			return new StatusResult(BankingStatus.invalidCredentials);
		
		if(account.getBalance()<0)
			return new StatusResult(BankingStatus.insufficientBalance);
		
		account.setActive(false);
		
		return new StatusResult(BankingStatus.success, account.getBalance());
	}

	public void creditInterest() {
		// TODO Auto-generated method stub
		for(int i=1;i<=lastId;i++) {
			accounts[i].creditInterest(interestRate);
		}
		
	}

	public StatusResult getBalance(int accountNumber, String password) {
		// TODO Auto-generated method stub
		return new StatusResult(BankingStatus.invalidCredentials);
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

}
