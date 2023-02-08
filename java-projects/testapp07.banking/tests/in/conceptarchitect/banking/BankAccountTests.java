package in.conceptarchitect.banking;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankAccountTests {
	
	String password="p@ss";
	double amount=20000;
	double interestRate=12;
	BankAccount account;//=new BankAccount("Vivek",password,amount,interestRate);
	
	@Before
	public void setup() {
		BankAccount.lastId=0;
		account=new BankAccount("Vivek",password,amount,interestRate);
	}
	
	@Test
	public void firstAccountWillHaveId1() {
		assertEquals(1, account.getAccountNumber());
	}
	
	@Test
	public void accountsHaveSequentialId() {
		var a2=new BankAccount("Someone",password,amount,interestRate);
		var a3=new BankAccount("Someone",password,amount,interestRate);
		
		assertEquals(2, a2.getAccountNumber());
		assertEquals(3,a3.getAccountNumber());
	}
	
	@Test
	public void accountNumberShouldBeUnique() {
		var a2=new BankAccount("Vivek",password,amount,interestRate);
		assertNotEquals(account.getAccountNumber(), a2.getAccountNumber());
	}
	
	@Test
	public void depositShouldFailForNegativeAmount() {		
		
		var result = account.deposit(-1);
		
		//assertEquals(false, result);
		assertFalse(result);
	}
	
	@Test
	public void depositShouldSucceedForPositiveAmount() {
		
		var result= account.deposit(1);
		
		assertTrue(result);
	}
	
	@Test
	public void withdrawShouldFailForNegativeAmount() {
		assertEquals(BankingStatus.invalidAmount, account.withdraw(-1, password));
		
	}
	
	@Test
	public void withdrawShouldFailForInvalidPassword() {
		var result = account.withdraw(1, "invalid password");
		
		assertEquals(BankingStatus.invalidCredentials, result);
	}
	
	@Test
	public void withdrawShouldFailForInsufficientBalance() {
		var result = account.withdraw(amount+1, password);
		
		assertEquals(BankingStatus.insufficientBalance, result);
	}
	
	@Test
	public void withdrawShouldSucceedInHappyPath() {
		var result = account.withdraw(amount, password);
		
		assertEquals(BankingStatus.success, result);
	}
	
	
	
	
	
	
	
	@Test
	public void interestRateShouldBeCommonToEveryAccount() {
		
		var a2=new BankAccount(1, "Vivek", password, amount, interestRate);
		
		//when we change it for a1
		var newRate= interestRate* 1.05;
		
		//a2.setInterestRate(newRate);
		
		BankAccount.setInterestRate(newRate);
		
		assertEquals(newRate,account.getInterestRate(),0.001);
		assertEquals(newRate,a2.getInterestRate(),0.001);
		
	}

}
