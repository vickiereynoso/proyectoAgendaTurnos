package com.agendaTurnos.main;

import java.sql.SQLException;

import com.agendaTurnos.conexion.*;
import com.agendaTurnos.dao.*;

public class AppPrincipal {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		Conexion.conectar();
		
		//AgendaDAO.crearTabla();
		//PacienteDAO.crearTabla();
		//TurnoDAO.crearTabla();
		//ProfesionalDAO.crearTabla();
		//EspecialidadDAO.crearTabla();
		AgendaDAO.mostrarProfesionalesPorAreaProfesional("Dermatologia");
		
		
		
	}

}

