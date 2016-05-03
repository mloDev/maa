package de.mlo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.mlo.model.Stada;

/**
 * The Interface StadaRepository.
 */
@Repository
public interface StadaRepository extends JpaRepository<Stada, Long> {

}
