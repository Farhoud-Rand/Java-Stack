package com.example.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.models.License;

@Repository
public interface LicenseRepository extends  CrudRepository<License, Long>{

}