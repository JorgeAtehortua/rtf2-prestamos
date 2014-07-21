package com.edu.udea.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.edu.udea.dao.TipoDocumentoDAO;
import com.edu.udea.dto.TipoDocumento;
import com.edu.udea.util.exception.DAOException;

public class TipoDocumentoDAOHibernate extends HibernateDaoSupport implements TipoDocumentoDAO {

	@Override
	public TipoDocumento obtenerTipoDocumento(String tipo) throws DAOException {
		Session session = null;
		TipoDocumento tipoDocumento;
		try {
			session = getSession();	
			tipoDocumento= (TipoDocumento)session.get(TipoDocumento.class, tipo);
		}catch(HibernateException e){
			throw new DAOException(e);
		}
		return tipoDocumento;
	}

	@Override
	public List<TipoDocumento> obtenerTipoDocumento() throws DAOException {
		Session session = null;
		List<TipoDocumento> tiposDocumento;
		try {
			session = getSession();	
			Criteria criteria = session.createCriteria(TipoDocumento.class);
			tiposDocumento= criteria.list();
		}catch(HibernateException e){
			throw new DAOException(e);
		}
		return tiposDocumento;
	}

	@Override
	public void AgregarTipoDocumento(TipoDocumento tipo) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void EliminarTipoDocumento(TipoDocumento tipo) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ActualizarTipoDocumento(TipoDocumento tipo) throws DAOException {
		// TODO Auto-generated method stub
		
	}
	
	

}
