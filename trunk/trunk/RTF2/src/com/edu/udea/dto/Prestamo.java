package com.edu.udea.dto;

import java.util.Date;
import java.sql.Time;;

public class Prestamo {
	
	private int idPrestamo;
	private Date fechaPrestamo;
	private Time horaInicio;
	private Time horaFin;
	private Time horaEntrega;
	private int cantidad;
	private String observacion;
	private Usuario usuario;
	private Dispositivo dispositivo;
	
	public Prestamo(){
		
	}
	
	public Prestamo(int idPrestamo, Date fechaPrestamo, Time horaInicio,
			Time horaFin, Time horaEntrega, int cantidad, String observacion,
			Usuario usuario, Dispositivo dispositivo) {
		super();
		this.idPrestamo = idPrestamo;
		this.fechaPrestamo = fechaPrestamo;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.horaEntrega = horaEntrega;
		this.cantidad = cantidad;
		this.observacion = observacion;
		this.usuario = usuario;
		this.dispositivo = dispositivo;
	}

	public int getIdPrestamo() {
		return idPrestamo;
	}
	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}
	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}
	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}
	public Time getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Time getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(Time horaFin) {
		this.horaFin = horaFin;
	}
	public Time getHoraEntrega() {
		return horaEntrega;
	}
	public void setHoraEntrega(Time horaEntrega) {
		this.horaEntrega = horaEntrega;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
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
