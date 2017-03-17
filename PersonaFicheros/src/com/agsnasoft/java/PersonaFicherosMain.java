package com.agsnasoft.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class PersonaFicherosMain {

	public static void main(String[] args) {
		List<Persona> personas = new ArrayList<Persona>();
		PersonaFicherosMain pFicheros = new PersonaFicherosMain();
		Scanner scaner = new Scanner(System.in);
		File fichero = new File("C:\\ws_sts_openlegacy\\Persona.txt");
		
		int opc = 0;
		do{
			opc = pFicheros.drawMenu();
			//opc = pFicheros.drawMenuConsola(scaner);
			switch (opc) {
			case 1:	
				personas.add(pFicheros.insertarDatos());
				//personas.add(pFicheros.insertarDatosConsola(scaner));
				pFicheros.guardarFichero(personas, fichero);
				break;
			case 2:
				pFicheros.leerFichero(fichero);
				break;
			case 3:
				pFicheros.modificarPersona(pFicheros.leerFichero(fichero), fichero);
				//pFicheros.modificarPersonaConsola(pFicheros.leerFichero(fichero), scaner, fichero);
				break;
			case 4:
				pFicheros.eliminarPersona(pFicheros.leerFichero(fichero), fichero);
				//pFicheros.eliminarPersonaConsola(pFicheros.leerFichero(fichero), scaner, fichero);
				break;
			}
		}while(opc != 5);
		
		scaner.close();
		System.exit(0);
	}
	
	public void guardarFichero(List<Persona> personas, File fichero){

		try {
			FileWriter fw = new FileWriter(fichero);
			int i = 0;
			if(personas.size() > 0){			
				for(Persona persona: personas){
					if(i == 0){
						fw.write("Nombre,Apellidos,Dirección,Edad,Email\n");
						//System.out.println("Nombre		Apellidos		Dirección		Edad		Email");
					}				
					fw.write(persona.getNombre() + "," + persona.getApellidos() + "," + persona.getDireccion() + "," + persona.getEdad() + "," + persona.getEmail() + "\n");
					//System.out.println(persona.getNombre() + "		" + persona.getApellidos() + "		" + persona.getDireccion() + "		" + persona.getEdad() + "		" + persona.getEmail());
					i++;
				}
			}else{
				fw.write("Nombre,Apellidos,Dirección,Edad,Email\n");
			}
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Persona> leerFichero(File fichero){
		String cadena;
		List<Persona> personaList = new ArrayList<Persona>();
		try {
			FileReader fr = new FileReader(fichero);
			BufferedReader bf = new BufferedReader(fr);			
			System.out.println(bf.readLine());
			int c = 0;
			while((cadena = bf.readLine())!= null){
				String [] datos = cadena.split(",");	
				personaList.add(new Persona(datos[0],datos[1],datos[2],Integer.valueOf(datos[3]),datos[4]));
				System.out.println(c + "-" + cadena);
				c++;
			}
			bf.close();
			fr.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return personaList;
	}

	public int drawMenu(){
		int opc = 0;
		
		try {
			opc = Integer.valueOf(JOptionPane.showInputDialog("Elegir una opcion: \n" + 
					"1) Escribir Fichero\n" +
					"2) Leer Fichero\n" +
					"3) Modificar Registro\n" +
					"4) Eliminar Registro\n" + 
					"5) Salir\n"));
			
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

	public void eliminarPersona(List<Persona> personas, File fichero){
		try {
			int opc = Integer.valueOf(JOptionPane.showInputDialog("Elegir registro a eliminar:"));
			List<Persona> personasAux = new ArrayList<Persona>();
			for (int i = 0; i < personas.size(); i++) {
				if(!(i == opc)){
					personasAux.add(personas.get(i));
				}
				System.out.println(i + "-" + personas.get(i).toString());	
			}			
			guardarFichero(personasAux, fichero);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No existe registro a eliminar");
		}
	}
	
	public void eliminarPersonaConsola(List<Persona> personas, Scanner scaner, File fichero){
		try {
			System.out.println("Elegir registro a eliminar:");
			int opc = scaner.nextInt();
			List<Persona> personasAux = new ArrayList<Persona>();
			for (int i = 0; i < personas.size(); i++) {
				if(!(i == opc)){
					personasAux.add(personas.get(i));
				}
				System.out.println(i + "-" + personas.get(i).toString());	
			}			
			guardarFichero(personasAux, fichero);
		} catch (Exception e) {
			System.err.println("No existe registro a eliminar");
		}
	}
	
	
	public void modificarPersona(List<Persona> personas, File fichero){
		try {
			int opc = Integer.valueOf(JOptionPane.showInputDialog("Elegir registro a modificar:"));			
			Persona persona = null;
			for (int i = 0; i < personas.size(); i++) {
				if(i == opc){
					persona = insertarDatosModificar(personas.get(i));
				}
				System.out.println(i + "-" + persona.toString());	
			}			
			personas.set(opc, persona);
			guardarFichero(personas, fichero);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No existe registro a eliminar");
		}
	}
	
	public void modificarPersonaConsola(List<Persona> personas, Scanner scaner, File fichero){
		System.out.println("Elegir registro a modificar:");		
		int opc = Integer.valueOf(scaner.nextLine());			
		Persona persona = null;
		for (int i = 0; i < personas.size(); i++) {
			if(i == opc){
				System.out.println("Por favor insertar los datos de la persona a modificar separados por , ");
				System.out.println(personas.get(i).toString());
				try {
					String pLine = scaner.nextLine();
					String [] linea = pLine.split(",");
					persona = new Persona(linea[0], linea[1], linea[2], Integer.valueOf(linea[3]), linea[4]);
				} catch (Exception e) {
					System.err.println("Se ha producido una excepcion: " + e.getLocalizedMessage());
				}				
			}
			System.out.println(i + "-" + persona.toString());	
		}			
		personas.set(opc, persona);
		guardarFichero(personas, fichero);
	}
	
	public Persona insertarDatos(){
		
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
		
		return new Persona(nombre, apellidos, direccion, edad, email);
	}
	
	public Persona insertarDatosModificar(Persona persona){
		
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
		
		return new Persona(nombre, apellidos, direccion, edad, email);
	}


	public Persona insertarDatosModificarConsola(Scanner scaner, Persona persona){

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

	public Persona insertarDatosConsola(Scanner scaner){

		System.out.println("Por favor insertar los datos de una persona separados por , por ejemplo: ");
		System.out.println("Juan,Sanchez,Direccion N1,40,j.sanchez@email.com");

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
