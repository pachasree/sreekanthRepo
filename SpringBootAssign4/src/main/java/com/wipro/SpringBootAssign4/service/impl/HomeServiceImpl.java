package com.wipro.SpringBootAssign4.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.SpringBootAssign4.modal.Employee;
import com.wipro.SpringBootAssign4.repository.HomeRepository;
import com.wipro.SpringBootAssign4.service.HomeService;
@Service
@Transactional
public class HomeServiceImpl implements HomeService {
	
	@Autowired
	private HomeRepository homeRepository;

	@Override
	public Employee save(Employee employee) {
		return homeRepository.save(employee);
	}

	@Override
	public Employee getEmployee(Long employeeId) throws Exception {
		
		Optional<Employee> optional=homeRepository.findById(employeeId);
		optional.orElseThrow(() -> new Exception("No user found with employeeId " + employeeId));
		  
		return optional.get();
	}

	@Override
	public List<Employee> getALlEmployees() {
		
		return homeRepository.findAll();
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		homeRepository.deleteById(employeeId);
		//return null;
	}

}
