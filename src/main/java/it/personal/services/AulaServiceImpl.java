package it.personal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.personal.model.Aula;
import it.personal.model.Studente;
import it.personal.repository.AulaRepository;

@Service
public class AulaServiceImpl implements AulaService {

	@Autowired
	private AulaRepository aulaDao;

	@Override
	public Aula saveOrUpdate(Aula aula) {
		return aulaDao.save(aula);
	}

	@Override
	public void delete(Aula aula) {
		List<Aula> tempList = getList();
		boolean check = false;
		for (Aula aula2 : tempList) {
			if (aula.equals(aula2)) {
				aulaDao.delete(aula);
				check = true;
			}
		}
		if (!check)
			System.out.println("Nessuno studente trovato");
	}

	@Override
	public List<Aula> getList() {
		return (List<Aula>) aulaDao.findAll();
	}

	@Override
	public List<Studente> getListStudenti(Aula aula) {
		List<Aula> tempList = getList();

		for (Aula aula2 : tempList) {
			if (aula2.equals(aula)) {
				return aula2.getListStudenti();
			}
		}

		System.out.println("Non ci sono studenti in quest'aula");
		return null;
	}

}
