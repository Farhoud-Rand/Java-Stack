package com.example.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Models.Expense;

@Repository
public interface ExpenseRepository extends  CrudRepository<Expense, Long> {
	// Method retrieves all the expenses from the database
	@Override
	List<Expense> findAll();
	// Method deletes expense by its ID
	void deleteById(long id);
}