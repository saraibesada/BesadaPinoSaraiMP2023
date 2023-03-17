package org.mp.sesion03;

import java.util.Iterator;

public class EjemploUsoArrayList {
  public static void main(String[] args) {
		// Crea una lista
	List<String> lista = new ArrayList<String>();

	System.out.println();
		// Añade elementos a la lista
	lista.add("España"); // Añade a la lista
	System.out.println("(1) " + lista);

	lista.add(0, "Canada"); // Añade al principio de la lista
		System.out.println("(2) " + lista);

	lista.add("Rusia"); // Añade al final de la lista
    System.out.println("(3) " + lista);

    lista.add("Francia"); // Añade al final de la lista
    System.out.println("(4) " + lista);

    lista.add(2, "Alemania"); // Añade en la posición 2
    System.out.println("(5) " + lista);

    lista.add(5, "Noruega"); // Añade en la posición 5
    System.out.println("(6) " + lista);

    // Elimina elementos de la lista
    lista.remove("Canada"); // Igual que lista.remove(0)
    System.out.println("(7) " + lista);

    lista.remove(2); // Elimina el elemento en la posición 2
    System.out.println("(8) " + lista);

    lista.remove(lista.size() - 1); // elimina el último elemento
    System.out.print("(9) " + lista + "\n(10) ");

    for (String s: lista)
      System.out.print(s.toUpperCase() + " ");
    System.out.println();

    //otra forma
    Iterator<String>  iterador = lista.iterator();
    while (iterador.hasNext()){
    	System.out.print((iterador.next()).toUpperCase()+" ");
    }
  }
}

