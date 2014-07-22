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

public class PrestamoDAOHibernate extends HibernateDaoSupport implements PrestamoDAO {

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
