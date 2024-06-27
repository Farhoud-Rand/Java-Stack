package com.cd.JPA.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cd.JPA.models.Book;
import com.cd.JPA.services.BookService;

@RestController
public class BookApi {
	// Attribute
	private final BookService bookService;

	// Constructor
	public BookApi(BookService bookService) {
		this.bookService = bookService;
	}

	// Get All books -->Read operation
	@GetMapping("/api/books")
	public List<Book> index() {
		return bookService.allBooks();
	}

	// Create a new book -->Create operation
	@PostMapping("/api/books")
	public Book create(@RequestParam(value = "title") String title, @RequestParam(value = "description") String desc,
			@RequestParam(value = "language") String lang, @RequestParam(value = "pages") Integer numOfPages) {
		Book book = new Book(title, desc, lang, numOfPages);
		return bookService.createBook(book);
	}

	// Update existing book information --> Update operation
	@PutMapping("/api/books/{id}")
	public Book update(@PathVariable("id") Long id, @RequestParam(value = "title") String title,
			@RequestParam(value = "description") String desc, @RequestParam(value = "language") String lang,
			@RequestParam(value = "pages") Integer numOfPages) {
		Book book = bookService.updateBook(id, title, desc, lang, numOfPages);
		return book;
	}

	// Delete existing book --> Delete operation
	@DeleteMapping("/api/books/{id}")
	public void delete(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
	}

	// Get book information using its ID --> Read Operation
	@GetMapping("/api/books/{id}")
	public Book show(@PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
		return book;
	}
}