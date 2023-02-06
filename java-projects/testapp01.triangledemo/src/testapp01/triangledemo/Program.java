package testapp01.triangledemo;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Triangle t1;
		
		t1= new Triangle();
		
		t1.setSides(3,4,5);		
		testTriangle(t1);
		
		
		Triangle t2=new Triangle();
		t2.setSides(1, 1, 1);
		testTriangle(t2);
		
		
		Triangle t3=new Triangle();
		t3.setSides(2,4,8);
		testTriangle(t3);
		
		

	}

	private static void testTriangle(Triangle triangle) {
		System.out.println(triangle);
		System.out.print("Perimeter: "+triangle.perimeter()+"\t\t");
		System.out.println("Area: "+triangle.area());
		System.out.println();
	}
	
	

}
