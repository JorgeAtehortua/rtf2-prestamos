package com.edu.udea.dao.hibernate.test;

import static org.junit.Assert.*;

import org.apache.log4j.PropertyConfigurator;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.udea.dao.TipoDocumentoDAO;
import com.edu.udea.dto.TipoDocumento;
import com.edu.udea.util.exception.DAOException;
/**
 * Clase cuyo objetivo es hacer los test de los metodos de la clase tipodocumentoDaoHibernate
 * @author Cristian Fernando Ospina
 * @author David Alejandro Florez
 * @author Jason Angel
 *
 */	
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:configuracion-spring.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TipoDocumentoDAOHibernateTest {
	
	@BeforeClass
    public static void startup() {
        PropertyConfigurator.configure("log4j.properties");
    }
	
	@Autowired
	TipoDocumentoDAO tipoDocumentoDAO;
	/**
	 * verifica a modo de test si el tipodocumento ha sido obtenido
	 * @return Void
	 */
	@Test
	public void test1ObtenerTipoDocumento() {
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
	/**
	 * verifica a modo de test si la lista de documentos ha sido obtenida
	 * @return Void
	 */
	@Test
	public void test2ObtenerTiposDocumento() {
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
	
	/**
	 * verifica a modo de test si el tipodocumento ha sido agregado
	 * @return Void
	 */
	@Test
	public void test3AgregarTiposDocumento() {
		System.out.println("__________________________________________________");
		System.out.println("Corriendo Test para Agregar un tipo de documento");
		try{
			TipoDocumento tipoDocumento= new TipoDocumento("Pasaporte", "Usado por investigadores extranjeros");
			tipoDocumentoDAO.AgregarTipoDocumento(tipoDocumento);				
			assertNotNull(tipoDocumentoDAO.obtenerTipoDocumento("Pasaporte"));
		} catch (DAOException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * verifica a modo de test si el tipodocumento ha sido actualizado
	 * @return Void
	 */
	@Test
	public void test4ModificarTiposDocumento() {
		System.out.println("__________________________________________________");
		System.out.println("Corriendo Test para Modificar un tipo de documento");
		try{
			TipoDocumento tipoDocumento=tipoDocumentoDAO.obtenerTipoDocumento("Pasaporte");
			tipoDocumento.setDescripcion("Descripcion actualizada desde el test");
			tipoDocumentoDAO.ActualizarTipoDocumento(tipoDocumento);				
			assertEquals("Descripcion actualizada desde el test", tipoDocumentoDAO.obtenerTipoDocumento("Pasaporte").getDescripcion());
		} catch (DAOException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	/**
	 * verifica a modo de test si el tipodocumento ha sido eliminado
	 * @return Void
	 */
	@Test
	public void test5EliminarTiposDocumento() {
		System.out.println("__________________________________________________");
		System.out.println("Corriendo Test para Eliminar un tipo de documento");
		try{
			TipoDocumento tipoDocumento=tipoDocumentoDAO.obtenerTipoDocumento("Pasaporte");
			tipoDocumentoDAO.EliminarTipoDocumento(tipoDocumento);				
			assertNull(tipoDocumentoDAO.obtenerTipoDocumento("Pasaporta"));
		} catch (DAOException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	

}
