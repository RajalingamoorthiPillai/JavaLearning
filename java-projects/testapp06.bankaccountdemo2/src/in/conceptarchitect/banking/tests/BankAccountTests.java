package in.conceptarchitect.banking.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import in.conceptarchitect.banking.BankAccount;

public class BankAccountTests {
	
	String password="p@ss";
	double amount=20000;
	double interestRate=12;
	
	@Test
	public void depositShouldFailForNegativeAmount() {		
		var account=new BankAccount(1, "Vivek", password, amount, interestRate);
		var result = account.deposit(-1);
		
		//assertEquals(false, result);
		assertFalse(result);
	}
	
	@Test
	public void depositShouldSucceedForPositiveAmount() {
		var account=new BankAccount(1,"Vivek",password,amount,interestRate);
		var result= account.deposit(1);
		
		assertTrue(result);
	}
	
	
	
	@Test
	public void interestRateShouldBeCommonToEveryAccount() {
		var a1=new BankAccount(1, "Vivek", password, amount, interestRate);
		var a2=new BankAccount(1, "Vivek", password, amount, interestRate);
		
		//when we change it for a1
		var newRate= interestRate* 1.05;
		a1.setInterestRate(newRate);
		
		assertEquals(newRate,a1.getInterestRate(),0.001);
		assertEquals(newRate,a2.getInterestRate(),0.001);
		
	}

}
