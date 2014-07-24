package com.edu.udea.dao;

import java.util.List;

import com.edu.udea.dto.Rol;
import com.edu.udea.util.exception.DAOException;
/**
 * Interface que define los metodos que va a proveer el dao de rol
 * @author Cristian Fernando Ospina
 * @author David Alejandro Florez
 * @author Jason Angel
 *
 */
public interface RolDAO {
	/**
	 * Entrega los datos de un rol dado su identificador
	 * @param r String que identificador del rol
	 * @return instancia con los datos del rol obtenido, si no existe el rol retorna null.
	 * @throws DAOException
	 */
	public Rol obtenerRol(String r) throws DAOException;
	/**
	 * Entrega la lista de todos los rols existentes en base de datos
	 * @return lista rols
	 * @throws DAOException
	 */
	public List<Rol> obtenerRoles() throws DAOException;	

}
