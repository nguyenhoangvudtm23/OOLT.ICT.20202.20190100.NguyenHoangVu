package hust.soict.globalict.aims.order;
import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.utils.MyDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class Order {
	private static int ID = 0;
	@SuppressWarnings("serial")
	public static class OutNumberOrderException extends Exception{
		public OutNumberOrderException(String message) {
			super(message);
		}
	}
	private final int orderID;
	private static int nbOrders = 0;
	public static final int MAX_LIMITED_ORDERS = 2;
	public static final int MAX_NUMBERS_ORDERED = 10;
	private List<Media> itemsOrdered = new ArrayList<>();
	
	public MyDate date; 
	
//	public static boolean checkOrder() {
//		if(nbOrders >= MAX_LIMITED_ORDERS) return false;
//		else return true;
//	}
	
	public static Order createOrder() throws OutNumberOrderException {
		if(nbOrders < MAX_LIMITED_ORDERS) {
			return new Order();
		}
		else {
			throw new OutNumberOrderException("You can't create more orders !!!\nThe maximum orders can be created is " + MAX_LIMITED_ORDERS + "\n");
		}
	}
	
	public Order(){
		date = new MyDate();
		this.orderID = ID++;
		System.out.println("Create new order with orderID: " + orderID);
		nbOrders++;
	}
	
	public Order(int day, int month, int year){
		date = new MyDate(day, month, year);
		this.orderID = ID++;
		System.out.println("Create new order with orderID: " + orderID);
		nbOrders++;
	}
	
	public static Order createOrder(int day, int month, int year) throws OutNumberOrderException {
		if(nbOrders < MAX_LIMITED_ORDERS) {
			return new Order(day, month, year);
		}
		else {
			throw new OutNumberOrderException("You can't create more orders !!!\nThe maximum orders can be created is " + MAX_LIMITED_ORDERS + "\n");
		}
	}
	
	
	// COMPARE TO ARRAY PARAMETER
	// instead of using arguments as list, I prefer using arbitrary number of arguments 
	// because of it's convenience when passing not too many values
	
	public int getOrderID() {
		return orderID;
	}

	// add discs
	public void addMedia(Media ... meds ) {
		boolean flag = true;
		for(Media med: meds) {
			if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
				itemsOrdered.add(med);
				System.out.println("Add successfully disc: " + med.getTitle());
			}
			else {
				if(flag) {
					System.out.println("There is maximum " + MAX_NUMBERS_ORDERED + " in an Order\nPlease create new order!!!");
					flag = false;
				}
				System.out.println("Unsuccessfully add disc: " + med.getTitle());
			}
		}
	}
	
	
	// remove many discs
	public void removeMedia(Media ... meds) {
		if(itemsOrdered.isEmpty()) {
			System.out.println("Order is empty !!!. Nothing to remove\n");
			return;
		}
		for(Media med: meds) {
			if(itemsOrdered.indexOf(med) != -1 ) {
				itemsOrdered.remove(med);
				System.out.println("Remove successfully disc: " + med.getTitle());
			}
			else {
				System.out.println("There is no " + med.getTitle() + " in Order\nCan't remove");
			}
		}
	}
	
	// get information of order
	public void showOrder() {
		for(Media med: itemsOrdered) {
			System.out.printf("%03d%-20s%-20s%\t%f\n", med.getMediaID(), med.getTitle(), med.getCategory(), med.getCost());
		}
	}
	
	// total cost
	public float totalCost(){
		float totalcost = 0;
		for(Media temp: itemsOrdered) {
			totalcost += temp.getCost();
		}
		return totalcost;
	}
	// get lucky item
	public Media getALuckyItem() {
		int max = itemsOrdered.size(), min = 0;
		Random random = new Random();
		int lucky_number = random.nextInt(max - min) + min;
		Media lucky_item = this.itemsOrdered.get(lucky_number);
			
		System.out.println("The lucky item:  ");
	//	lucky_item.getInformation();
		itemsOrdered.remove(lucky_item);
		return lucky_item;

	}

}
	
