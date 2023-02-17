package testmt01.mainthread.app;

public class Program {

	public static void main(String[] args) {
		
		//Step #1
		var t1=new CountDownThread(); //this may run on a new thread
		var t2=new CountDownThread();
		var t3=new CountDownThread();
	
		
		//step#3
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("end of proram");
		
	}
	

}
