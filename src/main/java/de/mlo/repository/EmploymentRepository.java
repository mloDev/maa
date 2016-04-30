package de.mlo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mlo.model.Employment;

public interface EmploymentRepository extends JpaRepository<Employment, Long> {

}
