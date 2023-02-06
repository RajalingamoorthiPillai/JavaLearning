package testapp.triangledemo;

public class Triangle {

	double s1,s2,s3;
	boolean valid;
	
	void setSides(double x, double y, double z) {
		if(x>0 && y>0 && z>0 && x+y>z && y+z>x && x+z>y) {
			s1=x;
			s2=y;
			s3=z;
			valid=true;
		} else {
			//what to do when user enters wrong info?
			//System.out.println("invalid sides");
			valid=false;
		}
	}
	
	
	double perimeter() {
		if(valid)
			return s1+s2+s3;
		else
			return Double.NaN;
	}
	
	double area() {
		if(!valid)
			return Double.NaN;
		
		
		double s=perimeter()/2;
		
		return Math.sqrt(s*(s-s1)*(s-s2)*(s-s3));
	}
	
	public String toString() {
		if(!valid)
			return "<invalid triangle>";
		else
			return "Triangle <"+s1+","+s2+","+s3+">";
	}

	
}
