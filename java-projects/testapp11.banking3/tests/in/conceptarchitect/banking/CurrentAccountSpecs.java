package in.conceptarchitect.banking;

import static org.junit.Assert.*;

import org.junit.Test;

public class CurrentAccountSpecs {

	String password="p@ss";
	double balance=50000;
	CurrentAccount account;
	public CurrentAccountSpecs() {
		// TODO Auto-generated constructor stub
		account=new CurrentAccount(1,"Vivek",password, balance);
	}
	
	@Test
	public void currentAccountDoesntReceivedInterest() {
		var interestRate=12;
		account.creditInterest(interestRate);
		
		assertEquals(balance, account.getBalance(),0.01);
	}

}
