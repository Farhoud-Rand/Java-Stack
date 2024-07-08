package com.example.BeltExample.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="intructors")
public class Instructor {
	// ******************* Attributes *******************
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message="Instructor Name is required!")
	@Size(min=3, max=30, message="Instructor Name must be between 3 and 30 characters")
	private String instructorName;

	@NotEmpty(message="Email is required!")
	@Email(message="Please enter a valid email!")
	private String email;

	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;

	@NotEmpty(message="Password is required!")
	@Size(min=8, max=128, message="Password must be between 8 and 128 characters")
	private String password;

	@Transient
	@NotEmpty(message="Confirm Password is required!")
	@Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
	private String confirm;

	@OneToMany(mappedBy="teacher", fetch = FetchType.LAZY)
	private List<Course> coursesTeach;

	//	@ManyToMany(fetch = FetchType.LAZY)
	//	@JoinTable(name = "users_projects", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
	//	private List<Course> joinProjects;

	// ******************* Constructor *******************
	public Instructor() {
		//		this.joinProjects = new ArrayList<>();
		//		this.projectsLead = new ArrayList<>();
	}

	// ******************* Setters and Getters *******************
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	//	public List<Course> getProjectsLead() {
	//		return projectsLead;
	//	}
	//
	//	public void setProjectsLead(List<Course> projectsLead) {
	//		this.projectsLead = projectsLead;
	//	}
	//
	//	public List<Course> getJoinProjects() {
	//		return joinProjects;
	//	}
	//
	//	public void setJoinProjects(List<Course> joinProjects) {
	//		this.joinProjects = joinProjects;
	//	}

	//	******************* For create and update *******************
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}

	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
}