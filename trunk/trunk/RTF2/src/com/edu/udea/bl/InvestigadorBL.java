package com.edu.udea.bl;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import com.edu.udea.dto.Dispositivo;
import com.edu.udea.dto.Solicitud;
import com.edu.udea.dto.Usuario;
import com.edu.udea.util.exception.BLException;
import com.edu.udea.util.exception.DAOException;

public interface InvestigadorBL {
	
	public Dispositivo consultarDispositivo(Integer idDispositivo) throws BLException, DAOException;
	
	public List<Dispositivo> consultarDispositivos() throws BLException, DAOException;
	
	public Solicitud consultarSolicitud(int idSolicitud) throws BLException, DAOException;
	
	public List<Solicitud> consultarSolicitudes() throws BLException, DAOException;
	
	public void crearSolicitud(int idSolicitud, Date fechaSolicitud, Date fechaPrestamo,
			Time horaInicioPrestamo, Time horaFinPrestamo, int cantidad,
			Usuario usuario, Dispositivo dispositivo) throws BLException, DAOException;
	
	public void modificarrSolicitud(int idSolicitud, Date fechaSolicitud, Date fechaPrestamo,
			Time horaInicioPrestamo, Time horaFinPrestamo, int cantidad,
			Usuario usuario, Dispositivo dispositivo) throws BLException, DAOException;
	
	public void eliminarSolicitud(int idSolicitud) throws BLException, DAOException;

}
