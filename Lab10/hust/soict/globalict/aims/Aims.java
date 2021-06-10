package hust.soict.globalict.aims;

import hust.soict.globalict.aims.order.*;
import hust.soict.globalict.aims.order.Order.OutNumberOrderException;
import hust.soict.globalict.aims.utils.MyDate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.naming.LimitExceededException;

import hust.soict.globalict.aims.media.*;


public class Aims {
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<Order> listOrder = new ArrayList<>();
	public static ArrayList<Media> listMedia = new ArrayList<>();
	public static ArrayList<Media> ListBook = new ArrayList<>();
	public static ArrayList<Media> ListDigitalVideoDisc = new ArrayList<>();
	public static ArrayList<Media> ListCompactDisc = new ArrayList<>();
	public static int currentIdOrder = 0;
	
	
	public static void main(String[] args) throws OutNumberOrderException{
		// TODO Auto-generated method stub
		createListMedia();
//		CustomerMenu();
//		AdminMenu();
		System.out.println("Program Start !!!");
		char c = '0';
		do {
			MainMenu();
			c = sc.next().charAt(0);
			sc.nextLine();
			switch(c) {
			case '1': 
				AdminMenu();
				break;
			case '2':
				CustomerMenu();
				break;
			case '0':
				break;
			default:
				System.out.println("Wrong choice !!");
				break;
			}
		}while(c != '0');
		
		System.out.println("End program");
	}
	public static void MainMenu() {
		System.out.println("Main Menu !!");
		System.out.println("1. Admin Menu");
		System.out.println("2. Customer Menu");
		System.out.println("0. Exit");
		System.out.println("Please choose a number: 0-1-2");
	}
	// admin menu
	public static void AdminMenu() {
		char c = '0';
		do {
			showAdminMenu();
			c = sc.next().charAt(0);
			sc.nextLine();
			switch(c) {
			case '1':
				// create new item
				System.out.println("What type of item do you want to create?");
				char ans;
				do {
					System.out.print("Book(B) DigitalVideoDisc(D) CompactDisc(C): ");
					ans = sc.next().toUpperCase().charAt(0);
					sc.nextLine();
					if(ans != 'B' && ans != 'C' && ans != 'D') {
						System.out.println("Wrong key, choose again !!!");
					}
				}while(ans != 'B' && ans != 'C' && ans != 'D');
				// if admin want to create Book
				if(ans == 'B') {
					Book temp = FactoryBook.createBook();
					ListBook.add(temp);
					listMedia.add(temp);
					System.out.println("Successfully create Book with itemID: " + temp.getItemID());
				}
				// if admin want to create DVD
				else if(ans == 'D') {
					DigitalVideoDisc temp = FactoryDigitalVideoDisc.createDigitalVideoDisc();
					ListDigitalVideoDisc.add(temp);
					listMedia.add(temp);
					System.out.println("Successfully create DVD with itemID: " + temp.getItemID());
				}
				// if admin want to create CD
				else {
					CompactDisc temp = FactoryCompactDisc.createCompacDisc();
					ListCompactDisc.add(temp);
					listMedia.add(temp);
					System.out.println("Successfully create CD with itemID: " + temp.getItemID());
				}
				break;
				// if admin want to add CompactDisc
			case '2':
				// delete item by id
				System.out.println("Example enter item u want to delete: " + "1,2,3,4,5,6");
				System.out.println("Enter item id: ");
				String s = sc.nextLine();
				String[] deleitemid = s.split(",");
				int key;
//				for(String id: additemid) {
//					System.out.println(id);
//				}
//				System.out.println(additemid);
				for(String id: deleitemid) {
					try {
						key = Integer.valueOf(id.trim());
						int index = findItembyId(key, listMedia);
						// check if book, dvd, or cd
						
						if(index != -1) {
							System.out.println("Successfully delete item: " + listMedia.get(key).getTitle());
							listMedia.remove(index);
							Media med = listMedia.get(index);
							if(med instanceof Book) {
								int index_med = findItembyId(key, ListBook);
								ListBook.remove(index_med);
							}
							else if(med instanceof DigitalVideoDisc) {
								int index_med = findItembyId(key, ListDigitalVideoDisc);
								ListDigitalVideoDisc.remove(index_med);
							}
							else {
								int index_mde = findItembyId(key, ListCompactDisc);
								ListCompactDisc.remove(index_mde);
							}
						}
						else {
							System.out.println("ID "+ key + " doesnt exist !!!");
						}
					}
					catch(Exception e) {
						System.out.println("Invalid id item: " + id);
					}
				}
			
				break;
			case '3':
				// display the item list
				printListMedia();
				break;
			case '0':
				break;
			default:
				System.out.println("Wrong key, choose it again!!!");
				break;
			}
		}while(c != '0');
	}
	private static int findItembyId(int key, ArrayList<Media> listMedia2) {
		int index = 0;
		for(Media med: listMedia2) {
			if(med.getItemID() == key) {
				return index;
			}
			index ++;
		}
		return -1;
	}
	
