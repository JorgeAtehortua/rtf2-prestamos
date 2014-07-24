package com.edu.udea.dao;

import java.util.List;

import com.edu.udea.dto.TipoDocumento;
import com.edu.udea.util.exception.DAOException;
/**
 * Interface que define los metodos que va a proveer el dao de tipoDocumento
 * @author Cristian Fernando Ospina
 * @author David Alejandro Florez
 * @author Jason Angel
 *
 */
public interface TipoDocumentoDAO {
	/**
	 * Entrega los datos de un tipoDocumento dado su identificador
	 * @param tipo String que identificador del tipoDocumento
	 * @return instancia con los datos del tipoDocumento obtenido, si no existe el tipoDocumento retorna null.
	 * @throws DAOException
	 */
	public TipoDocumento obtenerTipoDocumento(String tipo) throws DAOException;
	/**
	 * Entrega la lista de todos los tipoDocumentos existentes en base de datos
	 * @return lista tipoDocumentos
	 * @throws DAOException
	 */
	public List<TipoDocumento> obtenerTipoDocumento() throws DAOException;
	/**
	 * Agrega un tipoDocumento
	 * @param tipoDocumento tipoDocumento a agregar
	 * @return void
	 * @throws DAOException
	 */
	public void AgregarTipoDocumento(TipoDocumento tipo) throws DAOException;
	/**
	 * Elimina un tipoDocumento
	 * @param tipoDocumento tipoDocumento a eliminar
	 * @return void
	 * @throws DAOException
	 */ 
	public void EliminarTipoDocumento(TipoDocumento tipo) throws DAOException;
	/**
	 * Actualiza un tipoDocumento
	 * @param tipoDocumento tipoDocumento a actualizar
	 * @return void
	 * @throws DAOException
	 */
	public void ActualizarTipoDocumento(TipoDocumento tipo) throws DAOException;
		
	
}
