package de.mlo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.mlo.model.Stada;
import de.mlo.model.Student;

/**
 * The Interface StadaRepository.
 */
@Repository
public interface StadaRepository extends JpaRepository<Stada, Integer> {
	
	List<Stada> findAllByStudent(Student student);

}
