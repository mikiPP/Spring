package org.formacio.setmana2.servei;

import java.util.ArrayList;
import java.util.List;

import org.formacio.setmana2.domini.Curs;
import org.formacio.setmana2.domini.Matricula;
import org.formacio.setmana2.repositori.EdatIncorrecteException;
import org.formacio.setmana2.repositori.RepositoriEscola;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = EdatIncorrecteException.class)
@Service
public class ServeiEscola {

	@Autowired
	private RepositoriEscola repositoriEscola;
	/**
	 * Important: els alumnes i els cursos indicats JA existeixen a la base de dades.
	 * Per tant, els hem de carregar, no crear de nou.
	 * L'excepcio EdatIncorrecteException no s'ha de capturar. S'ha de propagar cap el client
	 */
	public List<Matricula> apunta (String curs, List<String> alumnes) throws EdatIncorrecteException {
		List<Matricula> matricules = new ArrayList<>();

		for(String alumne: alumnes){
			matricules.add(repositoriEscola.apunta(alumne,curs));

		}
		return matricules;
    }
}
