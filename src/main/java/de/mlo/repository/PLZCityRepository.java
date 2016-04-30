package de.mlo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mlo.model.PLZCity;

public interface PLZCityRepository extends JpaRepository<PLZCity, Long> {

}
