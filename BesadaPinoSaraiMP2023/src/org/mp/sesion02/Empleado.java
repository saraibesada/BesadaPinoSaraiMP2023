package org.mp.sesion02;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Empleado extends Persona{

	private String despacho;
	private int salario;
	private GregorianCalendar fecha;
	
	public Empleado(String nombre, String direccion, String telefono, String email, String despacho, int salario, GregorianCalendar fecha) {
		super(nombre, direccion, telefono, email);
		this.despacho = despacho;
		this.salario = salario;
		this.fecha = fecha;
	}

	public String getDespacho() {
		return despacho;
	}

	public void setDespacho(String despacho) {
		this.despacho = despacho;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}
	
	public String toString() {
		return super.toString() + "\nDespacho = " + this.despacho + ", salario = " + this.salario + ", Fecha de contratación = "
				+ this.fecha.get(Calendar.DAY_OF_MONTH) +"/" + (this.fecha.get(Calendar.MONTH)+1) + "/" + this.fecha.get(Calendar.YEAR);
	}
	
	

}

