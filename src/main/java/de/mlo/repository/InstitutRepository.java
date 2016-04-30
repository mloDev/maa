package de.mlo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mlo.model.Institut;

public interface InstitutRepository extends JpaRepository<Institut, Long> {

}
