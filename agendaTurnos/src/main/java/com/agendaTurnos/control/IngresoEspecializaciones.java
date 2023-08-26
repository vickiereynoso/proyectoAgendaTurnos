package com.agendaTurnos.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agendaTurnos.dao.EspecialidadDAO;
import com.agendaTurnos.vo.EspecialidadVO;

/**
 * Servlet implementation class IngresoEspecializaciones
 */
public class IngresoEspecializaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IngresoEspecializaciones() {
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
		PrintWriter x = response.getWriter();
		try {	
		String especialidad = request.getParameter("especialidad");		
		EspecialidadVO especialidadVO = new EspecialidadVO(especialidad);
		EspecialidadDAO eDAO = new EspecialidadDAO();
		eDAO.insertar(especialidadVO);
		x.print("El registro fue generado correctamente.");
		}catch(Exception e) {
			System.out.println("No fue guardado.");
			e.printStackTrace();
			x.print("Upss. Tenemos inconvenientes para guardar.");
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
