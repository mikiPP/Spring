package org.formacio.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServeiAlumnat {

	private RepositoriAlumnes repositori;


	@Autowired
	public  void inicialitzacio(RepositoriAlumnes repositori){
		this.repositori = repositori;
		repositori.altaAlumne(1,"Antonia");
		repositori.altaAlumne(2,"Joan");
	}


	
	/**
	 * ha de donar d'alta a la base de dades d'alumnes l'alumne indicat amb 
	 * el corresponent codi.
	 * Si el nom de l'alumne es null, no l'ha de donar d'alta
	 * Retorna true si l'alumne s'ha inserit, false si no.
	 */
	public boolean matricula (int id, String alumne) {

		if (alumne == null) {

			return false;
		} else {
			repositori.altaAlumne(id, alumne);
			return true;

		}
	}

	public RepositoriAlumnes getRepositori() {
		return repositori;
	}
}
