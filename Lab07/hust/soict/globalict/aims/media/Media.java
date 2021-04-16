package hust.soict.globalict.aims.media;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Media {
	private static int ID = 0;
	private final int itemID;
	protected String title, category;
	protected float cost;
	
	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}

	public Media(String title, String category, float cost) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.category = category;
		this.cost = cost;
		itemID = ID++;
	}
	
	public Media(String title) {
		this(title, "", 0f);
	}
	
	public Media(String title, String category, int mediaID) {
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

	public int getItemID() {
		return itemID;
	}

}
