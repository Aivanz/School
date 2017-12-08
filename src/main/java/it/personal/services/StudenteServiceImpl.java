package it.personal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.personal.model.Aula;
import it.personal.model.Studente;
import it.personal.repository.StudenteRepository;

@Service
public class StudenteServiceImpl implements StudenteService {

	@Autowired
	private StudenteRepository studenteDao;

	@Override
	public Studente saveOrUpdate(Studente studente) {
		return studenteDao.save(studente);
	}

	@Override
	public void delete(Studente studente) {
		List<Studente> tempList = getList();
		boolean check = false;

		for (Studente studente2 : tempList) {
			if (studente.equals(studente2)) {
				studenteDao.delete(studente2);
				check = true;
			}
		}

		if (!check)
			System.out.println("Nessuno studente trovato");

	}

	@Override
	public List<Studente> getList() {
		return (List<Studente>) studenteDao.findAll();
	}

	@Override
	public List<Studente> getByNome(String nome) {
		return studenteDao.getByNome(nome);
	}

	@Override
	public List<Studente> getByCognome(String cognome) {
		return studenteDao.getByCognome(cognome);
	}

	@Override
	public List<Studente> getByAula(Aula aula) {
		List<Studente> tempStudenti = getList();

		for (Studente studente : tempStudenti) {
			if (!(studente.getAula().equals(aula)))
				tempStudenti.remove(studente);
		}

		return tempStudenti;
	}

}
