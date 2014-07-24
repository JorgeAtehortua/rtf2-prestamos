package com.edu.udea.dao;

import java.util.List;

import com.edu.udea.dto.Prestamo;
import com.edu.udea.util.exception.DAOException;
/**
 * Interface que define los metodos que va a proveer el dao de prestamo
 * @author Cristian Fernando Ospina
 * @author David Alejandro Florez
 * @author Jason Angel
 *
 */
public interface PrestamoDAO {
	/**
	 * Entrega los datos de un prestamo dado su id
	 * @param id id del prestamo
	 * @return instancia con los datos del prestamo obtenido, si no existe el prestamo retorna null.
	 * @throws DAOException
	 */
	public Prestamo obtenerPrestamo(int id) throws DAOException;
	/**
	 * Entrega la lista de todos los prestamos existentes en base de datos
	 * @return lista prestamos
	 * @throws DAOException
	 */
	public List<Prestamo> obtenerPrestamos() throws DAOException;
	/**
	 * Agrega un prestamo
	 * @param prestamo prestamo a agregar
	 * @return void
	 * @throws DAOException
	 */
	public void agregarPrestamo(Prestamo prestamo) throws DAOException;
	/**
	 * Actualiza un prestamo
	 * @param prestamo prestamo a actualizar
	 * @return void
	 * @throws DAOException
	 */
	public void modificarPrestamo(Prestamo prestamo) throws DAOException;
	/**
	 * Elimina un prestamo
	 * @param prestamo prestamo a eliminar
	 * @return void
	 * @throws DAOException
	 */
	public void eliminarPrestamo(Prestamo prestamo) throws DAOException;

}
