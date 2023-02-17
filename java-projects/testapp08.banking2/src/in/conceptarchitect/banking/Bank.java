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
		var account=new SavingsAccount(lastId, name, password, amount);
		
		
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
		
		var status= account.close(password);
		
		return new StatusResult(status, account.getBalance());
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
	
	
	public BankingStatus transfer(int sourceAccount, String password, double amount, int targetAccount) {
		var source= getAccount(sourceAccount);
		var target=getAccount(targetAccount);
		
		if(source==null)
			return BankingStatus.invalidAccountNumber;
		if(target==null)
			return BankingStatus.invalidAccountNumber;
		
		var result= source.withdraw(amount, password);
		if(result==BankingStatus.success) {
			target.deposit(amount);
			
		}
		return result;
			
	}




	private BankAccount getAccount(int accountNumber) {
		// TODO Auto-generated method stub
		if(accountNumber<1 || accountNumber>lastId)
			return null;
		
		var account=accounts[accountNumber];
		if(!account.isActive())
			return null;
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
		if(account!=null && account.authenticate(password))
		{
			return account.toString();
		}
		else
			return null;
				
	}

	public boolean deposit(int accountNumber, int amount) {
		// TODO Auto-generated method stub
		var account=getAccount(accountNumber);
		if(account==null)
			return false;
		else
			return account.deposit(amount);
	}

	public BankingStatus withdraw(int accountNumber,String password, int amount) {
		// TODO Auto-generated method stub
		var account=getAccount(accountNumber);
		if(account==null)
			return BankingStatus.invalidAccountNumber;
		else
			return account.withdraw(amount, password);
		
	}

}
