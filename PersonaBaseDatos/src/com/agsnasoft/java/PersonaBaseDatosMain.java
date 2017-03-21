package com.agsnasoft.java;

import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.agsnasoft.java.dao.PersonaDao;
import com.agsnasoft.java.dao.PersonaDaoImpl;
import com.agsnasoft.java.model.Persona;

public class PersonaBaseDatosMain {
	
	private PersonaDao personaDao;

	public PersonaBaseDatosMain(String url, String usr, String pwd){
		personaDao = new PersonaDaoImpl(url, usr, pwd);
	}
	
	public static void main(String[] args) {

		PersonaBaseDatosMain pFicheros = new PersonaBaseDatosMain("jdbc:mysql://localhost:3306", "root", "root");
		Scanner scaner = new Scanner(System.in);
		Persona p = new Persona("Sara", "Conors", "Casa n1", 45, "s.conors@email.coms");
		Persona pM = new Persona("Sara", "Conors", "Casa n3", 46, "s.conors@email.coms");

		int opc = 0;
		do{
			opc = pFicheros.drawMenu();
			//opc = pFicheros.drawMenuConsola(scaner);
			switch (opc) {
			
				case 1:
					pFicheros.insertarPersona();
					//pFicheros.insertarPersonaConsola(scaner);
					break;
				case 2:
					pFicheros.consultarPersona();
					break;
				case 3:
					pFicheros.consultarPersonas();
					break;
				case 4:
					break;			
				case 5:
					
				break;
			}
		
		}while(opc != 6);
		
		scaner.close();
		System.exit(0);
	}

	public int drawMenu(){
		int opc = 0;
		
		try {
			opc = Integer.valueOf(JOptionPane.showInputDialog("Elegir una opcion: \n" + 
					"1) Insertar Persona\n" +
					"2) Consultar Persona\n" +
					"3) Consultar Personas\n" +
					"4) Modificar Persona\n" +
					"5) Eliminar Persona\n" + 
					"6) Salir\n"));
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Opcion no valida");
		}
		
		return opc;
	}

	public int drawMenuConsola(Scanner scaner){
		int opc = 0;
		try {
			System.out.println("Elegir una opcion: \n" + 
					"1) Escribir Fichero\n" +
					"2) Leer Fichero\n" +
					"3) Modificar Registro\n" +
					"4) Eliminar Registro\n" + 
					"5) Salir\n");
			opc = Integer.valueOf(scaner.nextLine());
		} catch (Exception e) {
			System.out.println("Opcion no valida");
		}
		return opc;
	}

	public void insertarPersona(){
		
		String nombre = JOptionPane.showInputDialog("Insertar Nombre:");
		String apellidos = JOptionPane.showInputDialog("Insertar Apellidos:");
		String direccion = JOptionPane.showInputDialog("Insertar Dirección:");
		Integer edad = 0;
		boolean isValid = true;
		do{			
			try {
				edad = Integer.valueOf(JOptionPane.showInputDialog("Insertar Edad:"));
				isValid = true;
			} catch (Exception e) {
				isValid = false;
			}			
		}while(!isValid);				
		String email = JOptionPane.showInputDialog("Insertar Email");
		
		personaDao.insertarPersona(new Persona(nombre, apellidos, direccion, edad, email));
	}

	public void insertarPersonaConsola(Scanner scaner){

		System.out.println("Por favor insertar los datos de una persona separados por , por ejemplo: ");
		System.out.println("Juan,Sanchez,Direccion N1,40,j.sanchez@email.com");
		try {
			String pLine = scaner.nextLine();
			String [] linea = pLine.split(",");
			personaDao.insertarPersona(new Persona(linea[0], linea[1], linea[2], Integer.valueOf(linea[3]), linea[4]));
		} catch (Exception e) {
			System.err.println("Se ha producido una excepcion: " + e.getLocalizedMessage());
		}		
		
	}

	public List<Persona> consultarPersona(){
		JOptionPane.showInputDialog("Indicar la persona a consultar");
		Persona p = new Persona();
		List<Persona> personas = personaDao.consultarPersona(p);
		return personas;
	}
	
	public List<Persona> consultarPersonas(){
		List<Persona> personas = personaDao.consultarPersonas();
		return personas;
	}

	
	public void eliminarPersona(Persona persona){
	}
	
	public void eliminarPersonaConsola(Persona persona, Scanner scaner){
	}
	
	public void modificarPersona(Persona personaActual, Persona personaModificada){		
	}
	
	public void modificarPersonaConsola(Persona personaActual, Persona personaModificada, Scanner scaner){
		System.out.println("Elegir registro a modificar:");		
		int opc = Integer.valueOf(scaner.nextLine());			
		Persona persona = null;
		
	}
	
	public void modificarDatosPersona(Persona persona){
		
		String nombre = JOptionPane.showInputDialog("Modificar Nombre " + persona.getNombre() + " ?");
		String apellidos = JOptionPane.showInputDialog("Modificar Apellidos " + persona.getApellidos() + " ?");
		String direccion = JOptionPane.showInputDialog("Modificar Dirección " + persona.getDireccion() + " ?");
		Integer edad = 0;
		boolean isValid = true;
		do{			
			try {
				edad = Integer.valueOf(JOptionPane.showInputDialog("Modificar Edad " + persona.getEdad() + " ?"));
				isValid = true;
			} catch (Exception e) {
				isValid = false;
			}			
		}while(!isValid);				
		String email = JOptionPane.showInputDialog("Modificar Email " + persona.getEmail() + " ?");

	}

	public Persona modificarDatosPersonaConsola(Scanner scaner, Persona persona){

		System.out.println("Por favor insertar los datos de la persona a modificar separados por , ");
		System.out.println(persona.toString());

		Persona p = null;

			try {
				String pLine = scaner.nextLine();
				String [] linea = pLine.split(",");
				p = new Persona(linea[0], linea[1], linea[2], Integer.valueOf(linea[3]), linea[4]);
			} catch (Exception e) {
				System.err.println("Se ha producido una excepcion: " + e.getLocalizedMessage());
			}			

		return p;
	}

	
}
