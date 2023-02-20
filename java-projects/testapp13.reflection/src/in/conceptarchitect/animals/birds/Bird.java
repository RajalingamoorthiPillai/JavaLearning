package in.conceptarchitect.animals.birds;

import in.conceptarchitect.animals.Animal;
import in.conceptarchitect.commons.SpecialBehavior;

public abstract class Bird extends Animal {
	
	@Override
	public final String breed() {
		// TODO Auto-generated method stub
		return this+" lays eggs";
	}
	
	
	@Override
	public String move() {
		// TODO Auto-generated method stub
		return fly();	
	}
	
	@SpecialBehavior
	public String fly() {
		return this+" flies in sky";
	}

}
