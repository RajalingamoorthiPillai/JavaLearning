package in.conceptarchitect.animals.mammals;

import in.conceptarchitect.animals.Animal;

public abstract class Mammal extends Animal {

	public Mammal() {
		super();
	}
	public String move() {
		return this+" moves on land";
	}
	
	public String breed() {
		
		return this+" is child bearing";
	}

}