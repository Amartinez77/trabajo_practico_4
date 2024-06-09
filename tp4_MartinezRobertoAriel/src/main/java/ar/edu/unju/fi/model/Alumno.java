package ar.edu.unju.fi.model;


import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component

public class Alumno {
	
	public String dni;
	public String nombre;
	public String apellido;
	public String email;
	public LocalDate fechaNacimiento;
	public String domicilio;
	public Integer lu;
	
	public Alumno() {
		// TODO Auto-generated constructor stub
	}

	public Alumno(String dni, String nombre, String apellido, String email, LocalDate fechaNacimiento, String domicilio,
			Integer lu) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.domicilio = domicilio;
		this.lu = lu;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public Integer getLu() {
		return lu;
	}

	public void setLu(Integer lu) {
		this.lu = lu;
	}
	
	

}
