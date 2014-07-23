package com.edu.udea.bl.impl;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import com.edu.udea.bl.InvestigadorBL;
import com.edu.udea.dao.DispositivoDAO;
import com.edu.udea.dao.SolicitudDAO;
import com.edu.udea.dto.Dispositivo;
import com.edu.udea.dto.Solicitud;
import com.edu.udea.dto.Usuario;
import com.edu.udea.util.exception.BLException;
import com.edu.udea.util.exception.DAOException;

public class InvestigadorBLImplements implements InvestigadorBL {
	
	private DispositivoDAO dispositivoDAO;
	
	private SolicitudDAO solicitudDAO;
	
	public SolicitudDAO getSolicitudDAO() {
		return solicitudDAO;
	}

	public void setSolicitudDAO(SolicitudDAO solicitudDAO) {
		this.solicitudDAO = solicitudDAO;
	}

	public DispositivoDAO getDispositivoDAO() throws DAOException, BLException {
		return dispositivoDAO;
	}
	
	public void setDispositivoDAO(DispositivoDAO dispositivo) throws DAOException, BLException {
		dispositivoDAO=dispositivo;
	}
	
	@Override
	public Dispositivo consultarDispositivo(Integer idDispositivo)
			throws BLException, DAOException {
		Dispositivo dispositivo= null;
		dispositivo = getDispositivoDAO().obtenerDispositivo(idDispositivo);
		
		if (dispositivo == null)
            throw new BLException("No hay ningun dispositivo con el id : "
                            + idDispositivo);
		return dispositivo;
	}

	@Override
	public List<Dispositivo> consultarDispositivos() throws BLException,
			DAOException {
		List<Dispositivo> dispositivos= null;
		dispositivos = getDispositivoDAO().obtenerDispositivos();
		
		if(dispositivos==null)
			throw new BLException("No hay dispositivos");
		return dispositivos;
	}

	@Override
	public Solicitud consultarSolicitud(int idSolicitud) throws DAOException, BLException {
		Solicitud solicitud= null;
		solicitud = getSolicitudDAO().obtenerSolicitud(idSolicitud);
		
		if (solicitud == null)
            throw new BLException("No hay ninguna solicitud con el id : "
                            + idSolicitud);
		return solicitud;		
	}

	@Override
	public List<Solicitud> consultarSolicitudes() throws DAOException, BLException {
		List<Solicitud> solicitudes= null;
		solicitudes = getSolicitudDAO().obtenerSolicitudes();
		
		if (solicitudes == null)
            throw new BLException("No hay solicitudes");
		return solicitudes;		
	}
	/**
	 * @param idSolicitud idSolicitud
	 */
	@Override
	public void crearSolicitud(int idSolicitud, Date fechaSolicitud, Date fechaPrestamo,
			Time horaInicioPrestamo, Time horaFinPrestamo, int cantidad,
			Usuario usuario, Dispositivo dispositivo) throws DAOException {
	
		Solicitud solicitud;
		solicitud= new Solicitud(idSolicitud, fechaSolicitud, fechaPrestamo, horaInicioPrestamo, 
				horaFinPrestamo, cantidad, usuario, dispositivo);
		getSolicitudDAO().agregarSolicitud(solicitud);	
		
	}

	@Override
	public void modificarrSolicitud(int idSolicitud, Date fechaSolicitud, Date fechaPrestamo,
			Time horaInicioPrestamo, Time horaFinPrestamo, int cantidad,
			Usuario usuario, Dispositivo dispositivo) throws DAOException {
		
		Solicitud solicitud;
		solicitud= new Solicitud(idSolicitud, fechaSolicitud, fechaPrestamo, horaInicioPrestamo, 
				horaFinPrestamo, cantidad, usuario, dispositivo);
		getSolicitudDAO().modificarrSolicitud(solicitud);	
		
	}

	@Override
	public void eliminarSolicitud(int idSolicitud) throws DAOException {
		
		Solicitud solicitud;
		solicitud= new Solicitud();
		solicitud.setIdSolicitud(idSolicitud);
		getSolicitudDAO().eliminarSolicitud(solicitud);
		
	}

}