	public static void showAdminMenu() {
		System.out.println("Product Management Application: ");
		System.out.println("--------------------------------");
		System.out.println("1. Create new item");
		System.out.println("2. Delete item by id");
		System.out.println("3. Display the items list");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	// customer menu
	public static void CustomerMenu() throws OutNumberOrderException {
		char c = '0';
		Order order;
		int n;
		do {
			showMenu();
			c = sc.next().charAt(0);
			sc.nextLine();
			switch(c) {
			case '1':
				Order neworder = createnewOrder();
				System.out.println(neworder.date.GetDate());
				break;
			case '2':
				// choose the order to add
				order = null;
				n = listOrder.size();
				// if there is no order
				if(listOrder.isEmpty()) {
					System.out.println("there is no order!!!\nPlease create an order");
					break;
				}
				// if only 1 order
				else if(n == 1) {
					order = listOrder.get(0);
					currentIdOrder = 0;
				}		
				// if there is many order
				else {
					System.out.println("the current id order is " + currentIdOrder);
					System.out.println("Would u like to change the current order to another order? (y/n)");
					char ans = 'n';
					do {
						ans = sc.next().toLowerCase().charAt(0);
						sc.nextLine();
						System.out.println("Wrong input !!!");
					}while(ans != 'n' && ans != 'y');
					// if client want to change to another order
					if(ans == 'y') {
						printListOrder();
						System.out.print("Choose the id order u want to add: ");
						int id = 0;
						do {
							id = sc.nextInt();
							sc.nextLine();
							if (id < 0 || id >= n) {
								System.out.println("id order invalid ! \nChoose id again");
							}
						}while(id < 0 || id >= n);
						currentIdOrder = id;
						System.out.println();
					}
				}
				order = listOrder.get(currentIdOrder);
				// if we can find an order to add
				if(order != null) {
					System.out.println("List of item \n");
					printListMedia();
					int key = 0;
//					System.out.println("Choose the id of item u want to add");
//					printListMedia();
//					System.out.println("Example adding item: " + "1,2,3,4,5,6");
//					System.out.println("Enter item id: ");
//					String s = sc.next();
//					String[] additemid = s.split(",");
//					for(String id: additemid) {
//						System.out.println(id);
//					}
////					System.out.println(additemid);
//					for(String id: additemid) {
//						try {
//							key = Integer.valueOf(id.trim());
//							order.addMedia(listMedia.get(key));
//						}
//						catch(Exception e) {
//							System.out.println("Wrong id item: " + id);
//						}
//						
//					}
					System.out.println("What type of item do you want to add?");
					char ans;
					do {
						System.out.print("Book(B) DigitalVideoDisc(D) CompactDisc(C): ");
						ans = sc.next().toUpperCase().charAt(0);
						sc.nextLine();
						if(ans != 'B' && ans != 'C' && ans != 'D') {
							System.out.println("Wrong key, choose again !!!");
						}
					}while(ans != 'B' && ans != 'C' && ans != 'D');
					
					// If add Book
					if(ans == 'B') {
						// check if list is empty
						if(ListBook.isEmpty()) {
							System.out.println("There is no Book to add");
							break;
						}
						System.out.println("List of Book item: ");
						printListBook();
						System.out.println("Example adding item: " + "1,2,3,4,5,6");
						System.out.print("Enter item id: ");
						String s = sc.nextLine();
						String[] additemid = s.split(",");
//						for(String id: additemid) {
//							System.out.println(id);
//						}
//						System.out.println(additemid);
						for(String id: additemid) {
							if(checkInteger(id.trim())) {
								key = Integer.parseInt(id.trim());
								int index = findItembyId(key, listMedia);
//								System.out.println(index);
								order.addMedia(listMedia.get(index));
							}
							else {
								System.out.println("Wrong id item: " + id);
							}
							
						}
					}
					// if add Digital Video Disc
					else if(ans == 'D') {
						if(ListDigitalVideoDisc.isEmpty()) {
							System.out.println("There is no DigitalVideoDisc to add !!!");
							break;
						}
						System.out.println("List of DigitalVideoDisc item: ");
						printListDigitalVideoDisc();
						System.out.println("Example adding item: " + "1,2,3,4,5,6");
						System.out.print("Enter item id: ");
						String s = sc.nextLine();
						String[] additemid = s.split(",");
//						for(String id: additemid) {
//							System.out.println(id);
//						}
//						System.out.println(additemid);
						for(String id: additemid) {
							if(checkInteger(id.trim())) {
								key = Integer.valueOf(id.trim());
								DigitalVideoDisc temp = (DigitalVideoDisc)listMedia.get(findItembyId(key, listMedia));
								System.out.println("Would you like to play DigitalVideoDisc: " + temp.getTitle());
								
								// check if customer want to hear the Digital Video Disc
								char ans1;
								do {
									System.out.print("y or n: ");
									ans1 = sc.next().toLowerCase().charAt(0);
									sc.nextLine();
									if(ans1 != 'y' && ans1 != 'n') {
										System.out.println("Wrong key!!!\nPlease choose again");
									}
								}while(ans1 != 'y' && ans1 != 'n');
								// if yes
								if(ans1 == 'y') {
									try {
										temp.play();
									} catch (PlayerException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									System.out.println("Do u still wannt to add the item?");
									// check if customer still want item after hearing
									char ans2;
									do {
										System.out.print("y or n: ");
										ans2 = sc.next().toLowerCase().charAt(0);
										sc.nextLine();
										if(ans2 != 'y' && ans2 != 'n') {
											System.out.println("Wrong key!!!\nPlease choose again");
										}
									}while(ans2 != 'y' && ans2 != 'n');
									if(ans2 == 'y') {
										order.addMedia(temp);
									}
								}
								// if no, just add as normal
								else order.addMedia(temp);
							}
							else {
								System.out.println("Wrong id item: " + id);
							}
						}
					}
					// if add CompactDisc
					else {
						// check if there is CompactDisc
						if(ListCompactDisc.isEmpty()) {
							System.out.println("There is no CompactDisct to add !!!");
							break;
						}
						System.out.println("List of CompactDisc item: ");
						printListCompacDisc();
						System.out.println("Example adding item: " + "1,2,3,4,5,6");
						System.out.print("Enter item id: ");
						String s = sc.nextLine();
						String[] additemid = s.split(",");
//						for(String id: additemid) {
//							System.out.println(id);
//						}
//						System.out.println(additemid);
						for(String id: additemid) {
							try {
								key = Integer.valueOf(id.trim());
								CompactDisc temp = (CompactDisc)ListCompactDisc.get(findItembyId(key, ListCompactDisc));
								System.out.println("Would you like to play CompactDisc: " + temp.getTitle());
								
								// check if customer want to hear the Digital Video Disc
								char ans1;
								do {
									System.out.print("y or n: ");
									ans1 = sc.next().toLowerCase().charAt(0);
									sc.nextLine();
									if(ans1 != 'y' && ans1 != 'n') {
										System.out.println("Wrong key!!!\nPlease choose again");
									}
								}while(ans1 != 'y' && ans1 != 'n');
								// if yes
								if(ans1 == 'y') {
									temp.play();
									System.out.println("Do u still wannt to add the item?");
									// check if customer still want item after hearing
									char ans2;
									do {
										System.out.print("y or n: ");
										ans2 = sc.next().toLowerCase().charAt(0);
										sc.nextLine();
										if(ans2 != 'y' && ans2 != 'n') {
											System.out.println("Wrong key!!!\nPlease choose again");
										}
									}while(ans2 != 'y' && ans2 != 'n');
									if(ans2 == 'y') {
										order.addMedia(temp);
									}
								}
								// if no, just add as normal
								else order.addMedia(temp);
							}
							catch(Exception e) {
								System.out.println("Wrong id item: " + id);
							}
						}
					}
					listOrder.set(currentIdOrder, order);
				}
				break;
			case '3':
				order = null;
				n = listOrder.size();
				// if there is no order
				if(listOrder.isEmpty()) {
					System.out.println("there is no order!!!\nPlease create an order");
					break;
				}
				// if only 1 order
				else if(n == 1) {
					order = listOrder.get(0);
					currentIdOrder = 0;
				}		
				// if there is many order
				else {
					System.out.println("the current id order is " + currentIdOrder);
					System.out.println("Would u like to change the current order to another order? (y/n)");
					char ans = 'n';
					do {
						ans = sc.next().toLowerCase().charAt(0);
						sc.nextLine();
						System.out.println("Wrong input !!!");
					}while(ans != 'n' && ans != 'y');
					// if client want to change to another order
					if(ans == 'y') {
						printListOrder();
						System.out.print("Choose the id order u want to add: ");
						int id = 0;
						do {
							id = sc.nextInt();
							sc.nextLine();
							if (id < 0 || id >= n) {
								System.out.println("id order invalid ! \nChoose id again");
							}
						}while(id < 0 || id >= n);
						currentIdOrder = id;
						System.out.println();
					}
				}
				order = listOrder.get(currentIdOrder);
				if(order != null) {
					System.out.println("List of item \n");
					printListMedia();
					System.out.print("Enter item id of item u want to delete: ");
					int key = sc.nextInt();
					sc.nextLine();
					int index = findItembyId(key, (ArrayList<Media>) listMedia);
					Media temp;
					if(index != -1) {
						temp = listMedia.get(index);
						System.out.println("Successfully delete item: " + listMedia.get(key).getTitle());
						listMedia.remove(index);
						order.removeMedia(temp);
					}
					else {
						System.out.println("ID "+ key + " doesnt exist !!!");
					}
					
					listOrder.set(currentIdOrder, order);
				}
				break;
			case '4':
				order = null;
				n = listOrder.size();
				// if there is no order
				if(listOrder.isEmpty()) {
					System.out.println("there is no order!!!\nPlease create an order");
					break;
				}
				// if only 1 order
				else if(n == 1) {
					order = listOrder.get(0);
					currentIdOrder = 0;
				}		
				// if there is many order
				else {
					System.out.println("the current id order is " + currentIdOrder);
					System.out.println("Would u like to change the current order to another order? (y/n)");
					char ans = 'n';
					do {
						ans = sc.next().toLowerCase().charAt(0);
						sc.nextLine();
						System.out.println("Wrong input !!!");
					}while(ans != 'n' && ans != 'y');
					// if client want to change to another order
					if(ans == 'y') {
						printListOrder();
						System.out.print("Choose the id order u want to add: ");
						int id = 0;
						do {
							id = sc.nextInt();
							sc.nextLine();
							if (id < 0 || id >= n) {
								System.out.println("id order invalid ! \nChoose id again");
							}
						}while(id < 0 || id >= n);
						currentIdOrder = id;
						System.out.println();
					}
				}
				order = listOrder.get(currentIdOrder);
				order.showOrder();
				break;
			case '0':
				System.out.println("End menu");
				break;
			default:
				System.out.println("Wrong input !!! \n");
				break;
			}
			// input c
		}while(c != '0');
	}
	
	public static void showMenu() {
		System.out.println("Order Management Application: ");
		System.out.println("--------------------------------");
		System.out.println("1. Create new order");
		System.out.println("2. Add item to the order");
		System.out.println("3. Delete item by id");
		System.out.println("4. Display the items list of order");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	public static Order createnewOrder() throws OutNumberOrderException{
		// check if can create more order
		if(listOrder.size() == Order.MAX_LIMITED_ORDERS) {
			System.out.println("Cant create new order\nThe maximum order can be created is "  + Order.MAX_LIMITED_ORDERS);
			return null;
		}
		Order order = null;
		// by default the date of the order is current date
		System.out.println("Would you like to change the date of the order? (y/n)");
		char c = 'n';
		do {
			c = sc.next().charAt(0);
			sc.nextLine();
			if(c != 'n' && c != 'y') {
				System.out.println("Wrong input !!!");
			}
		}while(c != 'n' && c != 'y');
		// if no
		if(c == 'n') {
			try {
				order = Order.createOrder();
			} catch (LimitExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (OutNumberOrderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// if yes
		else {
			int day, month, year;
			// input day
			MyDate temp = null; 
			do {
				System.out.print("Enter day: ");
				day = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter month: ");
				month = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter year: ");
				year = sc.nextInt();
				sc.nextLine();
				temp = new MyDate(day, month, year);
				if(!temp.isDateValid()) {
					System.out.println("Date is invalid!!!\nPlease enter again");
				}
			}while(!temp.isDateValid());
			order = Order.createOrder(day, month, year);
		}
		//System.out.println("Successfully create order with ID: " + order.getOrderID());
		listOrder.add(order);

		System.out.println();
		return order;
	}
	private static boolean checkInteger(String s) {
		try {
			Integer.parseInt(s);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	public static void printListOrder() {
		for(Order order: listOrder) {
			System.out.println("OrderID: " + order.getOrderID());
		} 
	}
	public static void createListMedia() {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "Royal", 120, 18.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Mat Biec", "Romance", "Victor Vu", 120, 2.22f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Attack on Titan", "Fiction", "MAPPA", 139, 13.13f);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("Detective Conan", "Detective", "Gosho Aoyama", 2000, 100.99f);
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("Death Note", "Fantasy", "MadHouse", 165, 124.55f);
		DigitalVideoDisc dvd8 = new DigitalVideoDisc("WandaVision", "Superhero", "Matt Shakman", 30, 32.11f);
		DigitalVideoDisc dvd9 = new DigitalVideoDisc("Justice League", "Superhero", "Jack Snyder", 240, 16.61f);
		DigitalVideoDisc dvd10 = new DigitalVideoDisc("HUSTers Baka", "wibu", "noCehG", 690, 458493.33f);
		DigitalVideoDisc dvd11 = new DigitalVideoDisc("Hoc Lai", "Truot Mon", "Royal", 120, 6000.00f);
		DigitalVideoDisc dvd12 = new DigitalVideoDisc("Jujutsu Kaisen");
		
		ListDigitalVideoDisc.addAll(Arrays.asList(dvd1, dvd2, dvd3, dvd4, dvd5, dvd6, dvd7, dvd8, dvd9, dvd10, dvd11, dvd12));
		
		Book book1 = new Book("The Silence of the Lambs");
		Book book2 = new Book("Another", "Creepy", 12.66f);
		Book book3 = new Book("Ban hoc cua Royal", "Art", 99.99f);
		book1.addAuthor("Thomas Harris");
		book2.addAuthor("Nguyen Hoang Vu");
		book3.addAuthor("Royal", "Crystal", "Lagos");
		Book book4 = new Book("Nimona", "Comic", 12f);
		book4.addAuthor("Hoang Vu Nguyen");
		
		ListBook.addAll(Arrays.asList(book1, book2, book3, book4));
		listMedia.addAll(ListDigitalVideoDisc);
		listMedia.addAll(ListBook);
	}
	public static void printListMedia() {
		Collections.sort(listMedia);
		int count = 0;
		for(Media med: listMedia) {
			System.out.printf("%03d\t%s\n", med.getItemID(), med.getTitle());
		}
	}
	public static void printListBook() {
		Collections.sort(ListBook);
		for(Media med: ListBook) {
			System.out.printf("%03d\t%s\n", med.getItemID(), med.getTitle());
		}
	}
	public static void printListCompacDisc() {
		Collections.sort(ListCompactDisc);
		for(Media med: ListCompactDisc) {
			System.out.printf("%03d\t%s\n", med.getItemID(), med.getTitle());
		}
	}
	public static void printListDigitalVideoDisc() {
		Collections.sort(ListDigitalVideoDisc);
		for(Media med: ListDigitalVideoDisc) {
			System.out.printf("%03d\t%s\n", med.getItemID(), med.getTitle());
		}
	}

}
