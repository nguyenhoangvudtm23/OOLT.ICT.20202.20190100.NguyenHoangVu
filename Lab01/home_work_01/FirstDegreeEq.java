package Lab01.home_work_01;

//ax + b = 0
public class FirstDegreeEq {
	private double a, b;
	public FirstDegreeEq(double a, double b) {
		this.a = a;
		this.b = b;
	}
	public FirstDegreeEq() {
		a = b = 0;
	}
	// setter and getter
	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	
	// resolve
	public String resolve() {
		if(a == 0){
			if(b == 0) {
				return "Phuong trinh vo so nghiem";
			}
			else {
				return "Phuong tring vo nghiem";
			}
		}
		else {
			return "nghiem cua phuon trinh" + (float)-b/a;
		}
	}
	
	
	
}