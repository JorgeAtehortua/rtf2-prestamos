package com.edu.udea.bl.test;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.udea.bl.impl.UsuarioBLImplements;
import com.edu.udea.dto.Dispositivo;
import com.edu.udea.util.exception.BLException;
import com.edu.udea.util.exception.DAOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:configuracion-spring.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioBLImplementsTest {

	@Autowired
	UsuarioBLImplements usuarioImpl;
	
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

}
