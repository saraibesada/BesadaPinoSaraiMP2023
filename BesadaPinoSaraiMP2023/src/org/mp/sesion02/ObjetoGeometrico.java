package org.mp.sesion02;

import java.util.GregorianCalendar;

public abstract class ObjetoGeometrico {
	
	protected String color;
	protected boolean relleno;
	protected GregorianCalendar fechaCreado;
	
	protected ObjetoGeometrico() {
		this.color = "blanco";
		this.relleno = false;
		this.fechaCreado = new GregorianCalendar();
	}

	protected ObjetoGeometrico(String color, boolean relleno) {
	this.color = color;
	this.relleno = relleno;
	this.fechaCreado = new GregorianCalendar();
	}
	
	public String getColor() {
		return this.color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public boolean esRelleno() {
		return this.relleno;
	}
	
	public void setRelleno(boolean relleno) {
		this.relleno = relleno;
	}
	
	public GregorianCalendar getFechaCreado() {
		return this.fechaCreado;
	}
	
	public String toString() {
		return "Creado el " + this.fechaCreado + "\ncolor: azul y relleno: "
				+ relleno;
	}
	
	public abstract double getPerimetro();
	public abstract double getArea();
	
}
