package in.conceptarchitect.banking.exceptions;

public class InsufficientBalanceException extends BankingException {
	
	double defict;
	

	public double getDefict() {
		return defict;
	}

	public InsufficientBalanceException(int accountNumber, double deficit, String message, Throwable cause) {
		super(accountNumber, message, cause);
		// TODO Auto-generated constructor stub
		this.defict=deficit;
	}

	public InsufficientBalanceException(int accountNumber, double deficit, String message) {
		super(accountNumber, message);
		// TODO Auto-generated constructor stub
		this.defict=deficit;
	}

	public InsufficientBalanceException(int accountNumber,double deficit) {
		super(accountNumber,"Invalid Denomination");
		// TODO Auto-generated constructor stub
		this.defict=deficit;
	}

	
}
