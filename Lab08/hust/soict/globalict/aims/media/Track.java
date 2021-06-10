package hust.soict.globalict.aims.media;

public class Track implements Playable{
	private String title;
	private int length;
	public String getTitle() {
		return title;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Track track = (Track)obj;
		if(track.title == this.title && track.length == this.length) return true;
		return false;
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
