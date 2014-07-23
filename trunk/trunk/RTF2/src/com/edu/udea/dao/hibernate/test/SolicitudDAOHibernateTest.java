package com.edu.udea.dao.hibernate.test;

import static org.junit.Assert.*;

import java.sql.Time;
import java.util.Date;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.udea.dao.SolicitudDAO;
import com.edu.udea.dto.Dispositivo;
import com.edu.udea.dto.Prestamo;
import com.edu.udea.dto.Solicitud;
import com.edu.udea.dto.TipoDispositivo;
import com.edu.udea.dto.TipoDocumento;
import com.edu.udea.dto.Usuario;
import com.edu.udea.util.exception.DAOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:configuracion-spring.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SolicitudDAOHibernateTest {
	
	@Autowired
	SolicitudDAO solicitudDAO;
	
	@Test
	public void test1AgregarSolicitud() {
		System.out.println("__________________________________________________");
		System.out.println("Test para agregar una solicitud");
		try {
			Date date= new Date(1994,5,25);
			Solicitud solicitud = new Solicitud(1, date,date ,new Time(0), new Time(0),1, new Usuario(1036941185, 
					new TipoDocumento("Cedula","")), new Dispositivo(2, "VideoBeam", "", 4, 4, new TipoDispositivo()));
			solicitudDAO.agregarSolicitud(solicitud);
			assertNotNull(solicitudDAO.obtenerSolicitud(1));			
		} catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	
	@Test
	public void test2ObtenerSolicitud() {
		System.out.println("__________________________________________________");
		System.out.println("Test para obtener una solicitud");
		try {
			Solicitud solicitud= solicitudDAO.obtenerSolicitud(1);
			System.out.println("Solicitud con id: " + solicitud.getIdSolicitud() + 
					" del Dispositivo" + solicitud.getDispositivo() + " en la fecha" + solicitud.getFechaSolicitud());
			assertTrue(true);
		}catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void test3ModificarSolicitud() {
		System.out.println("__________________________________________________");
		System.out.println("Test para Modificar una solicitud");
		try {
			Solicitud solicitud = solicitudDAO.obtenerSolicitud(1);
			solicitud.setCantidad(100);
			solicitudDAO.modificarrSolicitud(solicitud);
			assertEquals(100, solicitudDAO.obtenerSolicitud(1).getCantidad());			
		} catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void test4ObtenerSolicitudes() {
		System.out.println("__________________________________________________");
		System.out.println("Test para obtener todas las solicitudes");
		try {
			for (Solicitud solicitud:solicitudDAO.obtenerSolicitudes()) {
				System.out.println("Solicitud con id: " + solicitud.getIdSolicitud() + 
						" del Dispositivo" + solicitud.getDispositivo() + " en la fecha" + solicitud.getFechaSolicitud());
				
			}
			assertTrue(true);
		}catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void test5EliminarSolicitud() {
		System.out.println("__________________________________________________");
		System.out.println("Test para eliminar una solicitud");
		try {
			Solicitud solicitud= solicitudDAO.obtenerSolicitud(1);
			solicitudDAO.eliminarSolicitud(solicitud);
			assertNull(solicitudDAO.obtenerSolicitud(1));
		}catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	

}
