package com.agendaTurnos.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agendaTurnos.dao.ProfesionalDAO;
import com.agendaTurnos.vo.ProfesionalVO;

/**
 * Servlet implementation class Editar2
 */
public class Editar2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Editar2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());   	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
	    int id = Integer.parseInt(request.getParameter("id")); 
	    int dni = Integer.parseInt(request.getParameter("dni")); 
        String nombre=request.getParameter("nombre");  
        String apellido=request.getParameter("apellido");  
        String especialidad=request.getParameter("especialidad");  
        String email=request.getParameter("email");  
        String telefono=request.getParameter("telefono");
 
        int status= ProfesionalDAO.modificar(new ProfesionalVO(id,dni,nombre,apellido,especialidad,email,telefono));  
        if(status>0){  
            response.sendRedirect("ListarProfesionales");  
        }else{  
            out.println("Disculpas. No se pudo modificar el registro.");  
        }            
        out.close();
		
	}

}
