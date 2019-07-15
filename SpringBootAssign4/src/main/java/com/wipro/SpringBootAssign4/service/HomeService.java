package com.wipro.SpringBootAssign4.service;

import java.util.List;

import com.wipro.SpringBootAssign4.modal.Employee;

public interface HomeService {

	Employee save( Employee employee);

	Employee getEmployee(Long employeeId) throws Exception;

	List<Employee> getALlEmployees();

	void deleteEmployee(Long employeeId);

}
