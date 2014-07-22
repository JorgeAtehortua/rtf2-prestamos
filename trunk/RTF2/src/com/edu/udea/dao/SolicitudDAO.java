package com.edu.udea.dao;

import java.util.List;

import com.edu.udea.dto.Solicitud;
import com.edu.udea.util.exception.DAOException;

public interface SolicitudDAO {
	
	public Solicitud obtenerSolicitud(int id) throws DAOException;
	
	public List<Solicitud> obtenerSolicitudes() throws DAOException;
	
	public void agregarSolicitud(Solicitud solicitud) throws DAOException;
	
	public void modificarrSolicitud(Solicitud solicitud) throws DAOException;
	
	public void actualizarSolicitud(Solicitud solicitud) throws DAOException;
	

}
