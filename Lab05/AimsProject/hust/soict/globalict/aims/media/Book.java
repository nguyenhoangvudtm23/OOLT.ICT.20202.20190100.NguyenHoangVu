package hust.soict.globalict.aims.media;
import java.util.ArrayList;
import java.util.List;


public class Book extends Media{
	private List<String> authors = new ArrayList<String>();
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	// add author
	public void addAuthor(String authorName) {
		if(authors.indexOf(authorName) != -1) {
			authors.add(authorName);
			System.out.println("Add successfuly author:  " + authorName);
		}
	}
	// remove Author
	public void removeAuthor(String authorName) {
		if(authors.indexOf(authorName) != -1) // check if authors contains authorName
		{
			authors.remove(authorName);
		}
	}
	
}
