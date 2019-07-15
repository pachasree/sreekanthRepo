package com.wipro.SpringBootAssign4.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.SpringBootAssign4.modal.Employee;
import com.wipro.SpringBootAssign4.service.HomeService;

@RestController
public class HomeController {
	
	@Autowired
	private HomeService homeService; 
	
	@RequestMapping("/")
	@GetMapping
	private ResponseEntity newEmployee(){
		System.out.println("newEmployee");
		ResponseEntity responseEntity =new ResponseEntity<Employee>( new Employee(),HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping("/employee")
	@PostMapping
	private ResponseEntity addEmployee( @RequestBody Employee employee, BindingResult bindingResult){
		System.out.println("addEmployee");

		employee=homeService.save(employee);
		ResponseEntity responseEntity =new ResponseEntity<Employee>( employee,HttpStatus.OK);
		return responseEntity;
	}
	
	
	@RequestMapping("/employee/{empId}")
	@GetMapping
	private @ResponseBody ResponseEntity<Employee> getEmployee(@PathVariable(value="empId") Long employeeId) throws Exception{
		System.out.println("getEmployee");

		Employee employee=homeService.getEmployee(employeeId);
		System.out.println("employee : "+employee);
		//return employee;
		ResponseEntity responseEntity =new ResponseEntity<Employee>( employee,HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping("/deleteEmployee/{empId}")
	@DeleteMapping
	private ResponseEntity deleteEmployee(@PathVariable(value="empId") Long employeeId) throws Exception{
		System.out.println("deleteEmployee");
		homeService.deleteEmployee(employeeId);
		ResponseEntity responseEntity =new ResponseEntity<Employee>(HttpStatus.OK);
		return responseEntity;
	}
	
	
	@RequestMapping("/employees")
	@GetMapping
	private ResponseEntity allEmployees() throws Exception{
		System.out.println("allEmployees");
		List<Employee> employee=homeService.getALlEmployees();
		System.out.println("employee : "+employee);
		ResponseEntity responseEntity =new ResponseEntity<List<Employee>>( employee,HttpStatus.OK);
		return responseEntity;
	}

	

}
