package it.personal.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.personal.model.Aula;
import it.personal.model.Materia;
import it.personal.model.Professore;
import it.personal.model.Studente;
import it.personal.services.AulaService;
import it.personal.services.ProfessoreService;

@RestController
@RequestMapping("/professore")
public class ProfessoreController {

	@Autowired
	private ProfessoreService professoreService;

	@Autowired
	private AulaService aulaService;

	private final Logger logger = Logger.getLogger(Professore.class.getName());

	@GetMapping("/getModel")
	public Professore getModelProfessore() {
		return new Professore();
	}

	@PostMapping("/save")
	public Professore saveOrUpdateProfessore(@RequestBody Professore professore) {
		return professoreService.saveOrUpdate(professore);
	}

	@GetMapping("/getList")
	public List<Professore> getListProfessori() {
		return professoreService.getList();
	}

	@DeleteMapping("/delete")
	public void deleteProfessore(@RequestHeader String nome, @RequestHeader String cognome) {
		Professore temp = new Professore();
		temp.setNome(nome);
		temp.setCognome(cognome);

		professoreService.delete(temp);
	}

	@PutMapping("/setAula/{id}")
	public Professore setAula(@RequestBody Aula aula, @PathVariable("id") int id) {
		List<Professore> tempList = professoreService.getList();
		List<Aula> tempAula = aulaService.getList();

		for (Aula aula2 : tempAula) {
			if (aula2.equals(aula)) {
				for (Professore professore : tempList) {
					if (professore.getId() == id) {
						if (professore.getListAule().isEmpty() || !professore.getListAule().contains(aula2)) {
							professore.getListAule().add(aula2);
							return professoreService.saveOrUpdate(professore);
						}
					}
				}
				logger.info("Nessun professore corrispondete all'id");
				return null;
			}
		}

		logger.info("Aula corrispondente non esistente");
		return null;

	}

	@GetMapping("getByMateria/{materia}")
	public List<Professore> getByMateria(@RequestParam Materia materia) {
		return professoreService.getByMateria(materia);
	}

	@GetMapping("/getByNome/{nome}")
	public List<Professore> getByNome(@RequestParam String nome) {
		return professoreService.getByNome(nome);
	}

	@GetMapping("/getByCognome/{cognome}")
	public List<Professore> getByCognome(@RequestParam String cognome) {
		return professoreService.getByCognome(cognome);
	}

	@GetMapping("/getByAula")
	public List<Professore> getByAula(@RequestBody Aula aula) {
		return professoreService.getByAula(aula);
	}

}
