package com.edu.udea.dto;

public class TipoDocumento {
	
	private String tipoDocumento;
	private String descripcion;
	
	public TipoDocumento(){
		
	}

	public TipoDocumento(String tipoDocumento, String descripcion) {
		super();
		this.tipoDocumento = tipoDocumento;
		this.descripcion = descripcion;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

}
