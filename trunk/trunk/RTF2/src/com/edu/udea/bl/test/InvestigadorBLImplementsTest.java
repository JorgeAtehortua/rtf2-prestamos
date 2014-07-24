package com.edu.udea.bl.test;

import static org.junit.Assert.*;

import java.sql.Time;
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

import com.edu.udea.bl.impl.InvestigadorBLImplements;
import com.edu.udea.bl.impl.UsuarioBLImplements;
import com.edu.udea.dto.Dispositivo;
import com.edu.udea.dto.Solicitud;
import com.edu.udea.dto.TipoDispositivo;
import com.edu.udea.dto.TipoDocumento;
import com.edu.udea.dto.Usuario;
import com.edu.udea.util.exception.BLException;
import com.edu.udea.util.exception.DAOException;
/**
 * Clase cuyo objetivo es hacer los test de la logica del negocio en consideracion con el tipo de actor, esta clase corresponde al investigador
 * @author Cristian Fernando Ospina
 * @author David Alejandro Florez
 * @author Jason Angel
 *
 */	
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:configuracion-spring.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InvestigadorBLImplementsTest {
	
	@BeforeClass
    public static void startup() {
        PropertyConfigurator.configure("log4j.properties");
    }
	
	@Autowired
	UsuarioBLImplements usuarioImpl;
	
	@Autowired
	InvestigadorBLImplements investigadorImpl;
	/**
	 * verifica a modo de test si el dispositivo ha sido obtenido
	 * @return Void
	 */	
	@Test
	public void test1ConsultarDispositivo() {
		System.out.println("__________________________________________________");
		System.out.println("Test para obtener un dispositivo");		
		Dispositivo dispositivo= null;
		try {
			dispositivo  = usuarioImpl.consultarDispositivo(1);
			System.out.println("Codigo: "+ dispositivo.getIdDispositivo() +  " Nombre: " + dispositivo.getNombreDispositivo());
			assertTrue(true);
		} catch (DAOException | BLException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}
	/**
	 * verifica a modo de test si los dispositivos han sido obtenidos
	 * @return Void
	 */	
	@Test
	public void test2ConsultarDispositivos() {
		System.out.println("__________________________________________________");
		System.out.println("Test para obtener todos dispositivos");	
		try {
			for(Dispositivo dispositivo:usuarioImpl.consultarDispositivos()){
				System.out.println("Codigo: "+ dispositivo.getIdDispositivo() +  " Nombre: " + dispositivo.getNombreDispositivo());
			}			
			assertTrue(true);
		} catch (DAOException | BLException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
		
	}
	/**
	 * verifica a modo de test si la solicitud ha sido obtenida
	 * @return Void
	 */	
	@Test
	public void test3ConsultarSolicitud() {
		System.out.println("__________________________________________________");
		System.out.println("Test para consultar una solicitud");	
		Solicitud solicitud= null;
		try {
			solicitud  = investigadorImpl.consultarSolicitud(2);
			System.out.println("Solicitud con id: "+ solicitud.getIdSolicitud() +  
					" del Dispositivo: " + solicitud.getDispositivo().getNombreDispositivo() + " en la fecha" + solicitud.getFechaSolicitud());
			assertTrue(true);
		} catch (DAOException | BLException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
		
	}
	/**
	 * verifica a modo de test si las solicitudes han sido obtenidas
	 * @return Void
	 */	
	@Test
	public void test4ConsultarSolicitudes() {
		System.out.println("__________________________________________________");
		System.out.println("Test para consultar las solicitudes");	
		
		try {
			for(Solicitud solicitud: investigadorImpl.consultarSolicitudes()){
				System.out.println("Solicitud con id: "+ solicitud.getIdSolicitud() +  
						" del Dispositivo: " + solicitud.getDispositivo().getNombreDispositivo() + " en la fecha" + solicitud.getFechaSolicitud());
				
			}			
			assertTrue(true);
		} catch (DAOException | BLException e) {
			e.printStackTrace();
			fail("No paso el test 4 de consultar solicitudes");
		}
		
	}
	/**
	 * verifica a modo de test si la solicitud ha sido creada
	 * @return Void
	 */	
	@Test
	public void test5CrearSolicitud() {
		System.out.println("__________________________________________________");
		System.out.println("Test para crear una solicitud");
		try {
			Date date= new Date(2014,5,25);
			investigadorImpl.crearSolicitud(1, date,date ,new Time(0), new Time(0),1, new Usuario(1036941185, 
					new TipoDocumento("Cedula","")), new Dispositivo(2, "VideoBeam", "", 4, 4, new TipoDispositivo()));
			assertNotNull(investigadorImpl.consultarSolicitud(1));			
		} catch (DAOException | BLException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
	/**
	 * verifica a modo de test si la solicitud ha sido modificada
	 * @return Void
	 */	
	@Test
	public void test6ModificarSolicitud() {
		System.out.println("__________________________________________________");
		System.out.println("Test para consultar las solicitudes");	
		
		try {
			Solicitud solicitud = investigadorImpl.consultarSolicitud(1);
			solicitud.setCantidad(200);
			investigadorImpl.modificarrSolicitud(solicitud.getIdSolicitud(), solicitud.getFechaSolicitud(), solicitud.getFechaPrestamo(), 
					solicitud.getHoraInicioPrestamo(), solicitud.getHoraFinPrestamo(), solicitud.getCantidad(), 
					solicitud.getUsuario(), solicitud.getDispositivo());
			assertEquals(200, investigadorImpl.consultarSolicitud(1).getCantidad());
		} catch (DAOException | BLException e) {
			e.printStackTrace();
			fail("No paso el test de modificar solicitud");
		}
		
	}
	/**
	 * verifica a modo de test si la solicitud ha sido eliminada
	 * @return Void
	 */	
	@Test
	public void test7EliminarSolicitud() {
		System.out.println("__________________________________________________");
		System.out.println("Test para eliminar una solicitud");	
		
		try {
			investigadorImpl.eliminarSolicitud(1);			
			assertTrue(true);
		} catch (DAOException e) {
			e.printStackTrace();
			fail("No paso el test de eliminar solicitud");
		}
		
	}
	

}
