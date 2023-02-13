package in.conceptarchitect.banking;

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
	
	@Ignore
	@Test
	public void OdAccountIsABankAccount() {
		assertTrue( account instanceof BankAccount);
	}
	
	@Ignore
	@Test
	public void odLimitInitiallyAs10PercentOfInitalBalance() {
		var expectedOdLimit= balance/10;
		
		assertEquals(expectedOdLimit, account.getOdLimit(), 0.01);
	}
	
	@Ignore
	@Test
	public void odLimitIncreasesOnDepositIfItCrossMaxHistoricBalance() {
		//act
		double amount=10000;
		account.deposit(amount);
		double expectedNewOdLimit= (balance+amount)/10;
		
		assertEquals(expectedNewOdLimit, account.getOdLimit(),0.01);
	}
	
	@Ignore
	@Test
	public void odLimitDoestChangeOnDepositIfMaxHistoricBalanceIsNotBreached() {
		//arrange
		var amount = 20000;
		account.deposit(amount); //now we reached historical balance
		double odLimitAtHistoricMaxBalance= account.getOdLimit();
		account.withdraw(amount,password);
		
		//act
		account.depsoit(amount/2); //historic max balance not reached
		
		//Assert
		assertEquals(odLimitAtHistoricMaxBalance, account.getOdLimit(),0.01);
	}
	
	@Ignore
	@Test
	public void odLimitIncreasesOnCreditInterestIfItCrossMaxHistoricBalance() {
		
	}
	
	@Ignore
	@Test
	public void odLimitDoestChangeCreditInterestIfMaxHistoricBalanceIsNotBreached() {
		
	}
	
	@Ignore
	@Test
	public void withdrawCanWithdrawUptoBalancePlusOdLimit() {
		
	}
	
	@Ignore
	@Test
	public void overWithdrawAttracts1PercentChargeOnOverDraft() {
		
	}
	
	@Ignore
	@Test
	public void closeAccountShouldFailForNegativeBalance() {
		
	}
	
	
	@Ignore
	@Test
	public void creditInterestUsesStandardRateForUpto1Lac() {
		
		//arrange
		var expectedBalance= balance+balance*rate/1200;
		//act
		account.creditInterest(rate);
		
		//Assert
		assertEquals(expectedBalance, account.getBalance(),0.01);
		
		
	}
	
	@Ignore
	@Test
	public void creditInterestUsesStandardRateForUpto1Lac() {
		
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
