package de.mlo.service;

import java.util.List;

import de.mlo.exception.DublicateStudentException;
import de.mlo.exception.StudentNotFoundException;
import de.mlo.model.Student;

// TODO: Auto-generated Javadoc
/**
 * The Interface StudentService.
 */
public interface StudentService {
	
	/**
	 * Adds the student.
	 *
	 * @param student the student
	 * @throws DublicateStudentException the dublicate student exception
	 */
	public void addStudent (Student student) throws DublicateStudentException;
	
	/**
	 * Gets the student.
	 *
	 * @param id the id
	 * @return the student
	 * @throws StudentNotFoundException the student not found exception
	 */
	public Student getStudent(int id) throws StudentNotFoundException;
	
	/**
	 * Gets the student.
	 *
	 * @param name the name
	 * @return the student
	 * @throws StudentNotFoundException the student not found exception
	 */
	public Student getStudent(String name) throws StudentNotFoundException;
	
	/**
	 * Update student.
	 *
	 * @param student the student
	 * @throws DublicateStudentException the dublicate student exception
	 * @throws StudentNotFoundException the student not found exception
	 */
	public void updateStudent(Student student) throws DublicateStudentException, StudentNotFoundException;
	
	/**
	 * Delete student.
	 *
	 * @param id the id
	 * @throws StudentNotFoundException the student not found exception
	 */
	public void deleteStudent(int id) throws StudentNotFoundException;
	
	/**
	 * Gets the student.
	 *
	 * @return the student
	 */
	public List<Student> getStudent();

}
