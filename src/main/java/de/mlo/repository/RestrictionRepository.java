package de.mlo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mlo.model.Restrictions;

public interface RestrictionRepository extends JpaRepository<Restrictions, Integer> {

}
