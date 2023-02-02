class Method01{


	static void greet(String name){

		System.out.println("Hello "+name+", welcome to Java World");
	}


	static void goodBye(){
		System.out.println("Good Bye everyone, see you soon");
	}

	public static void main(String []args){
		
		greetEveryone();

	}

	static void greetEveryone(){

		greet("Vivek"); //call the other method
		greet("Raheem"); // call again
		greet("Venu"); //and yet again
	}

}