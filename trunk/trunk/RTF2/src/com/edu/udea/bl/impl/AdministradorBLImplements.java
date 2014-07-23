package com.edu.udea.bl.impl;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import com.edu.udea.bl.AdministradorBL;
import com.edu.udea.bl.InvestigadorBL;
import com.edu.udea.dao.DispositivoDAO;
import com.edu.udea.dao.PrestamoDAO;
import com.edu.udea.dao.SolicitudDAO;
import com.edu.udea.dao.TipoDispositivoDAO;
import com.edu.udea.dto.Dispositivo;
import com.edu.udea.dto.Prestamo;
import com.edu.udea.dto.Solicitud;
import com.edu.udea.dto.TipoDispositivo;
import com.edu.udea.dto.Usuario;
import com.edu.udea.util.exception.BLException;
import com.edu.udea.util.exception.DAOException;

public class AdministradorBLImplements  implements AdministradorBL  {
	
	private PrestamoDAO prestamoDAO;
	
	private SolicitudDAO solicitudDAO;
	
	private DispositivoDAO dispositivoDAO;
	
	private TipoDispositivoDAO tipoDispositivoDAO;		
	
	public PrestamoDAO getPrestamoDAO() {
		return prestamoDAO;
	}

	public void setPrestamoDAO(PrestamoDAO prestamoDAO) {
		this.prestamoDAO = prestamoDAO;
	}
	
	/**
	 * 
	 * @return
	 */
	public SolicitudDAO getSolicitudDAO() {
		return solicitudDAO;
	}
	
	/**
	 * 
	 * @param solicitudDAO
	 */
	public void setSolicitudDAO(SolicitudDAO solicitudDAO) {
		this.solicitudDAO = solicitudDAO;
	}

	/**
	 * 
	 * @return 
	 */
	public DispositivoDAO getDispositivoDAO() {
		return dispositivoDAO;
	}

	public void setDispositivoDAO(DispositivoDAO dispositivoDAO) {
		this.dispositivoDAO = dispositivoDAO;
	}

	public TipoDispositivoDAO getTipoDispositivoDAO() {
		return tipoDispositivoDAO;
	}

