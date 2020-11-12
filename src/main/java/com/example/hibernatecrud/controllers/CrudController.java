package com.example.hibernatecrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hibernatecrud.services.CrudService;

@RestController
public class CrudController {

	@Autowired
	private CrudService service; 
	
	@PostMapping("/saveorupdate")
	public Object saveorupdate(@RequestBody Object obj, @RequestParam String entityName) {
		return service.saveOrUpdate(entityName, obj);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestParam String entityName, @RequestParam Long id) {
		service.delete(entityName, id);
	}
	
	@PostMapping("/read")
	public Object read(@RequestParam String entityName, @RequestParam Long id) {
		return service.read(entityName, id);
	}
}
