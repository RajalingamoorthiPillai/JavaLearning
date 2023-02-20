package in.conceptarchitect.animals.mammals;

import in.conceptarchitect.commons.SpecialBehavior;

//@SpecialBehavior
public class Cow extends Mammal {
	
	//@SpecialBehavior
	int age;

	@Override
	public String eat() {
		// TODO Auto-generated method stub
		return this + " eats grass";
	}
	
	@SpecialBehavior
	public String provideMilk() {
		return this+" provides milk";
	}

}
