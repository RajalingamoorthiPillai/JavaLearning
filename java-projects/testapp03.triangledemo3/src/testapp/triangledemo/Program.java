package testapp.triangledemo;

import in.conceptarchitect.shapes.Triangle;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Triangle t1;
		
		t1= new Triangle(3,4,5);
		
		//t1.setSides(3,4,5);		
		
		
		testTriangle(t1);
		
		
		Triangle t2=new Triangle(5);
		//t2.setSides(1, 1, 1);
		testTriangle(t2);
		
		
		Triangle t3=new Triangle(2,4,8);
		//t3.setSides(2,4,8);
		testTriangle(t3);
		
		Triangle t4=new Triangle();
		
		testTriangle(t4);
		

	}
	
	

	private static void testTriangle(Triangle triangle) {
		System.out.println(triangle);
		if(triangle.isValid()) {
			System.out.print("Perimeter: "+triangle.perimeter()+"\t\t");
			System.out.println("Area: "+triangle.area());
		}
		System.out.println();
	}
	
	

}
