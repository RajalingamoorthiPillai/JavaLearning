package in.conceptarchitect.animals;

public abstract class Animal {

	public Animal() {
		System.out.println(this+" is created");
	}
	
	public abstract String eat();

	public abstract String move();

	public abstract String breed();
	
	public final boolean isPet() {
		return this instanceof Pet;
	}
	
	public String toString() {
		return getClass().getSimpleName();
	}

}