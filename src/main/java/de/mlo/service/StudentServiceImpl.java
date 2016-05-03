package de.mlo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.mlo.exception.DublicateStudentException;
import de.mlo.exception.StudentNotFoundException;
import de.mlo.model.Student;
import de.mlo.repository.StudentRepository;


// TODO: Auto-generated Javadoc
/**
 * The Class StudentServiceImpl.
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	
	/** The student repo. */
	@Autowired
	private StudentRepository studentRepo;

	/* (non-Javadoc)
	 * @see de.mlo.service.StudentService#addStudent(de.mlo.model.Student)
	 */
	@Override
	public void addStudent(Student student) throws DublicateStudentException {
		studentRepo.save(student);
		
	}

	/* (non-Javadoc)
	 * @see de.mlo.service.StudentService#getStudent(int)
	 */
	@Override
	public Student getStudent(int id) throws StudentNotFoundException {
		return studentRepo.findOne(id);
	}

	/* (non-Javadoc)
	 * @see de.mlo.service.StudentService#getStudent(java.lang.String)
	 */
	@Override
	public Student getStudent(String name) {
		return studentRepo.findByName(name);
	}

	/* (non-Javadoc)
	 * @see de.mlo.service.StudentService#updateStudent(de.mlo.model.Student)
	 */
	@Override
	public void updateStudent(Student student) throws DublicateStudentException {
		studentRepo.saveAndFlush(student);
	}

	/* (non-Javadoc)
	 * @see de.mlo.service.StudentService#deleteStudent(int)
	 */
	@Override
	public void deleteStudent(int id) {
		studentRepo.delete(id);
		
	}

	/* (non-Javadoc)
	 * @see de.mlo.service.StudentService#getStudent()
	 */
	@Override
	public List<Student> getStudent() {
		return studentRepo.findAll();
	}

}
