package hust.soict.globalict.aims.media;

import java.util.Scanner;

public class FactoryDigitalVideoDisc {
	static Scanner sc = new Scanner(System.in);
	public static DigitalVideoDisc createDigitalVideoDisc() {
		System.out.println("Enter DVD title: ");
		String title = sc.nextLine();
		System.out.println("Enter DVD category: ");
		String category = sc.nextLine();
		System.out.println("Enter DVD director: ");
		String director = sc.nextLine();
		
		boolean flag = false;
		// enter length
		int length = 0;
		do {
			try {
				length = sc.nextInt();
				sc.nextLine();
				flag = false;
			}
			catch(Exception e) {
				System.out.println("wrong format of length !\nPLease Enter again");
				flag = true;
			}
		}while(flag);
		// enter cost
		float cost = 0;
		do {
			System.out.println("Enter cost: ");
			String s = sc.nextLine();
			if(checkFloat(s)) {
				flag = false;
				cost = Float.parseFloat(s);
			}
			else {
				System.out.println("wrong format of cost !\nPLease Enter again");
				flag = true;
			}
//			try {
//				System.out.println("Enter cost: ");
//				cost = sc.nextFloat();
//				sc.nextLine();
//				flag = false;
//			}
//			catch(Exception e) {
//				System.out.println("wrong format of cost !\nPLease Enter again");
//				flag = true;
//			}
		}while(flag);
		
		return new DigitalVideoDisc(title, category, director, length, cost);
	}
	private static boolean checkFloat(String s) {
		try {
			Float.parseFloat(s);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
//	public static DigitalVideoDisc createDigitalVideoDisc(String title, String category, float cost) {
//		return new DigitalVideoDisc(title, category, cost);
//	}
}
