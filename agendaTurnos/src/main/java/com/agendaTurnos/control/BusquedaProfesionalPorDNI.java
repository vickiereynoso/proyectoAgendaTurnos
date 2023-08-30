package com.agendaTurnos.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agendaTurnos.dao.ProfesionalDAO;

/**
 * Servlet implementation class BusquedaProfesionalPorDNI
 */
public class BusquedaProfesionalPorDNI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusquedaProfesionalPorDNI() {
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
    	int dni = Integer.parseInt(request.getParameter("dni"));	 
        out.println("<h1>Profesional según DNI:</h1>");  

        if(ProfesionalDAO.buscar(dni) != null) {
        	out.print("<table border='1' width='100%'");  
        	out.print("<tr><th>DNI</th><th>NOMBRE</th><th>APELLIDO</th><th>ESPECIALIDAD</th><th>EMAIL</th><th>TELÉFONO</th></tr>");  
        	out.print("<tr><td>"+ProfesionalDAO.buscar(dni).getDni()+"</td><td>"+ProfesionalDAO.buscar(dni).getNombre()+"</td><td>"+ProfesionalDAO.buscar(dni).getApellido()+"</td><td>"+ProfesionalDAO.buscar(dni).getEspecialidad()+"</td><td>"+ProfesionalDAO.buscar(dni).getEmail()+"</td><td>"+ProfesionalDAO.buscar(dni).getTelefono()+"</td></tr>"); 
            out.print("</table>"); 
        }else {
        	out.print("No se encontró al profesional en cuestión.");
        }
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
