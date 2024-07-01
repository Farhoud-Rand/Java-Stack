package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Person;
import com.example.repositories.PersonRepository;

@Service
public class PersonService {
	// Attribute and constructor
	@Autowired
	PersonRepository personRepository;

	// Method to add new person to database
	public void add(Person person) {
		personRepository.save(person);
	}

	//	Find a person by its ID
	public Person findPerson(long id) {
		return personRepository.findById(id);
	}

	// Get all persons from database
	public List<Person> allPersons(){
		return personRepository.findAll();
	}
}
