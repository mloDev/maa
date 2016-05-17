package de.mlo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.mlo.exception.DuplicateEmployeeException;
import de.mlo.exception.DuplicateGroupeException;
import de.mlo.exception.EmployeeNotFoundException;
import de.mlo.model.Employee;
import de.mlo.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository empRepo;

	@Override
	public void addEmployee(Employee employee) throws DuplicateEmployeeException {
		empRepo.saveAndFlush(employee);
		
	}

	@Override
	public Employee getEmployee(int id) throws EmployeeNotFoundException {
		return empRepo.getOne(id);
	}

	@Override
	public Employee getEmployee(String employeeName) throws EmployeeNotFoundException {
		return empRepo.getEmployeeByName(employeeName);
	}

	@Override
	public void updateEmployee(Employee employee) throws EmployeeNotFoundException, DuplicateGroupeException {
		empRepo.saveAndFlush(employee);	
	}

	@Override
	public void deleteEmployee(int id) throws EmployeeNotFoundException {
		empRepo.delete(id);
		
	}

	@Override
	public List<Employee> getEmployees() {
		return empRepo.findAll();
	}

}
