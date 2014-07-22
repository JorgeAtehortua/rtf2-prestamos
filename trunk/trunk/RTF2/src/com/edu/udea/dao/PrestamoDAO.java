package com.edu.udea.dao;

import java.util.List;

import com.edu.udea.dto.Prestamo;
import com.edu.udea.util.exception.DAOException;

public interface PrestamoDAO {
	
	public Prestamo obtenerPrestamo(int id) throws DAOException;
	
	public List<Prestamo> obtenerPrestamos() throws DAOException;
	
	public void agregarPrestamo(Prestamo prestamo) throws DAOException;
	
	public void modificarPrestamo(Prestamo prestamo) throws DAOException;
	
	public void eliminarPrestamo(Prestamo prestamo) throws DAOException;

}
