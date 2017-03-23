package com.agsnasoft.java;

import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.agsnasoft.java.dao.PersonaDao;
import com.agsnasoft.java.dao.PersonaDaoImpl;
import com.agsnasoft.java.model.Persona;

public class PersonaBaseDatosMain {

	private PersonaDao personaDao;

	public PersonaBaseDatosMain(String url, String usr, String pwd) {
		personaDao = new PersonaDaoImpl(url, usr, pwd);
	}

	public static void main(String[] args) {

		PersonaBaseDatosMain pBaseDatos = new PersonaBaseDatosMain("jdbc:mysql://localhost:3306", "root", "root");
		Scanner scaner = new Scanner(System.in);

		int opc = 0;
		do {
			opc = pBaseDatos.drawMenu();
			// opc = pFicheros.drawMenuConsola(scaner);
			switch (opc) {

			case 1:
				pBaseDatos.insertarPersona();
				// pFicheros.insertarPersonaConsola(scaner);
				break;
			case 2:
				pBaseDatos.consultarPersona();
				break;
			case 3:
				pBaseDatos.consultarPersonas();
				break;
			case 4:
				pBaseDatos.modificarPersona();
				break;
			case 5:
				pBaseDatos.consultarPersonas();
				pBaseDatos.eliminarPersona();
				//pBaseDatos.eliminarPersonaConsola(scaner);
				break;
			}

		} while (opc != 6);

		scaner.close();
		System.exit(0);
	}

	public int drawMenu() {
		int opc = 0;

		try {
			opc = Integer.valueOf(JOptionPane.showInputDialog("Elegir una opcion: \n" + "1) Insertar Persona\n"
					+ "2) Consultar Persona\n" + "3) Consultar Personas\n" + "4) Modificar Persona\n"
					+ "5) Eliminar Persona\n" + "6) Salir\n"));

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Opcion no valida");
		}

		return opc;
	}

	public int drawMenuConsola(Scanner scaner) {
		int opc = 0;
		try {
			System.out.println("Elegir una opcion: \n" + "1) Escribir Fichero\n" + "2) Leer Fichero\n"
					+ "3) Modificar Registro\n" + "4) Eliminar Registro\n" + "5) Salir\n");
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
			personaDao.insertarPersona(new Persona(nombre, apellidos, direccion, edad, email));
		}		
	}

	public void insertarPersonaConsola(Scanner scaner) {

		System.out.println("Por favor insertar los datos de una persona separados por , por ejemplo: ");
		System.out.println("Juan,Sanchez,Direccion N1,40,j.sanchez@email.com");
		try {
			String pLine = scaner.nextLine();
			String[] linea = pLine.split(",");
			personaDao.insertarPersona(new Persona(linea[0], linea[1], linea[2], Integer.valueOf(linea[3]), linea[4]));
		} catch (Exception e) {
			System.err.println("Se ha producido una excepcion: " + e.getLocalizedMessage());
		}
	}

	public List<Persona> consultarPersona() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Indicar la persona a consultar"));
		Persona p = new Persona();
		p.setId(id);
		List<Persona> personas = personaDao.consultarPersona(p);
		if (personas == null || personas.size() == 0) {
			JOptionPane.showMessageDialog(null, "La persona indicada no existe");
		} else {
			for (Persona persona : personas) {
				System.out.println(persona.toString());
			}			
		}
		return personas;
	}

	public List<Persona> consultarPersonas() {
		List<Persona> personas = personaDao.consultarPersonas();
		String personasList = "";
		for (Persona persona : personas) {
			personasList += persona.toString() + "\n";
			System.out.println(persona.toString());
		}		
		//JOptionPane.showMessageDialog(null, "Listado de personas: \n" + personasList, "Consulta de personas", JOptionPane.INFORMATION_MESSAGE, null);
		return personas;
	}

	public void eliminarPersona() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Indicar la persona a eliminar"));
		Persona p = new Persona();
		p.setId(id);
		
		List<Persona> personas = personaDao.consultarPersona(p);
		
		if(personas == null || personas.size() > 0){
			int opc = JOptionPane.showConfirmDialog(null, "Desea eliminar a la persona: \n" + personas.get(0).toString(), "Eliminar Persona", JOptionPane.YES_NO_CANCEL_OPTION);
			if(opc == 0){
				if (personaDao.eliminarPersona(p)) {
					JOptionPane.showMessageDialog(null, "Persona eliminada correctamente");
				}
			}
		}else{
			JOptionPane.showMessageDialog(null, "La persona indicada no existe");
		}
	}

	public void eliminarPersonaConsola(Scanner scaner) {
		System.out.println("Indicar la persona a eliminar: ");
		String pLine = scaner.nextLine();
		Persona p = new Persona();
		p.setId(Integer.valueOf(pLine));
		if (!personaDao.eliminarPersona(p)) {
			System.out.println("La persona indicada no existe");
		} else {
			System.out.println("Persona eliminada correctamente");
		}
	}

	public void modificarPersona() {

		int id = Integer.parseInt(JOptionPane.showInputDialog("Indicar la persona a modificar"));
		Persona p = new Persona();
		p.setId(id);
		List<Persona> personas = personaDao.consultarPersona(p);
		if (personas == null || personas.size() == 0) {
			JOptionPane.showMessageDialog(null, "La persona indicada no existe");
		}else{
			int opc = JOptionPane.showConfirmDialog(null, "Desea modificar a la persona: \n" + personas.get(0).toString(),"Modificar Persona:", JOptionPane.YES_NO_CANCEL_OPTION);
			if(opc == 0){
				String nombre = JOptionPane.showInputDialog("Modificar Nombre " + personas.get(0).getNombre() + " ?");
				String apellidos = JOptionPane.showInputDialog("Modificar Apellidos " + personas.get(0).getApellidos() + " ?");
				String direccion = JOptionPane.showInputDialog("Modificar Dirección " + personas.get(0).getDireccion() + " ?");
				Integer edad = 0;
				boolean isValid = true;
				do {
					try {
						edad = Integer
								.valueOf(JOptionPane.showInputDialog("Modificar Edad " + personas.get(0).getEdad() + " ?"));
						isValid = true;
					} catch (Exception e) {
						isValid = false;
					}
				} while (!isValid);
				String email = JOptionPane.showInputDialog("Modificar Email " + personas.get(0).getEmail() + " ?");
		
				if(nombre.equals("") || apellidos.equals("") || direccion.equals("") || email.equals("")){
					JOptionPane.showMessageDialog(null, "No se puede modificar un usuario con informacion vacia");
				}else{			
					if (personaDao.actualizarPersona(personas.get(0), new Persona(nombre, apellidos, direccion, edad, email))) {
						JOptionPane.showMessageDialog(null, "Se ha modificado la persona correctamente");
					}
				}				
			}
		}
	}

	public void modificarPersonaConsola(Scanner scaner) {

		System.out.println("Por favor insertar los datos de la persona a modificar separados por , ");
		try {
			String pLine = scaner.nextLine();
			Persona p = new Persona();
			p.setId(Integer.valueOf(pLine));
			List<Persona> personas = personaDao.consultarPersona(p);			
			String[] linea = pLine.split(",");
			if (personaDao.actualizarPersona(personas.get(0), new Persona(linea[0], linea[1], linea[2], Integer.valueOf(linea[3]), linea[4]))) {
				System.out.println("Se ha modificado la persona correctamente");
			}
		} catch (Exception e) {
			System.err.println("Se ha producido una excepcion: " + e.getLocalizedMessage());
		}
	}

}
