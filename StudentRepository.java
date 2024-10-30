package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.StudentModels;

public interface StudentRepository extends CrudRepository<StudentModels,Integer>{

}
