package org.mp.sesion04;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGenericJosephus {

	private int k;
	private int n;

	private GenericJosephus<Integer> josephus;
	private GenericJosephus<String> josephus1;

	private Integer[] numeros0 = null;
	private Integer[] numeros1 = {1};
	private Integer[] numerosJosephus = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	private String[] nadie = { "" };
	private String[] persona = { "Josephus" };
	private String[] personas = { "Juan", "Josephus" };
	private String[] personas1 = { "Pablo", "Juan", "Andrés", "Felipe", "Simón", "Tomás", "Josephus" };

	private String stringSalidaToString = "";
	private String stringSalidaOrdenEliminacion = "";

	@Test
	public void testToString() {

		k = 0;
		n = 0;
		josephus = new GenericJosephus<Integer>(k, n, numeros0);

		stringSalidaToString = "Problema de Josephus: k=0, n=0" + "\n" + "Cola: []";
		assertEquals(stringSalidaToString, josephus.toString());

		k = 1;
		n = 1;
		josephus = new GenericJosephus<Integer>(k, n, numeros1);

		stringSalidaToString = "Problema de Josephus: k=1, n=1" + "\n" + "Cola: [1]";
		assertEquals(stringSalidaToString, josephus.toString());

		k = 3;
		n = 9;

		josephus = new GenericJosephus<Integer>(k, n, numerosJosephus);

		stringSalidaToString = "Problema de Josephus: k=3, n=9" + "\n" + "Cola: [1, 2, 3, 4, 5, 6, 7, 8, 9]";
		assertEquals(stringSalidaToString, josephus.toString());

		k = 0;
		n = 0;

		josephus1 = new GenericJosephus<String>(k, n, nadie);

		stringSalidaToString = "Problema de Josephus: k=0, n=0" + "\n" + "Cola: []";

		assertEquals(stringSalidaToString, josephus1.toString());

		k = 1;
		n = 1;
		josephus1 = new GenericJosephus<String>(k, n, persona);

		stringSalidaToString = "Problema de Josephus: k=1, n=1" + "\n" + "Cola: [Josephus]";
		assertEquals(stringSalidaToString, josephus1.toString());

		k = 2;
		n = 2;
		josephus1 = new GenericJosephus<String>(k, n, personas);

		stringSalidaToString = "Problema de Josephus: k=2, n=2" + "\n" + "Cola: [Juan, Josephus]";
		assertEquals(stringSalidaToString, josephus1.toString());

		k = 2;
		n = 7;
		josephus1 = new GenericJosephus<String>(k, n, personas1);

		stringSalidaToString = "Problema de Josephus: k=2, n=7" + "\n"
				+ "Cola: [Pablo, Juan, Andrés, Felipe, Simón, Tomás, Josephus]";
		assertEquals(stringSalidaToString, josephus1.toString());

	}

	@Test
	public void testOrdenEliminacion() {

		k = 0;
		n = 0;
		josephus = new GenericJosephus<Integer>(k, n, numeros0);

		stringSalidaOrdenEliminacion = "No hay ninguna persona";

		try {
			assertEquals(stringSalidaOrdenEliminacion, josephus.ordenEliminar(josephus.getCola()));
			fail("Debería haber lanzado una excepción");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "No hay ninguna persona");
		}

		k = 1;
		n = 1;
		josephus = new GenericJosephus<Integer>(k, n, numeros1);

		stringSalidaOrdenEliminacion = "Solo hay una persona";
		assertEquals(stringSalidaOrdenEliminacion, josephus.ordenEliminar(josephus.getCola()));

		k = 3;
		n = 9;
		josephus = new GenericJosephus<Integer>(k, n, numerosJosephus);

		stringSalidaOrdenEliminacion = "Orden de eliminación: " + "\n" + "Debe morir 3" + "\n" + "Debe morir 6" + "\n"
				+ "Debe morir 9" + "\n" + "Debe morir 4" + "\n" + "Debe morir 8" + "\n" + "Debe morir 5" + "\n"
				+ "Debe morir 2" + "\n" + "Debe morir 7" + "\n"+ "Debe morir 1" + "\n";

		String josephusString = josephus.ordenEliminar(josephus.getCola());
		assertEquals(stringSalidaOrdenEliminacion, josephusString);

		k = 0;
		n = 0;
		josephus1 = new GenericJosephus<String>(k, n, nadie);

		stringSalidaOrdenEliminacion = "No hay ninguna persona";

		try {
			assertEquals(stringSalidaOrdenEliminacion, josephus1.ordenEliminar(josephus1.getCola()));
			fail("Debería haber lanzado una excepción");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "No hay ninguna persona");
		}

		k = 1;
		n = 1;
		josephus1 = new GenericJosephus<String>(k, n, persona);

		stringSalidaOrdenEliminacion = "Solo hay una persona";
		assertEquals(stringSalidaOrdenEliminacion, josephus1.ordenEliminar(josephus1.getCola()));

		k = 2;
		n = 7;
		josephus1 = new GenericJosephus<String>(k, n, personas1);

		stringSalidaOrdenEliminacion = "Orden de eliminación: " + "\n" + "Debe morir Juan" + "\n" + "Debe morir Felipe"
				+ "\n" + "Debe morir Tomás" + "\n" + "Debe morir Pablo" + "\n" + "Debe morir Simón" + "\n"
				+ "Debe morir Andrés" + "\n" + "Debe morir Josephus" + "\n";
		assertEquals(stringSalidaOrdenEliminacion, josephus1.ordenEliminar(josephus1.getCola()));
	}

}
