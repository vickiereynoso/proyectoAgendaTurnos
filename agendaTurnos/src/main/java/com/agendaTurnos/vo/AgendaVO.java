package com.agendaTurnos.vo;

import java.util.ArrayList;

public class AgendaVO {

	private int cantTurnosXdia;
	private ArrayList<TurnoVO>turnos;
	private ArrayList<PacienteVO>pacientes;
	
	public AgendaVO(int cantTurnosXdia) {
		super();
		this.cantTurnosXdia = cantTurnosXdia;
		this.turnos = new ArrayList<>();
		this.pacientes = new ArrayList<>();
	}
		
	public int getCantTurnosXdia() {
		return cantTurnosXdia;
	}
	public ArrayList<TurnoVO> getTurnos() {
		return turnos;
	}
	public ArrayList<PacienteVO> getPacientes() {
		return pacientes;
	}
	public void setCantTurnosXdia(int cantTurnosXdia) {
		this.cantTurnosXdia = cantTurnosXdia;
	}
	public void setTurnos(ArrayList<TurnoVO> turnos) {
		this.turnos = turnos;
	}
	public void setPacientes(ArrayList<PacienteVO> pacientes) {
		this.pacientes = pacientes;
	}
	@Override
	public String toString() {
		return "AgendaVO [cantTurnosXdia=" + cantTurnosXdia + ", turnos=" + turnos + ", pacientes=" + pacientes + "]";
	}
	
}
