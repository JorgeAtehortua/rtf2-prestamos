package com.edu.udea.bl;

import java.util.List;

import com.edu.udea.dto.Dispositivo;
import com.edu.udea.util.exception.BLException;
import com.edu.udea.util.exception.DAOException;

public interface UsuarioBL {
	
	public Dispositivo consultarDispositivo(Integer idDispositivo) throws BLException, DAOException;
	
	public List<Dispositivo> consultarDispositivos() throws BLException, DAOException;
	

}
