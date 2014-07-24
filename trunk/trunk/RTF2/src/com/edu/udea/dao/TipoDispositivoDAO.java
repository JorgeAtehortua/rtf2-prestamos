package com.edu.udea.dao;

import java.util.List;

import com.edu.udea.dto.TipoDispositivo;
import com.edu.udea.util.exception.DAOException;
/**
 * Interface que define los metodos que va a proveer el dao de tipo de dispositivo
 * @author Cristian Fernando Ospina
 * @author David Alejandro Florez
 * @author Jason Angel
 *
 */
public interface TipoDispositivoDAO {
	/**
	 * Entrega los datos de un tipo de dispositivo dado su identificador
	 * @param tipoD String que identificador del tipo de dispositivo
	 * @return instancia con los datos del tipo de dispositivo obtenido, si no existe el tipo de dispositivo retorna null.
	 * @throws DAOException
	 */	
	public TipoDispositivo obtenerTipoDispositivo(String tipoD) throws DAOException;
	/**
	 * Entrega la lista de todos los tipo de dispositivos existentes en base de datos
	 * @return lista tipo de dispositivos
	 * @throws DAOException
	 */
	public List<TipoDispositivo> obtenerTiposDispositivos() throws DAOException;
	/**
	 * Agrega un tipo de dispositivo
	 * @param tipo de dispositivo tipo de dispositivo a agregar
	 * @return void
	 * @throws DAOException
	 */
	public void agregarTipoDispositivo(TipoDispositivo tipoDispositivo) throws DAOException;
	/**
	 * Elimina un tipo de dispositivo
	 * @param tipo de dispositivo tipo de dispositivo a eliminar
	 * @return void
	 * @throws DAOException
	 */
	public void eliminarTipoDispositivo(TipoDispositivo tipoDispositivo) throws DAOException;
	/**
	 * Actualiza un tipo de dispositivo
	 * @param tipo de dispositivo tipo de dispositivo a actualizar
	 * @return void
	 * @throws DAOException
	 */
	public void actualizarTipoDispositivo(TipoDispositivo tipoDispositivo) throws DAOException;

}
