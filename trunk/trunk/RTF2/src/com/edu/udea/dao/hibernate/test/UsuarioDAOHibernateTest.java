package com.edu.udea.dao.hibernate.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.edu.udea.dao.UsuarioDAO;
import com.edu.udea.dto.Rol;
import com.edu.udea.dto.TipoDocumento;
import com.edu.udea.dto.Usuario;
import com.edu.udea.util.exception.DAOException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion-spring.xml")
public class UsuarioDAOHibernateTest {

	@Autowired
	UsuarioDAO usuarioDAO; 
	
	@Test
	public void testObtenerUsuario() {
		System.out.println("__________________________________________________");
		System.out.println("Test para obtener un Usuario");
		try{			
			Usuario usuario= usuarioDAO.obtenerUsuario(1036941185,new TipoDocumento("Cedula", ""));
			System.out.println("Nombre de Usuario: "+ usuario.getNombre() + " Apellido: " + usuario.getApellido() + " Email: "+ usuario.getEmail());
			assertTrue(true);
		}catch (DAOException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testObtenerUsuarios() {
		System.out.println("__________________________________________________");
		System.out.println("Test para obtener todos Usuario");
		try{	
			for(Usuario usuario: usuarioDAO.obtenerUsuarios()){
				System.out.println("Nombre de Usuario: "+ usuario.getNombre() + " Apellido: " + usuario.getApellido() + " Email: "+ usuario.getEmail());
			}
			assertTrue(true);
		}catch (DAOException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	/*
	@Test
	public void testAgrearUsuarios() {
		System.out.println("__________________________________________________");
		System.out.println("Test para agregar un Usuario");
		try{	
			Usuario usuario =  new Usuario(15988, "Jason", "Angel", "password", "angel@udea.edu.co", new TipoDocumento("Id",""), new Rol("Investigador", ""));
			usuarioDAO.agregarUsuario(usuario);
			assertTrue(true);
		}catch (DAOException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	
	@Test
	public void testModificarUsuario() {
		System.out.println("__________________________________________________");
		System.out.println("Test para agregar un Usuario");
		try{	
			Usuario usuario =  usuarioDAO.obtenerUsuario(15988, new TipoDocumento("Id",""));
			usuario.setApellido("ANGEL ANGEL");
			usuarioDAO.modificarUsuario(usuario);
			assertTrue(true);
		}catch (DAOException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}*/
}
