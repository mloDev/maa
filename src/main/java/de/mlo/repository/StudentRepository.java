package de.mlo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mlo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	Student findByName(String name);

}
