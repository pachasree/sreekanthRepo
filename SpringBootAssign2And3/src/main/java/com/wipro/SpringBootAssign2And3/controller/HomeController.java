package com.wipro.SpringBootAssign2And3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.SpringBootAssign2And3.modal.Bank;
import com.wipro.SpringBootAssign2And3.modal.Branch;
import com.wipro.SpringBootAssign2And3.modal.Service;

@RestController
public class HomeController {
	
	List<Service> services =getSetvices(null);
	
	
	@RequestMapping("/")
	public ModelAndView getBankData(ModelAndView modelAndView){
		Bank bank= new Bank();
		bank.setIfsc("ICICI000123");
		bank.setName("ICICI BANK");
		bank.setBranches(getBranches("ICICI"));
		modelAndView.addObject("bank", bank);
		modelAndView.setViewName("bankDetails.html");
		return modelAndView;
		
	}
	@RequestMapping("/serviceDetails")
	public ModelAndView getBankServices(ModelAndView modelAndView){
		Bank bank= new Bank();
		bank.setIfsc("ICICI000123");
		bank.setName("ICICI BANK");
		bank.setServices(getSetvices("ICICI"));
		modelAndView.addObject("bank", bank);
		modelAndView.setViewName("bankServices.html");
		return modelAndView;
		
	}
	
	
	private List<Branch> getBranches(String branchCode) {
		
		List<Branch>  brances= new ArrayList<Branch>();
		
		Branch branch1= new Branch();
		branch1.setName(branchCode+"-BTM-Branch");
		branch1.setCode(branchCode+"-BTM");
		branch1.setLocation("BTM-Layout");
		branch1.setCity("Bangalore");
		
		brances.add(branch1);
		
		Branch branch2= new Branch();
		branch2.setName(branchCode+"-JP-Branch");
		branch2.setCode(branchCode+"-JP");
		branch2.setLocation("JP Nagar");
		branch2.setCity("Bangalore");
		
		brances.add(branch2);
		
		Branch branch3= new Branch();
		branch3.setName(branchCode+"-ECL-Branch");
		branch3.setCode(branchCode+"-ECL ");
		branch3.setLocation("ECL Layout");
		branch3.setCity("Bangalore");
		
		brances.add(branch3);
		
		
		Branch branch4= new Branch();
		branch4.setName(branchCode+"-Rajaji-Branch");
		branch4.setCode(branchCode+"-RR");
		branch4.setLocation("Rajaji Nagar");
		branch4.setCity("Bangalore");
		
		brances.add(branch4);
		
		return brances;
	}

	private List<Service> getSetvices(Object object) {
		List<Service> services = new ArrayList<Service>();
		
		Service service1 = new Service();
		service1.setCode("C&D");
		service1.setName("Credit and Debit Cards");
		services.add(service1);
		
		Service service2 = new Service();
		service2.setCode("SB");
		service2.setName("Savings bank ");
		services.add(service2);
		
		
		Service service3 = new Service();
		service3.setCode("LN");
		service3.setName("Loans");
		services.add(service3);
		
		Service service4 = new Service();
		service4.setCode("MN");
		service4.setName("Marchent services");
		services.add(service4);
		
		
		
		
		
		
		return services;
	}

}
