package org.formacio.setmana1.domini;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Completa amb annotacions aquesta classe per tal que sigui una entitat
 * mapejada a la taula T_LLIBRES, tal com esta definida a src/main/resources/schema.sql
 * La clau primaria es la propietat isbn. Important: aquesta clau NO se autogenera. S'assigna des de l'aplicacio
 */

@Entity
public class Llibre {

	@Id
	private String isbn;

	@Column
	private String titol;

	@Column
	private String autor;
	@Column
	private Integer pagines;

	// fitxeu-vos que aquesta propietat, a la base de dades, se guarda com VARCHAR2, no com INT.
	// Aixo requeria d'una annotacio especifica
	@Column
	private Recomanacio recomanacio;
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getTitol() {
		return titol;
	}
	
	public void setTitol(String titol) {
		this.titol = titol;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public Integer getPagines() {
		return pagines;
	}
	
	public void setPagines(Integer pagines) {
		this.pagines = pagines;
	}
	
	public Recomanacio getRecomanacio() {
		return recomanacio;
	}
	
	public void setRecomanacio(Recomanacio recomanacio) {
		this.recomanacio = recomanacio;
	}
}
