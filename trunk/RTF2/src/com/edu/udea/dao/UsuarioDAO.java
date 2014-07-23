package com.edu.udea.dao;

import java.util.List;

import com.edu.udea.dto.TipoDocumento;
import com.edu.udea.dto.Usuario;
import com.edu.udea.util.exception.DAOException;

public interface UsuarioDAO {

	public Usuario obtenerUsuario(int numeroDocumento, TipoDocumento tipoDocumento) throws DAOException;
	
	public List<Usuario> obtenerUsuarios() throws DAOException;
	
	public void agregarUsuario(Usuario usuario) throws DAOException;
	
	public void modificarUsuario(Usuario usuario) throws DAOException;
	
	public void eliminarUsuario(Usuario usuario) throws DAOException;
}
