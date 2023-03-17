package org.mp.sesion02;

import java.util.GregorianCalendar;

public class Profesor extends Empleado{
	
	private String horario;
	private int categoria;

	public Profesor(String nombre, String direccion, String telefono, String email, String despacho, int salario,
			GregorianCalendar fecha, String horario, int categoria) {
		super(nombre, direccion, telefono, email, despacho, salario, fecha);
		
		this.horario = horario;
		this.categoria = categoria;
	}

	public String getTutoria() {
		return horario;
	}

	public void setTutoria(String tutoria) {
		this.horario = tutoria;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	
	public String toString() {
		String tipo = "";
		if(this.categoria == 1) tipo = "Ayudante";
		else if(this.categoria == 2) tipo = "Titular de Universidad";
		else tipo = "Catedrático de Universidad";
		return "Profesor " + tipo + "\n" + super.toString() + "\nHorario = " + this.horario;
	}

}
