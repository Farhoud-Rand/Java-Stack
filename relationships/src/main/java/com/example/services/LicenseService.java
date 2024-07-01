package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.License;
import com.example.repositories.LicenseRepository;

@Service
public class LicenseService {
	// Attribute and constructor
	@Autowired
	LicenseRepository licenseRepository;

	// Method to add new person to database
	public void add(License license) {
		licenseRepository.save(license);
	}
}