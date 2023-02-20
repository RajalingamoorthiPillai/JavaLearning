package in.conceptarchitect.animals.birds;

import in.conceptarchitect.animals.Pet;
import in.conceptarchitect.commons.SpecialBehavior;
import in.conceptarchitect.commons.Speciality;

@Speciality(behavior = "humanSpeak")
public class Parrot extends Bird implements Pet{
	
	@Override
	public String eat() {
		// TODO Auto-generated method stub
		return this+" is a fruitarian";
	}
	
	@SpecialBehavior
	public String humanSpeak() {
		return this+" can speak like human";
	}

	
	

}
