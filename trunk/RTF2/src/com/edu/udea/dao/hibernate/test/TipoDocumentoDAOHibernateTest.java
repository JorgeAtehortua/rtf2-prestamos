package com.edu.udea.dao.hibernate.test;

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
			assertTrue(true);
		} catch (DAOException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testObtenerTiposDocumento() {
		System.out.println("__________________________________________________");
		System.out.println("Corriendo Test para Obtener todos los tipos de documento");
		try{
			for(TipoDocumento tipoDocumento:tipoDocumentoDAO.obtenerTipoDocumento()){
				System.out.println("Tipo Documento: " + tipoDocumento.getTipoDocumento() + " Descripcion: "+ tipoDocumento.getDescripcion());
			}		
			assertTrue(true);
		} catch (DAOException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	/*
	@Test
	public void testAgregarTiposDocumento() {
		System.out.println("__________________________________________________");
		System.out.println("Corriendo Test para Agregar un tipo de documento");
		try{
			TipoDocumento tipoDocumento= new TipoDocumento("Pasaporte", "Usado por investigadores extranjeros");
			tipoDocumentoDAO.AgregarTipoDocumento(tipoDocumento);				
			assertTrue(true);
		} catch (DAOException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	
	@Test
	public void testModificarTiposDocumento() {
		System.out.println("__________________________________________________");
		System.out.println("Corriendo Test para Modificar un tipo de documento");
		try{
			TipoDocumento tipoDocumento=tipoDocumentoDAO.obtenerTipoDocumento("Pasaporte");
			tipoDocumento.setDescripcion("Descripcion actualizada desde el test");
			tipoDocumentoDAO.ActualizarTipoDocumento(tipoDocumento);				
			assertTrue(true);
		} catch (DAOException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	
	@Test
	public void testEliminarTiposDocumento() {
		System.out.println("__________________________________________________");
		System.out.println("Corriendo Test para Eliminar un tipo de documento");
		try{
			TipoDocumento tipoDocumento=tipoDocumentoDAO.obtenerTipoDocumento("Pasaporte");
			tipoDocumentoDAO.EliminarTipoDocumento(tipoDocumento);				
			assertTrue(true);
		} catch (DAOException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	*/

}
