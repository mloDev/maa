package de.mlo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mlo.model.Req;

// TODO: Auto-generated Javadoc
/**
 * The Interface ReqRepository.
 */
public interface ReqRepository extends JpaRepository<Req, Integer> {
	
	List<Req> findAllByStudentId (int id);


}
