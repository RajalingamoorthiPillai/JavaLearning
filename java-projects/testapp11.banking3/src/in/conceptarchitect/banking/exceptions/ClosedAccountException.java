package in.conceptarchitect.banking.exceptions;

public class ClosedAccountException extends BankingException {

	public ClosedAccountException(int accountNumber) {
		super(accountNumber,"Account is already closed");
		// TODO Auto-generated constructor stub
	}

	public ClosedAccountException(int accountNumber, String message) {
		super(accountNumber, message);
		// TODO Auto-generated constructor stub
	}

	public ClosedAccountException(int accountNumber, String message, Throwable cause) {
		super(accountNumber, message, cause);
		// TODO Auto-generated constructor stub
	}

}
