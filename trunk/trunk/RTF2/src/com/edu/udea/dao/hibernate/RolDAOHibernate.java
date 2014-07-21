package com.edu.udea.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.edu.udea.dao.RolDAO;
import com.edu.udea.dto.Rol;
import com.edu.udea.util.exception.DAOException;

public class RolDAOHibernate extends HibernateDaoSupport implements RolDAO {

	@Override
	public Rol obtenerRol(String r) throws DAOException {
		Session session = null;
		Rol rol;
		try{
			session= getSession();
			rol= (Rol)session.get(Rol.class, r);			
		}catch(HibernateException e){
			throw new DAOException(e);
		}			
		return rol;
	}

	@Override
	public List<Rol> obtenerRoles() throws DAOException {
		Session session = null;
		List<Rol> roles;
		try{
			session = getSession();			
			Criteria criteria = session.createCriteria(Rol.class);
			roles= criteria.list();			
		}catch(HibernateException e){
			throw new DAOException(e);
		}			
		return roles;		
	}

}
