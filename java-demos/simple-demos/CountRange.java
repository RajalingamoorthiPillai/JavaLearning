class Program{

	public static void main(String[]args){
		int i=10;
		int j=50;
		countRange(i,j);
		System.out.println(i);
	}
	
	static void countRange(int min,int max){
		

		for(int count=0;min<max;min++){
			if(min%2==0)
				continue;

			System.out.print(min+"\t");
			if(min%5==0){
				count++;
				if(count==3) break;
			}
		}
		System.out.println("\nAt last count "+min);

	}

}