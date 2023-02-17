package testmt01.mainthread.app;

public class Program {

	public static void main(String[] args) throws InterruptedException {
		
		
		var t1= new Thread(()->countDown(200)); //connect logic to a new thread
		var t2=new Thread(()->countDown(100));
		var t3=new Thread(()->countDown(150));
		
		//step#3
		t1.start();
		t2.start();
		t3.start();
		
		//keepMainBusy();
		
		//put main to sleep.
		//makeMainSleep();
		
		isAliveTest(t1, t2, t3);
		
		System.out.println("end of program");
		
	}

	private static void isAliveTest(Thread t1, Thread t2, Thread t3) {
		while(t1.isAlive() || t2.isAlive() || t3.isAlive())
			System.out.print("+");
	}

	private static void makeMainSleep() throws InterruptedException {
		Thread.sleep(5000); //5 seconds
	}

	private static void keepMainBusy() {
		for(int i=0;i<500;i++)
			System.out.print(".");
	}
	
	static void countDown(int max) {
		
		System.out.printf("Thread %d  starts\n",Thread.currentThread().getId());
		
		while(max>=0) {
			System.out.printf("Thread %d  counts %d\n",Thread.currentThread().getId(),max);
			max--;
		}
		
		System.out.printf("Thread %d  stops\n",Thread.currentThread().getId());
	}
	

}
