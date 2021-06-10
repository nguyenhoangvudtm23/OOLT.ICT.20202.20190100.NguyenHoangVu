package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
	@Override
	public int compareTo(Media o) {
		// TODO Auto-generated method stub
		DigitalVideoDisc disc = (DigitalVideoDisc)o;
		if(this.cost == disc.cost) return 0;
		else if(this.cost < disc.cost) return -1;
		else return 1;
	}
	private static int ID = 0;
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, cost, ID++);
		this.director = director;
		this.length = length;
	}
	public DigitalVideoDisc(String title) {
		this(title, "", "", 0, 0f);
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		this(title, category, "", 0, cost);
	}
	public DigitalVideoDisc(String title, String category, String director,float cost) {
		this(title, category, director, 0, cost);
	}
	@Override
	public void getInformation() {
		super.getInformation();
		System.out.println("Director:\t" + director);
		System.out.println("Length:\t" + length);
	}
	@Override
	public void play() throws PlayerException {
		// TODO Auto-generated method stub
		if(this.getLength() <= 0) {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		}
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}


	
	// swap 2 disc
//	public void swap(DigitalVideoDisc dvd1) {
//		DigitalVideoDisc disc = new DigitalVideoDisc(dvd1.getTitle(), dvd1.getCategory(), dvd1.getDirector(), dvd1.getLength(), dvd1.getCost());
//		// assign dvd1
//		dvd1.setCategory(this.getCategory());
//		dvd1.setTitle(this.getTitle());
//		dvd1.setCost(this.getCost());
//		dvd1.setDirector(this.getDirector());
//		dvd1.setLength(this.getLength());
//		// assign this
//		this.setCategory(disc.getCategory());
//		this.setTitle(disc.getTitle());
//		this.setCost(disc.getCost());
//		this.setDirector(disc.getDirector());
//		this.setLength(disc.getLength());
//		System.out.println("Successfully swap !!!");
//	}
	
	
}
