package com.edu.udea.dto;
/**
 * Clase que representa el pojo de dispositivo del sistema, por tanto solo posee los metodos accesores y modificadores
 * @author Cristian Fernando Ospina
 * @author David Alejandro Florez
 * @author Jason Angel
 *
 */	
public class Dispositivo {
	
	private int idDispositivo;
	private String nombreDispositivo;
	private String descripcionDispositivo;
	private int cantidad;
	private int disponibles;
	private TipoDispositivo tipoDispositivo;
	
	public Dispositivo(){
		
	}
	
	public Dispositivo(int idDispositivo, String nombreDispositivo,
			String descripcionDispositivo, int cantidad, int disponibles,
			TipoDispositivo tipoDispositivo) {
		super();
		this.idDispositivo = idDispositivo;
		this.nombreDispositivo = nombreDispositivo;
		this.descripcionDispositivo = descripcionDispositivo;
		this.cantidad = cantidad;
		this.disponibles = disponibles;
		this.tipoDispositivo = tipoDispositivo;
	}

	public int getIdDispositivo() {
		return idDispositivo;
	}

	public void setIdDispositivo(int idDispositivo) {
		this.idDispositivo = idDispositivo;
	}

	public String getNombreDispositivo() {
		return nombreDispositivo;
	}

	public void setNombreDispositivo(String nombreDispositivo) {
		this.nombreDispositivo = nombreDispositivo;
	}

	public String getDescripcionDispositivo() {
		return descripcionDispositivo;
	}

	public void setDescripcionDispositivo(String descripcionDispositivo) {
		this.descripcionDispositivo = descripcionDispositivo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getDisponibles() {
		return disponibles;
	}

	public void setDisponibles(int disponibles) {
		this.disponibles = disponibles;
	}

	public TipoDispositivo getTipoDispositivo() {
		return tipoDispositivo;
	}

	public void setTipoDispositivo(TipoDispositivo tipoDispositivo) {
		this.tipoDispositivo = tipoDispositivo;
	}	
	
	
}
