package in.conceptarchitect.banking;

public class StatusResult {
	

	private BankingStatus status;
	double balance;

	public StatusResult(BankingStatus status) {
		// TODO Auto-generated constructor stub
		this.status=status; 
	}

	public StatusResult(BankingStatus status, double balance) {
		this(status);
		 
		this.balance=balance;
		
	}

	public BankingStatus getStatus() {
		// TODO Auto-generated method stub
		return status;
	}

	public double getResult() {
		// TODO Auto-generated method stub
		return balance;
	}

}
