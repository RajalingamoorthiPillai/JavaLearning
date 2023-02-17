package testmt01.mainthread.app;

public class Program {

	public static void main(String[] args) {
		
		//Step #1
		var c1=new CountDownTask(); //this may run on a new thread
		var c2=new CountDownTask();
		var c3=new CountDownTask();
	
		//Step #2
		var t1= new Thread(c1); //connect logic to a new thread
		var t2=new Thread(c2);
		var t3=new Thread(c3);
		
		//step#3
		t1.start();
		t2.start();
		t3.start();
		
		
		
	}
	

}
