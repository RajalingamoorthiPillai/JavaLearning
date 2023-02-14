package in.conceptarchitect.animals.birds;

import in.conceptarchitect.animals.Pet;

public class Parrot extends Bird implements Pet{
	
	@Override
	public String eat() {
		// TODO Auto-generated method stub
		return this+" is a fruitarian";
	}
	
	public String humanSpeak() {
		return this+" can speak like human";
	}

	
	

}
