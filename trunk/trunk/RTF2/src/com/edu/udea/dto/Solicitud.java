package com.edu.udea.dto;

import java.sql.Time;
import java.util.Date;
/**
 * Clase que representa el pojo de solicitud del sistema, por tanto solo posee los metodos accesores y modificadores
 * @author Cristian Fernando Ospina
 * @author David Alejandro Florez
 * @author Jason Angel
 *
 */	
public class Solicitud {

	private int idSolicitud;
	private Date fechaSolicitud;
	private Date fechaPrestamo;
	private Time horaInicioPrestamo;
	private Time horaFinPrestamo;
	private int cantidad;
	private Usuario usuario;
	private Dispositivo dispositivo;
	
	public Solicitud(){
		
	}

	public Solicitud(int idSolicitud, Date fechaSolicitud, Date fechaPrestamo,
			Time horaInicioPrestamo, Time horaFinPrestamo, int cantidad,
			Usuario usuario, Dispositivo dispositivo) {
		super();
		this.idSolicitud = idSolicitud;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaPrestamo = fechaPrestamo;
		this.horaInicioPrestamo = horaInicioPrestamo;
		this.horaFinPrestamo = horaFinPrestamo;
		this.cantidad = cantidad;
		this.usuario = usuario;
		this.dispositivo = dispositivo;
	}

	public int getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public Time getHoraInicioPrestamo() {
		return horaInicioPrestamo;
	}

	public void setHoraInicioPrestamo(Time horaInicioPrestamo) {
		this.horaInicioPrestamo = horaInicioPrestamo;
	}

	public Time getHoraFinPrestamo() {
		return horaFinPrestamo;
	}

	public void setHoraFinPrestamo(Time horaFinPrestamo) {
		this.horaFinPrestamo = horaFinPrestamo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Dispositivo getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}
	
}
