package com.example.ProductsAndCategories.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ProductsAndCategories.models.Category;
import com.example.ProductsAndCategories.models.Product;
import com.example.ProductsAndCategories.services.CategoryService;
import com.example.ProductsAndCategories.services.ProductService;

import jakarta.validation.Valid;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;

	@Autowired
	CategoryService cateoryService;

	// Page to render the two forms
	@GetMapping("/")
	public String index(Model model) {
		// Get all products and categories
		List<Product> products = productService.allProducts();
		model.addAttribute("products", products);
		List<Category> categories = cateoryService.allCategories();
		model.addAttribute("categories", categories);
		return "index.jsp";
	}

	// Page to should the form to add new Product
	@GetMapping("/products")
	public String productForm(@ModelAttribute("product") Product product) {
		return "productForm.jsp";
	}

	// Function to add new product to the table
	@PostMapping("/products/new")
	public String create(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "productForm.jsp";
		} else {
			productService.createProduct(product);
			return "redirect:/";
		}
	}

	// Function to render a page that contains product categories and a form to add a new category
	@GetMapping("/products/{productId}")
	public String showInfo(@PathVariable long productId, Model model) {
		Product product = productService.findById(productId);
		model.addAttribute("product", product);
		List<Category> categories = product.getCategories();
		model.addAttribute("categories", categories);
		List<Category> Allcategories = cateoryService.findCcategoriesNotContains(product);
		model.addAttribute("otherCategories", Allcategories);
		return "productInfo.jsp";
	}

	@PostMapping("/products/{productId}/add")
	public String addCategory(@PathVariable long productId, @RequestParam long categoryId) {
		Product product = productService.findById(productId);
		Category category = cateoryService.findById(categoryId);
		productService.addCategory(product,category);
		return "redirect:/";
	}
}
