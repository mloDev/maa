package de.mlo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mlo.model.Req;
import de.mlo.model.Student;

// TODO: Auto-generated Javadoc
/**
 * The Interface ReqRepository.
 */
public interface ReqRepository extends JpaRepository<Req, Integer> {
	
	/**
	 * Find by name.
	 *
	 * @param name the name
	 * @return the req
	 */
	Req findByName(String name);
	
	/**
	 * Find all by student.
	 *
	 * @param student the student
	 * @return the list
	 */
	List<Req> findAllByStudent(Student student);

}
