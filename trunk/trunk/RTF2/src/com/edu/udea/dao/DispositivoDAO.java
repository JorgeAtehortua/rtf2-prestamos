package com.edu.udea.dao;

import java.util.List;

import com.edu.udea.dto.Dispositivo;
import com.edu.udea.util.exception.DAOException;

/**
 * Interface que define los metodos que va a proveer el dao de dispositivo
 * @author Cristian Fernando Ospina
 * @author David Alejandro Florez
 * @author Jason Angel
 *
 */
public interface DispositivoDAO {
	
	/**
	 * Entrega la lista de todos los dispositivos existentes en base de datos
	 * @return lista dispositivos
	 * @throws DAOException
	 */
	public List<Dispositivo> obtenerDispositivos() throws DAOException;
	
	/**
	 * Entrega los datos de un dispositivo dado su id
	 * @param id id del dispositivo
	 * @return instancia con los datos del dispositivo obtenido, si no existe el disposito retorna null.
	 * @throws DAOException
	 */
	public Dispositivo obtenerDispositivo(Integer id) throws DAOException;
	
	/**
	 * Agrega un dispositivo
	 * @param dispositivo dispositivo a agregar
	 * @return void
	 * @throws DAOException
	 */
	public void agregarDispositivo(Dispositivo dispositivo) throws DAOException;
	
	/**
	 * Elimina un dispositivo
	 * @param dispositivo dispositivo a eliminar
	 * @return void
	 * @throws DAOException
	 */
	public void eliminarDispositivo(Dispositivo dispositivo) throws DAOException;
	
	/**
	 * Actualiza un dispositivo
	 * @param dispositivo dispositivo a actualizar
	 * @return void
	 * @throws DAOException
	 */
	public void actualizarDispositivo(Dispositivo dispositivo) throws DAOException;
	

}
