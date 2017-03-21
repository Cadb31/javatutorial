package com.agsnasoft.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agsnasoft.java.model.Persona;

public class PersonaDaoImpl implements PersonaDao {

	private Connection connection;

	public PersonaDaoImpl(String url, String usr, String pwd) {
		try {
			this.connection = DriverManager.getConnection(url, usr, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean insertarPersona(Persona p) {
		boolean isOk = false;
		String qInsert = "INSERT INTO personas.persona (nombre, apellidos, direccion, edad, email) VALUES( ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = connection.prepareStatement(qInsert);
			
			ps.setString(1, p.getNombre());
			ps.setString(2, p.getApellidos());
			ps.setString(3, p.getDireccion());
			ps.setInt(4, p.getEdad());
			ps.setString(5, p.getEmail());
			
			int r = ps.executeUpdate();
			ps.close();
			if(r != -1){
				isOk = true;				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isOk;
	}

	@Override
	public boolean actualizarPersona(Persona pActual, Persona pModificada) {
		boolean isOk = false;		
		String qEliminar = "UPDATE personas.persona SET nombre = ?, apellidos = ?, direccion = ?, edad = ?, email = ? WHERE nombre=? AND apellidos=? AND direccion=? AND edad=? AND email=?";


		try {
			
			PreparedStatement ps = connection.prepareStatement(qEliminar);
			ps.setString(1, pModificada.getNombre());
			ps.setString(2, pModificada.getApellidos());
			ps.setString(3, pModificada.getDireccion());
			ps.setInt(4, pModificada.getEdad());
			ps.setString(5, pModificada.getEmail());

			ps.setString(6, pActual.getNombre());
			ps.setString(7, pActual.getApellidos());
			ps.setString(8, pActual.getDireccion());
			ps.setInt(9, pActual.getEdad());
			ps.setString(10, pActual.getEmail());
			
			int r = ps.executeUpdate();
			ps.close();
			if(r > 0){
				isOk = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return isOk;
	}

	@Override
	public boolean eliminarPersona(Persona p) {
		boolean isOk = false;		
		String qEliminar = "DELETE FROM personas.persona WHERE nombre=? AND apellidos=? AND direccion=? AND edad=? AND email=?";

		try {
			
			PreparedStatement ps = connection.prepareStatement(qEliminar);
			ps.setString(1, p.getNombre());
			ps.setString(2, p.getApellidos());
			ps.setString(3, p.getDireccion());
			ps.setInt(4, p.getEdad());
			ps.setString(5, p.getEmail());
			
			int r = ps.executeUpdate();
			ps.close();
			if(r != -1){
				isOk = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return isOk;
	}
	
	@Override
	public List<Persona> consultarPersonas() {
		List<Persona> personas = new ArrayList<Persona>();
		String qSelect = "SELECT * FROM personas.persona";

		try {
			PreparedStatement ps = connection.prepareStatement(qSelect);

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				personas.add(new Persona(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return personas;
	}

	@Override
	public List<Persona> consultarPersona(Persona p) {
	
		List<Persona> personas = new ArrayList<Persona>();
		String qSelect = "SELECT * FROM personas.persona WHERE nombre=? AND apellidos=? AND direccion=? AND edad=? AND email=?";

		try {
			PreparedStatement ps = connection.prepareStatement(qSelect);
			
			ps.setString(1, p.getNombre());
			ps.setString(2, p.getApellidos());
			ps.setString(3, p.getDireccion());
			ps.setInt(4, p.getEdad());
			ps.setString(5, p.getEmail());

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				personas.add(new Persona(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return personas;
	}

}
