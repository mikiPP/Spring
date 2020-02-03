package org.formacio.component;

import org.springframework.stereotype.Repository;

import java.util.Collection;


public interface RepositoriAlumnes {

	String obteAlumne(int id);
	
	void altaAlumne(int id, String nom);
	
	Collection<String> llistaAlumnes();
}
