package com.agsnasoft.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonaFicherosMain {

	public static void main(String[] args) {
		Persona persona1 = new Persona("Jhon", "Conors", "Mi casa n.1", 20, "j.conors@email.com");
		Persona persona2 = new Persona("Sara", "Conors", "Mi casa n.1", 40, "s.conors@email.com");
		
		List<Persona> personas = new ArrayList<Persona>();
		personas.add(persona1);
		personas.add(persona2);
		
		PersonaFicherosMain pFicheros = new PersonaFicherosMain();
		pFicheros.guardarFichero(personas);
		pFicheros.leerFichero();

	}
	
	public void guardarFichero(List<Persona> personas){
		File fichero = new File("C:\\ws_sts_openlegacy\\Persona.txt");
		FileWriter fw;
		try {
			fw = new FileWriter(fichero);
			int i = 0;
			for(Persona persona: personas){
				if(i == 0){
					fw.write("Nombre		Apellidos		Dirección		Edad		Email\n");
					//System.out.println("Nombre		Apellidos		Dirección		Edad		Email");
				}
				
				fw.write(persona.getNombre() + "		" + persona.getApellidos() + "		" + persona.getDireccion() + "		" + persona.getEdad() + "		" + persona.getEmail() + "\n");
				//System.out.println(persona.getNombre() + "		" + persona.getApellidos() + "		" + persona.getDireccion() + "		" + persona.getEdad() + "		" + persona.getEmail());
				i++;
			}
			
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void leerFichero(){
		File fichero = new File("C:\\ws_sts_openlegacy\\Persona.txt");
		String cadena;
		try {
			FileReader fr = new FileReader(fichero);
			BufferedReader bf = new BufferedReader(fr);

			while((cadena = bf.readLine())!= null){
				System.out.println(cadena);
			}
			
			bf.close();
			fr.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
