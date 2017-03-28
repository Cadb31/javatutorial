package com.agsnasoft.java;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.agsnasoft.java.dao.PersonaFileDao;
import com.agsnasoft.java.dao.PersonaFileDaoImpl;
import com.agsnasoft.java.model.Persona;

public class PersonaFicherosMain {
	
	private PersonaFileDao personaDao;

	public PersonaFicherosMain(PersonaFileDao personaDao){
		this.personaDao = personaDao;
		personaDao.consultarPersonas();
	}	
	
	public static void main(String[] args) {
		File fichero = new File("C:\\ws_sts_openlegacy\\Persona.txt");
		PersonaFileDao personaDao = new PersonaFileDaoImpl(fichero);		
		PersonaFicherosMain pFicheros = new PersonaFicherosMain(personaDao);
		Scanner scaner = new Scanner(System.in);
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
				pFicheros.modificarPersona();
				//pFicheros.modificarPersonaConsola(scaner);
				break;
			case 5:
				pFicheros.eliminarPersona();
				//pFicheros.eliminarPersonaConsola(scaner);
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
					"1) Insertar Persona\n" +
					"2) Consultar Persona\n" +
					"3) Consultar Personas\n" +
					"4) Modificar Persona\n" +
					"5) Eliminar Persona\n" + 
					"6) Salir\n");
			opc = Integer.valueOf(scaner.nextLine());
		} catch (Exception e) {
			System.out.println("Opcion no valida");
		}
		return opc;
	}

	public void insertarPersona() {

		String nombre = JOptionPane.showInputDialog("Insertar Nombre:");
		String apellidos = JOptionPane.showInputDialog("Insertar Apellidos:");
		String direccion = JOptionPane.showInputDialog("Insertar Dirección:");
		Integer edad = 0;
		boolean isValid = true;
		do {
			try {
				edad = Integer.valueOf(JOptionPane.showInputDialog("Insertar Edad:"));
				isValid = true;
			} catch (Exception e) {
				isValid = false;
			}
		} while (!isValid);
		String email = JOptionPane.showInputDialog("Insertar Email");

		if(nombre.equals("") || apellidos.equals("") || direccion.equals("") || email.equals("")){
			JOptionPane.showMessageDialog(null, "No se puede insertar un usuario con informacion vacia");
		}else{
			personaDao.insertarPersona(new Persona(PersonaFileDao.personas.size() + 1, nombre, apellidos, direccion, edad, email));
		}		
	}

	public void insertarPersonaConsola(Scanner scaner) {

		System.out.println("Por favor insertar los datos de una persona separados por , por ejemplo: ");
		System.out.println("Juan,Sanchez,Direccion N1,40,j.sanchez@email.com\n");
		try {
			String pLine = scaner.nextLine();
			String[] linea = pLine.split(",");
			personaDao.insertarPersona(new Persona(PersonaFileDao.personas.size() + 1, linea[0], linea[1], linea[2], Integer.valueOf(linea[3]), linea[4]));
		} catch (Exception e) {
			System.err.println("Se ha producido una excepcion: " + e.getLocalizedMessage());
		}
	}

	public void consultarPersona() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Indicar la persona a consultar"));		
		Persona persona = personaDao.consultarPersona(new Persona(id, "", "", "", 0, ""));		

		if (persona == null) {
			JOptionPane.showMessageDialog(null, "La persona indicada no existe");
		} else {
			System.out.println(persona.toString());		
		}
	}

	public List<Persona> consultarPersonas() {
		List<Persona> personas = personaDao.consultarPersonas();
		for (Persona persona : personas) {
			System.out.println(persona.toString());
		}		
		return personas;
	}

	public void eliminarPersona() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Indicar la persona a eliminar"));

		Persona persona = personaDao.consultarPersona(new Persona(id, "","","",0,""));
		
		if(persona != null){
			int opc = JOptionPane.showConfirmDialog(null, "Desea eliminar a la persona: \n" + persona.toString(), "Eliminar Persona", JOptionPane.YES_NO_CANCEL_OPTION);
			if(opc == 0){
				if (personaDao.eliminarPersona(persona)) {
					JOptionPane.showMessageDialog(null, "Persona eliminada correctamente");
				}
			}		
		}else{
			JOptionPane.showMessageDialog(null, "La persona indicada no existe");
		}
	}

	public void eliminarPersonaConsola(Scanner scaner) {
		System.out.println("Indicar la persona a eliminar: \n");
		String pLine = scaner.nextLine();

		Persona persona = personaDao.consultarPersona(new Persona(Integer.valueOf(pLine), "","","",0,""));
		
		if(persona != null){			
			System.out.println("Desea eliminar a la persona: \n" + persona.toString() + "\n-> Presione: [0 Para Si, 1 Para No]\n");
			pLine = scaner.nextLine();
			int opc = Integer.parseInt(pLine);
			if(opc == 0){
				if (personaDao.eliminarPersona(persona)) {
					System.out.println("Persona eliminada correctamente");
				}
			}		
		}else{
			System.out.println("La persona indicada no existe");
		}
	}

	public void modificarPersona() {

		int id = Integer.parseInt(JOptionPane.showInputDialog("Indicar la persona a modificar"));
		Persona persona = personaDao.consultarPersona(new Persona(id,"","","",0,""));

		if (persona != null) {
			int opc = JOptionPane.showConfirmDialog(null, "Desea modificar a la persona: \n" + persona.toString(),"Modificar Persona:", JOptionPane.YES_NO_CANCEL_OPTION);
			if(opc == 0){
				String nombre = JOptionPane.showInputDialog("Modificar Nombre " + persona.getNombre() + " ?");
				String apellidos = JOptionPane.showInputDialog("Modificar Apellidos " + persona.getApellidos() + " ?");
				String direccion = JOptionPane.showInputDialog("Modificar Dirección " + persona.getDireccion() + " ?");
				Integer edad = 0;
				boolean isValid = true;
				do {
					try {
						edad = Integer
								.valueOf(JOptionPane.showInputDialog("Modificar Edad " + persona.getEdad() + " ?"));
						isValid = true;
					} catch (Exception e) {
						isValid = false;
					}
				} while (!isValid);
				String email = JOptionPane.showInputDialog("Modificar Email " + persona.getEmail() + " ?");
		
				if(nombre.equals("") || apellidos.equals("") || direccion.equals("") || email.equals("")){
					JOptionPane.showMessageDialog(null, "No se puede modificar un usuario con informacion vacia");
				}else{			
					if (personaDao.actualizarPersona(persona, new Persona(nombre, apellidos, direccion, edad, email))) {
						JOptionPane.showMessageDialog(null, "Se ha modificado la persona correctamente");
					}
				}				
			}
		}
	}

	public void modificarPersonaConsola(Scanner scaner) {

		try {
			System.out.println("Indicar la persona a modificar: \n");			
			String pLine = scaner.nextLine();
			Persona persona = personaDao.consultarPersona(new Persona(Integer.valueOf(pLine), "", "", "", 0, ""));
			if(persona != null){
				System.out.println(persona.toString());
				System.out.println("Por favor insertar los datos de la persona a modificar separados por , \n");
				pLine = scaner.nextLine();
				String[] linea = pLine.split(",");
				if (personaDao.actualizarPersona(persona, new Persona(persona.getId(), linea[0], linea[1], linea[2], Integer.valueOf(linea[3]), linea[4]))) {
					System.out.println("Se ha modificado la persona correctamente");
				}
			}else{
				System.err.println("La persona indicada no existe");
			}
		} catch (Exception e) {
			System.err.println("Se ha producido una excepcion: " + e.getLocalizedMessage());
		}
	}

	
}
