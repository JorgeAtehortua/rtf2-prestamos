package com.edu.udea.dao.hibernate.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.edu.udea.dao.RolDAO;
import com.edu.udea.dto.Rol;
import com.edu.udea.util.exception.DAOException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion-spring.xml")
public class RolDAOHibernateTest {
	
	@Autowired
	RolDAO rolDAO;
	
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
