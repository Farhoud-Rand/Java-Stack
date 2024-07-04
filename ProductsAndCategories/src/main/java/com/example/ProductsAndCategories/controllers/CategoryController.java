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
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;


	// Page to should the form to add new Category
	@GetMapping("/categories")
	public String categoryForm(@ModelAttribute("category") Category category) {
		return "categoryForm.jsp";
	}

	// Function to add new product to the table
	@PostMapping("/categories/new")
	public String create(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "categoryForm.jsp";
		} else {
			categoryService.createCategory(category);
			return "redirect:/";
		}
	}

	// Function to render a page that contains product categories and a form to add a new category
	@GetMapping("/categories/{categoryId}")
	public String showInfo(@PathVariable long categoryId, Model model) {
		Category category = categoryService.findById(categoryId);
		model.addAttribute("category", category);
		List<Product> products = category.getProducts();
		model.addAttribute("products", products);
		List<Product> Allproducts = productService.findProductsNotContains(category);
		model.addAttribute("otherProducts", Allproducts);
		return "categoryInfo.jsp";
	}

	@PostMapping("/categories/{categoryId}/add")
	public String addProduct(@PathVariable long categoryId, @RequestParam long productId) {
		Product product = productService.findById(productId);
		Category category = categoryService.findById(categoryId);
		categoryService.addProduct(category,product);
		return "redirect:/";
	}
}