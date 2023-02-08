package in.conceptarchitect.banking;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BankSpecs {

	String bankName="ICICI";
	private double interestRate=12;
	Bank bank;
	String name="Vivek";
	String password="p@ss";
	double amount =20000;
	
	@Before
	public void setUp() throws Exception {
		bank=new Bank(bankName,interestRate);
	}

	
	@Test	
	public void bankShouldHaveAName() {
		
		
		assertEquals(bankName, bank.getName());
	}
	
	
	@Test
	public void bankShouldDefineInterestRate() {
		
		
		assertEquals(interestRate,bank.getInterestRate(),0.001);
	}
	
	//@Ignore
	@Test
	public void openAccountShouldTakeNamePasswordAmountAndReturnAccountNumber() {
		var accountNumber=bank.openAccount(name,password,amount);
		
		assertEquals(1,accountNumber);
	}
	
	//@Ignore
	@Test
	public void openAccountShouldGenerateSequentialAccountNumber() {
		var a1=bank.openAccount("first", password, amount);
		var a2=bank.openAccount("second", password, amount);
		
		assertEquals(2,a2);
	}
	
	@Ignore
	@Test
	public void closeAccountShouldFailToCloseInvalidAccountNumber() {
		
	}
	
	
	@Ignore
	@Test
	public void closeAccountShouldFailToCloseAccountWithNegativeBalance() {
		
	}
	
	@Ignore
	@Test
	public void closeAccountShouldFailToCloseWithInvalidPassword() {
		
	}
	
	@Ignore
	@Test
	public void closeAccountShouldFailToCloseAlreadyClosedAccount() {
		
	}
	
	@Ignore
	@Test
	public void closeAccountShouldReturnTheClosingBalanceOnSuccess() {
		
	}


	@Ignore
	@Test
	public void transferShouldFailForInvalidSourceAccount() {
		
	}
	
	@Ignore
	@Test
	public void transferShouldFailForInvalidTargetAccount() {
		
	}
	
	@Ignore
	@Test
	public void transferShouldFailForInsufficientBalanceInSourceAccount() {
		
	}
	
	@Ignore
	@Test
	public void transferShouldFailForInvalidCredentialInSourceAccount() {
		
	}
	
	@Ignore
	@Test
	public void transferShouldFailForInvalidAmount() {
		
	}

	
	@Ignore
	@Test
	public void transferShouldBeSuccessfulInHappyPath() {
		
	}







	
	

}
