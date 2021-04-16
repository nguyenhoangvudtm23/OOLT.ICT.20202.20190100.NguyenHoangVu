package hust.soict.globalict.aims.media;

public class Track implements Playable{
	private String title;
	private int length;
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	public Track() {
		title = "";
		length = 0;
	}
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Playing track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
		
	}
	
}
