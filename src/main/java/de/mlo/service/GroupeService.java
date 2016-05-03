package de.mlo.service;

import java.util.List;

import de.mlo.exception.*;
import de.mlo.model.Groupe;

// TODO: Auto-generated Javadoc
/**
 * The Interface GroupeService.
 */
public interface GroupeService {

	/**
	 * Adds the groupe.
	 *
	 * @param groupe the groupe
	 * @throws DuplicateGroupeException the duplicate groupe exception
	 */
	public void addGroupe(Groupe groupe) throws DuplicateGroupeException;

	/**
	 * Gets the groupe.
	 *
	 * @param id the id
	 * @return the groupe
	 * @throws GroupeNotFoundException the groupe not found exception
	 */
	public Groupe getGroupe(int id) throws GroupeNotFoundException;

	/**
	 * Gets the groupe.
	 *
	 * @param groupename the groupename
	 * @return the groupe
	 * @throws GroupeNotFoundException the groupe not found exception
	 */
	public Groupe getGroupe(String groupename) throws GroupeNotFoundException;

	/**
	 * Update groupe.
	 *
	 * @param groupe the groupe
	 * @throws GroupeNotFoundException the groupe not found exception
	 * @throws DuplicateGroupeException the duplicate groupe exception
	 */
	public void updateGroupe(Groupe groupe) throws GroupeNotFoundException,
			DuplicateGroupeException;

	/**
	 * Delete groupe.
	 *
	 * @param id the id
	 * @throws GroupeNotFoundException the groupe not found exception
	 */
	public void deleteGroupe(int id) throws GroupeNotFoundException;

	/**
	 * Gets the groupes.
	 *
	 * @return the groupes
	 */
	public List<Groupe> getGroupes();

}
