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
	int a1,a2,lastAccount;
	
	@Before
	public void setUp() throws Exception {
		bank=new Bank(bankName,interestRate);
		a1=bank.openAccount("Account1", password, amount);
		a2=bank.openAccount("Account2", password, amount);
		lastAccount=a2;
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
		
		assertEquals(lastAccount+1,accountNumber);
	}
	
	//@Ignore
	@Test
	public void openAccountShouldGenerateSequentialAccountNumber() {
		var a1=bank.openAccount("first", password, amount);
		var a2=bank.openAccount("second", password, amount);
		
		assertEquals(lastAccount+1,a1);
		assertEquals(lastAccount+2,a2);
	}
	
	
	@Test
	public void closeAccountShouldFailToCloseInvalidAccountNumber() {
		
		//assertFalse(bank.closeAccount(100,password));
		//assertEquals(Double.NaN, bank.closeAccount(100, password),0.01);
		
		StatusResult result= bank.closeAccount(100, password);
		
		assertEquals(BankingStatus.invalidAccountNumber, result.getStatus());
	}
	
	
	
	@Test
	public void closeAccountShouldFailToCloseAccountWithNegativeBalance() {
		var a3=bank.openAccount("Negative Account", password, -1);
		//assertFalse(bank.closeAccount(a3,password));
		
		System.out.println("Total Accounts:"+bank.lastId);
		
		for(int i=1;i<=bank.lastId;i++)
			System.out.println(bank.accounts[i]);
		
		
		var result=bank.closeAccount(a3, password);
		System.out.println(result.getStatus());
		assertEquals(BankingStatus.insufficientBalance, result.getStatus());
	}
	
	
	@Test
	public void closeAccountShouldFailToCloseWithInvalidPassword() {
		//assertFalse(bank.closeAccount(a1,"wrong password"));
		var result=bank.closeAccount(a1, "wrong password");
		assertEquals(BankingStatus.invalidCredentials, result.getStatus());
	}
	
	
	@Test
	public void closeAccountShouldFailToCloseAlreadyClosedAccount() {
		
		//arrange
		bank.closeAccount(a1, password);
		
		//act
		var result = bank.closeAccount(a1, password);
		
		//assert
		assertEquals(BankingStatus.invalidAccountNumber	, result.getStatus());
	}
	
	
	@Test
	public void closeAccountShouldReturnTheClosingBalanceOnSuccess() {
		
		var  result = bank.closeAccount(a1, password);
		
		assertEquals(BankingStatus.success, result.getStatus());
		assertEquals(amount, result.getResult(),0.1);
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



	@Test
	public void creditInterestShouldCreditInterestToAllActiveAccounts() {
		
		bank.creditInterest();
		var expectedBalance= amount * interestRate/1200 + amount;
		
		assertEquals(expectedBalance, bank.getBalance(a1,password).getResult(),0.01);
		assertEquals(expectedBalance, bank.getBalance(a2,password).getResult(),0.01);
		
		
	}




	
	

}
