package com.agendaTurnos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.agendaTurnos.conexion.Conexion;
import com.agendaTurnos.vo.EspecialidadVO;
import com.agendaTurnos.vo.ProfesionalVO;

public class EspecialidadDAO {

	//CREAR TABLA ESPECIALIDADES:

			public static void crearTabla() {
				try {
					Connection conexion = Conexion.conectar();			
				    String sql = "CREATE TABLE ESPECIALIDADES " +
		            "(id INTEGER auto_increment," +
		            " especialidad VARCHAR(50), " + 
		            " PRIMARY KEY ( id ))"; 
					Statement stmt = conexion.createStatement();
					stmt.execute(sql);
					System.out.println("Tabla Especialidades creada exitosamente.");
					stmt.close();
					conexion.close();
				}catch(Exception e) {
					System.out.println("No se pudo crear la tabla Especialidades.");
					e.printStackTrace();
				}
			}


			//INSERTAR REGISTRO:

			public static void insertar(EspecialidadVO e) {
				try {
					
					Connection conexion = Conexion.conectar();			
					String sql = "INSERT INTO ESPECIALIDADES(ESPECIALIDAD) VALUES (?)";
					PreparedStatement stmt = conexion.prepareStatement(sql);
					stmt.setString(1, e.getEspecialidad());
					stmt.execute();
					System.out.println("La especialidad fue ingresada correctamente");
					stmt.close();
					conexion.close();
				}catch(Exception err) {
					System.out.println("No se pudo registrar la especialidad.");
					err.printStackTrace();
				}
			}
			
			
			//BORRAR REGISTRO:
			
			public static void borrar(int id) {
				try {
					Connection conexion = Conexion.conectar();
					String sql = "DELETE FROM ESPECIALIDADES WHERE ID = "+id;
					Statement stmt = conexion.createStatement();
					stmt.execute(sql);
					System.out.println("Especialidad eliminada.");
					stmt.close();
					conexion.close();
				}catch(Exception e) {
					System.out.println("No se pudo borrar la especialidad.");
					e.printStackTrace();//esto después hay que borrarlo porque queda mal que aparezca en la consola.
					}
				}
			
			
			//MODIFICAR REGISTRO:
			
			public static void modificar(EspecialidadVO especialidad) {
				try {
					Connection conexion = Conexion.conectar();
					String sql = "UPDATE ESPECIALIDADES SET ESPECIALIDAD = '" + especialidad.getEspecialidad() + "'WHERE ID = " + especialidad.getId();
					Statement stmt = conexion.createStatement();
					stmt.execute(sql);
					System.out.println("Especialidad modificada.");
					stmt.close();
					conexion.close();
				}catch(Exception e) {
					System.out.println("No se pudo modificar la especialidad.");
					e.printStackTrace();//esto después hay que borrarlo porque queda mal que aparezca en la consola.
				}
			}
			
			
			//MOSTRAR/LISTAR REGISTRO:
			
			public static void listar() throws SQLException { 
				
				//Otra manera de escribir el código:
				
				Connection conexion = Conexion.conectar();
				Statement stmt = conexion.createStatement();
				
				try {
					String query = "SELECT * FROM ESPECIALIDADES";
					ResultSet datos = stmt.executeQuery(query); //execute query me retornara todos los datos.
					System.out.println("ESPECIALIDADES:");
					while(datos.next()) {
						System.out.println("ID: "+ datos.getInt("id"));
						System.out.println("ESPECIALIDAD: "+ datos.getString("especialidad"));
						System.out.println("-----------------------------------");
					}
				}catch(Exception e) {
					System.out.println("No se pudo mostrar las especialidades.");
					e.printStackTrace();//esto después hay que borrarlo porque queda mal que aparezca en la consola.
				}finally {
					stmt.close();
					conexion.close();
				}
			}
			
			
			//BUSCAR REGISTRO : 
			
			public static boolean buscar(String especialidad) throws SQLException { 
				
				boolean existe = false;
				Connection conexion = Conexion.conectar();
				Statement stmt = conexion.createStatement();	
				try {
					String query = "SELECT * FROM ESPECIALIDADES WHERE ESPECIALIDAD = " + especialidad;
					ResultSet datos = stmt.executeQuery(query); //execute query me retornará todos los datos.
					//System.out.println("Los datos fueron mostrados correctamente.");
					while(datos.next() && existe == false) {
						if(datos.getString("especialidad") == especialidad) {			
							//System.out.println("El cliente ya existe en la base de datos:");
							existe = true;
						}else {
							System.out.println("No se ha encontrado la especialidad.");
							existe = false;
							}
						};
				}catch(Exception e) {
					System.out.println("No se pudo mostrar las especialidades.");
					e.printStackTrace();//esto después hay que borrarlo porque queda mal que aparezca en la consola.
				}finally {
					stmt.close();
					conexion.close();
				}
				return existe;	
			}

	
			public static ArrayList<EspecialidadVO> obtenerEspecialidades() throws SQLException { 				
				ArrayList<EspecialidadVO> especialidades = new ArrayList<>();
				Connection conexion = Conexion.conectar();
				Statement stmt = conexion.createStatement();	
				try {
					String query = "SELECT * FROM ESPECIALIDADES";
					ResultSet datos = stmt.executeQuery(query); //execute query me retornará todos los datos.
					//System.out.println("Los datos fueron mostrados correctamente.");
					while(datos.next()) {
						especialidades.add(new EspecialidadVO(datos.getString("especialidad")));
						};
				}catch(Exception e) {
					System.out.println("ERROR.");
					e.printStackTrace();//esto después hay que borrarlo porque queda mal que aparezca en la consola.
				}finally {
					stmt.close();
					conexion.close();
				}
				return especialidades;	
			}
			
}
