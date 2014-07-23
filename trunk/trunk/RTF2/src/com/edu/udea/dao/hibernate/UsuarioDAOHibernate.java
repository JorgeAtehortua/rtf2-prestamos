package com.edu.udea.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.edu.udea.dao.UsuarioDAO;
import com.edu.udea.dto.TipoDocumento;
import com.edu.udea.dto.Usuario;
import com.edu.udea.util.exception.DAOException;

public class UsuarioDAOHibernate extends HibernateDaoSupport implements UsuarioDAO {

	@Override
	public Usuario obtenerUsuario(int numeroDocumento, TipoDocumento tipoDocumento)
			throws DAOException {
		Session session = null;
		Usuario usuario;
		try{
			session = getSession();	
			usuario= (Usuario) session.get(Usuario.class, new Usuario(numeroDocumento,tipoDocumento));
		}catch(HibernateException e){
			throw new DAOException(e);
		}
		return usuario;
	}

	@Override
	public List<Usuario> obtenerUsuarios() throws DAOException {
		Session session = null;
		List<Usuario> usuarios;
		try{
			session = getSession();	
			Criteria criteria = session.createCriteria(Usuario.class);
			usuarios= criteria.list();
		}catch(HibernateException e){
			throw new DAOException(e);
		}
		return usuarios;
	}

	@Override
	public void agregarUsuario(Usuario usuario) throws DAOException {
		Session session = null;
		Transaction tx = null;
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.save(usuario);
			tx.commit();			
		}catch(HibernateException e){
			throw new DAOException(e);
		}	
		
	}

	@Override
	public void modificarUsuario(Usuario usuario) throws DAOException {
		Session session = null;
		Transaction tx = null;
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.update(usuario);
			tx.commit();			
		}catch(HibernateException e){
			throw new DAOException(e);
		}
		
	}

	@Override
	public void eliminarUsuario(Usuario usuario) throws DAOException {
		Session session = null;
		Transaction tx = null;
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.delete(usuario);
			tx.commit();			
		}catch(HibernateException e){
			throw new DAOException(e);
		}
		
	}


}
