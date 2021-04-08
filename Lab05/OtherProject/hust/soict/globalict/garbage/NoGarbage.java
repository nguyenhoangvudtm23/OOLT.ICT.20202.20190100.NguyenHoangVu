package hust.soict.globalict.garbage;

public class NoGarbage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aaa";
		
		// test with String builder
		StringBuilder sb = new StringBuilder(s);
		int length = s.length();
		int count = 0;
		long start = System.currentTimeMillis();
		while(count < 20) {
			sb.append(sb.toString());
			count ++;
		}
		long end = System.currentTimeMillis();
		//System.out.println(sb.toString());
		System.out.println("Time: " + (end - start));
		
		// test with + operator
		start = System.currentTimeMillis();
		count = 0;
		String temp = "";
		while(count < 20) {
			s += s;
			count ++;
		}
		end = System.currentTimeMillis();
		//System.out.println(s);
		System.out.println("Time: " + (end - start));
		
	}

}
