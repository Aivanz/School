package it.personal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import it.personal.model.Aula;
import it.personal.model.Materia;
import it.personal.model.Professore;
import it.personal.model.Studente;
import it.personal.repository.ProfessoreRepository;

@Service
public class ProfessoreServiceImpl implements ProfessoreService {

	@Autowired
	private ProfessoreRepository professoreDao;

	@Override
	public Professore saveOrUpdate(Professore professore) {
		return professoreDao.save(professore);
	}

	@Override
	public void delete(Professore professore) {
		List<Professore> tempList = getList();
		boolean check = false;

		for (Professore professore2 : tempList) {
			if (professore.equals(professore2)) {
				professoreDao.delete(professore);
				check = true;
			}
		}

		if (!check)
			System.out.println("Nessun professore trovato");
	}

	@Override
	public List<Professore> getList() {
		return (List<Professore>) professoreDao.findAll();
	}

	@Override
	public List<Professore> getByMateria(Materia materia) {
		List<Professore> tempList = getList();

		for (Professore professore : tempList) {
			if (!(professore.getMateria().equals(materia)))
				tempList.remove(professore);
		}

		return tempList;
	}

	@Override
	public List<Professore> getByNome(String nome) {
		return professoreDao.getByNome(nome);
	}

	@Override
	public List<Professore> getByCognome(String cognome) {
		return professoreDao.getByCognome(cognome);
	}

	@Override
	public List<Professore> getByAula(Aula aula) {
		List<Professore> tempList = getList();

		for (Professore professore : tempList) {
			if (!(professore.getListAule().contains(aula)))
				tempList.remove(professore);
		}

		return tempList;
	}

}
