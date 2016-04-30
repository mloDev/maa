package de.mlo.service;

import java.util.List;

import de.mlo.exception.*;
import de.mlo.model.Groupe;

public interface GroupeService {

	public void addGroupe(Groupe groupe) throws DuplicateGroupeException;

	public Groupe getGroupe(int id) throws GroupeNotFoundException;

	public Groupe getGroupe(String groupename) throws GroupeNotFoundException;

	public void updateGroupe(Groupe groupe) throws GroupeNotFoundException,
			DuplicateGroupeException;

	public void deleteGroupe(int id) throws GroupeNotFoundException;

	public List<Groupe> getGroupes();

}
