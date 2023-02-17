package testmt01.mainthread.app;

public class Program {

	public static void main(String[] args) {
		
		//Step #1
		var printer=new ThreadInfoPrinter(); //this may run on a new thread
	
		//Step #2
		var userThread= new Thread(printer); //connect logic to a new thread
		
		//Step#3
		userThread.start(); //start the new thread and calls printer.run()
		
		//printer is an ordinary object. It can be used even without new thread
		printer.run(); //runs on the current thread printer.run()
	}
	

}
