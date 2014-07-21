package com.edu.udea.dao;

import java.util.List;

import com.edu.udea.dto.TipoDocumento;
import com.edu.udea.util.exception.DAOException;

public interface TipoDocumentoDAO {
	
	public TipoDocumento obtenerTipoDocumento(String tipo) throws DAOException;
	
	public List<TipoDocumento> obtenerTipoDocumento() throws DAOException;
	
	public void AgregarTipoDocumento(TipoDocumento tipo) throws DAOException;
	 
	public void EliminarTipoDocumento(TipoDocumento tipo) throws DAOException;
	
	public void ActualizarTipoDocumento(TipoDocumento tipo) throws DAOException;
		
	
}
