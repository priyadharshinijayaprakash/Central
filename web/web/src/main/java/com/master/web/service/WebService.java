package com.master.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.master.web.model.Web;
import com.master.web.dao.WebDAO;

@Service
public class WebService {
	@Autowired
	WebDAO wd;

	public List<Web> getAllQuestions() {
		// TODO Auto-generated method stub
		return wd.findAll();
	}

	public List<Web> getQuestionsByCategory(String category) {
		// TODO Auto-generated method stub
		return wd.findBycategory(category);
	}

	public void addQuestion(Web question) {
		wd.save(question);
	}
}
