package it.personal.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.personal.model.Anno;
import it.personal.model.Aula;
import it.personal.model.Sezione;
import it.personal.model.Studente;
import it.personal.services.AulaService;

@RestController
@RequestMapping("/aula")
public class AulaController {

	@Autowired
	private AulaService aulaService;

	private final Logger logger = Logger.getLogger(Aula.class.getName());

	@GetMapping("/getModel")
	public Aula getModel() {
		return new Aula();
	}

	@PostMapping("/save")
	public Aula saveOrUpdate(@RequestBody Aula aula) {
		return aulaService.saveOrUpdate(aula);
	}

	@DeleteMapping("/delete")
	public void delete(@RequestHeader Anno anno, @RequestHeader Sezione sezione) {
		Aula temp = new Aula();
		temp.setAnno(anno);
		temp.setSezione(sezione);

		aulaService.delete(temp);
	}
	
	@GetMapping("/getListStudenti")
	public List<Studente> getListStudenti (@RequestHeader Anno anno, @RequestHeader Sezione sezione){
		Aula aula = new Aula();
		aula.setAnno(anno);
		aula.setSezione(sezione);
		
		return aulaService.getListStudenti(aula);
	}
	
	

}
