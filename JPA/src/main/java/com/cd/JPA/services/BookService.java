package com.cd.JPA.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cd.JPA.models.Book;
import com.cd.JPA.repository.BookRepository;

@Service
public class BookService {
	//	Attributes
	// adding the book repository as a dependency
	// bookRepository is not an instance of BookRepository:it's a data type
	private final BookRepository bookRepository;

	//	Constructor
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	// Returns all the books
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}

	// Creates a book
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}

	// Retrieves a book
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}

	// Deletes a book by its ID
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}

	// Updates a book information
	public Book updateBook(Book b) {
		return bookRepository.save(b);
	}

	public List<Book> booksContaining(String search){
		return bookRepository.findByDescriptionContaining(search);
	}
}

