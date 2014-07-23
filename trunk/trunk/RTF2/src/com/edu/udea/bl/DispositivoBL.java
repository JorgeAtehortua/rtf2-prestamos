package com.edu.udea.bl;

import java.util.List;

import com.edu.udea.dto.Dispositivo;
import com.edu.udea.dto.TipoDispositivo;
import com.edu.udea.util.exception.DAOException;

public interface DispositivoBL {
	
	public Dispositivo obtenerDispositivo(Integer idDispositivo) throws DAOException;
	
	public List<Dispositivo> obtenerDispositivos() throws DAOException;
	
	public void agregarDispositivo(int idDispositivo, String nombreDispositivo,
			String descripcionDispositivo, int cantidad, int disponibles,
			TipoDispositivo tipoDispositivo) throws DAOException;
	
	public void eliminarDispositivo(Integer idDispositivo) throws DAOException;
	
	public void actualizarDispositivo(Integer idDispositivo) throws DAOException;

}
