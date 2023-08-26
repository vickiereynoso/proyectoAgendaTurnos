package com.agendaTurnos.main;

import com.agendaTurnos.conexion.*;
import com.agendaTurnos.dao.*;

public class AppPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Conexion.conectar();
		
		//AgendaDAO.crearTabla();
		//PacienteDAO.crearTabla();
		//TurnoDAO.crearTabla();
		//ProfesionalDAO.crearTabla();
		EspecialidadDAO.crearTabla();
		
		
		
		
	}

}

