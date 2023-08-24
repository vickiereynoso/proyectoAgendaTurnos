package com.agendaTurnos.vo;

public class TurnoVO {

	private int id;
	private PacienteVO paciente;
	private ProfesionalVO profesional;
	private boolean asistencia=false;
	private String fecha;
	private String hora;
	
	public TurnoVO(PacienteVO paciente, ProfesionalVO profesional, boolean asistencia, String fecha, String hora) {
		super();
		this.paciente = paciente;
		this.profesional = profesional;
		this.asistencia = asistencia;
		this.fecha = fecha;
		this.hora = hora;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PacienteVO getPaciente() {
		return paciente;
	}

	public void setPaciente(PacienteVO paciente) {
		this.paciente = paciente;
	}

	public ProfesionalVO getProfesional() {
		return profesional;
	}

	public void setProfesional(ProfesionalVO profesional) {
		this.profesional = profesional;
	}

	public boolean isAsistencia() {
		return asistencia;
	}

	public void setAsistencia(boolean asistencia) {
		this.asistencia = asistencia;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	@Override
	public String toString() {
		return "TurnoVO [id=" + id + ", paciente=" + paciente + ", profesional=" + profesional + ", asistencia="
				+ asistencia + ", fecha=" + fecha + ", hora=" + hora + "]";
	}

	
	
}
