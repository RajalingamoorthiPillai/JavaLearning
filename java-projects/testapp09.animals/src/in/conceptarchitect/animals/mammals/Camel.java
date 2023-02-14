package in.conceptarchitect.animals.mammals;

import in.conceptarchitect.animals.Pet;
import in.conceptarchitect.commons.Rideable;

public class Camel extends Mammal  implements Rideable,Pet{

	public String eat() {
		return this+" is a grass eater";
	}
	
	
	public String ride() {
		return this+" is a desert Ride";
	}

}
