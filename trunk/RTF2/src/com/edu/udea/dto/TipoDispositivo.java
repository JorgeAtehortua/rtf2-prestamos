package com.edu.udea.dto;
/**
 * Clase que representa el pojo del tipoDispositivo del sistema, por tanto solo posee los metodos accesores y modificadores
 * @author Cristian Fernando Ospina
 * @author David Alejandro Florez
 * @author Jason Angel
 *
 */	
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
