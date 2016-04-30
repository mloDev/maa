package de.mlo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mlo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
