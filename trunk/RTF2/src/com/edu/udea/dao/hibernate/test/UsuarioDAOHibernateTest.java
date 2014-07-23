package com.edu.udea.dao.hibernate.test;

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

import com.edu.udea.dao.UsuarioDAO;
import com.edu.udea.dto.Rol;
import com.edu.udea.dto.TipoDocumento;
import com.edu.udea.dto.Usuario;
import com.edu.udea.util.exception.DAOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:configuracion-spring.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioDAOHibernateTest {

	@BeforeClass
    public static void startup() {
        PropertyConfigurator.configure("log4j.properties");
    }
	
	@Autowired
	UsuarioDAO usuarioDAO; 
	
	@Test
	public void test1ObtenerUsuario() {
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
	public void test2ObtenerUsuarios() {
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
	
	
	@Test
	public void test3AgrearUsuarios() {
		System.out.println("__________________________________________________");
		System.out.println("Test para agregar un Usuario");
		try{	
			Usuario usuario =  new Usuario(15989, "Jason", "Angel", "password", "angel@udea.edu.co", new TipoDocumento("Id",""), new Rol("Investigador", ""));
			usuarioDAO.agregarUsuario(usuario);
			assertNotNull(usuarioDAO.obtenerUsuario(15989, new TipoDocumento("Id","")));
		}catch (DAOException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	
	@Test
	public void test4ModificarUsuario() {
		System.out.println("__________________________________________________");
		System.out.println("Test para agregar un Usuario");
		try{	
			Usuario usuario =  usuarioDAO.obtenerUsuario(15989, new TipoDocumento("Id",""));
			usuario.setApellido("ANGEL ANGEL");
			usuarioDAO.modificarUsuario(usuario);
			assertEquals("ANGEL ANGEL", usuarioDAO.obtenerUsuario(15989, new TipoDocumento("Id","")).getApellido());
		}catch (DAOException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void test5EliminarUsuario() {
		System.out.println("__________________________________________________");
		System.out.println("Test para eliminar un Usuario");
		try{	
			Usuario usuario =  usuarioDAO.obtenerUsuario(15989, new TipoDocumento("Id",""));
			usuarioDAO.eliminarUsuario(usuario);
			assertNull(usuarioDAO.obtenerUsuario(15989, new TipoDocumento("Id","")));
		}catch (DAOException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
