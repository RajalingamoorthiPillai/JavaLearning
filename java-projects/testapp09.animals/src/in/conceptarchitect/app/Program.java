package in.conceptarchitect.app;

import in.conceptarchitect.animals.Animal;
import in.conceptarchitect.animals.Hunter;
import in.conceptarchitect.animals.Pet;
import in.conceptarchitect.animals.birds.Eagle;
import in.conceptarchitect.animals.birds.Parrot;
import in.conceptarchitect.animals.mammals.Camel;
import in.conceptarchitect.animals.mammals.Dog;
import in.conceptarchitect.animals.mammals.Horse;
import in.conceptarchitect.animals.mammals.Leopard;
import in.conceptarchitect.animals.mammals.Tiger;
import in.conceptarchitect.animals.reptiles.Crocodile;
import in.conceptarchitect.animals.reptiles.Snake;
import in.conceptarchitect.commons.Rideable;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal [] animals= { 
				new Tiger(), 
				new Horse(),
				//new Animal(),
				new Crocodile(),
				new Parrot(),
				new Dog(),
				//new Reptile(),
				new Camel(),
				new Snake(),
				//new Mammal(),
				//new Cat(),				
				new Eagle(),
				//new Bird(),
				new Leopard(),				
		};
		
		System.out.println();
		
		for(var animal:animals) {
			
			if(animal.isPet())
				System.out.print("Pet ");
			System.out.println(animal);
			System.out.println(animal.eat());
			System.out.println(animal.move());
			System.out.println(animal.breed());
			
			//huntIfYouAreATiger(animal);
			
			huntIfYourAreAHunter(animal);
			rideARideable(animal);
			
			
			System.out.println();
		}
		

	}

	
	private static void rideARideable(Animal animal) {
		// TODO Auto-generated method stub
		if(animal instanceof Rideable) {
			var rideable=(Rideable) animal;
			System.out.println(rideable.ride());
		}
	}

	
	private static void huntIfYourAreAHunter(Animal animal) {
		// TODO Auto-generated method stub
		if(animal instanceof Hunter) {
			Hunter hunter=(Hunter) animal;
			System.out.println(hunter.hunt());
		}
	}

	private static void huntIfYouAreATiger(Animal animal) {
		if(animal instanceof Tiger) {
			var tiger=(Tiger) animal;
			System.out.println(tiger.hunt());
		}
	}

}
