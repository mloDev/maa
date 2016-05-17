package de.mlo.service;

import java.util.List;

import de.mlo.exception.DuplicateEmployeeException;
import de.mlo.exception.DuplicateGroupeException;
import de.mlo.exception.EmployeeNotFoundException;
import de.mlo.model.Employee;

//TODO: Auto-generated Javadoc
/**
* The Interface GroupeService.
*/
public interface EmployeeService {


	public void addEmployee(Employee employee) throws DuplicateEmployeeException;

	public Employee getEmployee(int id) throws EmployeeNotFoundException;

	public Employee getEmployee(String employeeName) throws EmployeeNotFoundException;

	public void updateEmployee(Employee employee) throws EmployeeNotFoundException,
			DuplicateGroupeException;

	public void deleteEmployee(int id) throws EmployeeNotFoundException;

	public List<Employee> getEmployees();

}