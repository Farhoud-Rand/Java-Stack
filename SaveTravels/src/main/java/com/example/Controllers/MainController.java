package com.example.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.Models.Expense;
import com.example.Services.ExpenseService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	// Attribute and constructor
	@Autowired
	ExpenseService expenseService;

	// ******************** R (Read all) from CRUD ******************
	// Get all expenses from our database
	@GetMapping("/expenses")
	public String index(Model model,@ModelAttribute("expense") Expense expense) {
		List<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("expenses",expenses);
		return "index.jsp";
	}

	// ******************** R (Read one) from CRUD ********************
	// Get expenses' information by its ID
	@GetMapping("/expenses/{id}")
	public String index(Model model, @PathVariable long id) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense",expense);
		return "info.jsp";
	}

	// ******************** C (Create) from CRUD ********************
	// Function to add new expense to the table
	@PostMapping("/add")
	public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if(result.hasErrors()){
			model.addAttribute("expense",expense);
			List<Expense> expenses = expenseService.allExpenses();
			model.addAttribute("expenses",expenses);
			return "index.jsp";
		} else {
			expenseService.add(expense);
			return "redirect:/expenses";
		}
	}

	// ******************** U (Update) from CRUD ********************
	// Function to render page that allows us to update expense information
	@GetMapping("/expenses/{id}/edit")
	public String edit(Model model, @PathVariable long id) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense",expense);
		return "edit.jsp";
	}

	// Update expenses' information
	@PutMapping("/expenses/{id}")
	public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("expense",expense);
			return "edit.jsp";
		} else {
			expenseService.updateExpense(expense);
			return "redirect:/expenses";
		}
	}

	// ******************** D (Delete) from CRUD ********************
	@GetMapping("/expenses/{id}/destroy")
	public String destroy(@PathVariable long id) {
		expenseService.deleteExpense(id);
		return "redirect:/expenses";
	}
}
