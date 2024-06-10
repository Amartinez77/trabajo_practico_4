package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;


import ar.edu.unju.fi.model.Materia;

@Component

public class CollectionMateria {
	
	
	private static List<Materia> materias = new ArrayList<Materia>(); 
	

	/**
	 * Devuelve un arrayList de objetos de la clase Materia
	 * @return
	 */
	
	public static List<Materia> getMaterias() {
		
		return materias;
		
	}
	
	
	/**
	 * Agrega un objeto de la clase Materia al arrayList
	 * @param materia
	 */
	
	public static void agregarMateria(Materia materia) {
		
		materias.add(materia);
		
	}
	
	
	/**
	 * Elimina un objeto de la clase Materia en el arrayList
	 * @param codigo
	 */
	
	public static void eliminarMateria(String codigo) {
		
		Iterator<Materia> iterator = materias.iterator();
		
		while (iterator.hasNext()) {
			
			if (iterator.next().getCodigo().equals(codigo)) {
				
				iterator.remove();
				
			}
			
		}
		
		
	}
	
	
	/**
	 * Modifica un objeto de la clase Materia en el arrayList
	 * @param materia
	 */
	
	public static void modificarMateria(Materia materia) {
		
		for(Materia mat : materias) {
			
			if (mat.getCodigo().equals(materia.getCodigo())) {
				
				mat.setNombre(materia.getNombre());
				mat.setCurso(materia.getCurso());
				mat.setCantHoras(materia.getCantHoras());
				mat.setModalidad(materia.getModalidad());
				mat.setDocente(materia.getDocente());
				mat.setCarrera(materia.getCarrera());
							
				
			}			
			
		}		
		
	}
	
	
	/**
	 * Busca un objeto de la clase Materia en el arrayList
	 * @param codigo
	 * @return
	 */
	
	public static Materia buscarMateria(String codigo) {
		
		Predicate<Materia> filterMateria = c -> c.getCodigo().equals(codigo);
		
		Optional<Materia> materia = materias.stream().filter(filterMateria).findFirst();
		
		return materia.orElse(null);		
		
		
	}	
	
	
	
}
