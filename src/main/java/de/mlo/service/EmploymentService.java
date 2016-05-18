package de.mlo.service;

import java.util.List;

import de.mlo.exception.DuplicateEmploymentException;
import de.mlo.exception.DuplicateGroupeException;
import de.mlo.exception.EmploymentNotFoundException;
import de.mlo.model.Employment;

public interface EmploymentService {
	
	public void addGroupe(Employment employment) throws DuplicateEmploymentException;

	public Employment getEmployment(int id) throws EmploymentNotFoundException;

	public Employment getEmployment(String EmploymentName) throws EmploymentNotFoundException;

	public void updateEmployment(Employment employment) throws EmploymentNotFoundException,
			DuplicateGroupeException;

	public void deleteEmployment(int id) throws EmploymentNotFoundException;

	public List<Employment> getEmployments();

}
