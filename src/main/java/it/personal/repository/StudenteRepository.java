package it.personal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.personal.model.Studente;

public interface StudenteRepository extends CrudRepository<Studente, Integer> {
	public List<Studente> getByNome(String nome);

	public List<Studente> getByCognome(String cognome);
}
