package com.master.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.master.web.model.Web;

@Repository
public interface WebDAO extends JpaRepository<Web, Integer> {

	List<Web> findBycategory(String category);

	@Query(value = "SELECT * FROM web q Where q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
	static
	List<Web> findRandomQuestionsByCategory(String category, int numQ) {
		// TODO Auto-generated method stub
		return null;
	}
}
