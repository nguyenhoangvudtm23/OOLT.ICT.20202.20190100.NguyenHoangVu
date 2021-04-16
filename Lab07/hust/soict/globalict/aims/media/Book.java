 package hust.soict.globalict.aims.media;
import java.util.ArrayList;
import java.util.List;


public class Book extends Media{
	private List<String> authors = new ArrayList<String>();
	
	public Book(String title, String category, float cost) {
		super(title, category, cost);
		// TODO Auto-generated constructor stub
	}
	public Book(String title) {
		this(title, "", 0f);
	}
	public Book(String title, String category) {
		this(title, category, 0f);
	}
	// add author
	public void addAuthor(String ... authorNames) {
		for(String authorName: authorNames) {
			if(authors.indexOf(authorName) != -1) {
				authors.add(authorName);
				System.out.println("Add successfuly author:  " + authorName);
			}
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
