package de.mlo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mlo.model.Groupe;

// TODO: Auto-generated Javadoc
/**
 * The Interface GroupeRepo.
 */
public interface GroupeRepo extends JpaRepository<Groupe, Integer> {

	/**
	 * Find by groupename.
	 *
	 * @param name the name
	 * @return the groupe
	 */
	Groupe findByGroupename(String name);
}
