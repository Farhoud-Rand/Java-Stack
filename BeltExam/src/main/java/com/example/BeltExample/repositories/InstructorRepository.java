package com.example.BeltExample.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.BeltExample.models.Instructor;

@Repository
public interface InstructorRepository extends CrudRepository <Instructor, Long>{
	Instructor findByEmail(String email);
	Instructor findById(long id);

}
