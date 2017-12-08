package it.personal.services;

import java.util.List;

import it.personal.model.Aula;
import it.personal.model.Studente;

public interface AulaService {
	public Aula saveOrUpdate(Aula aula);

	public void delete(Aula aula);

	public List<Aula> getList();

	public List<Studente> getListStudenti(Aula aula);
}
