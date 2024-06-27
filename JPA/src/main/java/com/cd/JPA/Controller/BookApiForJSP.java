package com.cd.JPA.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cd.JPA.models.Book;
import com.cd.JPA.services.BookService;

@Controller
public class BookApiForJSP {
	//	Attribute and constructor
	@Autowired
	BookService bookService;

	// Get all books from our database
	@GetMapping("/books")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books",books);
		return "index.jsp";
	}



}
