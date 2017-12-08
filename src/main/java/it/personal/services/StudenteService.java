package it.personal.services;

import java.util.List;

import it.personal.model.Aula;
import it.personal.model.Studente;

public interface StudenteService {
	public Studente saveOrUpdate(Studente studente);

	public void delete(Studente studente);

	public List<Studente> getList();

	public List<Studente> getByNome(String nome);

	public List<Studente> getByCognome(String cognome);

	public List<Studente> getByAula(Aula aula);
}
