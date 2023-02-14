package in.conceptarchitect.animals.birds;

import in.conceptarchitect.animals.Animal;

public abstract class Bird extends Animal {
	
	@Override
	public String breed() {
		// TODO Auto-generated method stub
		return this+" lays eggs";
	}
	
	
	@Override
	public String move() {
		// TODO Auto-generated method stub
		return fly();	
	}
	
	public String fly() {
		return this+" flies in sky";
	}

}
