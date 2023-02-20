package in.conceptarchitect.animals.reptiles;

import in.conceptarchitect.animals.Animal;

public class Crocodile extends Reptile {
	
	@Override
	public String move() {
		// TODO Auto-generated method stub
		return super.move()+" and swims";
	}

	public String hunt() {
		return this+" is great underwater hunter";
	}
	

}
