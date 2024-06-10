package ar.edu.unju.fi.collections;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;


import ar.edu.unju.fi.model.Docente;

@Component

public class CollectionDocente {
	
	
	private static List<Docente> docentes = new ArrayList<Docente>();
	
	
	/**
	 * Devuelve un arrayList de objetos de la clase Docente
	 * @return
	 */
	
	public static List<Docente> getDocentes(){
		
		
		if (docentes.isEmpty()) {
			
			docentes.add(new Docente(1001, "Carlos", "Merida", "a@a.com", (long) 15465485));
			docentes.add(new Docente(1002, "Laura", "Paz", "a@a.com", (long) 15465485));
			docentes.add(new Docente(1003, "Pedro", "Aguirre", "a@a.com", (long) 15465485));		
			
		}
			
			return docentes;		
		
	}
	
	
	/**
	 * Agrega un objeto de la clase Docente al arrayList
	 * @param docente
	 */
	
	public static void agregarDocente(Docente docente) {
		
		docentes.add(docente);
		
	}
	
	
	/**
	 * metodo que elimina un objeto del arraylist mediante removeIf y una expresion lamnba, comparando el legajo 
	 * @param legajo
	 */
	
	public static void eliminarDocente(Integer legajo) {
		
		docentes.removeIf(docente -> docente.getLegajo().equals(legajo));
		
	}
	
	
	/**
	 * Modifica un objeto de la clase Docente en el arrayList
	 * @param docente
	 */
	
	public static void modificarDocente(Docente docente) {
        for (Docente doc : docentes) {
            if (doc.getLegajo().equals(docente.getLegajo())) {
                doc.setNombre(docente.getNombre());
                doc.setApellido(docente.getApellido());
                doc.setEmail(docente.getEmail());
                doc.setTelefono(docente.getTelefono());
            }
        }
    }
	
	
	public static Docente buscarDocente(Integer legajo) {
	    Predicate<Docente> filterDocente = doc -> doc.getLegajo().equals(legajo);

	    Optional<Docente> docente = docentes.stream().filter(filterDocente).findFirst();

	    return docente.orElse(null);
	}


}
