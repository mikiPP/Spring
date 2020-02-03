package org.formacio.setmana2.repositori;

import org.formacio.setmana2.domini.Alumne;
import org.formacio.setmana2.domini.Curs;
import org.formacio.setmana2.domini.Matricula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Modifica aquesta classe per tal que sigui un component Spring que realitza les 
 * operacions de persistencia tal com indiquen les firmes dels metodes
 */
@Repository
public class RepositoriEscola {

	@PersistenceContext
	private EntityManager em;


	public Curs carregaCurs(String nom) {
		return em.find(Curs.class,nom);
	}


	public Matricula apunta (String alumne, String curs) throws EdatIncorrecteException {

	    Matricula matricula = new Matricula();
	    Alumne alumne1 = em.find(Alumne.class,alumne);
		Curs curs1 = carregaCurs(curs);

		if(alumne1.getEdat() >= curs1.getEdatMinima()){
			matricula.setAlumne(alumne1);
			matricula.setCurs(curs1);
			em.persist(matricula);

		}else {
			throw new EdatIncorrecteException();
		}

		return em.find(matricula.getClass(),matricula.getId());
	}
	
	
}
