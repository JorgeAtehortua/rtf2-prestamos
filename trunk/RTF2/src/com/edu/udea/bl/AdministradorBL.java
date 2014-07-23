package com.edu.udea.bl;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import com.edu.udea.dto.Dispositivo;
import com.edu.udea.dto.Prestamo;
import com.edu.udea.dto.Solicitud;
import com.edu.udea.dto.TipoDispositivo;
import com.edu.udea.dto.Usuario;
import com.edu.udea.util.exception.BLException;
import com.edu.udea.util.exception.DAOException;

public interface AdministradorBL {
	
	public Dispositivo consultarDispositivo(Integer idDispositivo) throws BLException, DAOException;
	
	public List<Dispositivo> consultarDispositivos() throws BLException, DAOException;
	
	public void crearDispositivo(int idDispositivo, String nombreDispositivo,
			String descripcionDispositivo, int cantidad, int disponibles,
			TipoDispositivo tipoDispositivo) throws DAOException;
	
	public void eliminarDispositivo(int idDispositivo) throws DAOException;
	
	public void modificarDispositivo(int idDispositivo, String nombreDispositivo,
			String descripcionDispositivo, int cantidad, int disponibles,
			TipoDispositivo tipoDispositivo) throws DAOException;
	
	
	public Solicitud consultarSolicitud(int idSolicitud) throws BLException, DAOException;
	
	public List<Solicitud> consultarSolicitudes() throws BLException, DAOException;
	
	public Prestamo consultarPrestamo(int id) throws BLException, DAOException;
	
	public List<Prestamo> consultarPrestamos() throws BLException, DAOException;
	
	public void crearPrestamo(int idPrestamo, Date fechaPrestamo, Time horaInicio,
			Time horaFin, Time horaEntrega, int cantidad, String observacion,
			Usuario usuario, Dispositivo dispositivo) throws BLException, DAOException;
	
	public void modificarPrestamo(int idPrestamo, Date fechaPrestamo, Time horaInicio,
			Time horaFin, Time horaEntrega, int cantidad, String observacion,
			Usuario usuario, Dispositivo dispositivo) throws BLException, DAOException;
	
	public void eliminarPrestamo(int idPrestamo) throws BLException, DAOException;
	
	public TipoDispositivo consultarTipoDispositivo(String tipoD) throws BLException, DAOException;
	
	public List<TipoDispositivo> consultarTiposDispositivos() throws BLException, DAOException;
	
	public void crearTipoDispositivo(String tipoDispositivo, String descripcion) throws BLException, DAOException;
	
	public void eliminarTipoDispositivo(String tipoDispositivo) throws BLException, DAOException;
	
	public void actualizarTipoDispositivo(String tipoDispositivo, String descripcion) throws BLException, DAOException;

	
	
	
	
	
}
