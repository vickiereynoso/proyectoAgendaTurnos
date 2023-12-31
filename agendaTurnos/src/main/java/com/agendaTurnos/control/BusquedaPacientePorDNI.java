package com.agendaTurnos.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agendaTurnos.dao.PacienteDAO;
import com.agendaTurnos.dao.ProfesionalDAO;

/**
 * Servlet implementation class BusquedaPacientePorDNI
 */
public class BusquedaPacientePorDNI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusquedaPacientePorDNI() {
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
        out.println("<h1>Paciente según DNI:</h1>");  
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>DNI</th><th>NOMBRE</th><th>APELLIDO</th><th>EMAIL</th><th>TELÉFONO</th></tr>");  
        if(PacienteDAO.buscar(dni) != null) {
        	        out.print("<tr><td>"+PacienteDAO.buscar(dni).getDni()+"</td><td>"+PacienteDAO.buscar(dni).getNombre()+"</td><td>"+PacienteDAO.buscar(dni).getApellido()+"</td><td>"+PacienteDAO.buscar(dni).getEmail()+"</td><td>"+PacienteDAO.buscar(dni).getTelefono()+"</td></tr>"); 
        }else {
        	out.print("No se encontró al paciente en cuestión.");
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
