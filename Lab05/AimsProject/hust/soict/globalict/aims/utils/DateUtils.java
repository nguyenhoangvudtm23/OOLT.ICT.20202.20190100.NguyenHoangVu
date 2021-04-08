package hust.soict.globalict.aims.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DateUtils {
	
	public static int compareDate(MyDate mydate1, MyDate mydate2) {
		Calendar date1 = Calendar.getInstance();
		date1.set(mydate1.getYear(), mydate1.getMonth(), mydate1.getDay());
		Calendar date2 = Calendar.getInstance();
		date2.set(mydate2.getYear(), mydate2.getMonth(), mydate2.getDay());
		int flag = date1.compareTo(date2);
		// 0: equal
		// < 0: date1 < date2
		// > 0: date1 > date2
		return flag;
		
	}
	
	public static void sort(List<MyDate> ls){
		Collections.sort(ls, new Comparator<MyDate>() {

			@Override
			public int compare(MyDate o1, MyDate o2) {
				// TODO Auto-generated method stub
				return compareDate(o1, o2);
			}
			
		});
	}
}
