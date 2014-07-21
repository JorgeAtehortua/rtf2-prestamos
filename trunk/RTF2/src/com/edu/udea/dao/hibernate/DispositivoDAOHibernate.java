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

public class DispositivoDAOHibernate extends HibernateDaoSupport implements DispositivoDAO{
	
	public DispositivoDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

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
