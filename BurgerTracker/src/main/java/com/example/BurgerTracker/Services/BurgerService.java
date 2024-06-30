package com.example.BurgerTracker.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BurgerTracker.Models.Burger;
import com.example.BurgerTracker.Repositories.BurgerRepository;

@Service
public class BurgerService {
	// Attribute and constructor
	@Autowired
	BurgerRepository burgerRepository;

	// Function to get all burgers from database
	public List <Burger> allBurgers(){
		return burgerRepository.findAll();
	}

	//	Function to add a new burger
	public void add(Burger burger) {
		burgerRepository.save(burger);
	}
}
