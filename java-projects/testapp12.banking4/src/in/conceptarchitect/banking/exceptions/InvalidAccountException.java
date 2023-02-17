package in.conceptarchitect.banking.exceptions;

public class InvalidAccountException extends BankingException {

	public InvalidAccountException(int accountNumber, String message, Throwable cause) {
		super(accountNumber, message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidAccountException(int accountNumber, String message) {
		super(accountNumber, message);
		// TODO Auto-generated constructor stub
	}

	public InvalidAccountException(int accountNumber) {
		super(accountNumber,"Invalid Account Number");
		// TODO Auto-generated constructor stub
	}

	
}
