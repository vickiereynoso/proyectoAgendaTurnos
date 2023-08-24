package com.agendaTurnos.vo;

import java.util.ArrayList;

public class AgendaVO {

	private int id;
	private int turnosXdia;
	private int idprofesional;
	private int idespecialidad;
	private int idturnos;
	private int idpacientes;
	
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

	public int getIdturnos() {
		return idturnos;
	}

	public void setIdturnos(int idturnos) {
		this.idturnos = idturnos;
	}

	public int getIdpacientes() {
		return idpacientes;
	}

	public void setIdpacientes(int idpacientes) {
		this.idpacientes = idpacientes;
	}


	@Override
	public String toString() {
		return "AgendaVO [id=" + id + ", turnosXdia=" + turnosXdia + ", idprofesional=" + idprofesional
				+ ", idespecialidad=" + idespecialidad + ", idturnos=" + idturnos + ", idpacientes=" + idpacientes
				+ "]";
	}

}
