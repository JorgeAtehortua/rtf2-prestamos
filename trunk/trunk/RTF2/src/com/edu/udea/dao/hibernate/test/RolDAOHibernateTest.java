package com.edu.udea.dao.hibernate.test;

import static org.junit.Assert.*;

import org.apache.log4j.PropertyConfigurator;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.edu.udea.dao.RolDAO;
import com.edu.udea.dto.Rol;
import com.edu.udea.util.exception.DAOException;
/**
* Clase cuyo objetivo es hacer los test de los metodos de la clase rolDaoHibernate
* @author Cristian Fernando Ospina
* @author David Alejandro Florez
* @author Jason Angel
*
*/	
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion-spring.xml")
public class RolDAOHibernateTest {
	
	@BeforeClass
    public static void startup() {
        PropertyConfigurator.configure("log4j.properties");
    }
	
	@Autowired
	RolDAO rolDAO;
	/**
	 * verifica a modo de test si el rol ha sido obtenido
	 * @return Void
	 */	
	@Test
	public void TestObtenerRol() {
		System.out.println("__________________________________________________");
		System.out.println("Corriendo Test para Obtener un Rol");
		try {
			Rol rol= rolDAO.obtenerRol("Administrador");
			System.out.println("Rol: " + rol.getRol() + " Descripcion: " + rol.getDescripcion());
			assertTrue(true);		
		} catch (DAOException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	/**
	 * verifica a modo de test si la lista de rols ha sido obtenida
	 * @return Void
	 */	
	@Test
	public void TestObtenerRoles() {
		System.out.println("__________________________________________________");
		System.out.println("Corriendo Test para Obtener todos Roles");
		try {
			for (Rol rol: rolDAO.obtenerRoles() ){
				System.out.println("Rol: " + rol.getRol() + " Descripcion: " + rol.getDescripcion());
			}			
			assertTrue(true);		
		} catch (DAOException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
