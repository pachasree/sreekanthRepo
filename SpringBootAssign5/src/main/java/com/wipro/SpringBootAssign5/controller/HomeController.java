package com.wipro.SpringBootAssign5.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.SpringBootAssign5.modal.Employee;

@RestController
@RequestMapping(path="/employee")
public class HomeController {
	
	private Map<String,Employee> dataMap;
	
	HomeController(){
		this.dataMap= new HashMap<String,Employee>();
	}
	@RequestMapping("/{id}")
	@GetMapping
	private Employee newEmployee(@PathVariable(name="id") String id){
		System.out.println("@GetMapping newEmployee");
		Employee employee=dataMap.get(id);
		return employee;
	}
	
	@PostMapping
	private Employee addEmployee(@RequestBody Employee employee){
		System.out.println("@PostMapping addEmployee");
		dataMap.put(employee.getId(), employee);;
		return employee;
	}
	@PutMapping
	private Employee updateEmployee(@RequestBody Employee employee){
		System.out.println("@PutMapping updateEmployee");

		dataMap.put(employee.getId(), employee);
		return employee;
	}
	@DeleteMapping("/{id}")
	private Employee deleteEmployee(@PathVariable(name="id") String id){
		System.out.println("@DeleteMapping deleteEmployee");
		Employee employee=dataMap.remove(id);
		return employee;
	}


}
