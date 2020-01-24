package week3.chapter1.impl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Book {// implements Comparable<Book>{

	private String name;

	private int page;

	public Book(String name, int page) {
		this.name = name;
		this.page = page;
	}

	// @Override
	// public int compareTo(Book o) {
	// return name.compareTo(o.name);
	// }

	public String getName() {
		return name;
	}

	public int getPage() {
		return page;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", page=" + page + "]";
	}

}

public class ComparatorExamples {

	public static void main(String[] args) {
		List<Book> books = Arrays.asList(new Book("book1", 600), new Book("book1", 100), new Book("abook1", 200),
				new Book("dbook1", 300), new Book("cbook1", 400));

//old way
//		Collections.sort(books, new Comparator<Book>() {
//			@Override
//			public int compare(Book o1, Book o2) {
//				int comp1 = o1.getName().compareTo(o2.getName());
//				if(comp1==0){
//					comp1 = Integer.compare(o1.getPage(), o2.getPage());
//				}
//				return comp1;
//			}
//		});
//
//		books.forEach(System.out::println);
		

//new way
		books.stream().sorted(Comparator.comparing(Book::getName).thenComparing(Book::getPage)).forEach(System.out::println);
	}

}