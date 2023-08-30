package com.master.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.master.web.model.Web;
import com.master.web.service.WebService;

@RestController
@RequestMapping("questions")
public class WebController {
	@Autowired
	WebService ws;

	@GetMapping("allquestions")
	public List<Web> getAllQuestions() {
		return ws.getAllQuestions();
	}

	@GetMapping("category/{category}")
	public List<Web> getQuestionsByCategory(@PathVariable String category) {
		return ws.getQuestionsByCategory(category);
	}

	@PostMapping("add")
	public void addQuestion(@RequestBody Web question) {
		ws.addQuestion(question);
	}
}
