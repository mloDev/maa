package de.mlo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.mlo.exception.DublicateStudentException;
import de.mlo.exception.StudentNotFoundException;
import de.mlo.model.Student;
import de.mlo.repository.StudentRepository;


@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepo;

	@Override
	public void addStudent(Student student) throws DublicateStudentException {
		studentRepo.save(student);
		
	}

	@Override
	public Student getStudent(int id) throws StudentNotFoundException {
		return studentRepo.findOne(id);
	}

	@Override
	public Student getStudent(String name) {
		return studentRepo.findByName(name);
	}

	@Override
	public void updateStudent(Student student) throws DublicateStudentException {
		studentRepo.saveAndFlush(student);
		
	}

	@Override
	public void deleteStudent(int id) {
		studentRepo.delete(id);
		
	}

	@Override
	public List<Student> getStudent() {
		return studentRepo.findAll();
	}

}
