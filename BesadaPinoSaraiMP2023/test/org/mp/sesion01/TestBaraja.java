package org.mp.sesion01;


import static org.junit.Assert.*;

import java.util.Random;


import org.junit.Before;
import org.junit.Test;

public class TestBaraja {

	private Carta carta;
	private Baraja baraja;
	private Carta[] cartasNP;

	@Before
	public void setUp() throws Exception {

		Carta[] cartas = new Carta[40];
		String[] palos = { "O", "C", "E", "B" };

		int j = 0;
		for (int k = 0; k < palos.length; k++) {
			for (int i = 1; i < 8; i++) {
				carta = new Carta(palos[k], i);
				cartas[j] = carta;
				j++;
			}
			for (int i = 10; i < 13; i++) {
				carta = new Carta(palos[k], i);
				cartas[j] = carta;
				j++;
			}
		}
		baraja = new Baraja("EspaÃ±ola", cartas);

		cartasNP = new Carta[40];

		j=0;
		for (int i = 1; i < 8; i++) {
			for (int k = 0; k < palos.length; k++) {
				carta = new Carta(palos[k], i);
				cartasNP[j] = carta;
				j++;
			}
		}
		for (int i = 10; i < 13; i++) {
			for (int k = 0; k < palos.length; k++) {
				carta = new Carta(palos[k], i);
				cartasNP[j] = carta;
				j++;
			}
		}

	}

	@Test
	public void testGetters() {


		Carta carta1 = new Carta("O", 1);
		Carta carta2 = new Carta("B", 12);

		assertEquals(1, carta1.getValor());
		assertEquals("B", carta2.getPalo());
		assertEquals(12, carta2.getNumero());
		assertEquals(48, carta2.getValor());



	}

	@Test
	public void testEqualsCarta() {

		Carta carta1 = new Carta("O", 5);
		Carta carta2 = new Carta("O", 2);
		Carta carta3 = new Carta("E", 2);
		Carta carta4 = new Carta("O", 2);

		assertEquals(true, carta1.equals(carta1));
		assertEquals(true, carta2.equals(carta2));
		assertEquals(true, carta3.equals(carta3));
		assertEquals(true, carta2.equals(carta4));

		assertEquals(false, carta3.equals(carta1));
		assertEquals(false, carta3.equals("MiCarta"));
		assertEquals(false, carta3.equals(new Integer(8)));

	}

	@Test
	public void testCompareToCarta() {

		Carta carta1 = new Carta("O", 5);
		Carta carta2 = new Carta("O", 2);
		Carta carta3 = new Carta("E", 2);
		assertEquals(0, carta1.compareTo(carta1));
		assertEquals(-1, carta1.compareTo(carta3));
		assertEquals(1, carta1.compareTo(carta2));
	}

	@Test
	public void testOrdenarBarajaInsercion() {

		Carta[] cartas = baraja.getCartas();
		barajar(cartas);
		baraja.insercion(cartas);

		for (int i = 0; i < cartas.length - 1; i++) {
			//System.out.println(cartas[i]+" <-> "+ cartas[i + 1]);
			assertEquals(-1, cartas[i].compareTo(cartas[i + 1]));
		}
	}


	public void barajar(Carta[] cartas) {

		Random rand = new Random();
		for (int i = 0; i < 160; i++) {
			int x = rand.nextInt(40);
			int y = rand.nextInt(40);

			Carta swap = cartas[x];
			cartas[x] = cartas[y];
			cartas[y] = swap;
		}
	}

}