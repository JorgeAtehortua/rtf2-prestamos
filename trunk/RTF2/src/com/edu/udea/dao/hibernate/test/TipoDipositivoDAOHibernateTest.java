package com.edu.udea.dao.hibernate.test;

import static org.junit.Assert.*;

import org.apache.log4j.PropertyConfigurator;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runners.MethodSorters;

import com.edu.udea.dao.TipoDispositivoDAO;
import com.edu.udea.dto.TipoDispositivo;
import com.edu.udea.util.exception.DAOException;
/**
 * Clase cuyo objetivo es hacer los test de los metodos de la clase tipodispositivoDaoHibernate
 * @author Cristian Fernando Ospina
 * @author David Alejandro Florez
 * @author Jason Angel
 *
 */	
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:configuracion-spring.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TipoDipositivoDAOHibernateTest {
	
	@BeforeClass
    public static void startup() {
        PropertyConfigurator.configure("log4j.properties");
    }
	
	@Autowired
	TipoDispositivoDAO tipoDispositivoDAO;
	/**
	 * verifica a modo de test si el tipodispositivo ha sido obtenido
	 * @return Void
	 */
	@Test
	public void Test1ObtenerTipoDispositivo() {
		System.out.println("__________________________________________________");
		System.out.println("Corriendo Test para Obtener un tipo de dispositivo");
		try{			
			TipoDispositivo tipoDispositivo = tipoDispositivoDAO.obtenerTipoDispositivo("Microscopio");		
			System.out.println("Tipo Dispositivo: "+ tipoDispositivo.getTipoDispositivo() +  " Descripcion: " + tipoDispositivo.getDescripcion());
			assertTrue(true);		
		} catch (DAOException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	/**
	 * verifica a modo de test si la lista de dispositivos ha sido obtenida
	 * @return Void
	 */
	@Test
	public void Test2ObtenerTiposDispositivos() {
		System.out.println("__________________________________________________");
		System.out.println("Corriendo Test para Obtener Todos los tipos de dispositivos");
		try{	
			for(TipoDispositivo tipoDispositivo: tipoDispositivoDAO.obtenerTiposDispositivos()){ 
				System.out.println("Tipo Dispositivo: "+ tipoDispositivo.getTipoDispositivo() +  " Descripcion: " + tipoDispositivo.getDescripcion());
			}				
			assertTrue(true);		
		} catch (DAOException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	
	/**
	 * verifica a modo de test si el tipodispositivo ha sido agregado
	 * @return Void
	 */
	@Test
	public void test3AgregarTipoDispositivo() {
		System.out.println("__________________________________________________");
		System.out.println("Test para Agregar un dispositivo");		
		try {
			TipoDispositivo tipoDispositivo = new TipoDispositivo("Tipo1", "Descripcion Tipo1");
			tipoDispositivoDAO.agregarTipoDispositivo(tipoDispositivo);
			assertNotNull(tipoDispositivoDAO.obtenerTipoDispositivo("Tipo1"));
		} catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
		
	/**
	 * verifica a modo de test si el tipodispositivo ha sido actualizado
	 * @return Void
	 */
	@Test
	public void test4ActualizarTipoDispositivo(){ 
		System.out.println("__________________________________________________");
		System.out.println("Test para Actualizar un dispositivo");		
		try{			
			TipoDispositivo tipoDispositivo = tipoDispositivoDAO.obtenerTipoDispositivo("Tipo1");	
			tipoDispositivo.setDescripcion("Test");
			tipoDispositivoDAO.actualizarTipoDispositivo(tipoDispositivo);
			assertEquals("Test", tipoDispositivoDAO.obtenerTipoDispositivo("Tipo1").getDescripcion());
		
		} catch (DAOException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	/**
	 * verifica a modo de test si el tipodispositivo ha sido eliminado
	 * @return Void
	 */
	@Test
	public void test5EliminarTipoDispositivo(){ 
		System.out.println("__________________________________________________");
		System.out.println("Test para Eliminar un dispositivo");		
		try{			
			TipoDispositivo tipoDispositivo = tipoDispositivoDAO.obtenerTipoDispositivo("Tipo1");	
			tipoDispositivoDAO.eliminarTipoDispositivo(tipoDispositivo);
			assertNull(tipoDispositivoDAO.obtenerTipoDispositivo("Tipo"));
		
		} catch (DAOException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	
}
