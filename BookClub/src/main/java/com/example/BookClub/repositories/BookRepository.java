package com.example.BookClub.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.BookClub.models.Book;


@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
	// this method retrieves all the books from the database
	@Override
	List<Book> findAll();
	// this method counts how many titles contain a certain string
	Long countByTitleContaining(String search);
	// this method deletes a book that starts with a specific title
	Long deleteByTitleStartingWith(String search);
	// this method deletes by its ID
	void deleteById(long id);
	// this method find a specific book by its ID
	Optional<Book> findById(long id);
}