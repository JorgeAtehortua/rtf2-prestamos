package com.edu.udea.bl.test;

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

import com.edu.udea.bl.impl.UsuarioBLImplements;
import com.edu.udea.dto.Dispositivo;
import com.edu.udea.util.exception.BLException;
import com.edu.udea.util.exception.DAOException;
/**
 * Clase cuyo objetivo es hacer los test de la logica del negocio en consideracion con el tipo de actor, esta clase corresponde al usuario
 * @author Cristian Fernando Ospina
 * @author David Alejandro Florez
 * @author Jason Angel
 *
 */	
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:configuracion-spring.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioBLImplementsTest {

	@BeforeClass
    public static void startup() {
        PropertyConfigurator.configure("log4j.properties");
    }
	
	@Autowired
	UsuarioBLImplements usuarioImpl;
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
			dispositivo  = usuarioImpl.consultarDispositivo(1);
			System.out.println("Codigo: "+ dispositivo.getIdDispositivo() +  " Nombre: " + dispositivo.getNombreDispositivo());
			assertTrue(true);
		} catch (DAOException | BLException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}
	/**
	 * verifica a modo de test si los dispositivos han consultados
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

}
