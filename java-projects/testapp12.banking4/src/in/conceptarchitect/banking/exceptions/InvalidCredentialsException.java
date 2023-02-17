package in.conceptarchitect.banking.exceptions;

public class InvalidCredentialsException extends BankingException {

	public InvalidCredentialsException(int accountNumber, String message, Throwable cause) {
		super(accountNumber, message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidCredentialsException(int accountNumber, String message) {
		super(accountNumber, message);
		// TODO Auto-generated constructor stub
	}

	public InvalidCredentialsException(int accountNumber) {
		super(accountNumber,"Invalid Credentials");
		// TODO Auto-generated constructor stub
	}

	
}
