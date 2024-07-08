package com.example.BeltExample.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.BeltExample.models.Student;
@Repository
public interface StudentRepository extends CrudRepository <Student, Long>{
	Student findById(long id);
	@Query("SELECT s FROM Student s WHERE NOT EXISTS (SELECT 1 FROM s.JoinedCourses c WHERE c.id = :courseId)")
	List<Student> findStudentsNotInCourse(@Param("courseId") Long courseId);
}