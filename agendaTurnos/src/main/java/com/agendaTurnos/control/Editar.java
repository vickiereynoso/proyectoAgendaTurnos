package com.agendaTurnos.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agendaTurnos.dao.EspecialidadDAO;
import com.agendaTurnos.dao.ProfesionalDAO;
import com.agendaTurnos.vo.EspecialidadVO;
import com.agendaTurnos.vo.ProfesionalVO;

/**
 * Servlet implementation class Editar
 */
public class Editar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Editar() {
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
	     out.println("<h1>Editar Profesional</h1>");
	     int id = Integer.parseInt(request.getParameter("id"));      
	     ProfesionalVO p = ProfesionalDAO.buscarPorID(id);       
	     out.print("<form action='Editar2' method='post'>");  
	     out.print("<table>");  
	     out.print("<tr><td></td><td><input type='hidden' name='id' value='"+p.getId()+"'/></td></tr>");
	     out.print("<tr><td>DNI:</td><td><input type='number' name='dni' value='"+p.getDni()+"'/></td></tr>");  
	     out.print("<tr><td>Nombre:</td><td><input type='text' name='nombre' value='"+p.getNombre()+"'/></td></tr>");
	     out.print("<tr><td>Apellido:</td><td><input type='text' name='apellido' value='"+p.getApellido()+"'/></td></tr>");  
	     out.print("<tr><td>Especialidad:</td><td>");  
	     out.print("<select name='especialidad' style='width:150px'>");   
	     for(EspecialidadVO e: EspecialidadDAO.obtenerEspecialidades()) {
	    	 out.print("<option value="+p.getEspecialidad()+">"+ e.getEspecialidad()+"</option>");
	     }
	     out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+p.getEmail()+"'/></td></tr>");  
	     out.print("<tr><td>Teléfono:</td><td><input type='text' name='teléfono' value='"+p.getTelefono()+"'/></td></tr>");  
	     out.print("</select>");  
	     out.print("</td></tr>"); 
	     out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
	     out.print("</table>");  
	     out.print("</form>");         
	     out.close(); 
	     }catch(Exception e) {
	    	e.printStackTrace();
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
