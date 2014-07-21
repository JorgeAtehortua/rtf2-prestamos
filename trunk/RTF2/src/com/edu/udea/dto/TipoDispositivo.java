package com.edu.udea.dto;

public class TipoDispositivo {
	private String tipoDispositivo;
	private String descripcion;
	
	public TipoDispositivo(){
		
	}

	public TipoDispositivo(String tipoDispositivo, String descripcion) {
		super();
		this.tipoDispositivo = tipoDispositivo;
		this.descripcion = descripcion;
	}

	public String getTipoDispositivo() {
		return tipoDispositivo;
	}

	public void setTipoDispositivo(String tipoDispositivo) {
		this.tipoDispositivo = tipoDispositivo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
		
}
