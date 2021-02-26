package Lab01.home_work_01;
import javax.swing.JOptionPane;
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Linear equation with 1 variables
		FirstDegreeEq eq = new FirstDegreeEq(0, 2);
		JOptionPane.showMessageDialog(null, eq.resolve());
		// linear equation with 2 variables
		FirstDegreeEq_2_vars eq1 = new FirstDegreeEq_2_vars(1, 2, 6, 4, 5, 6);
		JOptionPane.showMessageDialog(null, eq1.resolve());
		
		SecondDegreeEq eq2 = new SecondDegreeEq(1, -6, 9);
		JOptionPane.showMessageDialog(null, eq2.resolve());
		System.exit(0);
	}

}
