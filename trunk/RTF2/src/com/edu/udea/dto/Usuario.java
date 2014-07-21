package com.edu.udea.dto;

public class Usuario {
	
	private int numeroDocumento;
	private String nombre;
	private String apellido;
	private String contrasena;
	private String email;
	private TipoDocumento tipoDocumento;
	private Rol rol;
	
	
	public Usuario(){
		
	}
	
	public Usuario(int numeroDocumento, String nombre, String apellido,
			String contrasena, String email, TipoDocumento tipoDocumento,
			Rol rol) {
		super();
		this.numeroDocumento = numeroDocumento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.contrasena = contrasena;
		this.email = email;
		this.tipoDocumento = tipoDocumento;
		this.rol = rol;
	}

	public int getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(int numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	

}
