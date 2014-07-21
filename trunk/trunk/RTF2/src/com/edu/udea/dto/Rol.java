package com.edu.udea.dto;

public class Rol {
	
	private String rol;
	private String descripcion;
	
	public Rol(){
		
	}

	public Rol(String rol, String descripcion) {
		super();
		this.rol = rol;
		this.descripcion = descripcion;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
