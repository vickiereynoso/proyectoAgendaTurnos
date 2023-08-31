package com.agendaTurnos.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agendaTurnos.dao.EspecialidadDAO;
import com.agendaTurnos.vo.EspecialidadVO;

/**
 * Servlet implementation class ListarEspecialidades
 */
public class ListarEspecialidades extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarEspecialidades() {
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
		ArrayList<EspecialidadVO> especialidades = new ArrayList<EspecialidadVO>();
		out.println("<a href='index1.jsp'>VOLVER A INICIO</a>");  
		out.println("<h1>Lista Especialidades</h1>");  
		   
		especialidades = EspecialidadDAO.obtenerEspecialidades();  
		 
        out.print("<table cellpadding=\"5\" cellspacing=\"5\" border=\"1\">");
        out.print("<tr bgcolor=\"lightblue\"><th>ESPECIALIDAD</th><th>EDITAR</th><th>ELIMINAR</th></tr>");  
        for(EspecialidadVO e : especialidades){  
         out.print("<tr bgcolor=\"lightgrey\"><td>"+e.getEspecialidad()+"</td><td><a href='EditServlet?id="+e.getId()+"'>Editar</a></td>"
         		+"<td><a href='DeleteServlet?id="+e.getId()+"'>Eliminar</a></td></tr>");  
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
