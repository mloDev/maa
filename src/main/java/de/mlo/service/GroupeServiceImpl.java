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

@Service
@Transactional
public class GroupeServiceImpl implements GroupeService {

	static Logger logger = LoggerFactory.getLogger(GroupeServiceImpl.class);
	
	@Autowired
	private GroupeRepo groupeRepo;

	@Override
	public void addGroupe(Groupe groupe) throws DuplicateGroupeException {
		groupeRepo.save(groupe);
	}

	@Override
	public Groupe getGroupe(int id) throws GroupeNotFoundException {
		return groupeRepo.getOne(id);
	}

	@Override
	public Groupe getGroupe(String groupename) throws GroupeNotFoundException {
		return groupeRepo.findByGroupename(groupename);
	}

	@Override
	public void updateGroupe(Groupe groupe) throws GroupeNotFoundException, DuplicateGroupeException {
		groupeRepo.flush();
		
	}

	@Override
	public void deleteGroupe(int id) throws GroupeNotFoundException {
		groupeRepo.delete(id);
		
	}

	@Override
	public List<Groupe> getGroupes() {
		return groupeRepo.findAll();
	}
	

}
