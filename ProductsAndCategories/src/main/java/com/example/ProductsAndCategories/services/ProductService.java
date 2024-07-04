package com.example.ProductsAndCategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProductsAndCategories.models.Category;
import com.example.ProductsAndCategories.models.Product;
import com.example.ProductsAndCategories.repositories.ProductRepository;

@Service
public class ProductService {
	// Attributes
	@Autowired
	ProductRepository productRepository;

	// Returns all the products
	public List<Product> allProducts() {
		return productRepository.findAll();
	}

	// Create a new product
	public void createProduct(Product product) {
		productRepository.save(product);
	}

	// Find product by ID
	public Product findById(long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if (optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
	}

	public void addCategory(Product product,Category category) {
		product.getCategories().add(category);
		productRepository.save(product);

	}

	public List<Product> findProductsNotContains (Category category){
		return productRepository.findByCategoriesNotContains(category);
	}


}