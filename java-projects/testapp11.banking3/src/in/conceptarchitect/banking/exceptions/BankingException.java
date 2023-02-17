package in.conceptarchitect.banking.exceptions;

public class BankingException extends RuntimeException{
	
	int accountNumber;
	

	public int getAccountNumber() {
		return accountNumber;
	}

	public BankingException(int accountNumber) {
		this(accountNumber,"Banking Exception");
		// TODO Auto-generated constructor stub
	}
	
	public BankingException(int accountNumber,String message) {
		super(message);
		// TODO Auto-generated constructor stub
		this.accountNumber=accountNumber;
				
	}

	
	public BankingException(int accountNumber,String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
		this.accountNumber=accountNumber;
	}

	




}
