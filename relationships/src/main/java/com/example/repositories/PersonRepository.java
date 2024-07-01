package com.example.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Person;

@Repository
public interface PersonRepository extends  CrudRepository<Person, Long>{
	// Method to find a specific person by ID
	Person findById(long id);

	// Method to get all persons
	@Override
	List<Person> findAll();
}