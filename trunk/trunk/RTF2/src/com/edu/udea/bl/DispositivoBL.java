package com.edu.udea.bl;

import java.util.List;

import com.edu.udea.dao.DispositivoDAO;
import com.edu.udea.dto.Dispositivo;
import com.edu.udea.dto.TipoDispositivo;
import com.edu.udea.util.exception.BLException;
import com.edu.udea.util.exception.DAOException;

public interface DispositivoBL {
		
	public Dispositivo obtenerDispositivo(Integer idDispositivo) throws DAOException, BLException;
	
	public List<Dispositivo> obtenerDispositivos() throws DAOException, BLException;
	
	public void agregarDispositivo(int idDispositivo, String nombreDispositivo,
			String descripcionDispositivo, int cantidad, int disponibles,
			TipoDispositivo tipoDispositivo) throws DAOException, BLException;
	
	public void eliminarDispositivo(Integer idDispositivo) throws DAOException, BLException;
	
	public void actualizarDispositivo(Integer idDispositivo) throws DAOException, BLException;

}
