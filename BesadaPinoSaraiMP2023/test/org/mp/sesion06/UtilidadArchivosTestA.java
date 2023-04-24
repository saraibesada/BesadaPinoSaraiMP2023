package org.mp.sesion06;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mp.sesion06.UtilidadArchivos;

public class UtilidadArchivosTestA {

    private String mensaje;
	private String directorioEntrada;
    private List listaControl;

	@Before
	public void setUp() throws Exception {
		directorioEntrada = System.getProperty("user.dir");
		listaControl = new ArrayList();
	}

	@Test
    public void testCopiar() throws IOException{
		directorioEntrada = directorioEntrada + File.separator + "test"
				+ File.separator + "org" + File.separator + "mp"
				+ File.separator + "sesion06" + File.separator;

		String origen = directorioEntrada + "archivoPruebaO.txt";
		String destino = directorioEntrada + "archivoPruebaD.txt";
		File forigen = new File(origen);
		File fdestino = new File(destino);
		FileWriter fw = new FileWriter(forigen);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		pw.println("A");
		pw.println("B");
		pw.println("C");
		pw.close();

		UtilidadArchivos.copiar(forigen, fdestino);
		assertTrue(fdestino.exists());
		assertTrue(forigen.length()==fdestino.length());
	}

	@Test
    public void testComprobarTests(){

    	// Comprueba que los test no han sido modificados
      	cargarArchivoControl("http://jdbm.myqnapcloud.com/control/test2022.txt");

		directorioEntrada = directorioEntrada + File.separator
				+ "test" + File.separator;

		File dir = new File(directorioEntrada);
		UtilidadArchivos utilidadDirectorios = new UtilidadArchivos();
		ArrayList listado = utilidadDirectorios.listarDirectoriosArchivos(dir);

		ArrayList listadoFiltrado = new ArrayList();

		// System.out.println("Listado de los test: ");
		for (Iterator iter = listado.iterator(); iter.hasNext();) {

			File file = (File) iter.next();
			String salida = file.getAbsolutePath();
			if (salida.contains(".java") & salida.contains("Test")
					& !salida.contains(".svn")) {
			    //System.out.println(salida+";"+file.length());
				listadoFiltrado.add(salida + ";" + file.length());
			}
		}

		ArrayList listadoTestModificados = new ArrayList();

		for (Iterator iterA = listaControl.iterator(); iterA.hasNext();) {

			String elemento = (String) iterA.next();
			boolean control = false;

			for (Iterator iter = listadoFiltrado.iterator(); iter.hasNext();) {
				String cadena = (String) iter.next();
				if (cadena.endsWith(elemento)) {
					control = true;
					break;
				}
			}

			if (control) {
				assertTrue(control);
				System.out.println(elemento);
			} else {
				assertFalse(control);
				// El siguiente test ha sido modificado, aparece en rojo:
				System.err.println(elemento);
				listadoTestModificados.add(elemento);
			}
		}
		mensaje = "Alg�n test ha sido modificado";
		assertEquals(mensaje, 0, listadoTestModificados.size());

    }


	@Test
	public void testZip() {

    	// Ser� creado en la carpeta por encima del proyecto
        // para no modificarlo incrementando su tama�o

        String directorioZip = directorioEntrada + File.separator + "src" + File.separator;
        File directorio = new File(directorioZip);

        File directorioSalida = new File(directorioEntrada);
        String salida =  directorioSalida.getParent();

        File fichero = new File(directorioEntrada);
        String nombreFichero = fichero.getName();
        nombreFichero = nombreFichero + ".zip";

        UtilidadArchivos directorios = new UtilidadArchivos();

        /* Directorio a recorrer; directorio de salida; nombre del archivo */
        directorios.zip(directorio, salida, nombreFichero);

        String control = salida + File.separator + nombreFichero;
        File archivoZip = new File(control);

        mensaje = "El zip ha sido creado y existe";
        assertTrue(mensaje, archivoZip.exists());
        mensaje = "Su tama�o debe ser mayor que 10000";
        assertTrue(mensaje, archivoZip.length()>10000);

    }

    public void cargarArchivoControl(String direccion)  {
    	// m�todo de utilidad que cargar ficheros desde una direcci�n URL.
        URL url = null;
		try {
			url = new URL(direccion);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		try {
			InputStream is = url.openStream();
			DataInputStream dis = new DataInputStream(is);

			String str;
			while ((str = dis.readLine()) != null) {
				if (!System.getProperty("os.name").contains("Windows")) {
					str = str.replaceAll("\\\\", File.separator);
				}
				listaControl.add(str);
			}
			is.close();
		} catch (IOException e) {
		}
	}



}
