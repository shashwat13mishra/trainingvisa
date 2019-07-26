package com.visa.training.assignment1.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int book_id;
	String book_name;
	String author;
	String category;
	int releaseYear;
	
	@OneToMany(mappedBy="book",cascade = {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE},fetch=FetchType.EAGER)//maps account owner of the association
	List<Chapter> chapters = new ArrayList<Chapter>();

	public Book() {
		// TODO Auto-generated constructor stub
	}
	

	
	public Book(int book_id, String book_name, String author, String category, int releaseYear) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.author = author;
		this.category = category;
		this.releaseYear = releaseYear;
	}

	@Override
	public String toString() {

		return "Book " + book_id +"," + book_name+"," + author+", "+ category+","+releaseYear ;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public List<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}
		
}