package com.master.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.master.web.model.Quiz;

@Repository
public interface QuizDAO extends JpaRepository<Quiz, Integer> {

	
	

}
