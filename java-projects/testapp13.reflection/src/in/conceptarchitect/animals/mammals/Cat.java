package in.conceptarchitect.animals.mammals;

import in.conceptarchitect.animals.Hunter;
import in.conceptarchitect.commons.SpecialBehavior;
import in.conceptarchitect.commons.Speciality;


public abstract class Cat extends Mammal implements Hunter {

	public Cat() {
		super();
	}

	@Override
	public String eat() {
		// TODO Auto-generated method stub
		return this+" is a flesh eater";
	}

	@Override
	public String move() {
		// TODO Auto-generated method stub
		return this+" moves on land";
	}

	@SpecialBehavior
	public String hunt() {
		return this+" hunts in jungle";
	}

}