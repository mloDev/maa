package de.mlo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mlo.model.Student;

// TODO: Auto-generated Javadoc
/**
 * The Interface StudentRepository.
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	/**
	 * Find by name.
	 *
	 * @param name the name
	 * @return the student
	 */
	Student findByName(String name);

}
