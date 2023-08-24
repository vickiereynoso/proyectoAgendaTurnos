package com.agendaTurnos.main;

import com.agendaTurnos.conexion.*;
import com.agendaTurnos.dao.PacienteDAO;

public class AppPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Conexion.conectar();
//		ClienteVO cliente = new ClienteVO(12345678,"Ximena", "xime4422288@gmail.com");
//		ClienteDAO cDAO = new ClienteDAO();
//		cDAO.insertar(cliente);
		PacienteDAO pDAO = new PacienteDAO();
		PacienteDAO.crearTabla();
		
		
		
		
	}

}

