package com.edu.udea.dao;

import java.util.List;

import com.edu.udea.dto.TipoDispositivo;
import com.edu.udea.util.exception.DAOException;

public interface TipoDispositivoDAO {
	
	public TipoDispositivo obtenerTipoDispositivo(String tipoD) throws DAOException;
	
	public List<TipoDispositivo> obtenerTiposDispositivos() throws DAOException;
	
	public void agregarTipoDispositivo(TipoDispositivo tipoDispositivo) throws DAOException;
	
	public void eliminarTipoDispositivo(TipoDispositivo tipoDispositivo) throws DAOException;
	
	public void actualizarTipoDispositivo(TipoDispositivo tipoDispositivo) throws DAOException;

}
