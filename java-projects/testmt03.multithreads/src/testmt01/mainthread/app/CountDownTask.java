package testmt01.mainthread.app;

public class CountDownTask implements Runnable {

	@Override
	public void run() {
		int max=100;
		System.out.printf("Thread %d  starts\n",Thread.currentThread().getId());
		
		while(max>=0) {
			System.out.printf("Thread %d  counts %d\n",Thread.currentThread().getId(),max);
			max--;
		}
		
		System.out.printf("Thread %d  stops\n",Thread.currentThread().getId());
		
	}

}
