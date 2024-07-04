package com.example.ProductsAndCategories.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ProductsAndCategories.models.Category;
import com.example.ProductsAndCategories.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	// this method retrieves all the categories from the database
	@Override
	List<Category> findAll();

	// this method deletes by its ID
	void deleteById(long id);

	// this method find a specific category by its ID
	Optional<Category> findById(long id);

	List<Category> findByProductsNotContains(Product product);

}