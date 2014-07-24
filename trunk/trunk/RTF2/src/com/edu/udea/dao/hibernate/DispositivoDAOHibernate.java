package com.edu.udea.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.edu.udea.dao.DispositivoDAO;
import com.edu.udea.dto.Dispositivo;
import com.edu.udea.util.exception.DAOException;
/**
 * Clase que hereda de HibernateDaoSupport e implementa (sobrescribe) los metodos del dao del dispositivo
 * @author Cristian Fernando Ospina
 * @author David Alejandro Florez
 * @author Jason Angel
 *
 */
public class DispositivoDAOHibernate extends HibernateDaoSupport implements DispositivoDAO{
	/**
	 * constructor
	 */
	public DispositivoDAOHibernate() {
		
	}
	/**
	 * Entrega los datos de un dispositivo dado su identificador
	 * @param id id identificador del dispositivo
	 * @return instancia con los datos del dispositivo obtenido, si no existe el dispositivo retorna null.
	 * @throws DAOException
	 */
	@Override	
	public Dispositivo obtenerDispositivo(Integer id) throws DAOException {
		Session session = null;
		Dispositivo dispositivo = null;
		
		try{
			session = getSession();			
			dispositivo = (Dispositivo)session.get(Dispositivo.class, id);
			
		}catch(HibernateException e){
			throw new DAOException(e);
		}
		return dispositivo;
	}
	/**
	 * Entrega la lista de todos los dispositivos existentes en base de datos
	 * @return lista dispositivos
	 * @throws DAOException
	 */	
	@Override
	public List<Dispositivo> obtenerDispositivos() throws DAOException {
		Session session = null;
		List<Dispositivo> dispositivos  = new ArrayList<Dispositivo>();
		
		try{
			session = getSession();			
			Criteria criteria = session.createCriteria(Dispositivo.class);			
			dispositivos = criteria.list();
			
		}catch(HibernateException e){
			throw new DAOException(e);
		}
		return dispositivos;
	}
	/**
	 * Agrega un dispositivo
	 * @param dispositivo dispositivo a agregar
	 * @return void
	 * @throws DAOException
	 */
	@Override
	public void agregarDispositivo(Dispositivo dispositivo) throws DAOException {
		Session session = null;
		Transaction tx = null;
		try{
			session = getSession();			
			tx = session.beginTransaction();
			session.save(dispositivo);
			tx.commit();			
		}catch(HibernateException e){
			throw new DAOException(e);
		}
		
	}
	/**
	 * Elimina un dispositivo
	 * @param dispositivo dispositivo a eliminar
	 * @return void
	 * @throws DAOException
	 */
	@Override
	public void eliminarDispositivo(Dispositivo dispositivo) throws DAOException {
		Session session = null;
		Transaction tx = null;
		try{
			session = getSession();			
			tx = session.beginTransaction();
			session.delete(dispositivo);
			tx.commit();		
			
		}catch(HibernateException e){
			throw new DAOException(e);
		}
		
	}
	/**
	 * Actualiza un dispositivo
	 * @param dispositivo dispositivo a actualizar
	 * @return void
	 * @throws DAOException
	 */
	@Override
	public void actualizarDispositivo(Dispositivo dispositivo) throws DAOException {
		Session session = null;
		Transaction tx = null;
		try{
			session = getSession();			
			tx = session.beginTransaction();
			session.update(dispositivo);
			tx.commit();		
			
		}catch(HibernateException e){
			throw new DAOException(e);
		}
		
	}

}
