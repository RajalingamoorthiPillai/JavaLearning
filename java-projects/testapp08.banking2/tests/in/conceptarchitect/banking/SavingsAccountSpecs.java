package in.conceptarchitect.banking;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class SavingsAccountSpecs {
	
	String name="Vivek";
	String password="p@ss";
	double balance =20000;
	int minBalance=5000;
	SavingsAccount account;

	@Before //arrange
	public void setUp() throws Exception {
		account=new SavingsAccount(1,name,password,balance);
	}

	//@Ignore
	@Test	
	public void SavingsAccountIsATypeOfBankAccount() {
		var account=new SavingsAccount(1,name,password,balance);
		
		assertTrue( account instanceof BankAccount);
	}
	
	//@Ignore
	@Test	
	public void SavingsAccountShouldHaveMinBalance() {
		var actualMinBalance= account.getMinBalance();
		
		assertEquals(minBalance, actualMinBalance);
	}
	
	//@Ignore
	@Test	
	public void withdrawShouldFailToWithdrawIfMinBalanceConditionIsNotmet() {
		
		var result = account.withdraw(balance-minBalance+1, password);
		
		assertEquals(BankingStatus.insufficientBalance, result);
		
	}
	
	//@Ignore
	@Test	
	public void withdrawShouldFailToWithdrawNegativeAmount() {
		
		assertEquals(BankingStatus.invalidAmount,account.withdraw(-1, password));
		
	}
	
	//@Ignore
	@Test	
	public void withdrawShouldFailToWithdrawWithInvalidCredentials() {
		assertEquals(BankingStatus.invalidCredentials, account.withdraw(1, "wrong password"));
	}
	
	//@Ignore
	@Test	
	public void withdrawShouldBeSuccessfulInWithdrawingUptoMinBalance() {
		var result=account.withdraw(balance-minBalance, password);
		assertEquals(BankingStatus.success, result);
		assertEquals(minBalance, account.getBalance(), 0.01);
	}
	
	//@Ignore
	@Test	
	public void creditInterestShouldCreditStandardInterest() {
		
		//Arrange
		var rate=12.0;
		var expectedBalance= balance+balance*rate/1200;
		
		//Act
		account.creditInterest(rate);
		
		//Assert
		assertEquals(expectedBalance, account.getBalance(),0.01);
	}
	
	
	
	
	
	
	

}
