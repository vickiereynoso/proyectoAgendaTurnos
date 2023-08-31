package com.agendaTurnos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.agendaTurnos.conexion.Conexion;
import com.agendaTurnos.vo.ProfesionalVO;

public class ProfesionalDAO {

	//CREAR TABLA PROFESIONALES:

			public static void crearTabla() {
				try {
					Connection conexion = Conexion.conectar();			
				    String sql = "CREATE TABLE PROFESIONALES " +
		            "(id INTEGER auto_increment," +
				    " dni INTEGER not NULL," +
		            " nombre VARCHAR(50), " + 
		            " apellido VARCHAR(50), " +
		            " especialidad VARCHAR(50), " +
		            " email VARCHAR(50), " +
		            " telefono VARCHAR(15),"+
		            " PRIMARY KEY ( id ))"; 
					Statement stmt = conexion.createStatement();
					stmt.execute(sql);
					System.out.println("Tabla Profesionales creada exitosamente.");
					stmt.close();
					conexion.close();
				}catch(Exception e) {
					System.out.println("No se pudo crear la tabla Profesionales.");
					e.printStackTrace();
				}
			}


			//INSERTAR REGISTRO:

			public static void insertar(ProfesionalVO p) {
				try {
					
					Connection conexion = Conexion.conectar();			
					String sql = "INSERT INTO PROFESIONALES(DNI, NOMBRE, APELLIDO, ESPECIALIDAD, EMAIL, TELEFONO) VALUES (?,?,?,?,?,?)";
					PreparedStatement stmt = conexion.prepareStatement(sql);
					stmt.setInt(1, p.getDni());
					stmt.setString(2, p.getNombre());
					stmt.setString(3, p.getApellido());
					stmt.setString(4, p.getEspecialidad());
					stmt.setString(5, p.getEmail());
					stmt.setString(6, p.getTelefono());
					stmt.execute();
					System.out.println("El profesional fue ingresado correctamente");
					stmt.close();
					conexion.close();
				}catch(Exception e) {
					System.out.println("No se pudo registrar el profesional.");
					e.printStackTrace();
				}
			}
			
			
			//BORRAR REGISTRO:
			
			public static void borrar(int id) {
				try {
					Connection conexion = Conexion.conectar();
					String sql = "DELETE FROM PROFESIONALES WHERE ID = "+id;
					Statement stmt = conexion.createStatement();
					stmt.execute(sql);
					System.out.println("Profesional eliminado.");
					stmt.close();
					conexion.close();
				}catch(Exception e) {
					System.out.println("No se pudo borrar el profesional.");
					e.printStackTrace();//esto después hay que borrarlo porque queda mal que aparezca en la consola.
					}
				}
			
			
			//MODIFICAR REGISTRO:
			
			public static void modificar(ProfesionalVO profesional) {
				try {
					Connection conexion = Conexion.conectar();
					String sql = "UPDATE PACIENTES SET DNI = '" + profesional.getDni() +"' , NOMBRE = '" 
							+ profesional.getNombre()+"', APELLIDO = '"+ profesional.getApellido()+ "', ESPECIALIDAD = '"+ profesional.getEspecialidad() +"', EMAIL = '" + profesional.getEmail()+ "', TELEFONO = '" + profesional.getTelefono()+ "'WHERE ID = " + profesional.getId();
					Statement stmt = conexion.createStatement();
					stmt.execute(sql);
					System.out.println("Profesional modificado.");
					stmt.close();
					conexion.close();
				}catch(Exception e) {
					System.out.println("No se pudo modificar el profesional.");
					e.printStackTrace();//esto después hay que borrarlo porque queda mal que aparezca en la consola.
				}
			}
			
			
			//MOSTRAR/LISTAR REGISTRO:
			
