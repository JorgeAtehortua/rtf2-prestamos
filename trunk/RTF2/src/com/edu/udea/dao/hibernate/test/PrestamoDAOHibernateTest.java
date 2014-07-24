package com.edu.udea.dao.hibernate.test;

import static org.junit.Assert.*;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.PropertyConfigurator;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.udea.dao.PrestamoDAO;
import com.edu.udea.dto.Dispositivo;
import com.edu.udea.dto.Prestamo;
import com.edu.udea.dto.TipoDispositivo;
import com.edu.udea.dto.TipoDocumento;
import com.edu.udea.dto.Usuario;
import com.edu.udea.util.exception.DAOException;
/**
 * Clase cuyo objetivo es hacer los test de los metodos de la clase prestamoDaoHibernate
 * @author Cristian Fernando Ospina
 * @author David Alejandro Florez
 * @author Jason Angel
 *
 */	
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:configuracion-spring.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PrestamoDAOHibernateTest {
	
	@BeforeClass
    public static void startup() {
        PropertyConfigurator.configure("log4j.properties");
    }
	
	@Autowired
	PrestamoDAO prestamoDAO;
	/**
	 * verifica a modo de test si el prestamo ha sido obtenido
	 * @return Void
	 */	
	@Test
	public void test1obtenerPrestamo() {
		System.out.println("__________________________________________________");
		System.out.println("Test para obtener un prestamo");
		try {
			Prestamo prestamo= prestamoDAO.obtenerPrestamo(1);
			System.out.println("Prestamo: " + prestamo.getIdPrestamo() + " Dispositivo prestado : " + prestamo.getDispositivo() +
					" cantidad: " + prestamo.getCantidad() + " observacion: " + prestamo.getObservacion() + " fecha prestamo:" + prestamo.getFechaPrestamo());
			assertTrue(true);
			
		} catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
	/**
	 * verifica a modo de test si la lista de prestamos ha sido obtenida
	 * @return Void
	 */
	@Test
	public void test2obtenerPrestamos() {
		System.out.println("__________________________________________________");
		System.out.println("Test para obtener todos los prestamos");
		try {
			for(Prestamo prestamo:prestamoDAO.obtenerPrestamos()){
				System.out.println("Prestamo: " + prestamo.getIdPrestamo() + " Dispositivo prestado : " + prestamo.getDispositivo() +
						" cantidad: " + prestamo.getCantidad() + " observacion: " + prestamo.getObservacion() + " fecha prestamo:" + prestamo.getFechaPrestamo());
			}
			assertTrue(true);			
		} catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
	
	/**
	 * verifica a modo de test si el prestamo ha sido agregado
	 * @return Void
	 */	
	@Test
	public void test3AgregarPrestamo() {
		System.out.println("__________________________________________________");
		System.out.println("Test para agregar un prestamo");
		try {
			Date date= new Date(1994,5,25);
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
			Prestamo prestamo = new Prestamo(2, date,new Time(0), new Time(0),new Time(0), 1, "", new Usuario(1036941185, 
					new TipoDocumento("Cedula","")), new Dispositivo(2, "VideoBeam", "", 4, 4, new TipoDispositivo()));
			prestamoDAO.agregarPrestamo(prestamo);
			assertNotNull(prestamoDAO.obtenerPrestamo(2));			
		} catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
	/**
	 * verifica a modo de test si el prestamo ha sido actualizado
	 * @return Void
	 */	
	@Test
	public void test4ModificarPrestamo() {
		System.out.println("__________________________________________________");
		System.out.println("Test para Modificar un prestamo");
		try {
			Prestamo prestamo = prestamoDAO.obtenerPrestamo(2);
			prestamo.setObservacion("Test");
			prestamoDAO.modificarPrestamo(prestamo);
			assertEquals("Test", prestamoDAO.obtenerPrestamo(2).getObservacion());		
		} catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
	/**
	 * verifica a modo de test si el - ha sido eliminado
	 * @return Void
	 */
	@Test
	public void test6EliminarPrestamo() {
		System.out.println("__________________________________________________");
		System.out.println("Test para Eliminar un prestamo");
		try {
			Prestamo prestamo = prestamoDAO.obtenerPrestamo(2); 
			prestamoDAO.eliminarPrestamo(prestamo);
			assertNull(prestamoDAO.obtenerPrestamo(2));		
		} catch (DAOException e) {
			fail(e.getMessage());
		}
		
	}

}
