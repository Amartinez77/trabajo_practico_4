package ar.edu.unju.fi.model;

public class Carrera {
	
	public Integer codigo;
	public String nombre;
	public Integer cantAnios;
	public String estado;
	
	public Carrera() {
		// TODO Auto-generated constructor stub
	}

	public Carrera(Integer codigo, String nombre, Integer cantAnios, String estado) {
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

	public Integer getCantAnios() {
		return cantAnios;
	}

	public void setCantAnios(Integer cantAnios) {
		this.cantAnios = cantAnios;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	

}
