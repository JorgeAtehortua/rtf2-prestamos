package com.edu.udea.dto;
/**
 * Clase que representa el pojo del tipoDocumento del sistema, por tanto solo posee los metodos accesores y modificadores
 * @author Cristian Fernando Ospina
 * @author David Alejandro Florez
 * @author Jason Angel
 *
 */	
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
