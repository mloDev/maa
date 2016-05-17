package de.mlo.service;

import java.util.List;

import de.mlo.model.Stada;
import de.mlo.model.Student;

public interface StadaService {

	public void addStada(Stada stada);

	public Stada getStada(int id);

	public void updateStada(Stada stada);

	public void deleteStada(int id);

	public List<Stada> getStadas();

	public List<Stada> getStadasByStudent(Student student);

}
