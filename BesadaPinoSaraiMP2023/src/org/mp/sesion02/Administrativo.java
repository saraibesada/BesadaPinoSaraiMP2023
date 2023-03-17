package org.mp.sesion02;

import java.util.GregorianCalendar;

public class Administrativo extends Empleado{
	
	private String unidad;

	public Administrativo(String nombre, String direccion, String telefono, String email, String despacho, int salario,
			GregorianCalendar fecha, String unidad) {
		super(nombre, direccion, telefono, email, despacho, salario, fecha);
		this.unidad = unidad;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public String toString() {
		return "Administrativo\n" + super.toString() + "\nDestinado en la unidad " + this.unidad;
	}
	
}
