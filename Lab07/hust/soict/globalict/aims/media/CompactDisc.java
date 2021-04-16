package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {

	private static int ID = 0;
	private String artist;
	private List<Track> tracks = new ArrayList<>();
	public CompactDisc(String title, String category, String director, float cost, String artist) {
		super(title, category, director, 0, cost, ID++);
		this.artist = artist;
		// TODO Auto-generated constructor stub
	}
	public CompactDisc(String title, String category, float cost, String artist) {
		super(title, category, 0f, ID++);
		this.artist = artist;
	}
	public CompactDisc(String title, String category) {
		super(title, category, 0f, ID++);
		artist = "";
	}
	public String getArtist() {
		return artist;
	}
	public void addTrack(Track ... trks) {
		for(Track trk: trks) {
			if(tracks.indexOf(trk) != -1) {
				System.out.println("The track " + trk.getTitle() + " is already in list track!!");
			}
			else {
				tracks.add(trk);
				this.length += trk.getLength();
				System.out.println("Successfully add track " + trk.getTitle());
			}
		}
	}
	
	public void removeTrack(Track ... trks) {
		for(Track trk: trks) {
			if(tracks.indexOf(trk) == -1){
				System.out.println("Can not remove track " + trk.getTitle() + "\nThe track is not in the list !!!");
			}
			else {
				tracks.remove(trk);
				System.out.println("Successfully remove track " + trk.getTitle());
			}
		}
	}
	public int getLength() {
		int result = 0;
		for(Track trk: tracks) {
			result += trk.getLength();
		}
		return result;
	}
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Playing CompactDisc: " + this.getTitle());
		System.out.println("CompactDisc length: " + this.getLength());
		
		for(Track trk: tracks) {
			trk.play();
		}
	}
	
	
	

}
