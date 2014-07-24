package com.edu.udea.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.edu.udea.dao.RolDAO;
import com.edu.udea.dto.Rol;
import com.edu.udea.util.exception.DAOException;
/**
 * Clase que hereda de HibernateDaoSupport e implementa (sobrescribe) los metodos del dao del rol
 * @author Cristian Fernando Ospina
 * @author David Alejandro Florez
 * @author Jason Angel
 *
 */	
public class RolDAOHibernate extends HibernateDaoSupport implements RolDAO {
	/**
	 * Entrega los datos de un rol dado su identificador
	 * @param r String identificador del rol
	 * @return instancia con los datos del rol obtenido, si no existe el rol retorna null.
	 * @throws DAOException
	 */
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
	/**
	 * Entrega la lista de todos los rols existentes en base de datos
	 * @return lista rols
	 * @throws DAOException
	 */
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
