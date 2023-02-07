package testapp01.triangledemo;

public class Triangle {

	double s1,s2,s3;
	

	
	
	double perimeter() {
		return s1+s2+s3*2;
	}
	
	double area() {
		double s=perimeter()/2;
		
		return Math.sqrt(s*(s-s1)*(s-s2)*(s-s3));
	}
	
	public String toString() {
		return "Triangle <"+s1+","+s2+","+s3+">";
	}

	void setSides(double x, double y, double z) {
		// TODO Auto-generated method stub
		s1=x;
		s2=y;
		s3=z;
	}
}
