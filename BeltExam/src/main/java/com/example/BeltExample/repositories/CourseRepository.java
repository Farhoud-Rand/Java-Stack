package com.example.BeltExample.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.BeltExample.models.Course;

@Repository
public interface CourseRepository extends CrudRepository <Course, Long>{
	//	List<Course> findByTeamNotContains(Instructor user);
	//	List<Course> findByTeamContains(Instructor user);
	Optional<Course> findById(long id);
	@Override
	List<Course> findAll();

}