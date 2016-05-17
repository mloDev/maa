package de.mlo.service;

import java.util.List;

import de.mlo.exception.DuplicateInstitutException;
import de.mlo.exception.InstitutNotFoundException;
import de.mlo.model.Institut;

public interface InstitutService {

	public void addInstitut(Institut institut) throws DuplicateInstitutException;

	public Institut getInstitut(int id) throws InstitutNotFoundException;

	public Institut getInstitut(String institutName) throws InstitutNotFoundException;

	public void updateInstitut(Institut institut) throws InstitutNotFoundException,
			DuplicateInstitutException;

	public void deleteInstitut(int id) throws InstitutNotFoundException;

	public List<Institut> getInstituts();
}
