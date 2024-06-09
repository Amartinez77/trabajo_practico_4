package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component

public class Materia {
	
	public String codigo;
	public String nombre;
	public String curso;
	public Integer cantHoras;
	public String modalidad;
	public Docente docente;
	public Carrera carrera;
	
	
	public Materia() {
		// TODO Auto-generated constructor stub
	}


	public Materia(String codigo, String nombre, String curso, Integer cantHoras, String modalidad, Docente docente,
			Carrera carrera) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.curso = curso;
		this.cantHoras = cantHoras;
		this.modalidad = modalidad;
		this.docente = docente;
		this.carrera = carrera;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCurso() {
		return curso;
	}


	public void setCurso(String curso) {
		this.curso = curso;
	}


	public Integer getCantHoras() {
		return cantHoras;
	}


	public void setCantHoras(Integer cantHoras) {
		this.cantHoras = cantHoras;
	}


	public String getModalidad() {
		return modalidad;
	}


	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}


	public Docente getDocente() {
		return docente;
	}


	public void setDocente(Docente docente) {
		this.docente = docente;
	}


	public Carrera getCarrera() {
		return carrera;
	}


	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	
	
	
	
}
