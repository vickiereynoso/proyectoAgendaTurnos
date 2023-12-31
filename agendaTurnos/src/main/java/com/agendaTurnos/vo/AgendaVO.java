package com.agendaTurnos.vo;

import java.util.ArrayList;

public class AgendaVO {

	private int id;
	private int turnosXdia;
	private int idprofesional;
	private int idespecialidad;
	
	public AgendaVO(int turnosXdia) {
		super();
		this.turnosXdia = turnosXdia;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTurnosXdia() {
		return turnosXdia;
	}

	public void setCantTurnosXdia(int turnosXdia) {
		this.turnosXdia = turnosXdia;
	}

	public int getIdprofesional() {
		return idprofesional;
	}

	public void setIdprofesional(int idprofesional) {
		this.idprofesional = idprofesional;
	}

	public int getIdespecialidad() {
		return idespecialidad;
	}

	public void setIdespecialidad(int idespecialidad) {
		this.idespecialidad = idespecialidad;
	}


	@Override
	public String toString() {
		return "AgendaVO [id=" + id + ", turnosXdia=" + turnosXdia + ", idprofesional=" + idprofesional
				+ ", idespecialidad=" + idespecialidad + "]";
	}

}
