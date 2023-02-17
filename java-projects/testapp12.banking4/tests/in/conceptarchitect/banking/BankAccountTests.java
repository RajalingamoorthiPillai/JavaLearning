package in.conceptarchitect.banking;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import in.conceptarchitect.banking.exceptions.InsufficientBalanceException;
import in.conceptarchitect.banking.exceptions.InvalidCredentialsException;
import in.conceptarchitect.banking.exceptions.InvalidDenominationException;

public class BankAccountTests {
	
	String password="p@ss"; 
	double amount=20000;
	double interestRate=12;
	BankAccount account;//=new BankAccount("Vivek",password,amount,interestRate);
	
	
	@Before
	public void setup() {
		//BankAccount.lastId=0;
		account=new SavingsAccount(1,"Vivek",password,amount);
	}
	
	@Test
	public void firstAccountWillHaveId1() {
		assertEquals(1, account.getAccountNumber());
	}
	
	@Test
	public void accountsHaveSequentialId() {
		var a2=new SavingsAccount(2,"Someone",password,amount);
		var a3=new SavingsAccount(3,"Someone",password,amount);
		
		assertEquals(2, a2.getAccountNumber());
		assertEquals(3,a3.getAccountNumber());
	}
	
	@Test
	public void accountNumberShouldBeUnique() {
		var a2=new SavingsAccount(2,"Vivek",password,amount);
		assertNotEquals(account.getAccountNumber(), a2.getAccountNumber());
	}
	
	@Test
	public void depositShouldFailForNegativeAmount() {		
		
//		var result = account.deposit(-1);
//		
//		//assertEquals(false, result);
//		assertFalse(result);
	}
	
	@Test
	public void depositShouldSucceedForPositiveAmount() {
		
//		var result= account.deposit(1);
//		
//		assertTrue(result);
	}
	
	@Test
	public void withdrawShouldFailForNegativeAmount() {
		try{
			account.withdraw(-1, password);
			fail("Excepted InvalidDenominationException wasn't thrown");
			
		}catch(InvalidDenominationException ex) {
			System.out.println(ex.getMessage());
			assertTrue(ex.getMessage().contains("Amount Must Be"));
			
		}
		
	}
	
	@Test(expected = InvalidCredentialsException.class)
	public void withdrawShouldFailForInvalidPassword() {
		
		account.withdraw(1, "wrong password");
		
	}
	
	
	@Test
	public void withdrawShouldFailForInsufficientBalance() {
		
		var ex= assertThrows(InsufficientBalanceException.class, ()->{			
			//your code here
			account.withdraw(amount+1, password);
		});
		
		//you can also validate agains exception properties
		assertEquals(5001, ex.getDefict(),0.0);
		
	}
	
	/*
	
	@Test
	public void withdrawShouldSucceedInHappyPath() {
		var result = account.withdraw(1, password);
		
		assertEquals(BankingStatus.success, result);
	}
	
	*/
	
	
	
	
	
//	@Test
//	public void interestRateShouldBeCommonToEveryAccount() {
//		
//		var a2=new BankAccount(1, "Vivek", password, amount,interestRate);
//		
//		//when we change it for a1
//		var newRate= interestRate* 1.05;
//		
//		//a2.setInterestRate(newRate);
//		
//		BankAccount.setInterestRate(newRate);
//		
//		assertEquals(newRate,account.getInterestRate(),0.001);
//		assertEquals(newRate,a2.getInterestRate(),0.001);
//		
//	}

}
