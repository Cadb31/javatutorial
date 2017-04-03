package com.agsnasoft.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agsnasoft.java.model.Persona;

public class PersonaDaoImpl implements PersonaDao {

	private Connection connection;

	public PersonaDaoImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean insertarPersona(Persona p) {
		boolean isOk = false;
		String qInsert = "INSERT INTO persona (nombre, apellidos, direccion, edad, email) VALUES( ?, ?, ?, ?, ?)";
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
		String qEliminar = "UPDATE persona SET nombre = ?, apellidos = ?, direccion = ?, edad = ?, email = ? WHERE id = ?";

		try {
			
			PreparedStatement ps = connection.prepareStatement(qEliminar);
			ps.setString(1, pModificada.getNombre());
			ps.setString(2, pModificada.getApellidos());
			ps.setString(3, pModificada.getDireccion());
			ps.setInt(4, pModificada.getEdad());
			ps.setString(5, pModificada.getEmail());

			ps.setInt(6, pActual.getId());
			
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
		String qEliminar = "DELETE FROM persona WHERE id = ?";

		try {
			
			PreparedStatement ps = connection.prepareStatement(qEliminar);
			ps.setInt(1, p.getId());
			
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
	public List<Persona> consultarPersonas() {
		List<Persona> personas = new ArrayList<Persona>();
		String qSelect = "SELECT id, nombre, apellidos, direccion, edad, email FROM persona";

		try {
			PreparedStatement ps = connection.prepareStatement(qSelect);

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				personas.add(new Persona(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6)));
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return personas;
	}

	@Override
	public Persona consultarPersona(Persona p) {
	
		Persona persona = null;
		String qSelect = "SELECT id, nombre, apellidos, direccion, edad, email FROM persona WHERE id = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(qSelect);
			
			ps.setInt(1, p.getId());

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				persona  = new Persona(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return persona;
	}

}
