package de.mlo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.mlo.exception.DuplicateInstitutException;
import de.mlo.exception.InstitutNotFoundException;
import de.mlo.model.Institut;
import de.mlo.repository.InstitutRepository;

@Service
@Transactional
public class InstitutServiceImpl implements InstitutService{
	
	@Autowired
	InstitutRepository instRepo;
	

	@Override
	public void addInstitut(Institut institut) throws DuplicateInstitutException {
		instRepo.saveAndFlush(institut);
		
	}

	@Override
	public Institut getInstitut(int id) throws InstitutNotFoundException {
		return instRepo.getOne(id);
	}

	@Override
	public Institut getInstitut(String institutName) throws InstitutNotFoundException {
		return instRepo.findInstitutByName(institutName);
	}

	@Override
	public void updateInstitut(Institut institut) throws InstitutNotFoundException, DuplicateInstitutException {
		instRepo.saveAndFlush(institut);
		
	}

	@Override
	public void deleteInstitut(int id) throws InstitutNotFoundException {
		instRepo.delete(id);
	}

	@Override
	public List<Institut> getInstituts() {
		return instRepo.findAll();
	}

}
