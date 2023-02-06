package in.conceptarchitect.shapes;

public class Triangle {

	private double s1,s2,s3;
	private boolean inValid;
	
	public boolean isValid() {
		return !inValid;
	}
	
	public Triangle(double s1,double s2,double s3) {
		setSides(s1,s2,s3);
	}
	
	public Triangle(double side) {
		setSides(side,side,side);
	}
	
	public Triangle() {
		setSides(1,1,1);
	}
	
	private void setSides(double x, double y, double z) {
		if(x>0 && y>0 && z>0 && x+y>z && y+z>x && x+z>y) {
			s1=x;
			s2=y;
			s3=z;
			inValid=false;
		} else {
			//what to do when user enters wrong info?
			//System.out.println("invalid sides");
			inValid=true;
		}
	}
	
	
	public double perimeter() {
		if(isValid())
			return s1+s2+s3;
		else
			return Double.NaN;
	}
	
	public double area() {
		if(!isValid())
			return Double.NaN;
		
		
		double s=perimeter()/2;
		
		return Math.sqrt(s*(s-s1)*(s-s2)*(s-s3));
	}
	
	public String toString() {
		if(!isValid())
			return "<invalid triangle>";
		else
			return "Triangle <"+s1+","+s2+","+s3+">";
	}

	
}
