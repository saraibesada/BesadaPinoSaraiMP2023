package org.mp.sesion07;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class ImagenDAOTestA {

	String mensaje;
	String directorioEntrada;
	String cabeceraI;
	String cabeceraD;
	String directorioDatos;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		directorioEntrada = System.getProperty("user.dir");

		directorioDatos = directorioEntrada + File.separator + "src" + File.separator + "org" + File.separator + "mp"
				+ File.separator + "sesion07" + File.separator;

		cabeceraI = directorioDatos + "imageni.cabecera";
		cabeceraD = directorioDatos + "imagend.cabecera";

		System.setProperty("line.separator", "\r\n");
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLeerImagenI() throws IOException {

		Imagen imagen = ImagenDAO.leerArchivo(cabeceraI);

		// Todas estas aserciones deben ser ciertas.
		assertTrue(imagen.getFormatoImagen().equals("BSQ"));
		assertTrue(imagen.getNumeroBandas() == 5);
		assertTrue(imagen.getLineas() == 100);
		assertTrue(imagen.getColumnas() == 100);

		assertEquals((imagen.getBandas().get(0)).getNombreBanda(), "Banda1");
		assertEquals((imagen.getBandas().get(1)).getNombreBanda(), "Banda2");
		assertEquals(((Banda) imagen.getBandas().get(2)).getNombreBanda(), "Banda3");
		assertEquals(((Banda) imagen.getBandas().get(3)).getNombreBanda(), "Banda4");
		assertEquals(((Banda) imagen.getBandas().get(4)).getNombreBanda(), "Banda5");
		
		mensaje = "Debe haber una banda menos";
		assertTrue(mensaje, imagen.getNumeroBandas() == 5);
	}
	
	@Test
	public void testLeerImagenD() throws IOException {

		Imagen imagen = ImagenDAO.leerArchivo(cabeceraD);

		// Todas estas aserciones deben ser ciertas.
		assertTrue(imagen.getFormatoImagen().equals("BSQ"));
		assertTrue(imagen.getNumeroBandas() == 5);
		assertTrue(imagen.getLineas() == 100);
		assertTrue(imagen.getColumnas() == 100);

		assertEquals((imagen.getBandas().get(0)).getNombreBanda(), "Banda1");
		assertEquals((imagen.getBandas().get(1)).getNombreBanda(), "Banda2");
		assertEquals(((Banda) imagen.getBandas().get(2)).getNombreBanda(), "Banda3");
		assertEquals(((Banda) imagen.getBandas().get(3)).getNombreBanda(), "Banda4");
		assertEquals(((Banda) imagen.getBandas().get(4)).getNombreBanda(), "Banda5");

		assertTrue(mensaje, imagen.getNumeroBandas() == 5);		
	  }	  
	
	@Test
	public void testEscribirImagenI() throws IOException {

		Imagen imagen = ImagenDAO.leerArchivo(cabeceraI);
		// Todas estas aserciones deben ser ciertas.
		assertTrue(imagen.getFormatoImagen().equals("BSQ"));
		assertTrue(imagen.getNumeroBandas() == 5);
		assertTrue(imagen.getLineas() == 100);
		assertTrue(imagen.getColumnas() == 100);

		Imagen imagenNueva =null;
		try {
			imagenNueva = imagen.extraerImagen(0, 0, 9, 9);
			assertTrue(imagenNueva.getFormatoImagen().equals("BSQ"));
			assertTrue(imagenNueva.getNumeroBandas() == 5);
			assertTrue(imagenNueva.getLineas() == 10);
			assertTrue(imagenNueva.getColumnas() == 10);
			imagenNueva.setTipoImagen("Integer");
		} catch (XYFueraImagenException e) {
			e.printStackTrace();
		}

		 
		  String salida = directorioDatos + "imageni01.cabecera";


		  ImagenDAO.escribirArchivo(salida, imagenNueva);
		  
		  File fcabecera = new File (salida);
		  assertTrue(fcabecera.exists());
		  assertTrue(fcabecera.length()==78);
		  
		  String sdatos = salida.substring(0, salida.length()-8) + "dat";
		  File fdatos = new File (sdatos);
		  assertTrue(fdatos.exists());	  
		  assertTrue(fdatos.length()==2000);		  
	}
	
	@Test
	public void testEscribirImagenD() throws IOException {

		Imagen imagen = ImagenDAO.leerArchivo(cabeceraD);
		// Todas estas aserciones deben ser ciertas.
		assertTrue(imagen.getFormatoImagen().equals("BSQ"));
		assertTrue(imagen.getNumeroBandas() == 5);
		assertTrue(imagen.getLineas() == 100);
		assertTrue(imagen.getColumnas() == 100);

		Imagen imagenNueva =null;
		try {
			imagenNueva = imagen.extraerImagen(0, 0, 9, 9);
			assertTrue(imagenNueva.getFormatoImagen().equals("BSQ"));
			assertTrue(imagenNueva.getNumeroBandas() == 5);
			assertTrue(imagenNueva.getLineas() == 10);
			assertTrue(imagenNueva.getColumnas() == 10);
			imagenNueva.setTipoImagen("Double");
		} catch (XYFueraImagenException e) {
			e.printStackTrace();
		}

		 
		  String salida = directorioDatos + "imagend01.cabecera";
		  ImagenDAO.escribirArchivo(salida, imagenNueva);
		  
		  File fcabecera = new File (salida);
		  assertTrue(fcabecera.exists());
		  assertTrue(fcabecera.length()==77);
		  
		  String sdatos = salida.substring(0, salida.length()-8) + "dat";
		  File fdatos = new File (sdatos);
		  assertTrue(fdatos.exists());	  
		  assertTrue(fdatos.length()==4000);		  
	}

}
