package com.cd.JPA.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.cd.JPA.models.Book;
import com.cd.JPA.services.BookService;

import jakarta.validation.Valid;

@Controller
public class BookApiForJSP {
	//	Attribute and constructor
	@Autowired
	BookService bookService;

	// ******************** C (Create) from CRUD ********************
	// Function to render the page that contains the form
	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book, Model model) {
		model.addAttribute("book",book);
		return "NewFile.jsp";
	}

	// Function to add new book to the table
	@PostMapping("/books")
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("book",book);
			return "NewFile.jsp";
		} else {
			bookService.createBook(book);
			return "redirect:/books";
		}
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

	// ******************** U (Update) from CRUD ********************
	// Function to render page that allows us to update book information
	@GetMapping("/books/{id}/edit")
	public String edit(Model model, @PathVariable long id) {
		Book book = bookService.findBook(id);
		model.addAttribute("book",book);
		return "edit.jsp";
	}

	// Get books' information by its ID
	@PutMapping("/books/{id}")
	public String update(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("book",book);
			return "edit.jsp";
		} else {
			bookService.updateBook(book);
			return "redirect:/books";
		}
	}

	// ******************** D (Update) from CRUD ********************
	@GetMapping("/books/{id}/destroy")
	public String destroy(@PathVariable long id) {
		bookService.deleteBook(id);
		return "redirect:/books";
	}
}
