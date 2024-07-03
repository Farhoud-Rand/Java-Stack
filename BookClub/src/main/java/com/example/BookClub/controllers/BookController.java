package com.example.BookClub.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.BookClub.models.Book;
import com.example.BookClub.models.User;
import com.example.BookClub.services.BookService;
import com.example.BookClub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class BookController {
	@Autowired
	BookService bookService;
	@Autowired
	UserService userService;

	// ******************** R (Read all) from CRUD ********************
	// Get all books from our database
	@GetMapping("/books")
	public String allBooks(Model model, HttpSession session) {
		// Check if the user is already login or not
		if (session.getAttribute("user") != null) {
			User user = userService.getUserByID((long)session.getAttribute("user"));
			model.addAttribute("user", user);
			List<Book> books = bookService.allBooks();
			model.addAttribute("books", books);
			return "books.jsp";
		}
		return "notLogin.jsp";
	}

	// ******************** R (Read one) from CRUD ********************
	// Get books' information by its ID
	@GetMapping("/books/{bookId}")
	public String index(Model model, @PathVariable long bookId, HttpSession session) {
		if (session.getAttribute("user") != null) {
			User user = userService.getUserByID((long) session.getAttribute("user"));
			boolean readByUser = bookService.readedByUser(user.getId(), bookId);
			model.addAttribute("user", user);
			model.addAttribute("readed", readByUser);
			Optional<Book> optionalBook = bookService.findBook(bookId);
			if (optionalBook.isPresent()) {
				Book book = optionalBook.get();
				model.addAttribute("b", book);
			}
			return "info.jsp";
		}
		return "notLogin.jsp";

	}

	// ******************** C (Create) from CRUD ********************
	// Function to render the page that contains the form
	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book, Model model, HttpSession session) {
		if (session.getAttribute("user") != null) {
			return "NewBook.jsp";
		}
		return "notLogin.jsp";
	}

	// Function to add new book to the table
	@PostMapping("/books")
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model,
			HttpSession session) {
		if (session.getAttribute("user") != null) {
			if (result.hasErrors()) {
				return "NewBook.jsp";
			} else {
				User user = userService.getUserByID((long) session.getAttribute("user"));
				bookService.createBook(book, user);
				return "redirect:/books";
			}
		}
		return "notLogin.jsp";
	}

	// ******************** U (Update) from CRUD ********************
	// Function to render page that allows us to update book information
	@GetMapping("/books/{bookId}/edit")
	public String edit(Model model, @PathVariable long bookId, HttpSession session) {
		if (session.getAttribute("user") != null) {
			Optional<Book> optionalBook = bookService.findBook(bookId);
			if (optionalBook.isPresent()) {
				Book book = optionalBook.get();
				model.addAttribute("book", book);
				return "edit.jsp";
			}
		}
		return "notLogin.jsp";
	}

	// Function to update book information
	@PutMapping("/books/{id}")
	public String update(@Valid @ModelAttribute("book") Book book, BindingResult result, @PathVariable long id,
			HttpSession session) {
		if (session.getAttribute("user") != null) {
			if (result.hasErrors()) {
				return "edit.jsp";
			} else {
				User LastUser = userService.getUserByID((long) session.getAttribute("user"));
				bookService.updateBook(book, LastUser);
				return "redirect:/books";
			}
		}
		return "notLogin.jsp";
	}

	// ******************** D (Delete) from CRUD ********************
	@GetMapping("/books/{bookId}/destroy")
	public String destroy(@PathVariable long bookId, HttpSession session) {
		if (session.getAttribute("user") != null) {
			bookService.deleteBook(bookId);
			return "redirect:/books";
		}
		return "notLogin.jsp";
	}
}
