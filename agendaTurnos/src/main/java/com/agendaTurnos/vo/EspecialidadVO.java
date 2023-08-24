package com.agendaTurnos.vo;

public class EspecialidadVO {

	private int id;
	private String especialidad;
	
	public EspecialidadVO(String especialidad) {
		super();
		this.especialidad = especialidad;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	@Override
	public String toString() {
		return "EspecialidadVO [id=" + id + ", especialidad=" + especialidad + "]";
	}
	
	
}
