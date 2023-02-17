package in.conceptarchitect.banking;

import in.conceptarchitect.utils.KeyPad;

public class ATM {
	Bank bank;
	KeyPad keypad=new KeyPad();
	int accountNumber;
	String password;
	
	public ATM(Bank bank) {
		// TODO Auto-generated constructor stub
		this.bank=bank;
	}


	public void start() {
		while(true) {
			accountNumber= keypad.readInt("account number?");
			password=keypad.readString("pin?");
			mainMenu();	
		}
	}


	private void mainMenu() {
		// TODO Auto-generated method stub
		int choice=0;
		do {
			choice=keypad.readInt("1. deposit 2. withdraw 3. transfer 4. close 5. show 0. exit");
			switch(choice) {
			case 1: doDeposit(); break;
			case 2: doWithdraw(); break;
			case 3: doTransfer(); break;
			case 4: doClose(); choice=0; break;
			case 5: doShowAccountDetails(); break;
			case 0: break;
			default:
				System.out.println("Invalid Input.Retry");
			}
			System.out.println();
		}while(choice!=0);
	}


	private void doShowAccountDetails() {
		// TODO Auto-generated method stub
		
		var details = bank.getAccountDetails(accountNumber,password);
		
		if(details!=null)
			printInfo(details);
		else
			printError("Invalid Account Info");
		
	}


	private void printError(String string) {
		// TODO Auto-generated method stub
		System.err.println("ERROR:"+string);
	}


	private void printInfo(String details) {
		// TODO Auto-generated method stub
		System.out.println("INFO:"+details);
	}


	private void doClose() {
		// TODO Auto-generated method stub
		
		var result=bank.closeAccount(accountNumber, password);
		if(result.getStatus()==BankingStatus.success) {
			System.out.println("Your account is closed");
			dispenseCash(result.getResult());
		}else {
			printError(result.getStatus().toString());
		}
			
		
	}


	private void dispenseCash(double amount) {
		// TODO Auto-generated method stub
		System.out.println("please collect your cash: "+amount);
	}	


	private void doTransfer() {
		// TODO Auto-generated method stub
		var toAccount=keypad.readInt("account to transfer?");
		var amount=keypad.readInt("amount to transfer?");
		
		var result=bank.transfer(accountNumber, password, amount, toAccount);
		
		if(result==BankingStatus.success)
			printInfo("amount transferred");
		else
			printError(result.toString());
	}


	private void doWithdraw() {
		// TODO Auto-generated method stub
		
		var amount= keypad.readInt("Amount to Deposit?");
		var result=bank.withdraw(accountNumber,password,amount);
		if(result==BankingStatus.success) {
			dispenseCash(amount);
		}			
		else
			printError(result.toString());
	}


	private void doDeposit() {
		// TODO Auto-generated method stub
		var amount= keypad.readInt("Amount to Deposit?");
		if(bank.deposit(accountNumber,amount))
			printInfo("deposited");
		else
			printError("deposit failed");
		
	}

}