	public void setTipoDispositivoDAO(TipoDispositivoDAO tipoDispositivoDAO) {
		this.tipoDispositivoDAO = tipoDispositivoDAO;
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
	public void crearDispositivo(int idDispositivo, String nombreDispositivo,
			String descripcionDispositivo, int cantidad, int disponibles,
			TipoDispositivo tipoDispositivo) throws DAOException {
		Dispositivo dispositivo= new  Dispositivo(idDispositivo, nombreDispositivo, 
				descripcionDispositivo, cantidad, disponibles, tipoDispositivo);
		getDispositivoDAO().agregarDispositivo(dispositivo);
		
		
	}

	@Override
	public void eliminarDispositivo(int idDispositivo) throws DAOException {
		Dispositivo dispositivo = new Dispositivo();
		dispositivo.setIdDispositivo(idDispositivo);
		getDispositivoDAO().eliminarDispositivo(dispositivo);
		
	}

	@Override
	public void modificarDispositivo(int idDispositivo,
			String nombreDispositivo, String descripcionDispositivo,
			int cantidad, int disponibles, TipoDispositivo tipoDispositivo)
			throws DAOException {
		Dispositivo dispositivo = new Dispositivo(idDispositivo, nombreDispositivo, 
				descripcionDispositivo, cantidad, disponibles, tipoDispositivo);
		getDispositivoDAO().actualizarDispositivo(dispositivo);
		
	}

	@Override
	public Solicitud consultarSolicitud(int idSolicitud) throws BLException,
			DAOException {
		Solicitud solicitud= null;
		solicitud = getSolicitudDAO().obtenerSolicitud(idSolicitud);
		
		if (solicitud == null)
            throw new BLException("No hay ninguna solicitud con el id : "
                            + idSolicitud);
		return solicitud;		
	}

	@Override
	public List<Solicitud> consultarSolicitudes() throws BLException,
			DAOException {
		List<Solicitud> solicitudes= null;
		solicitudes = getSolicitudDAO().obtenerSolicitudes();
		
		if (solicitudes == null)
            throw new BLException("No hay solicitudes");
		return solicitudes;		
	}
	
	@Override
	public Prestamo consultarPrestamo(int id) throws DAOException, BLException {
		Prestamo prestamo= getPrestamoDAO().obtenerPrestamo(id);
		
		if (prestamo == null)
            throw new BLException("No hay ningun prestamo con el id : "
                            + id);
		return prestamo;
	}

	@Override
	public List<Prestamo> consultarPrestamos() throws DAOException, BLException {
		List<Prestamo> prestamos= getPrestamoDAO().obtenerPrestamos();
		if (prestamos == null)
            throw new BLException("No hay prestamos");
		return prestamos;
	}

	@Override
	public void crearPrestamo(int idPrestamo, Date fechaPrestamo,
			Time horaInicio, Time horaFin, Time horaEntrega, int cantidad,
			String observacion, Usuario usuario, Dispositivo dispositivo)
			throws DAOException {
		Prestamo prestamo = new Prestamo(idPrestamo, fechaPrestamo, horaInicio, 
				horaFin, horaEntrega, cantidad, observacion, usuario, dispositivo);
		getPrestamoDAO().agregarPrestamo(prestamo);
		
	}

	@Override
	public void modificarPrestamo(int idPrestamo, Date fechaPrestamo,
			Time horaInicio, Time horaFin, Time horaEntrega, int cantidad,
			String observacion, Usuario usuario, Dispositivo dispositivo)
			throws DAOException {
		Prestamo prestamo = new Prestamo(idPrestamo, fechaPrestamo, horaInicio, horaFin, 
				horaEntrega, cantidad, observacion, usuario, dispositivo);
		getPrestamoDAO().modificarPrestamo(prestamo);
		
	}

	@Override
	public void eliminarPrestamo(int idPrestamo) throws DAOException {
		Prestamo prestamo = new Prestamo();
		prestamo.setIdPrestamo(idPrestamo);
		getPrestamoDAO().eliminarPrestamo(prestamo);		
		
	}

	@Override
	public TipoDispositivo consultarTipoDispositivo(String tipoD)
			throws DAOException, BLException {
		TipoDispositivo tipoDispositivo= getTipoDispositivoDAO().obtenerTipoDispositivo(tipoD);
		if (tipoDispositivo == null)
            throw new BLException("No hay un tipo dispositivo igual a " + tipoD);
		return tipoDispositivo;
	}

	@Override
	public List<TipoDispositivo> consultarTiposDispositivos() throws DAOException, BLException {
		List<TipoDispositivo> tipoDispositivos= getTipoDispositivoDAO().obtenerTiposDispositivos();
		if (tipoDispositivos == null)
            throw new BLException("No hay tipos de dispositivos" );
		return tipoDispositivos;
	}

	@Override
	public void crearTipoDispositivo(String tipoDispositivo, String descripcion)
			throws DAOException {
		TipoDispositivo tipoD= new TipoDispositivo(tipoDispositivo, descripcion);
		getTipoDispositivoDAO().agregarTipoDispositivo(tipoD);
		
	}

	@Override
	public void eliminarTipoDispositivo(String tipoDispositivo)
			throws DAOException {
		TipoDispositivo tipoD= new TipoDispositivo();
		tipoD.setTipoDispositivo(tipoDispositivo);
		getTipoDispositivoDAO().eliminarTipoDispositivo(tipoD);
		
	}
	
	@Override
	public void actualizarTipoDispositivo(String tipoDispositivo,
			String descripcion) throws DAOException {
		TipoDispositivo tipoD= new TipoDispositivo(tipoDispositivo, descripcion);
		getTipoDispositivoDAO().actualizarTipoDispositivo(tipoD);
		
	}

}
