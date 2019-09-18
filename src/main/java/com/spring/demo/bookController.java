package com.spring.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class bookController {
	
	@Autowired
	private BookService bookservice;
	
	/**
	 * 獲取全部書單
	 * 
	 * */
	@GetMapping("/books")
	public String getll(Model model) {
		List<Book> books = bookservice.findAll();
		model.addAttribute("books", books);
		return "books"; 
	}

	/**
	 * 獲取一筆書單
	 * 
	 * */
	@GetMapping("/books/{id}")
	public String detail(@PathVariable long id, Model model) {
		Book books = bookservice.findOne(id);
		if(books == null) {
			Book book = new Book();
			books = book;
		}
		model.addAttribute("books", books); 
		return "book";
	}
	
//	@GetMapping("/books/{id}")
//	public List<Book> detail(@PathVariable long id) {
//		return bookservice.findOne(id);
//	}
}
