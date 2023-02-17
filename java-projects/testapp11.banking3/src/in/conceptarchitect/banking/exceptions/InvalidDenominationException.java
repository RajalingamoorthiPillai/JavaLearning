package in.conceptarchitect.banking.exceptions;

public class InvalidDenominationException extends BankingException {

	public InvalidDenominationException(int accountNumber, String message, Throwable cause) {
		super(accountNumber, message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidDenominationException(int accountNumber, String message) {
		super(accountNumber, message);
		// TODO Auto-generated constructor stub
	}

	public InvalidDenominationException(int accountNumber) {
		super(accountNumber,"Invalid Denomination");
		// TODO Auto-generated constructor stub
	}

	
}
