package hust.soict.globalict.test.media;

import hust.soict.globalict.aims.media.Book;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book book = new Book("Another", "Creepy", 12.66f);
		book.setContent("My name is nguyen hoang vu");
		System.out.println(book.toString());
	}

}
