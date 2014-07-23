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

	public SolicitudDAO getSolicitudDAO() {
		return solicitudDAO;
	}

	public void setSolicitudDAO(SolicitudDAO solicitudDAO) {
		this.solicitudDAO = solicitudDAO;
	}

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
	public void crearDispositivo(int idDispositivo, String nombreDispositivo,
			String descripcionDispositivo, int cantidad, int disponibles,
			TipoDispositivo tipoDispositivo) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarDispositivo(int idDispositivo) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarDispositivo(int idDispositivo,
			String nombreDispositivo, String descripcionDispositivo,
			int cantidad, int disponibles, TipoDispositivo tipoDispositivo)
			throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Prestamo consultarPrestamo(int id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Prestamo> consultarPrestamos() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crearPrestamo(int idPrestamo, Date fechaPrestamo,
			Time horaInicio, Time horaFin, Time horaEntrega, int cantidad,
			String observacion, Usuario usuario, Dispositivo dispositivo)
			throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarPrestamo(int idPrestamo, Date fechaPrestamo,
			Time horaInicio, Time horaFin, Time horaEntrega, int cantidad,
			String observacion, Usuario usuario, Dispositivo dispositivo)
			throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarPrestamo(int idPrestamo) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TipoDispositivo obtenerTipoDispositivo(String tipoD)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoDispositivo> obtenerTiposDispositivos() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crearTipoDispositivo(String tipoDispositivo, String descripcion)
			throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarTipoDispositivo(TipoDispositivo tipoDispositivo)
			throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarTipoDispositivo(String tipoDispositivo,
			String descripcion) throws DAOException {
		// TODO Auto-generated method stub
		
	}

}
