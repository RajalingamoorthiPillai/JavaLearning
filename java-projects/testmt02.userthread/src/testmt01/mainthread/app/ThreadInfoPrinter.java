package testmt01.mainthread.app;

public class ThreadInfoPrinter implements Runnable {

	@Override
	public void run() {
		var t=Thread.currentThread();
		System.out.printf("%s has id %d\n",t, t.getId());		
		
	}

}
