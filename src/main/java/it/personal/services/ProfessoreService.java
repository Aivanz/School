package it.personal.services;

import java.util.List;

import it.personal.model.Aula;
import it.personal.model.Materia;
import it.personal.model.Professore;

public interface ProfessoreService {
	public Professore saveOrUpdate(Professore professore);

	public void delete(Professore professore);

	public List<Professore> getList();

	public List<Professore> getByMateria(Materia materia);

	public List<Professore> getByNome(String nome);

	public List<Professore> getByCognome(String cognome);

	public List<Professore> getByAula(Aula aula);
}
