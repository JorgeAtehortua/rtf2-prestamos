package com.edu.udea.dao;

import java.util.List;

import com.edu.udea.dto.TipoDocumento;
import com.edu.udea.dto.Usuario;
import com.edu.udea.util.exception.DAOException;
/**
 * Interface que define los metodos que va a proveer el dao de usuario
 * @author Cristian Fernando Ospina
 * @author David Alejandro Florez
 * @author Jason Angel
 *
 */
public interface UsuarioDAO {
	/**
	 * Entrega los datos de un usuario dado su identificador
	 * @param numeroDocumento entero que identifica al usuario, tipoDocumento TipoDocumento identificador del usuario
	 * @return instancia con los datos del usuario obtenido, si no existe el usuario retorna null.
	 * @throws DAOException
	 */
	public Usuario obtenerUsuario(int numeroDocumento, TipoDocumento tipoDocumento) throws DAOException;
	/**
	 * Entrega la lista de todos los usuarios existentes en base de datos
	 * @return lista usuarios
	 * @throws DAOException
	 */	
	public List<Usuario> obtenerUsuarios() throws DAOException;
	/**
	 * Agrega un usuario
	 * @param usuario usuario a agregar
	 * @return void
	 * @throws DAOException
	 */
	public void agregarUsuario(Usuario usuario) throws DAOException;
	/**
	 * Actualiza un usuario
	 * @param usuario usuario a actualizar
	 * @return void
	 * @throws DAOException
	 */
	public void modificarUsuario(Usuario usuario) throws DAOException;
	/**
	 * Elimina un usuario
	 * @param usuario usuario a eliminar
	 * @return void
	 * @throws DAOException
	 */
	public void eliminarUsuario(Usuario usuario) throws DAOException;
}
