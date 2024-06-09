package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component

public class Carrera {
	
	public Integer codigo;
	public String nombre;
	public Byte cantAnios;
	public Boolean estado;
	
	public Carrera() {
		// TODO Auto-generated constructor stub
	}

	public Carrera(Integer codigo, String nombre, Byte cantAnios, Boolean estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.cantAnios = cantAnios;
		this.estado = estado;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Byte getCantAnios() {
		return cantAnios;
	}

	public void setCantAnios(Byte cantAnios) {
		this.cantAnios = cantAnios;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

}
