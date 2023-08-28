package com.agendaTurnos.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agendaTurnos.dao.ProfesionalDAO;
import com.agendaTurnos.vo.ProfesionalVO;
import com.agendaTurnos.dao.*;

/**
 * Servlet implementation class BusquedaDeProfesionalPorArea
 */
public class BusquedaDeProfesionalPorArea extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusquedaDeProfesionalPorArea() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();
        try {
        String especialidad = request.getParameter("especialidad");
        //out.println("<a href='index.html'>Add New Employee</a>");  
        out.println("<h1>Lista de Profesionales en la especialidad elegida:</h1>");  
          
        ArrayList<ProfesionalVO> empleados = AgendaDAO.obtenerProfesionalesPorAreaProfesional(especialidad);  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>DNI</th><th>NOMBRE</th><th>APELLIDO</th><th>ESPECIALIDAD</th><th>EMAIL</th><th>TELÉFONO</th></tr>");  
        for(ProfesionalVO p : empleados){  
         out.print("<tr><td>"+p.getDni()+"</td><td>"+p.getNombre()+"</td><td>"+p.getApellido()+"</td><td>"+p.getEspecialidad()+"</td><td>"+p.getEmail()+"</td><td>"+p.getTelefono()+"</td></tr>");  
        }  
        out.print("</table>");  
        out.close(); 
		}catch(Exception e){
			e.printStackTrace();
			out.print("Disculpen. Tenemos inconvenientes para mostrar los resultados.");
		}finally {
			out.print("");
			}

		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
