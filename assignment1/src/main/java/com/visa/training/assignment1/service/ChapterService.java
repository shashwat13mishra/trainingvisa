package com.visa.training.assignment1.service;

import java.util.List;

import com.visa.training.assignment1.domain.Chapter;

public interface ChapterService {
	public int addNewChapter(Chapter b);
	public Chapter findById(int id);
	public List<Chapter> findAll();
	public void delete(int id);
	public int updateChapter(Chapter toBeUpdated);

}
