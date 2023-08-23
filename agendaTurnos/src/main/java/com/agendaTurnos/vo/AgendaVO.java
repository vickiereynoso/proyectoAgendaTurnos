package com.agendaTurnos.vo;

import java.util.ArrayList;

public class AgendaVO {

	private int cantTurnosXdia;
	private String profesional;
	private String especialidad;
	private ArrayList<TurnoVO>turnos;
	private ArrayList<PacienteVO>pacientes;
	
	public AgendaVO(int cantTurnosXdia, String profesional, String especialidad) {
		super();
		this.cantTurnosXdia = cantTurnosXdia;
		this.profesional = profesional;
		this.especialidad = especialidad;
		this.turnos = new ArrayList<>();
		this.pacientes = new ArrayList<>();
	}

	public int getCantTurnosXdia() {
		return cantTurnosXdia;
	}

	public void setCantTurnosXdia(int cantTurnosXdia) {
		this.cantTurnosXdia = cantTurnosXdia;
	}

	public String getProfesional() {
		return profesional;
	}

	public void setProfesional(String profesional) {
		this.profesional = profesional;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public ArrayList<TurnoVO> getTurnos() {
		return turnos;
	}

	public void setTurnos(ArrayList<TurnoVO> turnos) {
		this.turnos = turnos;
	}

	public ArrayList<PacienteVO> getPacientes() {
		return pacientes;
	}

	public void setPacientes(ArrayList<PacienteVO> pacientes) {
		this.pacientes = pacientes;
	}

	@Override
	public String toString() {
		return "AgendaVO [cantTurnosXdia=" + cantTurnosXdia + ", profesional=" + profesional + ", especialidad="
				+ especialidad + ", turnos=" + turnos + ", pacientes=" + pacientes + "]";
	}
		
	
}
