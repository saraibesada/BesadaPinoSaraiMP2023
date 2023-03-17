package org.mp.sesion02;

public class Estudiante extends Persona{
	
	private int nivel;

	public Estudiante(String nombre, String direccion, String telefono, String email, int nivel) {
		super(nombre, direccion, telefono, email);
		this.nivel = nivel;
		
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	public String toString() {
		String tipo = "";
		if(this.nivel == 1) tipo = "Grado"; 
		else if(this.nivel == 2) tipo = "Máster";
		else tipo = "Doctorado";
		
		return "Estudiante de " + tipo + "\n" + super.toString();
	}

}
