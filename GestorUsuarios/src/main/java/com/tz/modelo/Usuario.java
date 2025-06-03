package com.tz.modelo;

public class Usuario {
	private int idUser;
	private String nombre;
	private String correo;
	private String clave;
	private int idRol;
	private boolean estado;
	
	public Usuario(String nombre, String correo, String clave, int role) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.clave = clave;
		this.idRol = role;
	}
	
	public Usuario(int idUser, String nombre, String correo, String clave, int role, boolean estado) {
		super();
		this.idUser = idUser;
		this.nombre = nombre;
		this.correo = correo;
		this.clave = clave;
		this.idRol = role;
		this.estado = estado;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int role) {
		this.idRol = role;
	}
	
	
	

}