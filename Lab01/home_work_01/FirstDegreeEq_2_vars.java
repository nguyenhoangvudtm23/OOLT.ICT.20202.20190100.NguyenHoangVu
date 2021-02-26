package Lab01.home_work_01;

public class FirstDegreeEq_2_vars {
	// a11.x1 + a12.x2 = b1
	// a21.x1 + a22.x2 = b2
	private double a11, a21, a12, a22, b1, b2;
	private double D1, D2, D;
	// constructor
	public FirstDegreeEq_2_vars() {
		// TODO Auto-generated constructor stub
		a11 = a21 = a12 = a22 = b1 = b2 = 0;
		D1 = D2 = D = 0;
	}
	public FirstDegreeEq_2_vars(double a11, double a12, double b1, double a21, double a22, double b2) {
		this.a11 = a11;
		this.a21 = a21;
		this.a22 = a22;
		this.a12 = a12;
		this.b1 = b1;
		this.b2 = b2;
	}
	
	// resolve
	public String resolve() {
		D = a11*a22 - a21*a12;
		D1 = b1*a22 - b2*a12;
		D2 = a11*b2 - a21*b1;
		if(D != 0) {
			return ("(x1, x2) = (" + D1/D + "," +  (D2/D) + ")");
		}
		else {
			if(D1 == 0 && D2 == 0) {
				return "the system has infinitely many solutions";
			}
			else return "the system has no solutions";
		}
	}
	// setter and getter
	public double getA11() {
		return a11;
	}
	public void setA11(int a11) {
		this.a11 = a11;
	}
	public double getA21() {
		return a21;
	}
	public void setA21(int a21) {
		this.a21 = a21;
	}
	public double getA12() {
		return a12;
	}
	public void setA12(int a12) {
		this.a12 = a12;
	}
	public double getA22() {
		return a22;
	}
	public void setA22(int a22) {
		this.a22 = a22;
	}
	public double getB1() {
		return b1;
	}
	public void setB1(int b1) {
		this.b1 = b1;
	}
	public double getB2() {
		return b2;
	}
	public void setB2(int b2) {
		this.b2 = b2;
	}
	
}
