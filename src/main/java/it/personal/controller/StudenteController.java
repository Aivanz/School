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
import it.personal.model.Studente;
import it.personal.services.AulaService;
import it.personal.services.StudenteService;

@RestController
@RequestMapping("/studente")
public class StudenteController {

	@Autowired
	private StudenteService studenteService;

	@Autowired
	private AulaService aulaService;

	private final Logger logger = Logger.getLogger(Studente.class.getName());

	@GetMapping("/getModel")
	public Studente getModelStudente() {
		return new Studente();
	}

	@PostMapping("/save")
	public Studente saveOrUpdateStudente(@RequestBody Studente studente) {
		return studenteService.saveOrUpdate(studente);
	}

	@PutMapping("/setAula/{id}")
	public Studente setAula(@RequestBody Aula aula, @PathVariable("id") int id) {
		List<Studente> tempList = studenteService.getList();
		List<Aula> tempAula = aulaService.getList();

		for (Aula aula2 : tempAula) {
			if (aula2.equals(aula)) {
				for (Studente studente : tempList) {
					if (studente.getId() == id) {
						if (studente.getAula() == null) {
							studente.setAula(aula2);
							return studenteService.saveOrUpdate(studente);
						}
					}
				}
				logger.info("Nessun studente corrispondete all'id");
				return null;
			}
		}

		logger.info("Aula corrispondente non esistente");
		return null;

	}

	@DeleteMapping("/delete")
	public void deleteStudente(@RequestHeader String nome, @RequestHeader String cognome) {
		Studente temp = new Studente();
		temp.setNome(nome);
		temp.setCognome(cognome);

		studenteService.delete(temp);
	}

	@GetMapping("/getList")
	public List<Studente> getListStudenti() {
		return studenteService.getList();
	}

	@GetMapping("/getByNome/{nome}")
	public List<Studente> getByNome(@RequestParam String nome) {
		return studenteService.getByNome(nome);
	}

	@GetMapping("/getByCognome/{cognome}")
	public List<Studente> getByCognome(@RequestParam String cognome) {
		return studenteService.getByCognome(cognome);
	}

	@GetMapping("/getByAula")
	public List<Studente> getByAula(@RequestBody Aula aula) {
		return studenteService.getByAula(aula);
	}

}
