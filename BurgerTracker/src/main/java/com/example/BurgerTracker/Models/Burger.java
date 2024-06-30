package com.example.BurgerTracker.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="burgers")
public class Burger {
	//	Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank()
	private String name;

	@NotBlank()
	private String restaurant;

	@Min(1)
	@Max(5)
	private int rating;

	@NotBlank()
	private String notes;

	// constructors
	public Burger(Long id, @NotBlank String name, @NotBlank String restaurant, @NotBlank @Min(0) @Max(5) int rating,
			@NotBlank String notes) {
		super();
		this.id = id;
		this.name = name;
		this.restaurant = restaurant;
		this.rating = rating;
		this.notes = notes;
	}

	public Burger() {
		super();
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}
