package testmt01.mainthread.app;

public class Program {

	public static void main(String[] args) {
		
		
		var t1= new Thread(()->countDown()); //connect logic to a new thread
		var t2=new Thread(()->countDown());
		var t3=new Thread(()->countDown());
		
		//step#3
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("end of program");
		
	}
	
	static void countDown() {
		int max=100;
		System.out.printf("Thread %d  starts\n",Thread.currentThread().getId());
		
		while(max>=0) {
			System.out.printf("Thread %d  counts %d\n",Thread.currentThread().getId(),max);
			max--;
		}
		
		System.out.printf("Thread %d  stops\n",Thread.currentThread().getId());
	}
	

}
