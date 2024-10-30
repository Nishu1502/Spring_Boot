package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.StudentModels;
import com.example.demo.repository.StudentRepository;

@RestController
public class StudentController {
	@Autowired
	StudentRepository sr;
	
	@PostMapping("Insert")
	public String insert(StudentModels sm)
	{
		try 
		{
			sr.save(sm);
			return"Record Inserted";
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		return "stored";
	}
	
	@PostMapping("Delete")
	public String delete(int id)
	{
		try
		{
			sr.deleteById(id);
			return "Recored Deleted";
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		return "stored";
	}
	
	@PostMapping("Update")
	public String update(@ModelAttribute StudentModels models)
	{
		try
		{
			sr.save(models);
			return "Recored updated";
		}
		catch(Exception e)
		{
			e.printStackTrace();;
		}
		return "stored";
	}
	
	@GetMapping("display")
	public Iterable<StudentModels>getall()
	{
		return sr.findAll();
	}
}
