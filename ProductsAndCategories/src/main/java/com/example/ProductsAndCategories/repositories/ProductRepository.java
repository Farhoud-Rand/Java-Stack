package com.example.ProductsAndCategories.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ProductsAndCategories.models.Category;
import com.example.ProductsAndCategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	// this method retrieves all the products from the database
	@Override
	List<Product> findAll();

	// this method deletes by its ID
	void deleteById(long id);

	// this method find a specific product by its ID
	Optional<Product> findById(long id);

	List<Product> findByCategoriesNotContains(Category category);

}