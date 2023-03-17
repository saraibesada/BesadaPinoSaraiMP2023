/**
 *
 */
package org.mp.sesion03;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

/**
 * @author mdurban
 *
 */
public class TestLinkedList {

	private LinkedList<String> lista1 = new LinkedList<String>();
	private Integer[] enteros = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 }; // autoboxing
	private LinkedList<Integer> lista2 = new LinkedList<Integer>(enteros);

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 *
	 */
	@Test
	public void testGetFirst() {
		assertEquals(null, lista1.getFirst());
		assertEquals(new Integer(1), lista2.getFirst());
		String resultado1 = "[]";
		String resultado2 = "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]";
		assertEquals(resultado1, lista1.toString());
		assertEquals(resultado2, lista2.toString());
	}

	/**
	 * Test method for {@link org.mp.sesion03.LinkedList#getLast()}.
	 */
	@Test
	public void testGetLast() {
		assertEquals(null, lista1.getLast());
		assertEquals(new Integer(16), lista2.getLast());
		String resultado1 = "[]";
		String resultado2 = "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]";
		assertEquals(resultado1, lista1.toString());
		assertEquals(resultado2, lista2.toString());
	}

	/**
	 * Test method for
	 * {@link org.mp.sesion03.LinkedList#addFirst(java.lang.Object)}.
	 */
	@Test
	public void testAddFirst() {
		lista1.addFirst("Ana");
		assertEquals("Ana", lista1.getFirst());
		lista2.addFirst(999);
		assertEquals(new Integer(999), lista2.getFirst());
		String resultado1 = "[Ana]";
		String resultado2 = "[999, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]";
		assertEquals(resultado1, lista1.toString());
		assertEquals(resultado2, lista2.toString());
	}

	/**
	 * Test method for
	 * {@link org.mp.sesion03.LinkedList#addLast(java.lang.Object)}.
	 */
	@Test
	public void testAddLast() {
		lista1.addLast("Zapata");
		assertEquals("Zapata", lista1.getFirst());
		lista2.addLast(999);
		assertEquals(new Integer(999), lista2.getLast());
		String resultado1 = "[Zapata]";
		String resultado2 = "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 999]";
		assertEquals(resultado1, lista1.toString());
		assertEquals(resultado2, lista2.toString());
	}

	/**
	 * Test method for
	 * {@link org.mp.sesion03.LinkedList#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntE() {
		lista1.add(-7, "Juan");
		assertEquals("Juan", lista1.getFirst());
		lista1.add(0, "Ana");
		assertEquals("Ana", lista1.getFirst());
		lista1.add(1, "Belen");
		assertEquals("Ana", lista1.getFirst());
		lista1.add(20, "Zapata");
		assertEquals("Zapata", lista1.getLast());

		lista2.add(-7, 3);
		assertEquals(new Integer(3), lista2.getFirst());
		lista2.add(0, 1);
		assertEquals(new Integer(1), lista2.getFirst());
		lista2.add(1, 5);
		assertEquals(new Integer(1), lista2.getFirst());
		lista2.add(20, 7);
		assertEquals(new Integer(7), lista2.getLast());

		String resultado1 = "[Ana, Belen, Juan, Zapata]";
		String resultado2 = "[1, 5, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 7]";
		assertEquals(resultado1, lista1.toString());
		assertEquals(resultado2, lista2.toString());

	}

	/**
	 * Test method for {@link org.mp.sesion03.LinkedList#removeFirst()}.
	 */
	@Test
	public void testRemoveFirst() {
		assertEquals(null, lista1.removeFirst());
		assertEquals(new Integer(1), lista2.removeFirst());
		String resultado1 = "[]";
		String resultado2 = "[2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]";
		assertEquals(resultado1, lista1.toString());
		assertEquals(resultado2, lista2.toString());

	}

	/**
	 * Test method for {@link org.mp.sesion03.LinkedList#removeLast()}.
	 */
	@Test
	public void testRemoveLast() {
		assertEquals(null, lista1.removeLast()); // lista vacia
		lista1.addFirst("Ana");
		assertEquals("Ana", lista1.removeLast()); // lista con un elemento
		lista1.addFirst("Juan"); // cualquier otro caso
		lista1.addFirst("Ana");
		assertEquals("Juan", lista1.removeLast());

		assertEquals(new Integer(1), lista2.removeFirst());
		// assertEquals(new Integer(1), lista2.removeFirst());

		String resultado1 = "[Ana]";
		String resultado2 = "[2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]";
		assertEquals(resultado1, lista1.toString());
		assertEquals(resultado2, lista2.toString());
	}

	/**
	 * Test method for {@link org.mp.sesion03.LinkedList#remove(int)}.
	 */
	@Test
	public void testRemoveInt() {
		assertEquals(null, lista1.remove(0));
		assertEquals(new Integer(1), lista2.remove(0));
		assertEquals(new Integer(16), lista2.remove(14));
		assertEquals(new Integer(7), lista2.remove(5));
		String resultado1 = "[]";
		String resultado2 = "[2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 13, 14, 15]";
		assertEquals(resultado1, lista1.toString());
		assertEquals(resultado2, lista2.toString());

	}

	/**
	 * Test method for {@link org.mp.sesion03.LinkedList#toString()}.
	 */
	@Test
	public void testToString() {
		// más que probado en los otros pero bueno...
		String resultado1 = "[]";
		String resultado2 = "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]";
		assertEquals(resultado1, lista1.toString());
		assertEquals(resultado2, lista2.toString());

	}

	/**
	 * Test method for {@link org.mp.sesion03.LinkedList#clear()}.
	 */
	@Test
	public void testClear() {
		lista1.clear();
		lista2.clear();
		String resultado1 = "[]";
		String resultado2 = "[]";
		assertEquals(resultado1, lista1.toString());
		assertEquals(resultado2, lista2.toString());

	}

	/**
	 * Test method for
	 * {@link org.mp.sesion03.LinkedList#contains(java.lang.Object)}.
	 */
	@Test
	public void testContains() {
		assertFalse(lista1.contains("Ana"));
		assertTrue(lista2.contains(7));
	}

	/**
	 * Test method for
	 * {@link org.mp.sesion03.LinkedList#indexOf(java.lang.Object)}.
	 */
	@Test
	public void testIndexOf() {
		assertEquals(-1, lista1.indexOf("Jacinto"));
		assertEquals(-1, lista2.indexOf(329));
		assertEquals(0, lista2.indexOf(1));
		assertEquals(15, lista2.indexOf(16));
		assertEquals(4, lista2.indexOf(5));

	}

	/**
	 * Test method for
	 * {@link org.mp.sesion03.LinkedList#lastIndexOf(java.lang.Object)}.
	 */
	@Test
	public void testLastIndexOf() {
		assertEquals(-1, lista1.lastIndexOf("Ana"));
		lista1.add("Ana");
		lista1.add("Ana");
		assertEquals(1, lista1.lastIndexOf("Ana"));

		assertEquals(-1, lista2.lastIndexOf(329));
		lista2.add(16);
		lista2.add(16);
		assertEquals(17, lista2.lastIndexOf(16));

	}

	/**
	 * Test method for
	 * {@link org.mp.sesion03.LinkedList#set(int, java.lang.Object)}.
	 */
	@Test
	public void testSet() {
		assertEquals(null, lista1.set(0, "Juan"));
		lista1.add("Ana");
		assertEquals("Ana", lista1.set(0, "Juan"));

		assertEquals(new Integer(1), lista2.set(0,999));
		assertEquals(new Integer(16), lista2.set(15,999));
		assertEquals(new Integer(8), lista2.set(7,999));

		String resultado1 = "[Juan]";
		String resultado2 = "[999, 2, 3, 4, 5, 6, 7, 999, 9, 10, 11, 12, 13, 14, 15, 999]";
		assertEquals(resultado1, lista1.toString());
		assertEquals(resultado2, lista2.toString());

	}

	/**
	 * Test method for {@link org.mp.sesion03.LinkedList#iterator()}.
	 */
	@Test
	public void testIterator() {
		Iterator<String> iteradorString = lista1.iterator();
		Iterator<Integer> iteradorEnteros = lista2.iterator();
		String resultado1 = "";
		String resultado2 = "";
		
		try {
			iteradorString.next();
			fail("Debería haber lanzado una excepción");
		} catch (NoSuchElementException e) {
			assertEquals(e.getMessage(), "No hay más elementos en la lista");

		}

		while (iteradorString.hasNext()) {
			resultado1 += iteradorString.next() + " ";
		}

		while (iteradorEnteros.hasNext()) {
			resultado2 += iteradorEnteros.next() + " ";
		}

		assertEquals("", resultado1);
		assertEquals("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 ", resultado2);


		iteradorEnteros = lista2.iterator();
		iteradorEnteros.remove();
		assertEquals("[2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]", lista2.toString());
		iteradorEnteros.next();
		iteradorEnteros.remove();
		assertEquals("[3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]", lista2.toString());
		while (iteradorEnteros.hasNext()) {
			iteradorEnteros.next();
			iteradorEnteros.remove();
		}
		assertEquals("[]", lista2.toString());

		iteradorString = lista1.iterator();
		iteradorString.remove();
		assertEquals("[]", lista1.toString());

		}

}
