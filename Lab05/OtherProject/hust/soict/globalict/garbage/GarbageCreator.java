package hust.soict.globalict.garbage;

public class GarbageCreator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aaa";
		int length = s.length();
		int count = 0;
		while(count < 5) {
			s += s;
			count ++;
		}
		System.out.println(s);
	}

}
