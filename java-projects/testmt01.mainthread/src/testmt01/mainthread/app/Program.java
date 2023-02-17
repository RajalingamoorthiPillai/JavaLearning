package testmt01.mainthread.app;

public class Program {

	public static void main(String[] args) {
		
		Thread currentThread = Thread.currentThread();
		
		System.out.println(currentThread);
		
		currentThread.setName("My Thread");
		currentThread.setPriority(8);
		
		System.out.println(currentThread);

	}

}
