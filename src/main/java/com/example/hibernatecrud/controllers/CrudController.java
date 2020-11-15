package com.example.hibernatecrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hibernatecrud.entities.Employee;
import com.example.hibernatecrud.services.CrudService;

@RestController
public class CrudController {

	@Autowired
	private CrudService service; 
	
	@PostMapping("/saveorupdate")
	public Object saveorupdate(@RequestBody Object json, @RequestParam String entityName) {
		return service.saveOrUpdate(entityName, json);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestParam String entityName, @RequestParam Long id) {
		service.delete(entityName, id);
	}
	
	@PostMapping("/find")
	public Object find(@RequestParam String entityName, @RequestParam Long id) {
		return service.find(entityName, id);
	}
}
