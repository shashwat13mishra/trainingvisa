package com.visa.training.assignment1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.training.assignment1.dal.BookRepository;
import com.visa.training.assignment1.domain.Book;

@Service
public class BookServiceImpl implements BookService {

	BookRepository dao;

	@Autowired
	public void setDao(BookRepository dao) {
		this.dao = dao;
	}

	@Override
	public int addNewBook(Book b) {
		Book created = dao.save(b);
		return created.getBook_id();
	}

	@Override
	public Book findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void delete(int id) {
		Book b = dao.findById(id);
		if (b != null)
			dao.deleteById(id);
		else
			throw new IllegalArgumentException("No book exists with this ID");
	}

	@Override
	public int updateBook(Book toBeUpdated) {
		int id = toBeUpdated.getBook_id();
		Book b = dao.findById(id);
		toBeUpdated.getChapters().forEach(c -> c.setBook(b));

		b.setChapters(toBeUpdated.getChapters());
		System.out.println(b);
		b.setBook_name(toBeUpdated.getBook_name());
		b.setAuthor(toBeUpdated.getAuthor());
		b.setCategory(toBeUpdated.getCategory());
		b.setChapters(toBeUpdated.getChapters());
		//toBeUpdated.getChapters().forEach(System.out::println);
		b.setReleaseYear(toBeUpdated.getReleaseYear());
		// delete(id);
		// id = addNewProduct(toBeUpdated);
		Book c = dao.save(b);
		//b.getChapters().forEach(c->c.setBook(b));
		return c.getBook_id();
	}

}
