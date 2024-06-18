package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;

@Component

public class CollectionMateria {
	
	
	private static List<Materia> materias = new ArrayList<Materia>(); 
	

	/**
	 * Devuelve un arrayList de objetos de la clase Materia
	 * @return
	 */
	
	public static List<Materia> getMaterias() {
		
if (materias.isEmpty()) {
			
			materias.add(new Materia("0005", "Algebra", "1ro", 100, "presencial", new Docente(9999, "Pedro", "Perez", "p@p.com", (long)154821326), null));
			materias.add(new Materia("0046", "Analisis Matematico", "2do", 100, "presencial", new Docente(5456, "Mirta", "Blanco", "mirta@blanco.com", (long)1548218787), null));
			materias.add(new Materia("0061", "Programacion Estructurada", "1ro", 100, "virtual", new Docente(9999, "Jose", "Puente", "jose@puente.com", (long)1548171115), null));	
			
		}
			
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
