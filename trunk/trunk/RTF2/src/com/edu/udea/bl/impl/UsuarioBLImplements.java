package com.edu.udea.bl.impl;

import java.util.List;

import com.edu.udea.bl.UsuarioBL;
import com.edu.udea.dao.DispositivoDAO;
import com.edu.udea.dto.Dispositivo;
import com.edu.udea.util.exception.BLException;
import com.edu.udea.util.exception.DAOException;

public class UsuarioBLImplements implements UsuarioBL {
	
	private DispositivoDAO dispositivoDAO;
	
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
	public List<Dispositivo> consultarDispositivos() throws BLException, DAOException {
		List<Dispositivo> dispositivos= null;
		dispositivos = getDispositivoDAO().obtenerDispositivos();
		
		if(dispositivos==null)
			throw new BLException("No hay dispositivos");
		return dispositivos;
	}

	

}
