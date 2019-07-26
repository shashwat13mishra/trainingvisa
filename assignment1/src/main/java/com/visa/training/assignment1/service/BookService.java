package com.visa.training.assignment1.service;

import java.util.List;

import com.visa.training.assignment1.domain.Book;

public interface BookService {
	public int addNewBook(Book b);
	public Book findById(int id);
	public List<Book> findAll();
	public void delete(int id);
	public int updateBook(Book toBeUpdated);

}
