class Program{

	public static void main(String[]args){

		for(int i=1;i<=12;i++){
			System.out.println("Month "+i+" has "+daysInMonth(i)+ " days");
	
		}		
		

	}

	static int daysInMonth(int month){

		switch(month){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				return 31;
			case 2:
				return 28;

			default:
				return 30;


		}
	}

}