package com.example.BurgerTracker.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.BurgerTracker.Models.Burger;

public interface BurgerRepository extends  CrudRepository<Burger, Long> {
	// Method retrieves all the burger from the database
	@Override
	List<Burger> findAll();
}
