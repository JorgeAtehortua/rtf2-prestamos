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

import com.edu.udea.dao.DispositivoDAO;
import com.edu.udea.dto.Dispositivo;
import com.edu.udea.dto.TipoDispositivo;
import com.edu.udea.util.exception.DAOException;
/**
 * Clase cuyo objetivo es hacer los test de los metodos de la clase dispositivoDaoHibernate
 * @author Cristian Fernando Ospina
 * @author David Alejandro Florez
 * @author Jason Angel
 *
 */	
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:configuracion-spring.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DispositivoDAOHibernateTest {
	
	@BeforeClass
    public static void startup() {
        PropertyConfigurator.configure("log4j.properties");
    }
	
	@Autowired
	DispositivoDAO dispositivoDao;
	/**
	 * verifica a modo de test si el dispositivo ha sido obtenido
	 * @return Void
	 */	
	@Test
	public void test1ObtenerDispositivo() {
		System.out.println("__________________________________________________");
		System.out.println("Test para obtener un dispositivo");
		try{			
			Dispositivo dispositivo = dispositivoDao.obtenerDispositivo(1);		
			System.out.println("Codigo: "+ dispositivo.getIdDispositivo() +  " Nombre: " + dispositivo.getNombreDispositivo());
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
	public void test2ObtenerDispositivos() {
		System.out.println("__________________________________________________");
		System.out.println("Test para obtener todos los dispositivos");
		try{			
			for(Dispositivo dispositivo:dispositivoDao.obtenerDispositivos()){
				System.out.println("Codigo: "+ dispositivo.getIdDispositivo() +  " Nombre: " + dispositivo.getNombreDispositivo());
			}			
			assertTrue(true);
		
		} catch (DAOException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	
	/**
	 * verifica a modo de test si el dispositivo ha sido agregado
	 * @return Void
	 */						
	@Test
	public void test3AgregarDispositivo() {
		System.out.println("__________________________________________________");
		System.out.println("Test para Agregar un dispositivo");
		try{
			Dispositivo dispositivo = new Dispositivo(1110, "Microscopio Optico", "Esta en buen estado", 2, 2, new TipoDispositivo("Microscopio", ""));			
			dispositivoDao.agregarDispositivo(dispositivo);
			assertNotNull(dispositivoDao.obtenerDispositivo(1110));
		
		} catch (DAOException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	/**
	 * verifica a modo de test si el dispositivo ha sido actualizado
	 * @return Void
	 */	
	@Test
	public void test4ActualizarDispositivo() {
		System.out.println("__________________________________________________");
		System.out.println("Test para actualizar un dispositivo");
		try{			
			Dispositivo dispositivo = dispositivoDao.obtenerDispositivo(1110);
			dispositivo.setDescripcionDispositivo("Test");
			dispositivoDao.actualizarDispositivo(dispositivo);
			assertEquals("Test", dispositivoDao.obtenerDispositivo(1110).getDescripcionDispositivo());
		
		} catch (DAOException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	/**
	 * verifica a modo de test si el dispositivo ha sido eliminado
	 * @return Void
	 */	
	@Test
	public void test5EliminarDispositivo() {
		System.out.println("__________________________________________________");
		System.out.println("Test para eliminar un dispositivo");
		try{			
			Dispositivo dispositivo = dispositivoDao.obtenerDispositivo(1110);	
			dispositivoDao.eliminarDispositivo(dispositivo);
			assertNull(dispositivoDao.obtenerDispositivo(1110));		
		} catch (DAOException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
}
