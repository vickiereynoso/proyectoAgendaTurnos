package com.agendaTurnos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.agendaTurnos.conexion.Conexion;
import com.agendaTurnos.vo.AgendaVO;
import com.agendaTurnos.vo.PacienteVO;
import com.agendaTurnos.vo.TurnoVO;

public class AgendaDAO {

	//CREAR TABLA AGENDA:
	
		
		public static void crearTabla() {
			try {
				Connection conexion = Conexion.conectar();			
			    String sql = "CREATE TABLE AGENDA " +
	            "(id INTEGER auto_increment," +
	            " turnosXdia INTEGER ," +
	            " idprofesional INTEGER ," +
	            " idespecialidad INTEGER ," +
	            " PRIMARY KEY ( id ))"; 
				Statement stmt = conexion.createStatement();
				stmt.execute(sql);
				System.out.println("Tabla Agenda creada exitosamente.");
				stmt.close();
				conexion.close();
			}catch(Exception e) {
				System.out.println("No se pudo crear la tabla Turnos.");
				e.printStackTrace();
			}
		}
	
	
	//INSERTAR REGISTRO:
	
		public static void insertar(AgendaVO a) {
			try {
				
				Connection conexion = Conexion.conectar();			
				String sql = "INSERT INTO AGENDA(TURNOSXDIA, IDPROFESIONAL, IDESPECIALIDAD) VALUES (?,?,?)";
				PreparedStatement stmt = conexion.prepareStatement(sql);
				stmt.setInt(1, a.getTurnosXdia());
				stmt.setInt(2, a.getIdprofesional());
				stmt.setInt(3, a.getIdespecialidad());
				stmt.execute();
				System.out.println("La agenda fue creada correctamente");
				stmt.close();
				conexion.close();
			}catch(Exception e) {
				System.out.println("No se pudo crear la agenda.");
				e.printStackTrace();
			}
		}
	
	
	//BORRAR REGISTRO:
	
		public static void borrar(int id) {
			try {
				Connection conexion = Conexion.conectar();
				String sql = "DELETE FROM AGENDA WHERE ID = "+id;
				Statement stmt = conexion.createStatement();
				stmt.execute(sql);
				System.out.println("Agenda eliminada.");
				stmt.close();
				conexion.close();
			}catch(Exception e) {
				System.out.println("No se pudo borrar la agenda.");
				e.printStackTrace();//esto después hay que borrarlo porque queda mal que aparezca en la consola.
				}
			}
	
		
//		//MODIFICAR REGISTRO:
//		
//		public static void modificar(Venta venta) {
//			try {
//				Connection conexion = Conexion.conectar();			
//				String sql = "INSERT INTO VENTA(IDCLIENTE, IDCOMIDA, VENDEDOR) VALUES (?,?,?)";
//				PreparedStatement stmt = conexion.prepareStatement(sql);
//				stmt.setInt(1, venta.getIdCliente());
//				stmt.setInt(2, venta.getIdComida());
//				stmt.setString(3, venta.getVendedor());
//				stmt.execute();
//				System.out.println("El registro fue ingresado correctamente");
//				stmt.close();
//				conexion.close();
//			}catch(Exception e) {
//				System.out.println("No se pudo modificar el registro.");
//				e.printStackTrace();//esto después hay que borrarlo porque queda mal que aparezca en la consola.
//			}
//		}
	
	//MODIFICAR REGISTRO:
	
		public static void modificar(AgendaVO agenda) {
			try {
				Connection conexion = Conexion.conectar();
				String sql = "UPDATE AGENDA SET TURNOSXDIA = '" + agenda.getTurnosXdia() +"' , IDPROFESIONAL = '" 
						+ agenda.getIdprofesional()+"', IDESPECIALIDAD = '"+ agenda.getIdespecialidad() +"'WHERE ID = " + agenda.getId();
				Statement stmt = conexion.createStatement();
				stmt.execute(sql);
				System.out.println("Agenda modificada.");
				stmt.close();
				conexion.close();
			}catch(Exception e) {
				System.out.println("No se pudo modificar la agenda.");
				e.printStackTrace();//esto después hay que borrarlo porque queda mal que aparezca en la consola.
			}
		}
	
	
	//MOSTRAR/LISTAR REGISTRO:
	
	public static void listar() throws SQLException { 
		
			//Otra manera de escribir el código:
			
			Connection conexion = Conexion.conectar();
			Statement stmt = conexion.createStatement();
			
			try {
				String query = "SELECT * FROM AGENDA";
				ResultSet datos = stmt.executeQuery(query); //execute query me retornara todos los datos.
				System.out.println("AGENDA:");
				while(datos.next()) {
					System.out.println("ID: "+ datos.getInt("id"));
					System.out.println("TURNOSXDIA: "+ datos.getInt("turnosXdia"));
					System.out.println("IDPROFESIONAL: "+ datos.getInt("idprofesional"));
					System.out.println("IDESPECIALIDAD: "+ datos.getInt("idespecialidad"));
					System.out.println("-----------------------------------");
				}
			}catch(Exception e) {
				System.out.println("No se pudo mostrar la agenda.");
				e.printStackTrace();//esto después hay que borrarlo porque queda mal que aparezca en la consola.
			}finally {
				stmt.close();
				conexion.close();
			}
		}
	
	
	//BUSCAR REGISTRO : 
	
		public static boolean buscar(int id) throws SQLException { 
			
			boolean existe = false;
			Connection conexion = Conexion.conectar();
			Statement stmt = conexion.createStatement();	
			try {
				String query = "SELECT * FROM AGENDA WHERE ID = " + id;
				ResultSet datos = stmt.executeQuery(query); //execute query me retornará todos los datos.
				//System.out.println("Los datos fueron mostrados correctamente.");
				while(datos.next() && existe == false) {
					if(datos.getInt("id") == id) {			
						//System.out.println("El cliente ya existe en la base de datos:");
						existe = true;
					}else {
						System.out.println("No se ha encontrado la agenda.");
						existe = false;
						}
					};
			}catch(Exception e) {
				System.out.println("No se pudo mostrar la agenda.");
				e.printStackTrace();//esto después hay que borrarlo porque queda mal que aparezca en la consola.
			}finally {
				stmt.close();
				conexion.close();
			}
			return existe;	
		}

	
}
