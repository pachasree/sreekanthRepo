package com.wipro.SpringBootAssign1.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Assign1Controller {
	
	
	@Value("${app.bankName}")
	private String bankName;
	
	
	@Value("${app.bankAddress}")
	private String address;

	@RequestMapping("/")
	public String bankName(){
		
		return "Bank Name : "+bankName;
		
		
	}
	@RequestMapping("/{bankName}")
	public String bankName(@PathVariable(name="bankName") String bankName){
		return "Bank Name : "+bankName;
	}
	@RequestMapping("/address")
	public String bankAddress(){
		return "Bank Address : "+address;
	}
}
