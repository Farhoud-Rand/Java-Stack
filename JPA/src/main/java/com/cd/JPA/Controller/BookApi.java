package com.cd.JPA.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cd.JPA.models.Book;
import com.cd.JPA.services.BookService;

@RestController
public class BookApi {
	//Attribute
	private final BookService bookService;

	//	Constructor
	public BookApi(BookService bookService){
		this.bookService = bookService;
	}

	//	Get All books -->Read operation
	@RequestMapping("/api/books")
	public List<Book> index() {
		return bookService.allBooks();
	}

	// Create a new book -->Create operation
	@RequestMapping(value="/api/books", method=RequestMethod.POST)
	public Book create(@RequestParam(value="title") String title,
			@RequestParam(value="description") String desc,
			@RequestParam(value="language") String lang,
			@RequestParam(value="pages") Integer numOfPages) {
		Book book = new Book(title, desc, lang, numOfPages);
		return bookService.createBook(book);
	}

	// Update existing book information --> Update operation
	@RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
	public Book update(
			@PathVariable("id") Long id,
			@RequestParam(value="title") String title,
			@RequestParam(value="description") String desc,
			@RequestParam(value="language") String lang,
			@RequestParam(value="pages") Integer numOfPages) {
		Book book = bookService.updateBook(id,title, desc, lang, numOfPages);
		return book;
	}

	// Delete existing book --> Delete operation
	@RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id){
		bookService.deleteBook(id);
	}

	// Get book information using its ID --> Read Operation
	@RequestMapping("/api/books/{id}")
	public Book show(@PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
		return book;
	}
}