			public static void listar() throws SQLException { 
				
				//Otra manera de escribir el código:
				
				Connection conexion = Conexion.conectar();
				Statement stmt = conexion.createStatement();
				
				try {
					String query = "SELECT * FROM PROFESIONALES";
					ResultSet datos = stmt.executeQuery(query); //execute query me retornara todos los datos.
					System.out.println("PROFESIONALES:");
					while(datos.next()) {
						System.out.println("ID: "+ datos.getInt("id"));
						System.out.println("DNI: "+ datos.getInt("dni"));
						System.out.println("Nombre: "+ datos.getString("nombre"));
						System.out.println("Apellido: "+ datos.getString("apellido"));
						System.out.println("Especialidad: "+ datos.getString("especialidad"));
						System.out.println("Email: "+ datos.getString("email"));
						System.out.println("Telefono: "+ datos.getString("telefono"));
						System.out.println("-----------------------------------");
					}
				}catch(Exception e) {
					System.out.println("No se pudo mostrar los profesionales.");
					e.printStackTrace();//esto después hay que borrarlo porque queda mal que aparezca en la consola.
				}finally {
					stmt.close();
					conexion.close();
				}
			}
			
			
			//BUSCAR REGISTRO : 
			
			public static ProfesionalVO buscar(int dni) throws SQLException { 
				
				ProfesionalVO profesional = null;
				Connection conexion = Conexion.conectar();
				Statement stmt = conexion.createStatement();	
				try {
					String query = "SELECT * FROM PROFESIONALES WHERE DNI = " + dni;
					ResultSet datos = stmt.executeQuery(query); //execute query me retornará todos los datos.
					//System.out.println("Los datos fueron mostrados correctamente.");
					while(datos.next() && profesional == null) {
						if(datos.getInt("dni") == dni) {			
							profesional = new ProfesionalVO(datos.getInt("dni"),datos.getString("nombre"),datos.getString("apellido"),datos.getString("especialidad"),datos.getString("email"),datos.getString("telefono"));
							}
						};
				}catch(Exception e) {
					System.out.println("ERROR.");
					e.printStackTrace();//esto después hay que borrarlo porque queda mal que aparezca en la consola.
				}finally {
					stmt.close();
					conexion.close();
				}
				return profesional;	
			}

 
			public static ProfesionalVO buscarPorID(int id) throws SQLException { 
				
				ProfesionalVO profesional = null;
				Connection conexion = Conexion.conectar();
				Statement stmt = conexion.createStatement();	
				try {
					String query = "SELECT * FROM PROFESIONALES WHERE ID = " + id;
					ResultSet datos = stmt.executeQuery(query); //execute query me retornará todos los datos.
					//System.out.println("Los datos fueron mostrados correctamente.");
					while(datos.next() && profesional == null) {
						if(datos.getInt("id") == id) {			
							profesional = new ProfesionalVO(datos.getInt("dni"),datos.getString("nombre"),datos.getString("apellido"),datos.getString("especialidad"),datos.getString("email"),datos.getString("telefono"));
							}
						};
				}catch(Exception e) {
					System.out.println("ERROR.");
					e.printStackTrace();//esto después hay que borrarlo porque queda mal que aparezca en la consola.
				}finally {
					stmt.close();
					conexion.close();
				}
				return profesional;	
			}
			
			public static ArrayList<ProfesionalVO> obtenerProfesionales() throws SQLException { 				
				ArrayList<ProfesionalVO> profesionales = new ArrayList<>();
				Connection conexion = Conexion.conectar();
				Statement stmt = conexion.createStatement();	
				try {
					String query = "SELECT * FROM PROFESIONALES";
					ResultSet datos = stmt.executeQuery(query); //execute query me retornará todos los datos.
					//System.out.println("Los datos fueron mostrados correctamente.");
					while(datos.next()) {
						profesionales.add(new ProfesionalVO(datos.getInt("id"),datos.getInt("dni"),datos.getString("nombre"),datos.getString("apellido"),datos.getString("especialidad"),datos.getString("email"),datos.getString("telefono")));
						};
				}catch(Exception e) {
					System.out.println("ERROR.");
					e.printStackTrace();//esto después hay que borrarlo porque queda mal que aparezca en la consola.
				}finally {
					stmt.close();
					conexion.close();
				}
				return profesionales;	
			}
			
}
