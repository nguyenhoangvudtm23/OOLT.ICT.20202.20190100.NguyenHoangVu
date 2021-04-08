package hust.soict.globalict.aims.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import java.text.ParseException;

public class MyDate{
	private int day, month, year;
	
	public int getDay() {
		return day;
	}


	public void setDay(int day) {
		this.day = day;
	}


	public int getMonth() {
		return month;
	}


	public void setMonth(int month) {
		this.month = month;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}

	private static String[] monthName = {"January", "February",
            "March", "April", "May", "June", "July",
            "August", "September", "October", "November",
            "December"};
	public MyDate() {
		Calendar cal = Calendar.getInstance();
		this.month = (cal.get(Calendar.MONTH) + 1);
		this.day = (cal.get(Calendar.DAY_OF_MONTH));
		this.year = (cal.get(Calendar.YEAR));
	}
	
	public MyDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	// check if date is valid or not
	public boolean isDateValid() {
		String strDate = GetDatebyFormat().trim();
		// if date is null
		if(strDate.equals("")) {
			System.out.println("Invalid date\n");
			return false;
		}
		// date is not null
		else {
			SimpleDateFormat spdf = new SimpleDateFormat("yyyy-mm-dd");
			spdf.setLenient(false);
			try {
				Date date = spdf.parse(strDate);
				//System.out.println(strDate+" is valid date");
			}
			catch(ParseException e) {
				//System.out.println(strDate+" is Invalid date");
		        return false;
			}
			return true;
			
		}
	}
	// return date string
	public String GetDate(){
		String days;
		if(day % 10 == 1) {
			days = "st";
		}
		else if(day % 10 == 2) {
			days = "sd";
		}
		else if(day % 10 == 3) {
			days = "rd";
		}
		else days = "th";
		String res = new String(monthName[month-1] + " " +  day + days + " " + year);
		return res;
	}
	public String GetFormatDate() {
		return "YYYY-MM-DD";
	}
	
	public String GetDatebyFormat(){
		// format yyyy-mm-dd
		return String.format("%d-%02d-%02d", year, month, day);
	}
}