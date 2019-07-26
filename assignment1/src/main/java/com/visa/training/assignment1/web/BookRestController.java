package com.visa.training.assignment1.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.visa.training.assignment1.domain.Book;
import com.visa.training.assignment1.service.BookService;

@RestController
public class BookRestController {

	@Autowired
	BookService service;

	@RequestMapping(value = "/api/books", method = RequestMethod.GET)
	public List<Book> getAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/api/books/{id}")
	public ResponseEntity<Book> getById(@PathVariable("id") int id) {
		Book b = service.findById(id);
		if (b != null) {
			return new ResponseEntity<Book>(b, HttpStatus.OK);
		} else {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/api/books", method = RequestMethod.POST)
	public ResponseEntity<Book> createBook(@RequestBody Book toBeCreated) {
		try {
			toBeCreated.getChapters().forEach(c -> c.setBook(toBeCreated));
			//System.out.println(toBeCreated.);
			//toBeCreated.getChapters().forEach(c->System.out.println(c));
			int id = service.addNewBook(toBeCreated);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create("/api/books/" + id));
			return new ResponseEntity<>(headers, HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/api/books/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Book> updateProduct(@RequestBody Book toBeUpdated,@PathVariable int id) {
		try {
			toBeUpdated.getChapters().forEach(c -> c.setBook(toBeUpdated));
			//System.out.println(toBeUpdated);
			toBeUpdated.setBook_id(id);
			id = service.updateBook(toBeUpdated);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create("/api/books/" + id));
			return new ResponseEntity<>(headers, HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/api/books/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Book> deleteBook(@PathVariable int id) {
		try {
			service.delete(id);
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<>(headers, HttpStatus.FOUND);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}