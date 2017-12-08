package it.personal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.personal.model.Professore;

public interface ProfessoreRepository extends CrudRepository<Professore, Integer> {

	public List<Professore> getByNome(String nome);

	public List<Professore> getByCognome(String cognome);

}
