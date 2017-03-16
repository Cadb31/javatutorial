package com.agsnasoft.java;

public class Estudiante extends Persona {

	public Estudiante() {
		super();
	}

	public Estudiante(String nombre, String apellidos, String direccion, Integer edad, String email) {
		super(nombre, apellidos, direccion, edad, email);
	}

	public void estudiar(){
		System.out.println("Soy un estudiante aplicado");
	}
	
}
