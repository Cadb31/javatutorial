package com.agsnasoft.jpa.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	private String nombre;
	private String apellidos;
	private String direccion;
	private int edad;
	private String email;

	public Persona() {

	}

	public Persona(int id) {
		super();
		this.id = id;
	}

	public Persona(String nombre, String apellidos, String direccion, int edad, String email) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.edad = edad;
		this.email = email;
	}

	public Persona(int id, String nombre, String apellidos, String direccion, int edad, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.edad = edad;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion
				+ ", edad=" + edad + ", email=" + email + "]";
	}

}