package com.edu.udea.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.edu.udea.dao.TipoDispositivoDAO;
import com.edu.udea.dto.TipoDispositivo;
import com.edu.udea.util.exception.DAOException;
/**
 * Clase que hereda de HibernateDaoSupport e implementa (sobrescribe) los metodos del dao del tipoDispositivo
 * @author Cristian Fernando Ospina
 * @author David Alejandro Florez
 * @author Jason Angel
 *
 */	
public class TipoDispositivoDAOHibernate extends HibernateDaoSupport implements TipoDispositivoDAO{
	/**
	 * Entrega los datos de un tipoDispositivo dado su identificador
	 * @param tipoD String identificador del tipoDispositivo
	 * @return instancia con los datos del tipoDispositivo obtenido, si no existe el tipoDispositivo retorna null.
	 * @throws DAOException
	 */
	@Override
	public TipoDispositivo obtenerTipoDispositivo(String tipoD)
			throws DAOException {
		Session session = null;
		TipoDispositivo tipoDispositivo;
		try{
			session = getSession();		
			tipoDispositivo= (TipoDispositivo)session.get(TipoDispositivo.class,tipoD);
		}catch(HibernateException e){
			throw new DAOException(e);
		}
		return tipoDispositivo;
	}
	/**
	 * Entrega la lista de todos los tipoDispositivos existentes en base de datos
	 * @return lista tipoDispositivos
	 * @throws DAOException
	 */
	@Override
	public List<TipoDispositivo> obtenerTiposDispositivos()
			throws DAOException {
		Session session = null;
		List<TipoDispositivo> tiposDispositivos = new ArrayList<TipoDispositivo>();
		try{
			session = getSession();			
			Criteria criteria = session.createCriteria(TipoDispositivo.class);	
			tiposDispositivos= criteria.list();
		}catch(HibernateException e){
			throw new DAOException(e);
		}
		return tiposDispositivos;
	}
	/**
	 * Agrega un tipoDispositivo
	 * @param tipoDispositivo tipoDispositivo a agregar
	 * @return void
	 * @throws DAOException
	 */
	@Override
	public void agregarTipoDispositivo(TipoDispositivo tipoDispositivo)
			throws DAOException {
		Session session = null;
		Transaction tx = null;
		try{
			session = getSession();			
			tx = session.beginTransaction();
			session.save(tipoDispositivo);
			tx.commit();
		}catch(HibernateException e){
			throw new DAOException(e);
		}
		
	}
	/**
	 * Elimina un tipoDispositivo
	 * @param tipoDispositivo tipoDispositivo a eliminar
	 * @return void
	 * @throws DAOException
	 */
	@Override
	public void eliminarTipoDispositivo(TipoDispositivo tipoDispositivo)
			throws DAOException {
		Session session = null;
		Transaction tx = null;
		try{
			session = getSession();			
			tx = session.beginTransaction();
			session.delete(tipoDispositivo);
			tx.commit();
		}catch(HibernateException e){
			throw new DAOException(e);
		}
		
	}
	/**
	 * Actualiza un tipoDispositivo
	 * @param tipoDispositivo tipoDispositivo a actualizar
	 * @return void
	 * @throws DAOException
	 */
	@Override
	public void actualizarTipoDispositivo(TipoDispositivo tipoDispositivo)
			throws DAOException {
		Session session = null;
		Transaction tx = null;
		try{
			session = getSession();			
			tx = session.beginTransaction();
			session.update(tipoDispositivo);
			tx.commit();
		}catch(HibernateException e){
			throw new DAOException(e);
		}
		
	}

}
