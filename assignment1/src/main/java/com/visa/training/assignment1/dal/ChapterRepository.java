package com.visa.training.assignment1.dal;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.visa.training.assignment1.domain.Chapter;

@Repository
public interface ChapterRepository extends CrudRepository<Chapter, Integer>{
public Chapter findById(int id);
public List<Chapter> findAll();
}