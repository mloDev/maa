package de.mlo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mlo.model.Employment;

/**
 * The Interface EmploymentRepository.
 */
public interface EmploymentRepository extends JpaRepository<Employment, Integer> {

}
