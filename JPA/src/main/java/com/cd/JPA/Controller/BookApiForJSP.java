package com.cd.JPA.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cd.JPA.models.Book;
import com.cd.JPA.services.BookService;

import jakarta.validation.Valid;

@Controller
public class BookApiForJSP {
	//	Attribute and constructor
	@Autowired
	BookService bookService;

	// ******************** C (Create) from CRUD ********************
	// Function to display page that allows us to create new show
	@GetMapping("books/new")
	public String create() {
		return "new.jsp";
	}
	// Function to add new show to the table
	@PostMapping("books/add")
	public ResponseEntity<?> addBook(@Valid @RequestBody Book book) {
		bookService.createBook(book);
		return ResponseEntity.ok(book);
	}

	// ******************** R (Read all) from CRUD ********************
	// Get all books from our database
	@GetMapping("/books")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books",books);
		return "index.jsp";
	}

	// ******************** R (Read one) from CRUD ********************
	// Get books' information by its ID
	@GetMapping("/books/{id}")
	public String index(Model model, @PathVariable long id) {
		Book book = bookService.findBook(id);
		model.addAttribute("b",book);
		return "info.jsp";
	}


}
