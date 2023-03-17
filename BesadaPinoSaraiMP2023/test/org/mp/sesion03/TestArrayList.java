
package org.mp.sesion03;

import static org.junit.Assert.*;


import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;


public class TestArrayList {

	private ArrayList<String> lista1 = new ArrayList<String>();
	private Integer[] enteros = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16}; // autoboxing
	private ArrayList<Integer> lista2 = new ArrayList<Integer>(enteros);


	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIsEmpty() {
		assertTrue(lista1.isEmpty());
		assertFalse(lista2.isEmpty());
	}

	@Test
	public void testAddE() {
		assertEquals(0, lista1.size);
		lista1.add("Juan");
		assertEquals(1, lista1.size);
		assertEquals(lista1.toString(), "[Juan]");
		lista2.add(25);
		assertEquals(17, lista2.size);
		assertEquals(lista2.toString(), "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 25]");
	}

	@Test
	public void testAddIntE() {
		int index = 0;
		try {
			index = -1;
			lista1.add(index, "Ana");
			index = 1;
			lista1.add(1, "Ana");
			fail("Debería haber lanzado una excepción");
		} catch (IndexOutOfBoundsException e) {
			assertEquals(e.getMessage(), "Indice: " + index + ", Tamaño: " + lista1.size);
			
		}
		lista1.add(0, "Ana");
		assertEquals(lista1.toString(), "[Ana]");
		lista2.add(lista2.size, 999);
		assertEquals(lista2.toString(), "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 999]");
		lista2.add(3, 111);
		assertEquals(lista2.toString(), "[1, 2, 3, 111, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 999]");
	}

	@Test
	public void testClear() {
		lista1.clear();
		assertEquals(0, lista1.size);
		assertEquals(lista1.toString(), "[]");
		lista2.clear();
		assertEquals(0, lista2.size);
		assertEquals(lista2.toString(), "[]");
	}

	@Test
	public void testContains() {
		assertTrue(lista2.contains(7));
		assertFalse(lista1.contains("Juan"));
	}

	@Test
	public void testGet() {
		String string = "";
		int index = 0;
		try {
			index = -1;
			string = lista1.get(index);
			index = 17;
			string = lista1.get(index);
			fail("Debería haber lanzado una excepción");
		} catch (IndexOutOfBoundsException e) {
			assertEquals(e.getMessage(), "Indice: " + index + ", Tamaño: " + lista1.size);
		}
		lista1.add("Ana");
		string = lista1.get(0);
		assertEquals("Ana", string);
		try {
			index = -1;
			lista2.get(index); // unboxing
			index = 1;
			lista2.get(index); // unboxing
			fail("Debería haber lanzado una excepción");
		} catch (IndexOutOfBoundsException e) {
			assertEquals(e.getMessage(), "Indice: " + index + ", Tamaño: " + lista2.size);
		}
		lista2.add(0);
		string = lista2.toString();
		assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 0]", string);

	}

	@Test
	public void testIndexOf() {
		assertEquals(-1, lista1.indexOf("Jacinto"));
		assertEquals(-1, lista2.indexOf(978));
		lista1.add("Ana");
		assertEquals(0, lista1.indexOf("Ana"));
		assertEquals(0, lista2.indexOf(1));
		assertEquals(15, lista2.indexOf(16));
		assertEquals(3, lista2.indexOf(4));
	}

	@Test
	public void testLastIndexOf() {
		lista1.add("Ana");
		lista1.add("Ana");
		assertEquals(1, lista1.lastIndexOf("Ana"));
		lista2.add(7);
		lista2.add(7);
		lista2.add(7);
		assertEquals(18, lista2.lastIndexOf(7));

	}

	@Test
	public void testRemoveInt() {
		String string;
		Integer entero;
		int index = 0;

		try {
			string = lista1.remove(index);
			fail("Debería haber lanzado una excepción");

		} catch (IndexOutOfBoundsException e) {
			assertEquals(e.getMessage(), "Indice: " + index + ", Tamaño: " + lista1.size);
		}
		try {
			index = -1;
			entero = lista2.remove(index);
			index = 16;
			entero = lista2.remove(index);
			fail("Debería haber lanzado una excepción");

		} catch (IndexOutOfBoundsException e) {
			assertEquals(e.getMessage(), "Indice: " + index + ", Tamaño: " + lista2.size);
		}
		index = 0;
		entero = lista2.remove(index);
		assertEquals(new Integer(2), lista2.get(0));
		lista1.add("Ana");
		lista1.add("Juan");
		string = lista1.remove(0);
		assertEquals("Juan", lista1.get(0));

	}

	@Test
	public void testSet() {
		int index = 0;
		try {
			lista1.set(index, "Juan");
			fail("Debería haber lanzado una excepción");
		} catch (IndexOutOfBoundsException e) {
			assertEquals(e.getMessage(), "Indice: " + index + ", Tamaño: " + lista1.size);
		}
		try {
			index = 16;
			lista2.set(index, 25);
			index = -1;
			lista2.set(index, 25);
			fail("Debería haber lanzado una excepción");
		} catch (IndexOutOfBoundsException e) {
			assertEquals(e.getMessage(), "Indice: " + index + ", Tamaño: " + lista2.size);
		}
		index = 0;
		lista1.add("Ana");
		assertEquals("Ana", lista1.set(index, "Juan"));
		assertEquals("Juan", lista1.get(0));
		index = 5;
		assertEquals(new Integer(6), lista2.set(index, 345));
		assertEquals(new Integer(345), lista2.get(5));
	}

	@Test
	public void testTrimToSize() {
		try {
			lista2.trimToSize();
			fail("Debería haber lanzado una excepción");
		} catch (RuntimeException e1) {
			assertEquals(e1.getMessage(),"Guapit@ no necesitas hacer un trim, el tamaño coincide con la capacidad");
		}
		assertEquals(16, lista2.size);
		System.out.print(
				"Antes de invocar al método trimToSize, la capacidad es igual al tamaño => " + lista2.size + "\n");
		System.out.print("\tLista: ");
		int i = 0;
		for (; i < 16; i++) {
			System.out.print(lista2.get(i) + " ");
		}
		System.out.println("\n\nBorramos 5 elementos.....e invocamos al método trimToSize");
		lista2.remove(0);
		lista2.remove(0);
		lista2.remove(0);
		lista2.remove(0);
		lista2.remove(0);

		lista2.trimToSize();

		System.out.print("\nDespués de invocar al método trimToSize, la capacidad se ha adecuado al tamaño y es => "
				+ lista2.size + "\n");
		assertEquals(11, lista2.size);
		i = 0;
		System.out.print("\tLista: ");
		try {
			for (; i < 16; i++) {
				System.out.print(lista2.get(i) + " ");
			}
			fail("Debería haber lanzado una excepción");
		} catch (IndexOutOfBoundsException e) {
			System.out
					.println("\n\nCapturo la excepción por intentar acceder a la posición " + i  + " en la lista");
		}

	}

	@Test
	public void testIterator() {
		Iterator<String> iteradorString = lista1.iterator();
		Iterator<Integer> iteradorEnteros = lista2.iterator();

		assertEquals(new Integer(1), iteradorEnteros.next());
		assertEquals(new Integer(2), iteradorEnteros.next());

		assertTrue(iteradorEnteros.hasNext());
		assertFalse(iteradorString.hasNext());
		
		try {
			iteradorString.next();
			fail("Debería haber lanzado una excepción");
		} catch (NoSuchElementException e) {
			assertEquals(e.getMessage(), "No hay más elementos en la lista");

		}

		lista1.add("Ana");
		lista1.add("Juan");

		assertEquals("Ana", iteradorString.next());
		assertEquals("Juan", iteradorString.next());

		iteradorEnteros.remove();
		assertEquals(new Integer(4), lista2.get(2));
		int index = 2;
		try {
			iteradorString.remove();
			fail("Debería haber lanzado una excepción");
		} catch (IndexOutOfBoundsException e) {
			assertEquals(e.getMessage(), "Indice: " + index + ", Tamaño: " + lista1.size);
		}

	}


}
