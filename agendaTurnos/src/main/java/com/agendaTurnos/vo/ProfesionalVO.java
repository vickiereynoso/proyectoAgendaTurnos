package com.agendaTurnos.vo;

public class ProfesionalVO extends PacienteVO {

	private String especialidad;

	//TENDRIA QUE IR  IDESPECIALIDAD, O ESPECIALIDAD A SECAS.
	public ProfesionalVO(int dni, String nombre, String apellido, String especialidad, String email, String telefono) {
		super(dni, nombre, apellido, email, telefono);
		this.especialidad = especialidad;
		// TODO Auto-generated constructor stub
	}

	
	
	public ProfesionalVO(int id, int dni, String nombre, String apellido, String especialidad, String email, String telefono) {
		super(id, dni, nombre, apellido, email, telefono);
		this.especialidad = especialidad;
	}



	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	@Override
	public String toString() {
		return "ProfesionalVO [especialidad=" + especialidad + ", getId()=" + getId() + ", getDni()=" + getDni()
				+ ", getNombre()=" + getNombre() + ", getApellido()=" + getApellido() + ", getEmail()=" + getEmail()
				+ ", getTelefono()=" + getTelefono() + "]";
	}

	

	
	
}
