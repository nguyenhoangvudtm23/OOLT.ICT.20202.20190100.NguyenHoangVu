package Lab04;

import java.util.ArrayList;
import java.util.List;



public class Order {
	@SuppressWarnings("serial")
	public static class OutNumberOrderException extends Exception{
		public OutNumberOrderException(String message) {
			super(message);
		}
	}
	
	private static int nbOrders = 0;
	public static final int MAX_LIMITED_ORDERS = 1;
	public static final int MAX_NUMBERS_ORDERED = 10;
	private int qtyOrdered;
	private List<DigitalVideoDisc> itemsOrdered = new ArrayList<>() ;
	public static boolean checkOrder() {
		if(nbOrders >= MAX_LIMITED_ORDERS) return false;
		else return true;
	}
	
	public static Order createOrder() throws OutNumberOrderException {
		if(nbOrders < MAX_LIMITED_ORDERS) {
			return new Order();
		}
		else {
			throw new OutNumberOrderException("You can't create more orders !!!\nThe maximum orders can be created is " + MAX_LIMITED_ORDERS + "\n");
		}
	}
	
	public Order(){	
		nbOrders++;
		qtyOrdered = 0;
	}
	
	// COMPARE TO ARRAY PARAMETER
	// instead of using arguments as list, I prefer using arbitrary number of arguments 
	// because of it's convenience when passing not too many values
	
	// add discs
	public void addDigitalVideoDisc(DigitalVideoDisc ... discs ) {
		boolean flag = true;
		for(DigitalVideoDisc disc: discs) {
			if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
				itemsOrdered.add(disc);
				System.out.println("Add successfully disc: " + disc.getTitle());
			}
			else {
				if(flag) {
					System.out.println("There is maximum " + MAX_NUMBERS_ORDERED + " in an Order\nPlease create new order!!!");
					flag = false;
				}
				System.out.println("Unsuccessfully add disc: " + disc.getTitle());
			}
		}
	}
	
	// add 2 discs
	public void addDigitalVideoDisc(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
		this.addDigitalVideoDisc(disc1, disc2);
	}
	
	
	// remove many discs
	public void removeDigitalVideoDisc(DigitalVideoDisc ... discs) {
		if(itemsOrdered.isEmpty()) {
			System.out.println("Order is empty !!!. Nothing to remove\n");
			return;
		}
		for(DigitalVideoDisc disc: discs) {
			if(itemsOrdered.indexOf(disc) != -1 ) {
				itemsOrdered.remove(disc);
				System.out.println("Remove successfully disc: " + disc.getTitle());
			}
			else {
				System.out.println("There is no " + disc.getTitle() + " in Order\nCan't remove");
			}
		}
	}
	
	
	
	// total cost
	public float totalCost(){
		float totalcost = 0;
		for(DigitalVideoDisc temp: itemsOrdered) {
			totalcost += temp.getCost();
		}
		return totalcost;
	}

}
	
