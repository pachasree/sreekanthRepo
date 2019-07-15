package com.wipro.SpringBootAssign4.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.servlet.ModelAndView;

import com.wipro.SpringBootAssign4.modal.Employee;
import com.wipro.SpringBootAssign4.service.HomeService;

@RestController
public class HomeController {
	
	@Autowired
	private HomeService homeService; 
	
	@RequestMapping("/")
	@GetMapping
	private ModelAndView newEmployee(ModelAndView modelAndView){
		System.out.println("newEmployee");
		//ResponseEntity responseEntity =new ResponseEntity<Employee>( ,HttpStatus.OK);
		modelAndView.addObject("employee", new Employee());
		modelAndView.addObject("departments", getDepartments());
		modelAndView.setViewName("index.html");
		return modelAndView;
	}
	
	private List<String> getDepartments() {

		List<String> depatments=new ArrayList<String>();
		depatments.add("IT Department");
		depatments.add("Business");
		depatments.add("HR");
		return depatments;
	}

	@RequestMapping("/employee")
	@PostMapping
	private ModelAndView addEmployee(@Valid Employee employee, BindingResult bindingResult){
		System.out.println("addEmployee");
		//validator.validate(employee);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("index.html");
		if(bindingResult.hasErrors()){
			modelAndView.addObject("employee", employee);
			return modelAndView;
		}
		employee=homeService.save(employee);
		modelAndView.addObject("employee", new Employee());
		modelAndView.addObject("message", "Employee added successfully");
		modelAndView.addObject("departments", getDepartments());
		//ResponseEntity responseEntity =new ResponseEntity<Employee>( employee,HttpStatus.OK);
		
		
		return modelAndView;
	}
	
	
	@RequestMapping("/display/{empId}")
	@GetMapping
	private @ResponseBody ResponseEntity<Employee> getEmployee(@PathVariable(value="empId") Long employeeId) throws Exception{
		System.out.println("getEmployee");

		Employee employee=homeService.getEmployee(employeeId);
		System.out.println("employee : "+employee);
		//return employee;
		ResponseEntity responseEntity =new ResponseEntity<Employee>( employee,HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping("/delete/{empId}")
	@DeleteMapping
	private ResponseEntity deleteEmployee(@PathVariable(value="empId") Long employeeId) throws Exception{
		System.out.println("deleteEmployee");
		homeService.deleteEmployee(employeeId);
		ResponseEntity responseEntity =new ResponseEntity<Employee>(HttpStatus.OK);
		return responseEntity;
	}
	
	
	@RequestMapping("/displayAll")
	@GetMapping
	private ResponseEntity allEmployees() throws Exception{
		System.out.println("allEmployees");
		List<Employee> employee=homeService.getALlEmployees();
		System.out.println("employee : "+employee);
		ResponseEntity responseEntity =new ResponseEntity<List<Employee>>( employee,HttpStatus.OK);
		return responseEntity;
	}

	

}
