package com.wipro.SpringBootAssign4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.SpringBootAssign4.modal.Employee;

@Repository
public interface HomeRepository extends JpaRepository<Employee,Long> {

}
