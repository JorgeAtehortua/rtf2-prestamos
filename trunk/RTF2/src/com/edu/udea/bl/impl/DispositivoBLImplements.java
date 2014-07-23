package com.edu.udea.bl.impl;

import java.util.List;

import com.edu.udea.bl.DispositivoBL;
import com.edu.udea.dao.DispositivoDAO;
import com.edu.udea.dto.Dispositivo;
import com.edu.udea.dto.TipoDispositivo;
import com.edu.udea.util.exception.BLException;
import com.edu.udea.util.exception.DAOException;

public class DispositivoBLImplements implements DispositivoBL {

	private DispositivoDAO dispositivoDAO;
	
	
	public DispositivoDAO getDispositivoDAO() throws DAOException, BLException {
		return dispositivoDAO;
	}
	
	public void setDispositivoDAO(DispositivoDAO dispositivo) throws DAOException, BLException {
		dispositivoDAO=dispositivo;
	}
	
	@Override
	public Dispositivo obtenerDispositivo(Integer idDispositivo)
			throws DAOException, BLException {
		Dispositivo dispositivo= null;
		dispositivo = getDispositivoDAO().obtenerDispositivo(idDispositivo);
		
		if (dispositivo == null)
            throw new BLException("No hay ningun dispositivo con el id : "
                            + idDispositivo);
		return dispositivo;
	}

	@Override
	public List<Dispositivo> obtenerDispositivos() throws DAOException, BLException {
		List<Dispositivo> dispositivos= null;
		dispositivos = getDispositivoDAO().obtenerDispositivos();
		
		if(dispositivos==null)
			throw new BLException("No hay dispositivos");
		return dispositivos;
	}

	@Override
	public void agregarDispositivo(int idDispositivo, String nombreDispositivo,
			String descripcionDispositivo, int cantidad, int disponibles,
			TipoDispositivo tipoDispositivo) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarDispositivo(Integer idDispositivo) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarDispositivo(Integer idDispositivo)
			throws DAOException {
		// TODO Auto-generated method stub
		
	}
	

}
