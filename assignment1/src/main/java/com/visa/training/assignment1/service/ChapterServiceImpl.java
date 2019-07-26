package com.visa.training.assignment1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.training.assignment1.dal.BookRepository;
import com.visa.training.assignment1.domain.Book;

@Service
public class ChapterServiceImpl implements ChapterService {

	ChapterRepository dao;

	@Autowired
	public void setDao(ChapterRepository dao) {
		this.dao = dao;
	}

	@Override
	public int addNewChapter(Chapter b) {
		Chapter created = dao.save(b);
		return created.getChapter_id();
	}

	@Override
	public Chapter findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public List<Chapter> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void delete(int id) {
		Chapter b = dao.findById(id);
		if (b != null)
			dao.deleteById(id);
		else
			throw new IllegalArgumentException("No Chapter exists with this ID");
	}

	@Override
	public int updateChapter(Chapter toBeUpdated) {
		int id = toBeUpdated.getChapter_id();
		Chapter b = dao.findById(id);
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
