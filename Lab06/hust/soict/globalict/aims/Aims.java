package hust.soict.globalict.aims;

import hust.soict.globalict.aims.order.*;
import hust.soict.globalict.aims.order.Order.OutNumberOrderException;
import hust.soict.globalict.aims.utils.MyDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hust.soict.globalict.aims.media.*;


public class Aims {
	public static Scanner sc = new Scanner(System.in);
	public static List<Order> listOrder = new ArrayList<>();
	public static List<Media> listMedia = new ArrayList<>();
	public static int currentIdOrder = 0;
	
	public static void main(String[] args) throws OutNumberOrderException{
		// TODO Auto-generated method stub
		char c = '0';
		createListMedia();
		Order order;
		int n;
		do {
			showMenu();
			c = sc.next().charAt(0);
			switch(c) {
			case '1':
				Order neworder = createnewOrder();
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
						System.out.println("Wrong input !!!");
					}while(ans != 'n' && ans != 'y');
					// if client want to change to another order
					if(ans == 'y') {
						printListOrder();
						System.out.print("Choose the id order u want to add: ");
						int id = 0;
						do {
							id = sc.nextInt();
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
					int key = 0;
					System.out.println("Choose the id of item u want to add");
					printListMedia();
					System.out.print("Enter item id: ");
					key = sc.nextInt();
					if(key < 0 || key >= listMedia.size()) {
						System.out.println("Wrong item id doesn't exist !!!");
						break;
					}
					order.addMedia(listMedia.get(key));
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
						System.out.println("Wrong input !!!");
					}while(ans != 'n' && ans != 'y');
					// if client want to change to another order
					if(ans == 'y') {
						printListOrder();
						System.out.print("Choose the id order u want to add: ");
						int id = 0;
						do {
							id = sc.nextInt();
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
					int key = 0;
					System.out.println("Choose the id of item u want to delete");
					printListMedia();
					System.out.print("Enter item id: ");
					key = sc.nextInt();
					if(key < 0 || key >= listMedia.size()) {
						System.out.println("Wrong item id doesn't exist !!!");
						break;
					}
					order.removeMedia(listMedia.get(key));
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
						System.out.println("Wrong input !!!");
					}while(ans != 'n' && ans != 'y');
					// if client want to change to another order
					if(ans == 'y') {
						printListOrder();
						System.out.print("Choose the id order u want to add: ");
						int id = 0;
						do {
							id = sc.nextInt();
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
			if(c != 'n' && c != 'y') {
				System.out.println("Wrong input !!!");
			}
		}while(c != 'n' && c != 'y');
		// if no
		if(c == 'n') {
			order = Order.createOrder();
		}
		// if yes
		else {
			int day, month, year;
			// input day
			MyDate temp = null; 
			do {
				System.out.print("Enter day: ");
				day = sc.nextInt();
				System.out.print("Enter month: ");
				month = sc.nextInt();
				System.out.print("Enter year: ");
				year = sc.nextInt();
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
	public static void printListOrder() {
		for(Order order: listOrder) {
			System.out.println("OrderID: " + order.getOrderID());
		} 
	}
	public static void createListMedia() {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Tom and Jerry", "Animation", "William Hanna", 87, 25.6f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("One Piece", "Animation", "Oda Eiichiro", 120, 25.6f);
		Book book1 = new Book("Nimona", "Comic", 12f);
		listMedia.add(dvd1);
		listMedia.add(dvd2);
		listMedia.add(dvd3);
		listMedia.add(dvd4);
		listMedia.add(book1);
	}
	public static void printListMedia() {
		for(Media med: listMedia) {
			System.out.printf("%03d\t%s\n", med.getMediaID(), med.getTitle());
		}
	}

}
