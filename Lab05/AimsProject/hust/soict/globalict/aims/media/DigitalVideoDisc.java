package hust.soict.globalict.aims.media;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
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
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
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
	
	public void getInformation() {
		System.out.println("Title:\t"+ title);
		System.out.println("Category:\t" + category);
		System.out.println("Director:\t" + director);
		System.out.println("Length:\t" + length);
		System.out.println("Cost:\t" + cost);
	}
	
	// swap 2 disc
	public void swap(DigitalVideoDisc dvd1) {
		DigitalVideoDisc disc = new DigitalVideoDisc(dvd1.getTitle(), dvd1.getCategory(), dvd1.getDirector(), dvd1.getLength(), dvd1.getCost());
		// assign dvd1
		dvd1.setCategory(this.getCategory());
		dvd1.setTitle(this.getTitle());
		dvd1.setCost(this.getCost());
		dvd1.setDirector(this.getDirector());
		dvd1.setLength(this.getLength());
		// assign this
		this.setCategory(disc.getCategory());
		this.setTitle(disc.getTitle());
		this.setCost(disc.getCost());
		this.setDirector(disc.getDirector());
		this.setLength(disc.getLength());
		System.out.println("Successfully swap !!!");
	}
	
	// search title
	public boolean search(String title) {
		String regex = title;
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(this.title);
		if (m.find()) return true;
		else return false;
	}
}
