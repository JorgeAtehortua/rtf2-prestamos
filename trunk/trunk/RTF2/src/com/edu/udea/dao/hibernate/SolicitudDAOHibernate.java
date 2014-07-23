package com.edu.udea.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.edu.udea.dao.SolicitudDAO;
import com.edu.udea.dto.Solicitud;
import com.edu.udea.util.exception.DAOException;

public class SolicitudDAOHibernate extends HibernateDaoSupport implements SolicitudDAO {

	@Override
	public Solicitud obtenerSolicitud(int id) throws DAOException {
		Session session = null;
		Solicitud solicitud= null;
		try{
			session = getSession();	
			solicitud = (Solicitud) session.get(Solicitud.class, id);
		}catch(HibernateException e){
			throw new DAOException(e);
		}
		return solicitud;
	}

	@Override
	public List<Solicitud> obtenerSolicitudes() throws DAOException {
		Session session = null;
		List<Solicitud> solicitudes= null;
		try{
			session = getSession();	
			Criteria criteria = session.createCriteria(Solicitud.class);
			solicitudes = criteria.list();
		}catch(HibernateException e){
			throw new DAOException(e);
		}
		return solicitudes;
	}

	@Override
	public void agregarSolicitud(Solicitud solicitud) throws DAOException {
		Session session = null;
		Transaction tx = null;
		try{
			session = getSession();			
			tx = session.beginTransaction();
			session.save(solicitud);
			tx.commit();			
		}catch(HibernateException e){
			throw new DAOException(e);
		}
		
	}

	@Override
	public void modificarrSolicitud(Solicitud solicitud) throws DAOException {
		Session session = null;
		Transaction tx = null;
		try{
			session = getSession();			
			tx = session.beginTransaction();
			session.update(solicitud);
			tx.commit();			
		}catch(HibernateException e){
			throw new DAOException(e);
		}
		
	}

	@Override
	public void eliminarSolicitud(Solicitud solicitud) throws DAOException {
		Session session = null;
		Transaction tx = null;
		try{
			session = getSession();			
			tx = session.beginTransaction();
			session.delete(solicitud);
			tx.commit();			
		}catch(HibernateException e){
			throw new DAOException(e);
		}
		
	}

}
