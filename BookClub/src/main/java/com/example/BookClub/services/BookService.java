package com.example.BookClub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.BookClub.models.Book;
import com.example.BookClub.models.User;
import com.example.BookClub.repositories.BookRepository;

@Service
public class BookService {
	// Attributes
	private final BookRepository bookRepository;

	// Constructor
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	// Returns all the books
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}

	// Creates a book
	public Book createBook(Book b, User user) {
		b.setUser(user);
		return bookRepository.save(b);
	}

	// Retrieves a book
	public Optional<Book> findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook;
		} else {
			return null;
		}
	}

	// Deletes a book by its ID
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}

	// Updates a book information
	public Book updateBook(Book book , 	User user) {
		book.setUser(user);
		return bookRepository.save(book);
	}

	// Check if the user read this book or not
	public boolean readedByUser(long userId, long bookId) {
		Optional<Book> bookOptional = bookRepository.findById(bookId);
		if (bookOptional.isPresent()) {
			Book book = bookOptional.get();
			if (book.getUser().getId() == userId) {
				return true;
			}
		}
		return false;
	}
}
