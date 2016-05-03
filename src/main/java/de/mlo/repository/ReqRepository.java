package de.mlo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mlo.model.Req;
import de.mlo.model.Student;

public interface ReqRepository extends JpaRepository<Req, Integer> {
	
	Req findByName(String name);
	
	List<Req> findAllByStudent(Student student);

}
