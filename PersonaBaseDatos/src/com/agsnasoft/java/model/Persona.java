package com.agsnasoft.java.model;

public class Persona {
	
	private String nombre;
	private String apellidos;
	private String direccion;
	private Integer edad;
	private String email;

	public Persona() {
		super();
	}

	public Persona(String nombre, String apellidos, String direccion, Integer edad, String email) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.edad = edad;
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void escribirTipoPersona(String profesion){		
		System.out.println("Soy una persona de tipo: " + profesion);
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion + ", edad=" + edad
				+ ", email=" + email + "]";
	}
}
