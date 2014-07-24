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

import com.edu.udea.bl.impl.AdministradorBLImplements;
import com.edu.udea.dto.Dispositivo;
import com.edu.udea.dto.Prestamo;
import com.edu.udea.dto.Solicitud;
import com.edu.udea.dto.TipoDispositivo;
import com.edu.udea.dto.TipoDocumento;
import com.edu.udea.dto.Usuario;
import com.edu.udea.util.exception.BLException;
import com.edu.udea.util.exception.DAOException;
/**
 * Clase cuyo objetivo es hacer los test de la logica del negocio en consideracion con el tipo de actor, esta clase corresponde al administrador
 * @author Cristian Fernando Ospina
 * @author David Alejandro Florez
 * @author Jason Angel
 *
 */	
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:configuracion-spring.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdministradorBLImplementsTest {
	
	@BeforeClass
    public static void startup() {
        PropertyConfigurator.configure("log4j.properties");
    }
	
	@Autowired
	AdministradorBLImplements administradorImp;
	/**
	 * verifica a modo de test si el dispositivo ha sido consultado
	 * @return Void
	 */	
	@Test
	public void test1ConsultarDispositivo() {
		System.out.println("__________________________________________________");
		System.out.println("Test para obtener un dispositivo");		
		Dispositivo dispositivo= null;
		try {
			dispositivo  = administradorImp.consultarDispositivo(1);
			System.out.println("Codigo: "+ dispositivo.getIdDispositivo() +  " Nombre: " + dispositivo.getNombreDispositivo());
			assertTrue(true);
		} catch (DAOException | BLException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}
	/**
	 * verifica a modo de test si el dispositivo ha sido consultado
	 * @return Void
	 */	
	@Test
	public void test2ConsultarDispositivos() {
		System.out.println("__________________________________________________");
		System.out.println("Test para obtener todos dispositivos");	
		try {
			for(Dispositivo dispositivo:administradorImp.consultarDispositivos()){
				System.out.println("Codigo: "+ dispositivo.getIdDispositivo() +  " Nombre: " + dispositivo.getNombreDispositivo());
			}			
			assertTrue(true);
		} catch (DAOException | BLException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
		
	}
	/**
	 * verifica a modo de test si el dispositivo ha sido creado
	 * @return Void
	 */	
	@Test
	public void test3CrearDispositivo() {
		System.out.println("__________________________________________________");
		System.out.println("Test para crear un dispositivo");	
		
		try {
			administradorImp.crearDispositivo(1110, "Microscopio Optico", 
					"Esta en buen estado",2, 2, new TipoDispositivo("Microscopio", ""));
								
			assertNotNull(administradorImp.consultarDispositivo(1110));
		} catch (DAOException | BLException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
		
	}
	/**
	 * verifica a modo de test el dispositivo ha sido modificado
	 * @return Void
	 */	
	@Test
	public void test4ModificarDispositivo() {
		System.out.println("__________________________________________________");
		System.out.println("Test para modificar un dispositivo");	
		
		try {
			Dispositivo dispositivo= administradorImp.consultarDispositivo(1110);
			dispositivo.setDescripcionDispositivo("TEST");
			administradorImp.modificarDispositivo(dispositivo.getIdDispositivo(),dispositivo.getNombreDispositivo(),
					dispositivo.getDescripcionDispositivo(), dispositivo.getCantidad(), dispositivo.getDisponibles(), dispositivo.getTipoDispositivo());
			
								
			assertEquals("TEST",administradorImp.consultarDispositivo(1110).getDescripcionDispositivo());
		} catch (DAOException | BLException e) {
			e.printStackTrace();
			fail("Not yet implemented");
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
		
		try {
			administradorImp.eliminarDispositivo(1110);								
			assertTrue(true);
		} catch (DAOException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
		
	}
	/**
	 * verifica a modo de test si la solicitud ha sido consultado
	 * @return Void
	 */	
	@Test
	public void test6ConsultarSolicitud() {
		System.out.println("__________________________________________________");
		System.out.println("Test para consultar una solicitud");	
		Solicitud solicitud= null;
		try {
			solicitud  = administradorImp.consultarSolicitud(2);
			System.out.println("Solicitud con id: "+ solicitud.getIdSolicitud() +  
					" del Dispositivo: " + solicitud.getDispositivo().getNombreDispositivo() + " en la fecha" + solicitud.getFechaSolicitud());
			assertTrue(true);
		} catch (DAOException | BLException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
		
	}
	/**
	 * verifica a modo de test si la solicitud ha sido consultada
	 * @return Void
	 */	
	@Test
	public void test7ConsultarSolicitudes() {
		System.out.println("__________________________________________________");
		System.out.println("Test para consultar las solicitudes");	
		
		try {
			for(Solicitud solicitud: administradorImp.consultarSolicitudes()){
				System.out.println("Solicitud con id: "+ solicitud.getIdSolicitud() +  
						" del Dispositivo: " + solicitud.getDispositivo().getNombreDispositivo() + " en la fecha" + solicitud.getFechaSolicitud());
				
			}			
			assertTrue(true);
		} catch (DAOException | BLException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
		
	}
	/**
	 * verifica a modo de test si la solicitud ha sido consultado
	 * @return Void
	 */	
	@Test
	public void test8ConsultarPrestamo() {
		System.out.println("__________________________________________________");
		System.out.println("Test para consultar un prestamo");
		try {
			Prestamo prestamo= administradorImp.consultarPrestamo(1);
			System.out.println("Prestamo: " + prestamo.getIdPrestamo() + " Dispositivo prestado : " + prestamo.getDispositivo() +
					" cantidad: " + prestamo.getCantidad() + " observacion: " + prestamo.getObservacion() + " fecha prestamo:" + prestamo.getFechaPrestamo());
			assertTrue(true);
			
		} catch (DAOException | BLException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
	/**
	 * verifica a modo de test si el prestamo ha sido consultado
	 * @return Void
	 */	
	@Test
	public void test9ConsultarPrestamos() {
		System.out.println("__________________________________________________");
		System.out.println("Test para obtener todos los prestamos");
		try {
			for(Prestamo prestamo:administradorImp.consultarPrestamos()){
				System.out.println("Prestamo: " + prestamo.getIdPrestamo() + " Dispositivo prestado : " + prestamo.getDispositivo() +
						" cantidad: " + prestamo.getCantidad() + " observacion: " + prestamo.getObservacion() + " fecha prestamo:" + prestamo.getFechaPrestamo());
			}
			assertTrue(true);			
		} catch (DAOException | BLException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
	
	/**
	 * verifica a modo de test si el prestamo ha sido creado
	 * @return Void
	 */	
	@Test
	public void testACrearPrestamo() {
		System.out.println("__________________________________________________");
		System.out.println("Test para agregar un prestamo");
		try {
			Date date= new Date(2014,5,25);
			administradorImp.crearPrestamo(2, date,new Time(0), new Time(0),new Time(0), 1, "", new Usuario(1036941185, 
					new TipoDocumento("Cedula","")), new Dispositivo(2, "VideoBeam", "", 4, 4, new TipoDispositivo()));
			assertNotNull(administradorImp.consultarPrestamo(2));			
		} catch (DAOException | BLException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
	@Test
	/**
	 * verifica a modo de test si el prestamo ha sido creado
	 * @return Void
	 */	
public void testBModificarPrestamo() {
		System.out.println("__________________________________________________");
		System.out.println("Test para Modificar un prestamo");
		try {
			Prestamo prestamo = administradorImp.consultarPrestamo(2);
			prestamo.setObservacion("Test");
			administradorImp.modificarPrestamo(prestamo.getIdPrestamo(), prestamo.getFechaPrestamo(), prestamo.getHoraInicio(), 
					prestamo.getHoraFin(), prestamo.getHoraEntrega(), prestamo.getCantidad(), prestamo.getObservacion(), prestamo.getUsuario(), 
					prestamo.getDispositivo());
			assertEquals("Test", administradorImp.consultarPrestamo(2).getObservacion());		
		} catch (DAOException | BLException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
	/**
	 * verifica a modo de test si el prestamo ha sido eliminado
	 * @return Void
	 */	
	@Test
	public void testCEliminarPrestamo() {
		System.out.println("__________________________________________________");
		System.out.println("Test para Eliminar un prestamo");
		try { 
			administradorImp.eliminarPrestamo(2);
			assertTrue(true);		
		} catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
	/**
	 * verifica a modo de test si el tipo de dispositivo ha sido consultado
	 * @return Void
	 */	
	@Test
	public void TestDConsultarTipoDispositivo() {
		System.out.println("__________________________________________________");
		System.out.println("Corriendo Test para consultar un tipo de dispositivo");
		try{			
			TipoDispositivo tipoDispositivo = administradorImp.consultarTipoDispositivo("Pc");		
			System.out.println("Tipo Dispositivo: "+ tipoDispositivo.getTipoDispositivo() +  " Descripcion: " + tipoDispositivo.getDescripcion());
			assertTrue(true);		
		} catch (DAOException | BLException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	/**
	 * verifica a modo de test si el tipo de dispositivo ha sido obtenido
	 * @return Void
	 */	
	@Test
	public void TestEbtenerTiposDispositivos() {
		System.out.println("__________________________________________________");
		System.out.println("Corriendo Test para consultar Todos los tipos de dispositivos");
		try{	
			for(TipoDispositivo tipoDispositivo: administradorImp.consultarTiposDispositivos()){ 
				System.out.println("Tipo Dispositivo: "+ tipoDispositivo.getTipoDispositivo() +  " Descripcion: " + tipoDispositivo.getDescripcion());
			}				
			assertTrue(true);		
		} catch (DAOException | BLException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	/**
	 * verifica a modo de test si el tipo de dispositivo ha sido creado
	 * @return Void
	 */	
	@Test
	public void testFCrearTipoDispositivo() {
		System.out.println("__________________________________________________");
		System.out.println("Test para crear un dispositivo");		
		try {
			administradorImp.crearTipoDispositivo("Tipo1", "Descripcion Tipo1");
			assertNotNull(administradorImp.consultarTipoDispositivo("Tipo1"));
		} catch (DAOException | BLException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
		
	/**
	 * verifica a modo de test si el tipo de dispositivo ha sido actualizado
	 * @return Void
	 */	
	@Test
	public void testGActualizarTipoDispositivo(){ 
		System.out.println("__________________________________________________");
		System.out.println("Test para Actualizar un dispositivo");		
		try{			
			TipoDispositivo tipoDispositivo = administradorImp.consultarTipoDispositivo("Tipo1");	
			tipoDispositivo.setDescripcion("Test");
			administradorImp.actualizarTipoDispositivo(tipoDispositivo.getTipoDispositivo(), tipoDispositivo.getDescripcion());
			assertEquals("Test", administradorImp.consultarTipoDispositivo("Tipo1").getDescripcion());
		
		} catch (DAOException | BLException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	/**
	 * verifica a modo de test si el tipo de dispositivo ha sido eliminado
	 * @return Void
	 */	
	@Test
	public void testHEliminarTipoDispositivo(){ 
		System.out.println("__________________________________________________");
		System.out.println("Test para Eliminar un dispositivo");		
		try{			
			TipoDispositivo tipoDispositivo = administradorImp.consultarTipoDispositivo("Tipo1");	
			administradorImp.eliminarTipoDispositivo("Tipo1");
			assertTrue(true);
		
		} catch (DAOException | BLException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	

}
