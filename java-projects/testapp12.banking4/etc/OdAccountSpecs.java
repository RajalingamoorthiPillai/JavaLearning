package in.conceptarchitect.banking;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class OdAccountSpecs {

	double balance=50000;
	String password="p@ss";
	OdAccount account;
	double rate=12;
	@Before
	public void Init() {
		account=new OdAccount(1,"Vivek",password,balance);
	}
	
	//@Ignore
	@Test
	public void OdAccountIsABankAccount() {
		assertTrue( account instanceof BankAccount);
	}
	
	//@Ignore
	@Test
	public void odLimitInitiallyAs10PercentOfInitalBalance() {
		var expectedOdLimit= balance/10;
		
		assertEquals(expectedOdLimit, account.getOdLimit(), 0.01);
	}
	
	//@Ignore
	@Test
	public void odLimitIncreasesOnDepositIfItCrossMaxHistoricBalance() {
		//act
		double amount=10000;
		account.deposit(amount);
		double expectedNewOdLimit= (balance+amount)/10;
		
		assertEquals(expectedNewOdLimit, account.getOdLimit(),0.01);
	}
	
	//@Ignore
	@Test
	public void odLimitDoestChangeOnDepositIfMaxHistoricBalanceIsNotBreached() {
		//arrange
		var amount = 20000;
		account.deposit(amount); //now we reached historical balance
		double odLimitAtHistoricMaxBalance= account.getOdLimit();
		account.withdraw(amount,password);
		
		//act
		account.deposit(amount/2); //historic max balance not reached
		
		//Assert
		assertEquals(odLimitAtHistoricMaxBalance, account.getOdLimit(),0.01);
	}
	
	//@Ignore
	@Test
	public void odLimitIncreasesOnCreditInterestIfItCrossMaxHistoricBalance() {
		//act
		account.creditInterest(12);
		var newBalance=account.getBalance();
		var expectedOdLimit = newBalance/10;
		
		//assert
		assertEquals(expectedOdLimit, account.getOdLimit(),0.01);
	}
	
	//@Ignore
	@Test
	public void odLimitDoestChangeCreditInterestIfMaxHistoricBalanceIsNotBreached() {
		//arrange
		var expectedOdLimit=account.getOdLimit();
		account.withdraw(balance/2,	 password);
		//act
		account.creditInterest(12);
		
		//assert
		assertEquals(expectedOdLimit, account.getOdLimit(),0.01);
		
	}
	
	//@Ignore
	@Test
	public void withdrawCanWithdrawUptoBalancePlusOdLimit() {
		
		//act
		var result=account.withdraw(balance+account.getOdLimit(), password);
		
		//assert
		assertEquals(BankingStatus.success,result);
		assertTrue(account.getBalance()<0);
	}
	
	//@Ignore
	@Test
	public void overWithdrawAttracts1PercentChargeOnOverDraft() {
		var od = 5000;
		var odCharge= od*0.01;
		var expectedBalance= -(od+odCharge);
		
		var result=account.withdraw(balance+od, password);
		
		assertEquals(BankingStatus.success,result);
		assertEquals(expectedBalance, account.getBalance(),0.01);
	}
	
	//@Ignore
	@Test
	public void closeAccountShouldFailForNegativeBalance() {
		
		//arrange
		account.withdraw(balance+1, password); //now balance is negative
		
		//act
		var result=account.close(password);
		
		//Assert
		assertEquals(BankingStatus.insufficientBalance,result);
		assertTrue(account.isActive());
		
	}
	
	//@Ignore
	@Test
	public void closeAccountShouldFailForInvalidCredential() {
		
		//arrange
		
		//act
		var result=account.close("wrong password");
		
		//Assert
		assertEquals(BankingStatus.invalidCredentials,result);
		assertTrue(account.isActive());
		
	}
	
	//@Ignore
	@Test
	public void closeAccountShouldSucceedWithValidCredentialsAndPositiveBalance() {
		
		//arrange
		
		//act
		var result=account.close(password);
		
		//Assert
		assertEquals(BankingStatus.success,result);
		assertFalse(account.isActive());
		
	}
	
	
	
	//@Ignore
	@Test
	public void creditInterestUsesStandardRateForUpto1Lac() {
		
		//arrange
		var expectedBalance= balance+balance*rate/1200;
		//act
		account.creditInterest(rate);
		
		//Assert
		assertEquals(expectedBalance, account.getBalance(),0.01);
		
		
	}
	
	//@Ignore
	@Test
	public void creditInterestGivesAdditiona1PercentForBalanceAbove1Lac() {
		
		//arrange
		account.deposit(100000);
		double balance=account.getBalance();
		var expectedBalance= balance+balance*(rate+1)/1200;
		//act
		account.creditInterest(rate);
		
		//Assert
		assertEquals(expectedBalance, account.getBalance(),0.01);
		
		
	}
	
	
	
	
	
	
	
	
	

}
