package de.mlo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mlo.model.Groupe;

public interface GroupeRepo extends JpaRepository<Groupe, Integer> {

	Groupe findByGroupename(String name);
}
