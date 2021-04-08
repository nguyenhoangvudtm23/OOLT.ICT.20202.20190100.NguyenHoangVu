package hust.soict.globalict.aims;

import hust.soict.globalict.aims.order.*;
import hust.soict.globalict.aims.order.Order.OutNumberOrderException;
import hust.soict.globalict.aims.media.*;


public class Aims {

	public static void main(String[] args) throws OutNumberOrderException{
		// TODO Auto-generated method stub
		Order order1 = Order.createOrder();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		
		// get information of dvd1
		dvd1.getInformation(); 
		
		// add dvd1, dvd2
		order1.addDigitalVideoDisc(dvd1, dvd2);
		// print cost
		System.out.println(order1.totalCost());
		
		//Try to create new order. (Currently set max number of orders is 1)
		//Order order2 = Order.createOrder();
		
		
		// remove orderit 
		order1.removeDigitalVideoDisc(dvd1, dvd2, dvd1);
		
	}

}
