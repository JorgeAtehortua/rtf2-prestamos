package com.edu.udea.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.edu.udea.dao.PrestamoDAO;
import com.edu.udea.dto.Prestamo;
import com.edu.udea.util.exception.DAOException;
/**
 * Clase que hereda de HibernateDaoSupport e implementa (sobrescribe) los metodos del dao del prestamo
 * @author Cristian Fernando Ospina
 * @author David Alejandro Florez
 * @author Jason Angel
 *
 */
public class PrestamoDAOHibernate extends HibernateDaoSupport implements PrestamoDAO {
	/**
	 * Entrega los datos de un prestamo dado su identificador
	 * @param id id identificador del prestamo
	 * @return instancia con los datos del prestamo obtenido, si no existe el prestamo retorna null.
	 * @throws DAOException
	 */
	@Override
	public Prestamo obtenerPrestamo(int id) throws DAOException {
		Session session = null;
		Prestamo prestamo = null;
		
		try{
			session = getSession();			
			prestamo = (Prestamo)session.get(Prestamo.class, id);
			
		}catch(HibernateException e){
			throw new DAOException(e);
		}
		return prestamo;
	}
	/**
	 * Entrega la lista de todos los prestamos existentes en base de datos
	 * @return lista prestamos
	 * @throws DAOException
	 */
	@Override
	public List<Prestamo> obtenerPrestamos() throws DAOException {
		Session session = null;
		List<Prestamo> prestamos  = new ArrayList<Prestamo>();
		
		try{
			session = getSession();			
			Criteria criteria = session.createCriteria(Prestamo.class);			
			prestamos = criteria.list();
			
		}catch(HibernateException e){
			throw new DAOException(e);
		}
		return prestamos;
	}
	/**
	 * Agrega un prestamo
	 * @param prestamo prestamo a agregar
	 * @return void
	 * @throws DAOException
	 */
	@Override
	public void agregarPrestamo(Prestamo prestamo) throws DAOException {
		Session session = null;
		Transaction tx = null;
		try{
			session = getSession();			
			tx = session.beginTransaction();
			session.save(prestamo);
			tx.commit();			
		}catch(HibernateException e){
			throw new DAOException(e);
		}
		
	}
	/**
	 * Actualiza un prestamo
	 * @param prestamo prestamo a actualizar
	 * @return void
	 * @throws DAOException
	 */
	@Override
	public void modificarPrestamo(Prestamo prestamo) throws DAOException {
		Session session = null;
		Transaction tx = null;
		try{
			session = getSession();			
			tx = session.beginTransaction();
			session.update(prestamo);
			tx.commit();			
		}catch(HibernateException e){
			throw new DAOException(e);
		}
		
	}
	/**
	 * Elimina un prestamo
	 * @param prestamo prestamo a eliminar
	 * @return void
	 * @throws DAOException
	 */
	@Override
	public void eliminarPrestamo(Prestamo prestamo) throws DAOException {
		Session session = null;
		Transaction tx = null;
		try{
			session = getSession();			
			tx = session.beginTransaction();
			session.delete(prestamo);
			tx.commit();			
		}catch(HibernateException e){
			throw new DAOException(e);
		}
		
	}

}
