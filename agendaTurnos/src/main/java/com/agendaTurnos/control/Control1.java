package com.agendaTurnos.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agendaTurnos.dao.*;
import com.agendaTurnos.vo.*;

/**
 * Servlet implementation class Control
 */
public class Control1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Control1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter x = response.getWriter();
		try {
		int dni = Integer.parseInt(request.getParameter("dni"));	
		String nombre = request.getParameter("nombre"); //Del form recibe el name, NO el id.
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String telefono = request.getParameter("telefono");
		
		System.out.println(nombre+ email+ dni);
		
		ProfesionalVO profesional = new ProfesionalVO(dni,nombre,apellido,email,telefono);
		ProfesionalDAO pDAO = new ProfesionalDAO();
		pDAO.insertar(profesional);
		x.print("El registro fue generado correctamente.");
		}catch(Exception e) {
			System.out.println("No fue guardado.");
			e.printStackTrace();
			x.print("Upss. Tenemos inconvenientes para guardar.");
		}
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
