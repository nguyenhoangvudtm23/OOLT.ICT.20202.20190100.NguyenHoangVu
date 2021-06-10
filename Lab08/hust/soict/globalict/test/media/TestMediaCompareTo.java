package hust.soict.globalict.test.media;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

public class TestMediaCompareTo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Media> listMedia = new ArrayList<>();
		listMedia.add(new DigitalVideoDisc("tom and jerry", "cartoon", 16.0f));
		listMedia.add(new DigitalVideoDisc("infinity war", "action movie", 50f));
		listMedia.add(new DigitalVideoDisc("one punch man", "action movie", 10f));
		
		Iterator<Media> iterator = listMedia.iterator();
		System.out.println("The DVD currently in the order are: ");
		while (iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
		}
		
		Collections.sort(listMedia);
		iterator = listMedia.iterator();
		System.out.println("The DVD after sort in the order are: ");
		while (iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
		}
	}

}
