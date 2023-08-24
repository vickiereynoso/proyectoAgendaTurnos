package com.agendaTurnos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.agendaTurnos.conexion.Conexion;
import com.agendaTurnos.vo.TurnoVO;

public class TurnoDAO {

	//CREAR TABLA TURNOS:
	
		public static void crearTabla() {
			try {
				Connection conexion = Conexion.conectar();			
			    String sql = "CREATE TABLE TURNOS " +
	            "(id INTEGER auto_increment," +
			    " idpaciente INTEGER ," +
	            " fecha VARCHAR(50), " + 
	            " hora VARCHAR(50), " + 
	            " PRIMARY KEY ( id ))"; 
				Statement stmt = conexion.createStatement();
				stmt.execute(sql);
				System.out.println("Tabla Pacientes creada exitosamente.");
				stmt.close();
				conexion.close();
			}catch(Exception e) {
				System.out.println("No se pudo crear la tabla Turnos.");
				e.printStackTrace();
			}
		}


	//INSERTAR REGISTRO:

		public static void insertar(TurnoVO t) {
			try {
				
				Connection conexion = Conexion.conectar();			
				String sql = "INSERT INTO TURNOS(IDPACIENTE, FECHA, HORA) VALUES (?,?,?)";
				PreparedStatement stmt = conexion.prepareStatement(sql);
				stmt.setInt(1, t.getPaciente().getId());
				stmt.setString(2, t.getFecha());
				stmt.setString(3, t.getHora());
				stmt.execute();
				System.out.println("El turno fue ingresado correctamente");
				stmt.close();
				conexion.close();
			}catch(Exception e) {
				System.out.println("No se pudo insertar el turno.");
				e.printStackTrace();
			}
		}
	
	
	//BORRAR REGISTRO:
	
		public static void borrar(int id) {
			try {
				Connection conexion = Conexion.conectar();
				String sql = "DELETE FROM TURNOS WHERE ID = "+id;
				Statement stmt = conexion.createStatement();
				stmt.execute(sql);
				System.out.println("Turno eliminado.");
				stmt.close();
				conexion.close();
			}catch(Exception e) {
				System.out.println("No se pudo borrar el turno.");
				e.printStackTrace();//esto después hay que borrarlo porque queda mal que aparezca en la consola.
				}
			}
	
	
	//MODIFICAR REGISTRO:
	
		public static void modificar(TurnoVO turno) {
			try {
				Connection conexion = Conexion.conectar();
				String sql = "UPDATE TURNOS SET IDPACIENTE = '" + turno.getPaciente().getId() +"' , FECHA = '" 
						+ turno.getFecha()+"', HORA = '"+ turno.getHora()+ "'WHERE ID = " + turno.getId();
				Statement stmt = conexion.createStatement();
				stmt.execute(sql);
				System.out.println("Turno modificado.");
				stmt.close();
				conexion.close();
			}catch(Exception e) {
				System.out.println("No se pudo modificar el turno.");
				e.printStackTrace();//esto después hay que borrarlo porque queda mal que aparezca en la consola.
			}
		}
	
	
	//MOSTRAR/LISTAR REGISTRO:
	
	public static void listar() throws SQLException { 
		
		//Otra manera de escribir el código:
		
		Connection conexion = Conexion.conectar();
		Statement stmt = conexion.createStatement();
		
		try {
			String query = "SELECT * FROM TURNOS";
			ResultSet datos = stmt.executeQuery(query); //execute query me retornara todos los datos.
			System.out.println("TURNOS:");
			while(datos.next()) {
				System.out.println("ID: "+ datos.getInt("id"));
				System.out.println("IDPACIENTE: "+ datos.getInt("idpaciente"));
				System.out.println("FECHA: "+ datos.getString("fecha"));
				System.out.println("HORA: "+ datos.getString("hora"));
				System.out.println("-----------------------------------");
			}
		}catch(Exception e) {
			System.out.println("No se pudo mostrar los turnos.");
			e.printStackTrace();//esto después hay que borrarlo porque queda mal que aparezca en la consola.
		}finally {
			stmt.close();
			conexion.close();
		}
	}
	
	
	//BUSCAR REGISTRO : 
	
	public static boolean buscar(int idpaciente) throws SQLException { 
		
		boolean existe = false;
		Connection conexion = Conexion.conectar();
		Statement stmt = conexion.createStatement();	
		try {
			String query = "SELECT * FROM TURNOS WHERE DNI = " + idpaciente;
			ResultSet datos = stmt.executeQuery(query); //execute query me retornará todos los datos.
			//System.out.println("Los datos fueron mostrados correctamente.");
			while(datos.next() && existe == false) {
				if(datos.getInt("idpaciente") == idpaciente) {			
					//System.out.println("El cliente ya existe en la base de datos:");
					existe = true;
				}else {
					System.out.println("No se ha encontrado el turno.");
					existe = false;
					}
				};
		}catch(Exception e) {
			System.out.println("No se pudo mostrar los turnos.");
			e.printStackTrace();//esto después hay que borrarlo porque queda mal que aparezca en la consola.
		}finally {
			stmt.close();
			conexion.close();
		}
		return existe;	
	}

	
}
