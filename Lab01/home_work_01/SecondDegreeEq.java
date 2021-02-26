package Lab01.home_work_01;

public class SecondDegreeEq {
	private double a, b, c;
	private double Denta;
	public SecondDegreeEq() {
		a = b = c = 0;
	}
	public SecondDegreeEq(double a, double b, double c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	// setter and getter 
	public double getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public double getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public double getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	
	// resolve
	public String resolve() {
		Denta = Math.pow(b, 2) - 4*a*c;
		if (Denta == 0) {
			return "x = " + (float)-b/(2*a);
		}
		else if (Denta > 0) {
			double x1 = (-b + Math.sqrt(Denta))/(2*a);
			double x2 = (-b - Math.sqrt(Denta))/(2*a);
			return "(x1, x2) = (" + x1 + ", " + x2 + ")"; 
		}
		else return "the equation has no solution";
	}
	
	
}