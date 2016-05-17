package de.mlo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.mlo.model.Stada;
import de.mlo.model.Student;
import de.mlo.repository.StadaRepository;

@Service
@Transactional
public class StadaServiceImpl implements StadaService {
	
	@Autowired
	private StadaRepository stadaRepo;

	@Override
	public void addStada(Stada stada) {
		stadaRepo.save(stada);
	}

	@Override
	public Stada getStada(int id) {
		return stadaRepo.findOne(id);
	}

	@Override
	public void updateStada(Stada stada) {
		stadaRepo.saveAndFlush(stada);
		
	}

	@Override
	public void deleteStada(int id) {
		stadaRepo.delete(id);
	}

	@Override
	public List<Stada> getStadas() {
		return stadaRepo.findAll();
	}

	@Override
	public List<Stada> getStadasByStudent(Student student) {
		return stadaRepo.findAllByStudent(student);
	}

}
