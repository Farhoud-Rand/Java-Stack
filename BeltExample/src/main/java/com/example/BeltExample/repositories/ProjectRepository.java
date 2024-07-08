package com.example.BeltExample.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.BeltExample.models.Project;
import com.example.BeltExample.models.User;

@Repository
public interface ProjectRepository extends CrudRepository <Project, Long>{
	List<Project> findByTeamNotContains(User user);
	List<Project> findByTeamContains(User user);
	Project findById(long id);
}