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

/**
 * Servlet implementation class ListarProfesionales
 */
public class ListarProfesionales extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarProfesionales() {
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
		ArrayList<ProfesionalVO> profesionales = new ArrayList<ProfesionalVO>();
		out.println("<a href='index1.jsp'>VOLVER A INICIO</a>");   
		out.println("<h1>Lista Profesionales</h1>");  
		   
		profesionales = ProfesionalDAO.obtenerProfesionales();  
		 
        out.print("<table cellpadding='5' cellspacing='5' border='1' width='100%'>");
        out.print("<tr bgcolor='lightblue'><th>ID</th><th>DNI</th><th>NOMBRE</th><th>APELLIDO</th><th>ESPECIALIDAD</th><th>EMAIL</th><th>TELÉFONO</th><th>EDITAR</th><th>ELIMINAR</th></tr>");  
        for(ProfesionalVO p : profesionales){  
         out.print("<tr bgcolor='lightgrey'><td>"+p.getId()+"</td><td>"+p.getDni()+"</td><td>"+p.getNombre()+"</td><td>"+p.getApellido()+"</td><td>"+p.getEspecialidad()+"</td><td>"+p.getEmail()+"</td><td>"+p.getTelefono()+"</td><td><a href='Editar?id="+p.getId()+"'>Editar</a></td>"
         		+"<td><a href='DeleteServlet?id="+p.getId()+"'>Eliminar</a></td></tr>");  
        }  
		 out.print("</table>");  
		 out.close();
		}catch(Exception e) {
			e.printStackTrace();
			out.print("Disculpen. Tenemos inconvenientes para mostrar los resultados.");
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
