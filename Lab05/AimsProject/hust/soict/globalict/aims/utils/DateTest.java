package hust.soict.globalict.aims.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyDate o1 = new MyDate(2, 3, 2002);
		MyDate o2 = new MyDate(3, 4, 2001);
		// get current date
		MyDate o3 = new MyDate();
		
		//check if date is valid
		System.out.println(o1.isDateValid());
		
		// get date by format
		System.out.println(o3.GetFormatDate());
		System.out.println(o3.GetDatebyFormat());
		System.out.println(o3.GetDate());
		
		
		// compare date
		// 1 if o1 > o2, 0 if equal, -1 if o1 < o2
		System.out.println(DateUtils.compareDate(o1, o2));
		
		
		
		// sort list of date
		List<MyDate> ls = new ArrayList<MyDate>();
		ls.add(o1);
		ls.add(o2);
		ls.add(o3);
		DateUtils.sort(ls);
		Iterator<MyDate> it = ls.iterator();
		while(it.hasNext()) {
			MyDate date = it.next();
			System.out.println(date.GetDatebyFormat());
		}
	}

}
