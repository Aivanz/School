package it.personal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Aula {
	@Id
	@GeneratedValue
	private int id;
	@Enumerated(EnumType.STRING)
	private Anno anno;
	@Enumerated(EnumType.STRING)
	private Sezione sezione;
	@ManyToMany(mappedBy = "listAule")
	@JsonIgnore
	private List<Professore> listProfessori;
	@OneToMany(mappedBy = "aula")
	@JsonIgnore
	private List<Studente> listStudenti;

	public Aula() {
		listProfessori = new ArrayList<>();
		listStudenti = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Anno getAnno() {
		return anno;
	}

	public void setAnno(Anno anno) {
		this.anno = anno;
	}

	public Sezione getSezione() {
		return sezione;
	}

	public void setSezione(Sezione sezione) {
		this.sezione = sezione;
	}

	public List<Professore> getListProfessori() {
		return listProfessori;
	}

	public void setListProfessori(List<Professore> listProfessori) {
		this.listProfessori = listProfessori;
	}

	public List<Studente> getListStudenti() {
		return listStudenti;
	}

	public void setListStudenti(List<Studente> listStudenti) {
		this.listStudenti = listStudenti;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anno == null) ? 0 : anno.hashCode());
		result = prime * result + ((sezione == null) ? 0 : sezione.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aula other = (Aula) obj;
		if (anno != other.anno)
			return false;
		if (sezione != other.sezione)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aula [id=" + id + ", anno=" + anno + ", sezione=" + sezione + "]";
	}

}
