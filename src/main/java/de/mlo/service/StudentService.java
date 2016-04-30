package de.mlo.service;

import java.util.List;

import de.mlo.exception.DublicateStudentException;
import de.mlo.exception.StudentNotFoundException;
import de.mlo.model.Student;

public interface StudentService {
	
	public void addStudent (Student student) throws DublicateStudentException;
	
	public Student getStudent(int id) throws StudentNotFoundException;
	
	public Student getStudent(String name) throws StudentNotFoundException;
	
	public void updateStudent(Student student) throws DublicateStudentException, StudentNotFoundException;
	
	public void deleteStudent(int id) throws StudentNotFoundException;
	
	public List<Student> getStudent();

}
