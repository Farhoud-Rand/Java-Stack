package com.example.BeltExample.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BeltExample.models.Project;
import com.example.BeltExample.models.User;
import com.example.BeltExample.repositories.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	UserService userService;

	// Function to create a new project
	public void createProject(Project project, long userId) {
		User user = userService.getUserByID(userId);
		project.setLead(user);
		projectRepository.save(project);
		joinProject(project, user);
	}

	// Function to add new user as a team member for a specific team
	public void joinProject(Project project, User user) {
		project.getTeam().add(user);
		projectRepository.save(project);
	}

	// Function to get all projects that user is not part of their team
	public List<Project> getAllProjects(User user) {
		return projectRepository.findByTeamNotContains(user);
	}

	// Function to get all projects that the user is member of their team
	public List<Project> getUserProjects(User user) {
		return projectRepository.findByTeamContains(user);
	}

	// Function to find the project by its ID
	public Project findProjectById(long id) {
		return projectRepository.findById(id);
	}

	// Function to add user as a team member for a project
	public void addTeam(long projectId, long userId) {
		Project project = findProjectById(projectId);
		User user = userService.getUserByID(userId);
		project.getTeam().add(user);
		projectRepository.save(project);
	}

	// Function to add user as a team member for a project
	public void removeTeam(Project project, User user) {
		project.getTeam().remove(user);
		projectRepository.save(project);
	}

	//	Function to update a project
	public void updateProject (long id,Project project) {
		Project oLdProject = findProjectById(id);
		oLdProject.setTitle(project.getTitle());
		oLdProject.setDueDate(project.getDueDate());
		oLdProject.setDescription(project.getDescription());
		projectRepository.save(oLdProject);
	}

	//	Function to delete project by its ID
	public void deleteProjectById(long id) {
		projectRepository.deleteById(id);
	}
}
