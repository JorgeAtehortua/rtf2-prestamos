package com.edu.ude.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.edu.udea.dao.TipoDocumentoDAO;
import com.edu.udea.dto.TipoDocumento;
import com.edu.udea.util.exception.DAOException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion-spring.xml")
public class TipoDocumentoDAOHibernateTest {
	
	@Autowired
	TipoDocumentoDAO tipoDocumentoDAO;
	
	@Test
	public void testObtenerTipoDocumento() {
		System.out.println("__________________________________________________");
		System.out.println("Corriendo Test para Obtener un tipo de documento");
		try{
			TipoDocumento tipoDocumento= tipoDocumentoDAO.obtenerTipoDocumento("Cedula");
			System.out.println("Tipo Documento: " + tipoDocumento.getTipoDocumento() + " Descripcion: "+ tipoDocumento.getDescripcion());
			
		} catch (DAOException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
