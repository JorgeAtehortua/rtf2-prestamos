package com.edu.ude.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.edu.udea.dao.DispositivoDAO;
import com.edu.udea.dto.Dispositivo;
import com.edu.udea.dto.TipoDispositivo;
import com.edu.udea.util.exception.DAOException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion-spring.xml")
public class DispositivoDAOHibernateTest {
	
	@Autowired
	DispositivoDAO dispositivoDao;
	
	@Test
	public void testObtenerDispositivo() {
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
	
	@Test
	public void testObtenerDispositivos() {
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
	
	
	/*
	@Test
	public void testEliminarDispositivo() {
		System.out.println("__________________________________________________");
		System.out.println("Test para eliminar un dispositivo");
		try{			
			Dispositivo dispositivo = dispositivoDao.obtenerDispositivo(1110);	
			dispositivoDao.eliminarDispositivo(dispositivo);
			assertTrue(true);
		
		} catch (DAOException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
			
	@Test
	public void testAgregarDispositivo() {
		System.out.println("__________________________________________________");
		System.out.println("Test para Agregar un dispositivo");
		try{
			Dispositivo dispositivo = new Dispositivo(1110, "Microscopio Optico", "Esta en buen estado", 2, 2, new TipoDispositivo("Microscopio", ""));			
			dispositivoDao.agregarDispositivo(dispositivo);
			assertTrue(true);
		
		} catch (DAOException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	/*
	@Test
	public void testActualizarDispositivo() {
		System.out.println("__________________________________________________");
		System.out.println("Test para actualizar un dispositivo");
		try{			
			Dispositivo dispositivo = dispositivoDao.obtenerDispositivo(1);
			dispositivo.setCantidad(dispositivo.getCantidad()+1);
			dispositivoDao.actualizarDispositivo(dispositivo);
			assertTrue(true);
		
		} catch (DAOException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}*/
}
