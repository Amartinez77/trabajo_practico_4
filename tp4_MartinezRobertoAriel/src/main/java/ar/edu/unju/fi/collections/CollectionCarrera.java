package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Carrera;

@Component

public class CollectionCarrera {
	
	private static List<Carrera> carreras = new ArrayList<Carrera>();
	
	
	/**
	 * Metodo que devuelve un arraylist con objetos de la clase Carrera
	 * @return
	 */
	
	
	public static List<Carrera> getCarreras() {
		
		if (carreras.isEmpty()) {
			
			carreras.add(new Carrera(1, "A.P.U.", (byte)3, true));
			carreras.add(new Carrera(2, "Ingenieria Informática", (byte)5, true));
			carreras.add(new Carrera(3, "Ingenieria Química", (byte)5, false));

		}
		
		return carreras;
		
	}
	
	
	/**
	 * metodo que agrega una objeto de tipo carrera al arrayList de carreras
	 * @param carrera
	 */
	
	public static void agregarCarrera(Carrera carrera) {
		
		carreras.add(carrera);
		
	}
	
	
	/**
	 * metodo que recibe un codigoCarrera y con un iterador recorre el arraylist de carreras
	 * comparando el codigo del objeto, al encontrarlo lo elimina
	 * @param codigoCarrera
	 */
	
	public static void eliminarCarrera(int codigoCarrera) {
		
		Iterator<Carrera> iterator = carreras.iterator();
		
		while(iterator.hasNext()) {
			
			if (iterator.next().getCodigo() == codigoCarrera) {
				
				iterator.remove();
				
			}			
			
		}		
		
	}
	
	
	/**
	 * metodo que recibe un objeto de tipo carrera, luego recorre el arraylist comparando el codigo de carrera
	 * al encontrarlo (mediante un if) setea los valores en el objeto original
	 * @param carrera
	 */
	
	
	public static void modificarCarrera(Carrera carrera) {
		
		for(Carrera carre: carreras ) {
			
			if (carre.getCodigo() == carrera.getCodigo()) {
				carre.setNombre(carrera.getNombre());
				carre.setCantAnios(carrera.getCantAnios());
				carre.setEstado(carrera.getEstado());
				
			}else {
				
				System.out.println("No se encuentra el codigo de carrera");
				
			}			
			
		}	
		
	}
	
	
	/**
	 * metodo que recibe un codigo de tipo entero, mediante un predicate fitra el objeto que coincida con el codigo enviado por parametro
	 * lugo mediante un flujo stream con el filtro del predicate fitra la primera coincidencia.
	 * si se encuentra la carrera devuelve el objeto buscado sino lo encuentral devuelve null
	 * @param codigo
	 * @return
	 */
	
	public static Carrera buscarCarrera(int codigo) {		
		
		Predicate<Carrera> filterCodigo = c -> c.getCodigo() == codigo;
		Optional<Carrera> carrera = carreras.stream().filter(filterCodigo).findFirst();
		
		if (carrera.isPresent()) {
			
			return carrera.get();
			
		}else {
			
			return null;
			
		}	
		
	}
	
	
	
}
