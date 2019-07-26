package com.visa.training.assignment1.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "chapter")
public class Chapter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	int c_index;
	String name;
	int numPages;

	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE})
	@JoinColumn(name = "book_id") // This column specifies foreign key
	@JsonIgnore
	Book book;

	public Chapter() {
		// TODO Auto-generated constructor stub
	}

	public Chapter(int id, int c_index, String name, int numPages, Book book) {
		super();
		this.id = id;
		this.c_index = c_index;
		this.name = name;
		this.numPages = numPages;
		this.book = book;
	}
@Override
public String toString() {

	return "Chapter " + id +"," + c_index+"," + name+"," + numPages +"," + book.getBook_id();
}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getC_index() {
		return c_index;
	}

	public void setC_index(int c_index) {
		this.c_index = c_index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumPages() {
		return numPages;
	}

	public void setNumPages(int numPages) {
		this.numPages = numPages;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
