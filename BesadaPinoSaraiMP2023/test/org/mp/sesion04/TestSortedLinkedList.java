package org.mp.sesion04;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class TestSortedLinkedList {

	private SortedLinkedList<String> listaOrdenada;
	private SortedLinkedList<String> listaOrdenada1;

	@Before
	public void setUp() throws Exception {
		listaOrdenada = new SortedLinkedList<String>();
		String[] cadenas= {"Zapata","Juan","Ana","Belen","Zapata"};
		listaOrdenada1= new SortedLinkedList<String>(cadenas);
	}

	@Test
	public void testAddE() {
	  try {
		listaOrdenada.add("Juan");
		fail("Debería haber lanzado una excepción");
	} catch (UnsupportedOperationException e) {
		assertEquals(e.getMessage(), "No garantiza orden");
	}
	}

	@Test
	public void testAddFirst() {
		try {
			listaOrdenada.addFirst("Juan");
			fail("Debería haber lanzado una excepción");
		} catch (UnsupportedOperationException e) {
			assertEquals(e.getMessage(), "No garantiza orden");
		}
	}

	@Test
	public void testAddLast() {
		try {
			listaOrdenada.addLast("Juan");
			fail("Debería haber lanzado una excepción");
		} catch (UnsupportedOperationException e) {
			assertEquals(e.getMessage(), "No garantiza orden");
		}
	}
	
	@Test
	public void testAddIndex() {
		try {
			listaOrdenada.add(0,"Juan");
			fail("Debería haber lanzado una excepción");
		} catch (UnsupportedOperationException e) {
			assertEquals(e.getMessage(), "No garantiza orden");
		}
	}

	@Test
	public void testSet() {
		try {
			listaOrdenada.set(8,"Juan");
			fail("Debería haber lanzado una excepción");
		} catch (UnsupportedOperationException e) {
			assertEquals(e.getMessage(), "No garantiza orden");
		}
	}

	@Test
	public void testAddSorted() {

		assertEquals(0, listaOrdenada.size());

		listaOrdenada.addSorted("Juan");
		listaOrdenada.addSorted("Zapata");
		listaOrdenada.addSorted("Belen");
		listaOrdenada.addSorted("Ana");
		listaOrdenada.addSorted("Zapata");

		String salida = listaOrdenada.toString();
		assertEquals("Lista ordenada: [Ana, Belen, Juan, Zapata, Zapata]",salida);

		assertEquals(5, listaOrdenada1.size());

		String salida1 = listaOrdenada1.toString();
		assertEquals("Lista ordenada: [Ana, Belen, Juan, Zapata, Zapata]",salida1);

		listaOrdenada1.addSorted("Gloria");

		assertEquals(6, listaOrdenada1.size());

		salida1 = listaOrdenada1.toString();
		assertEquals("Lista ordenada: [Ana, Belen, Gloria, Juan, Zapata, Zapata]",salida1);
	}
	@Test
	public void testIterador() {

		Iterator<String> iteradorListaOrdenada = listaOrdenada1.iterator();

		while (iteradorListaOrdenada.hasNext()) {
			listaOrdenada1.removeFirst();
			iteradorListaOrdenada.next();
		}

		assertEquals("Lista ordenada: []",listaOrdenada1.toString());

	}

}
