package in.conceptarchitect.banking;

public class Bank {

	private String name;
	private double interestRate;

	public Bank(String bankName, double interestRate) {
		// TODO Auto-generated constructor stub
		this.name=bankName;
		this.interestRate=interestRate;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public double getInterestRate() {
		// TODO Auto-generated method stub
		return interestRate;
	}
	int x=0;
	public int openAccount(String name, String password, double amount) {
		// TODO Auto-generated method stub
		x++;
		return x;
	}

}
