package hust.soict.globalict.aims.media;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Media {
	private static int ID = 0;
	private final int mediaID;
	public int getMediaID() {
		return mediaID;
	}
	protected String title, category;
	protected float cost;
	
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

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public Media(String title, String category, float cost) {
		this.mediaID = ID++;
		// TODO Auto-generated constructor stub
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	
	public Media(String title) {
		this(title, "", 0f);
	}
	
	public Media(String title, String category) {
		this(title, category, 0f);
	}
	public void getInformation() {
		System.out.println("Title:\t"+ title);
		System.out.println("Category:\t" + category);
		System.out.println("Cost:\t" + cost);
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
