package de.mlo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mlo.model.Title;

/**
 * The Interface TitleRepository.
 */
public interface TitleRepository extends JpaRepository<Title, Long> {

}
