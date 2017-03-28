package com.agsnasoft.java.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.agsnasoft.java.model.Persona;

public class PersonaFileDaoImpl implements PersonaFileDao{
	
	private File fichero;
	
	public PersonaFileDaoImpl() {
		
	}

	public PersonaFileDaoImpl(File fichero) {
		super();
		this.fichero = fichero;
	}

	@Override
	public boolean insertarPersona(Persona person) {
		boolean isOk = false;
		try {
			personas.add(person);
			escribirFichero();
			isOk = true;
		} catch (Exception e) {
			isOk = false;
			e.printStackTrace();
		}
		return isOk;
	}

	@Override
	public boolean actualizarPersona(Persona pActual, Persona pModificada) {
		boolean isOk = false;
		for (int i = 0; i < personas.size(); i++) {
			if(pActual.getId() == personas.get(i).getId()){
				personas.get(i).setNombre(pModificada.getNombre());
				personas.get(i).setApellidos(pModificada.getApellidos());
				personas.get(i).setDireccion(pModificada.getDireccion());
				personas.get(i).setEdad(pModificada.getEdad());
				personas.get(i).setEmail(pModificada.getEmail());
				isOk = true;
			}
		}
		escribirFichero();
		return isOk;
	}

	@Override
	public boolean eliminarPersona(Persona p) {
		boolean isOk = false;
		List<Persona> personasAux = new ArrayList<Persona>();
		for (int i = 0; i < personas.size(); i++) {
			if(!(p.getId() == personas.get(i).getId())){
				personasAux.add(personas.get(i));
				isOk = true;
			}
			System.out.println(personas.get(i).toString());	
		}	
		personas.clear();
		personas.addAll(personasAux);
		escribirFichero();
		return isOk;
	}

	@Override
	public List<Persona> consultarPersonas() {
		String cadena;
		personas.clear();
		try {
			FileReader fr = new FileReader(fichero);
			BufferedReader bf = new BufferedReader(fr);
			System.out.println(bf.readLine());
			while((cadena = bf.readLine())!= null){
				String [] datos = cadena.split(",");	
				personas.add(new Persona(Integer.valueOf(datos[0]),datos[1],datos[2],datos[3],Integer.valueOf(datos[4]),datos[5]));
			}
			bf.close();
			fr.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return personas;
	}

	@Override
	public Persona consultarPersona(Persona p) {
		Persona persona = null;
		for (int i = 0; i < personas.size(); i++) {
			if(p.getId() == personas.get(i).getId()){
				persona = personas.get(i);
			}
		}
		return persona;
	}

	private void escribirFichero(){
		try {
			fichero.delete();
			FileWriter fw = new FileWriter(fichero);
			int i = 0;
			if(personas.size() > 0){			
				for(Persona persona: personas){
					if(i == 0){
						fw.write("Id,Nombre,Apellidos,Dirección,Edad,Email\n");						
					}				
					fw.write(persona.getId() + "," + persona.getNombre() + "," + persona.getApellidos() + "," + persona.getDireccion() + "," + persona.getEdad() + "," + persona.getEmail() + "\n");
					i++;
				}
			}else{
				fw.write("Id,Nombre,Apellidos,Dirección,Edad,Email\n");
			}
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
