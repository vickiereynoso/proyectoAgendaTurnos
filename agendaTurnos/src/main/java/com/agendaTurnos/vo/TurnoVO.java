package com.agendaTurnos.vo;

public class TurnoVO {

	private PacienteVO paciente;
	private boolean asistencia=false;
	private String fecha;
	private String hora;
	
	public TurnoVO(PacienteVO paciente, String fecha, String hora) {
		super();
		this.paciente = paciente;
		this.fecha = fecha;
		this.hora = hora;
	}
	
	public PacienteVO getPaciente() {
		return paciente;
	}
	public boolean isAsistencia() {
		return asistencia;
	}
	public String getFecha() {
		return fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setPaciente(PacienteVO paciente) {
		this.paciente = paciente;
	}
	public void setAsistencia(boolean asistencia) {
		this.asistencia = asistencia;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	@Override
	public String toString() {
		return "TurnoVO [paciente=" + paciente + ", asistencia=" + asistencia + ", fecha=" + fecha + ", hora=" + hora
				+ "]";
	}
	
	
	
}
