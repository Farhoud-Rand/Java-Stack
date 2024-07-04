package com.example.ProductsAndCategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProductsAndCategories.models.Category;
import com.example.ProductsAndCategories.models.Product;
import com.example.ProductsAndCategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	// Attributes
	@Autowired
	CategoryRepository categoryRepository;

	// Returns all the categories
	public List<Category> allCategories() {
		return categoryRepository.findAll();
	}

	// Create a new category
	public void createCategory(Category category) {
		categoryRepository.save(category);
	}

	// Find category by ID
	public Category findById(long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if (optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}
	}

	public List<Category> findCcategoriesNotContains (Product product){
		return categoryRepository.findByProductsNotContains(product);
	}

	public void addProduct(Category category, Product product) {
		category.getProducts().add(product);
		categoryRepository.save(category);
	}
}