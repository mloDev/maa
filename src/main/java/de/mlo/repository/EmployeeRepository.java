package de.mlo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mlo.model.Employee;

/**
 * The Interface EmployeeRepository.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	Employee getEmployeeByName(String employeeName);

}
