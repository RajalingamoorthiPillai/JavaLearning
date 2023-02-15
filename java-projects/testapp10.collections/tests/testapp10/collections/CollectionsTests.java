package testapp10.collections;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.banking.BankAccount;
import in.conceptarchitect.banking.CurrentAccount;
import in.conceptarchitect.banking.OdAccount;
import in.conceptarchitect.banking.SavingsAccount;
import in.conceptarchitect.utils.CollectionUtils;
import in.conceptarchitect.utils.Matcher;

public class CollectionsTests {
	
	class GreaterThanMatcher implements Matcher<Integer>{

		int threshhold;
		public GreaterThanMatcher(int threshhold) {
			this.threshhold=threshhold;
		}
		@Override
		public boolean match(Integer value) {
			
			return value> threshhold;
		}
		
	}
	
	@Test
	public void searchCanReturnAllValuesGreaterThan20() {
		var result = cu.search(numbers,new GreaterThanMatcher(20));
		
		assertEquals(2, result.size());
	}

	CollectionUtils cu;
	
	List<Integer> numbers;
	
	@Before
	public void setUp() throws Exception {
		cu=new CollectionUtils();
		numbers=cu.create(5,11,20,9,8,7,4,2,21,5,24);
	}

	@Test
	public void createCreatesAnArrayList() {
		var list= cu.create(20,30,50,4);
		
		assertTrue(list instanceof ArrayList);
		assertEquals(4, list.size());
	}
	
	
	@Test
	public void duplicateCanDuplicateAList() {
		var list=List.of(2,9,11,8,4);
		
		var target=cu.duplicate(list);
		
		assertEquals(list.size(), target.size());
		
		assertArrayEquals(list.toArray(), target.toArray());
		
		
	}

	@Test
	public void searchCanReturnsAListOfNumbersDivisibleBy3() {
		
		var result = cu.search(numbers, new DivisibilityMatcher(3));
		
		assertEquals(3, result.size());
		for(var value : result)
			assertTrue(value%3==0);
	}
	
	@Test
	public void searchCanReturnsAListOfNumbersDivisibleBy5() {
		
		var result = cu.search(numbers, new DivisibilityMatcher(5));
		
		assertEquals(3, result.size());
		for(var value : result)
			assertTrue("Invalid value found:"+value,value%5==0);
	}
	
	String password="p@ss";
	double amount=30000;
	
	public List<BankAccount> createAccounts(){
		
		return cu.create(
					new SavingsAccount(1,"SA1",password,amount),
					new CurrentAccount(2,"CA1",password,amount),
					new OdAccount(3, "OD1", password, amount),
					new SavingsAccount(4,"SA2",password,amount),
					new SavingsAccount(5,"SA3",password,amount),
					new SavingsAccount(6,"SA4",password,amount),
					new OdAccount(7, "OD1", password, amount)
				);
		
		
	}
	
	
	@Test
	public void searchCanReturnAllSavingsAccount() {
		var accounts=createAccounts();
		
		var matcher=  new Matcher<BankAccount>() {
			
			public boolean match(BankAccount value) {
				
				return value instanceof SavingsAccount;
			}			
		};
		
		var result= cu.search(accounts, matcher);
		
		assertEquals(4,result.size());
	}
	
	@Test
	public void searchForOdAccountWithNegativeBalance() {
		var accounts=createAccounts();
		accounts.get(accounts.size()-1).withdraw(amount*1.05, password);
		
		Matcher<BankAccount> negativeOd= account->  account.getBalance()<0;
		
		var result= cu.search(accounts, negativeOd);
		
		assertEquals(1,result.size());
		assertTrue(result.get(0) instanceof OdAccount);
	}
	
	@Test
	public void searchForNumbersDivisibleBy15AndGreaterThan50() {
		//arrange
		var values=new ArrayList<Integer>();
		for(int i=1;i<=100;i++)
			values.add(i);
		
		var expectedResult=List.of(60,75,90);
		//act --> find all multiples of 15 greater than 50
		var result = cu.search(values, number->number>50 && number%15==0);
		
		//assert
		assertArrayEquals(expectedResult.toArray(), result.toArray());
		
		
		
	}
	
	
	
}
