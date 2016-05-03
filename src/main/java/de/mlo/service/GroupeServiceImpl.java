package de.mlo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.mlo.exception.DuplicateGroupeException;
import de.mlo.exception.GroupeNotFoundException;
import de.mlo.model.Groupe;
import de.mlo.repository.GroupeRepo;

// TODO: Auto-generated Javadoc
/**
 * The Class GroupeServiceImpl.
 */
@Service
@Transactional
public class GroupeServiceImpl implements GroupeService {

	/** The logger. */
	static Logger logger = LoggerFactory.getLogger(GroupeServiceImpl.class);
	
	/** The groupe repo. */
	@Autowired
	private GroupeRepo groupeRepo;

	/* (non-Javadoc)
	 * @see de.mlo.service.GroupeService#addGroupe(de.mlo.model.Groupe)
	 */
	@Override
	public void addGroupe(Groupe groupe) throws DuplicateGroupeException {
		groupeRepo.save(groupe);
	}

	/* (non-Javadoc)
	 * @see de.mlo.service.GroupeService#getGroupe(int)
	 */
	@Override
	public Groupe getGroupe(int id) throws GroupeNotFoundException {
		return groupeRepo.getOne(id);
	}

	/* (non-Javadoc)
	 * @see de.mlo.service.GroupeService#getGroupe(java.lang.String)
	 */
	@Override
	public Groupe getGroupe(String groupename) throws GroupeNotFoundException {
		return groupeRepo.findByGroupename(groupename);
	}

	/* (non-Javadoc)
	 * @see de.mlo.service.GroupeService#updateGroupe(de.mlo.model.Groupe)
	 */
	@Override
	public void updateGroupe(Groupe groupe) throws GroupeNotFoundException, DuplicateGroupeException {
		groupeRepo.flush();
		
	}

	/* (non-Javadoc)
	 * @see de.mlo.service.GroupeService#deleteGroupe(int)
	 */
	@Override
	public void deleteGroupe(int id) throws GroupeNotFoundException {
		groupeRepo.delete(id);
		
	}

	/* (non-Javadoc)
	 * @see de.mlo.service.GroupeService#getGroupes()
	 */
	@Override
	public List<Groupe> getGroupes() {
		return groupeRepo.findAll();
	}
	

}
