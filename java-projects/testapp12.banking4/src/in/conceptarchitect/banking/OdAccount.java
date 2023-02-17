package in.conceptarchitect.banking;

public class OdAccount extends BankAccount {

	double maxHistoricBalance;
	
	public OdAccount(int accountNumber, String name, String password, double amount) {
		super(accountNumber, name, password, amount);
		// TODO Auto-generated constructor stub
		maxHistoricBalance=amount;
	}

	public double getOdLimit() {
		// TODO Auto-generated method stub
		return maxHistoricBalance/10;
	}
	
	@Override
	public void deposit(double amount) {
	
		super.deposit(amount);
		
		adjustOdLimit();
		
		
	}

	private void adjustOdLimit() {
		if(maxHistoricBalance<getBalance())
			maxHistoricBalance=getBalance();
	}
	
	@Override
	public void creditInterest(double interestRate) {
		// TODO Auto-generated method stub
		if(getBalance()>=100000)
			interestRate+=1;
		super.creditInterest(interestRate);
		adjustOdLimit();
	}
	
	
	
    @Override
    public double getMaxWithdrawableAmount() {
    	// TODO Auto-generated method stub
    	return getBalance()+getOdLimit()*1.01;
    }


    @Override
    public void withdraw(double amount, String password) {
    
    	super.withdraw(amount, password);
    	
    	if(getBalance()<0) {
    		var odCharge= (-getBalance())*0.01;
    		super.withdraw(odCharge, password);
    	}
    }
	
    

}
