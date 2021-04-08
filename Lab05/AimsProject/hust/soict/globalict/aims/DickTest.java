package hust.soict.globalict.aims;
import hust.soict.globalict.aims.order.Order;

import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class DickTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Order anOrder = new Order();

		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation", "Roger Allers", 87, 19.95f);
//		anOrder.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Tom and Jerry", "Animation", "Luke Shaw", 87, 25.6f);
		
		// add discs
		anOrder.addDigitalVideoDisc(dvd2, dvd1, dvd3);

		System.out.println("Total cost is: ");
		System.out.println(String.format("%.02f", anOrder.totalCost()));
		System.out.println();
		
		
		//System.out.println(anOrder.totalCost());
		// search item by name
		System.out.println(dvd1.search("Lio"));
		
		// get lucky item
		DigitalVideoDisc luck = anOrder.getALuckyItem();
		luck.getInformation();
		System.out.println(anOrder.totalCost());
		
	}
}
