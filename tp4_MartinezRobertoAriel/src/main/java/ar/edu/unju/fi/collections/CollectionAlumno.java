package ar.edu.unju.fi.collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Alumno;


@Component

public class CollectionAlumno {
	
	private static List<Alumno> alumnos = new ArrayList<Alumno>();
	
	
	
	/**
	 * Metodo que devuelve un arraylist con objetos de la clase alumno
	 * @return
	 */
	
	public static List<Alumno> getAlumnos(){
		
		if (alumnos.isEmpty()) {
			
			alumnos.add(new Alumno("31988652", "ariel", "martinez", "a@a.com", LocalDate.of(1985,11,24),"pedro lozano 55",5626));
			alumnos.add(new Alumno("21651612", "aldo", "antivilo", "a@a.com", LocalDate.of(1979,11,24),"jdjdjdjjdd 5454",5854));
			alumnos.add(new Alumno("32131134", "alejandro", "ruiz", "a@a.com", LocalDate.of(1987,11,24),"wdwedwed 45",4897));
		}
		
		return alumnos;
		
	}	
	
	
	/**
	 * metodo que agrega una objeto de tipo alumno al arrayList de alumnos
	 * @param alumno
	 */
	
	public static void agregarAlumno(Alumno alumno) {
		
		alumnos.add(alumno);		
		
	}
	
	
	/**
	 * metodo que recibe un dni y con un iterador recorre el arraylist de alumnos
	 * comparando el codigo del objeto, al encontrarlo lo elimina
	 * @param dni
	 */
	
	public static void eliminarAlumno(String dni){
		
		Iterator<Alumno> iterator = alumnos.iterator();
		
		while (iterator.hasNext()) {
			
			if(iterator.next().getDni().equals(dni)) {
				
				iterator.remove();				
				
			}
			
		}
		
	}
	
	
	/**
	 * metodo que recibe un objeto de tipo Alumno, luego recorre el arraylist comparando el dni del alumno
	 * al encontrarlo (mediante un if) setea los valores en el objeto original
	 * @param alumno
	 */
	
	public static void modificarAlumno(Alumno alumno) {
		
		for (Alumno alu : alumnos ) {
			
			if(alu.getDni().equals(alumno.getDni())) {
				
				alu.setNombre(alumno.getNombre());
				alu.setApellido(alumno.getApellido());
				alu.setEmail(alumno.getEmail());
				alu.setFechaNacimiento(alumno.getFechaNacimiento());
				alu.setDomicilio(alumno.getDomicilio());
				alu.setLu(alumno.getLu());
				
				
			}else {
				
				System.out.println("no se encontró alumno");
				
			}
			
		}
		
		
		
	}
	
	
	/**
	 * metodo que recibe un dni de tipo String, mediante un predicate fitra el objeto que coincida con el codigo enviado por parametro
	 * luego mediante un flujo stream con el filtro del predicate fitra la primera coincidencia.
	 * si se encuentra el alumno devuelve el objeto buscado, sino lo encuentra, devuelve null
	 * @param dni
	 * @return
	 */
	
	public static Alumno buscarAlumno(String dni) {
		
		Predicate<Alumno> filterAlumno = c -> c.getDni().equals(dni);
		Optional<Alumno> alumno = alumnos.stream().filter(filterAlumno).findFirst();
		
		if (alumno.isPresent()) {
			
			return alumno.get();
			
		}else {
			
			return null;
			
		}
		
	}
	

}
