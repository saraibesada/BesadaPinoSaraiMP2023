package org.mp.sesion03;

public class EjemploUsoLinkedList {
	/** Main method */
	public static void main(String[] args) {
		// Crea una lista de string
		LinkedList<String> lista = new LinkedList<String>();

		System.out.println();
		// Añade elementos a la lista
		lista.add("España"); // Añade a la lista
		System.out.println("(1) " + lista);

		lista.add(0, "Canada"); // Añade al principio de la lista
		System.out.println("(2) " + lista);

		lista.add("Rusia"); // Añade al final de la lista
		System.out.println("(3) " + lista);

		lista.addLast("Francia"); // Añade al final de la lista
		System.out.println("(4) " + lista);

		lista.add(2, "Alemania"); // Añade en la posición 2 de la lista
		System.out.println("(5) " + lista);

		lista.add(5, "Noruega"); // Añade en la posición 5 de la lista
		System.out.println("(6) " + lista);

		lista.add(0, "Polonia"); // Igual que lista.addFirst("Polonia")
		System.out.println("(7) " + lista);

    // Elimina elementos de la lista
    lista.remove(0); // Igual que lista.remove("Polonia")
    System.out.println("(8) " + lista);

    lista.remove(2); // Elimina el elemento en la posici�n 2
    System.out.println("(9) " + lista);

    lista.remove(lista.size() - 1); // Elimina el último elemento
    System.out.print("(10) " + lista + "\n(11) ");

    for (String s: lista)
      System.out.print(s.toUpperCase() + " ");

    lista.clear();
    System.out.println("\nDespués de limpiar la lista, el tamaño es  "
      + lista.size());
  }
}
