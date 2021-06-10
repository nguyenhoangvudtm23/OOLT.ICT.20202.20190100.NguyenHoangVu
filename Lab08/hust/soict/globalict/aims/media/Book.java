 package hust.soict.globalict.aims.media;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;


public class Book extends Media{
	private String content;
	List<String> contentTokens = new ArrayList<>();
	TreeMap<String, Integer> wordFrequency = new TreeMap<>();
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
		processContent();
	}
	public void processContent() {
		contentTokens.addAll(Arrays.asList(content.split(" ")));
		wordFrequency.clear();
		for(String str: contentTokens) {
			if(wordFrequency.containsKey(str)) {
				wordFrequency.put(str, wordFrequency.get(str) + 1);
			}
			else wordFrequency.put(str, 1);
		}
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder();
		str.append(authors.toString() + "\t" + content + "\t" +
				contentTokens.toString() + "\t" + wordFrequency.toString());
		return str.toString();
	}

	
}
