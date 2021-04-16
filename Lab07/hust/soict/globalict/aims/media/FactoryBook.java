package hust.soict.globalict.aims.media;

import java.util.Scanner;

public class FactoryBook {
	static Scanner sc = new Scanner(System.in);
	public static Book createBook(){
		System.out.println("Enter Book title: ");
		String title = sc.nextLine();
		System.out.println("Enter Book category: ");
		String category = sc.nextLine();
		boolean flag = false;
		// add cost
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
		Book book = new Book(title, category, cost);
		// add author
		System.out.println("Enter author list: ");
		
		String author = "0";
		do {
			System.out.println("(Enter '0' to stop adding author)");
			author = sc.nextLine();
			book.addAuthor(author);
		}while(!author.equals("0"));
		return book;
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
//	public static Book createBook(String title, String category) {
//		return new Book(title, category, 0f);
//	}
//	
//	public static Book createBook(String title) {
//		return createBook(title, "", 0f);
//	}
}
