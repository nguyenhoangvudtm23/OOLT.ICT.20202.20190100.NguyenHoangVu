package hust.soict.globalict.aims.media;

import java.util.Scanner;

public class FactoryCompactDisc {
	static Scanner sc = new Scanner(System.in);
	public static CompactDisc createCompacDisc() {
		System.out.println("Enter CD title: ");
		String title = sc.nextLine();
		System.out.println("Enter CD category: ");
		String category = sc.nextLine();
		System.out.println("Enter CD director: ");
		String director = sc.nextLine();
		System.out.println("Enter CD artist: ");
		String artist = sc.nextLine();
		
		
		boolean flag = false;
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
		
		CompactDisc cd = new CompactDisc(title, category, director, cost, artist);
		
		System.out.print("Enter the number of track u want to add to CD: ");
		int n = sc.nextInt();
		sc.nextLine();
		for(int i=1; i<=n; i++) {
			System.out.println("Enter the track no" + i);
			Track track = createTrack();
			cd.addTrack(track);
		}
		return cd;
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
	static Track createTrack() {
		System.out.println("Enter Track title: ");
		String title = sc.nextLine();
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
		return new Track(title, length);
	}
}
