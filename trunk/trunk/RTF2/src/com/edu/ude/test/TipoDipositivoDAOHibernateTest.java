package com.edu.ude.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.edu.udea.dao.TipoDispositivoDAO;
import com.edu.udea.dto.TipoDispositivo;
import com.edu.udea.util.exception.DAOException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion-spring.xml")
public class TipoDipositivoDAOHibernateTest {
	
	@Autowired
	TipoDispositivoDAO tipoDispositivoDAO;
	
	@Test
	public void TestObtenerTipoDispositivo() {
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
	
	@Test
	public void TestObtenerTiposDispositivos() {
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
	
	/*
	@Test
	public void testEliminarTipoDispositivo(){ 
		System.out.println("__________________________________________________");
		System.out.println("Test para Eliminar un dispositivo");		
		try{			
			TipoDispositivo tipoDispositivo = tipoDispositivoDAO.obtenerTipoDispositivo("Tipo1");	
			tipoDispositivoDAO.eliminarTipoDispositivo(tipoDispositivo);
			assertTrue(true);
		
		} catch (DAOException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testAgregarTipoDispositivo() {
		System.out.println("__________________________________________________");
		System.out.println("Test para Agregar un dispositivo");		
		try {
			TipoDispositivo tipoDispositivo = new TipoDispositivo("Tipo1", "Descripcion Tipo1");
			tipoDispositivoDAO.agregarTipoDispositivo(tipoDispositivo);
			assertTrue(true);
		} catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testActualizarTipoDispositivo(){ 
		System.out.println("__________________________________________________");
		System.out.println("Test para Actualizar un dispositivo");		
		try{			
			TipoDispositivo tipoDispositivo = tipoDispositivoDAO.obtenerTipoDispositivo("Tipo1");	
			tipoDispositivo.setDescripcion("Descripcion actualizada en el test");
			tipoDispositivoDAO.actualizarTipoDispositivo(tipoDispositivo);
			assertTrue(true);
		
		} catch (DAOException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	*/
	
}
