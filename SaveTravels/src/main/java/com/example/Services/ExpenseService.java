package com.example.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Models.Expense;
import com.example.Repositories.ExpenseRepository;

@Service
public class ExpenseService {
	// Attribute and constructor
	@Autowired
	ExpenseRepository expenseRepository;

	// Function to get all expenses from database
	public List <Expense> allExpenses(){
		return expenseRepository.findAll();
	}

	//	Function to add a new expense
	public void add(Expense expense) {
		expenseRepository.save(expense);
	}

	// Retrieves an expense by its id
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else {
			return null;
		}
	}

	// Deletes a expense by its ID
	public void deleteExpense(Long id) {
		expenseRepository.deleteById(id);
	}

	// Updates a expense information
	public Expense updateExpense(Expense expense) {
		return expenseRepository.save(expense);
	}
}