package com.edu.udea.dao;

import java.util.List;

import com.edu.udea.dto.Rol;
import com.edu.udea.util.exception.DAOException;

public interface RolDAO {
	
	public Rol obtenerRol(String r) throws DAOException;
	
	public List<Rol> obtenerRoles() throws DAOException;	

}
