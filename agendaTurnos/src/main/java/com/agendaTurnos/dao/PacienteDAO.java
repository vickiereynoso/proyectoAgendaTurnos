package com.agendaTurnos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.agendaTurnos.conexion.*;
import com.agendaTurnos.vo.*;

public class PacienteDAO {

	
//CREAR TABLA PACIENTES:

		public static void crearTabla() {
			try {
				Connection conexion = Conexion.conectar();			
			    String sql = "CREATE TABLE PACIENTES " +
	            "(id INTEGER auto_increment," +
			    " dni INTEGER not NULL," +
	            " nombre VARCHAR(50), " + 
	            " apellido VARCHAR(50), " + 
	            " email VARCHAR(50), " +
	            " telefono VARCHAR(15),"+
	            " PRIMARY KEY ( id ))"; 
				Statement stmt = conexion.createStatement();
				stmt.execute(sql);
				System.out.println("Tabla Pacientes creada exitosamente.");
				stmt.close();
				conexion.close();
			}catch(Exception e) {
				System.out.println("No se pudo crear la tabla Pacientes.");
				e.printStackTrace();
			}
		}


		//INSERTAR REGISTRO:

		public static void insertar(PacienteVO p) {
			try {
				
				Connection conexion = Conexion.conectar();			
				String sql = "INSERT INTO PACIENTES(DNI, NOMBRE, APELLIDO, EMAIL, TELEFONO) VALUES (?,?,?,?,?)";
				PreparedStatement stmt = conexion.prepareStatement(sql);
				stmt.setInt(1, p.getDni());
				stmt.setString(2, p.getNombre());
				stmt.setString(3, p.getApellido());
				stmt.setString(4, p.getEmail());
				stmt.setString(5, p.getTelefono());
				stmt.execute();
				System.out.println("El paciente fue ingresado correctamente");
				stmt.close();
				conexion.close();
			}catch(Exception e) {
				System.out.println("No se pudo registrar el paciente.");
				e.printStackTrace();
			}
		}
		
		
		//BORRAR REGISTRO:
		
		public static void borrar(int id) {
			try {
				Connection conexion = Conexion.conectar();
				String sql = "DELETE FROM PACIENTES WHERE ID = "+id;
				Statement stmt = conexion.createStatement();
				stmt.execute(sql);
				System.out.println("Paciente eliminado.");
				stmt.close();
				conexion.close();
			}catch(Exception e) {
				System.out.println("No se pudo borrar el paciente.");
				e.printStackTrace();//esto después hay que borrarlo porque queda mal que aparezca en la consola.
				}
			}
		
		
		//MODIFICAR REGISTRO:
		
		public static void modificar(PacienteVO paciente) {
			try {
				Connection conexion = Conexion.conectar();
				String sql = "UPDATE PACIENTES SET DNI = '" + paciente.getDni() +"' , NOMBRE = '" 
						+ paciente.getNombre()+"', APELLIDO = '"+ paciente.getApellido()+"', EMAIL = '" + paciente.getEmail()+ "', TELEFONO = '" + paciente.getTelefono()+ "'WHERE ID = " + paciente.getId();
				Statement stmt = conexion.createStatement();
				stmt.execute(sql);
				System.out.println("Paciente modificado.");
				stmt.close();
				conexion.close();
			}catch(Exception e) {
				System.out.println("No se pudo modificar el paciente.");
				e.printStackTrace();//esto después hay que borrarlo porque queda mal que aparezca en la consola.
			}
		}
		
		
		//MOSTRAR/LISTAR REGISTRO:
		
		public static void listar() throws SQLException { 
			
			//Otra manera de escribir el código:
			
			Connection conexion = Conexion.conectar();
			Statement stmt = conexion.createStatement();
			
			try {
				String query = "SELECT * FROM PACIENTES";
				ResultSet datos = stmt.executeQuery(query); //execute query me retornara todos los datos.
				System.out.println("PACIENTES:");
				while(datos.next()) {
					System.out.println("ID: "+ datos.getInt("id"));
					System.out.println("DNI: "+ datos.getInt("dni"));
					System.out.println("Nombre: "+ datos.getString("nombre"));
					System.out.println("Apellido: "+ datos.getString("apellido"));
					System.out.println("Email: "+ datos.getString("email"));
					System.out.println("Telefono: "+ datos.getString("telefono"));
					System.out.println("-----------------------------------");
				}
			}catch(Exception e) {
				System.out.println("No se pudo mostrar los pacientes.");
				e.printStackTrace();//esto después hay que borrarlo porque queda mal que aparezca en la consola.
			}finally {
				stmt.close();
				conexion.close();
			}
		}
		
		
		//BUSCAR REGISTRO : 
		
		public static boolean buscar(int dni) throws SQLException { 
			
			boolean existe = false;
			Connection conexion = Conexion.conectar();
			Statement stmt = conexion.createStatement();	
			try {
				String query = "SELECT * FROM PACIENTES WHERE DNI = " + dni;
				ResultSet datos = stmt.executeQuery(query); //execute query me retornará todos los datos.
				//System.out.println("Los datos fueron mostrados correctamente.");
				while(datos.next() && existe == false) {
					if(datos.getInt("dni") == dni) {			
						//System.out.println("El cliente ya existe en la base de datos:");
						existe = true;
					}else {
						System.out.println("No se ha encontrado el paciente.");
						existe = false;
						}
					};
			}catch(Exception e) {
				System.out.println("No se pudo mostrar los pacientes.");
				e.printStackTrace();//esto después hay que borrarlo porque queda mal que aparezca en la consola.
			}finally {
				stmt.close();
				conexion.close();
			}
			return existe;	
		}

}
