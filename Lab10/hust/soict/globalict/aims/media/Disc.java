package hust.soict.globalict.aims.media;

public class Disc extends Media {
	protected int length;
	protected String director;
	
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	
	public Disc(String title, String category, String director, int length, float cost, int mediaID) {
		super(title, category, cost);
		this.length = length;
		this.director = director;
	}
	public Disc(String title, String category, float cost, int length, int mediaID) {
		this(title, category, "", length, cost, mediaID);
	}
	public Disc(String title, String category, float cost, int mediaID) {
		this(title, category,"", 0, cost, mediaID);
	}
	
}
