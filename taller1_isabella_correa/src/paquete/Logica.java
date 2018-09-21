package paquete;

import java.awt.Desktop;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import processing.core.PApplet;

public class Logica {

	// BLOQUE DE CONSTANTES
	public final static int MAYUSCULAS = 1;
	public final static int ELIMINAR_A = 2;
	public final static int TEXTO_REVES = 3;
	public final static int TEXTO_ALEAOTRIO = 4;
	public final static int ELIMINAR_VOCALES = 5;
	public final static int ELIMINAR_ESPACIOS = 6;
	public final static int ELIMINAR_TEXTO = 7;
	public final static int LAS_A_SON_O = 8;

	// BLOQUE DE RELACIONES
	private ArrayList<Componente> componentes;

	// BLOQUE DE ATRIBUTOS
	private String cadena;
	private boolean estado;
	private int opacity;

	// BLOQUE CONSTRUCTOR
	public Logica() {

		cadena = "";
		estado = false;
		opacity = 255;
		componentes = new ArrayList<Componente>();

		String rutaArchivo = "./resources/song.txt";
		try {
			LeerTxt(rutaArchivo);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void dibujar(PApplet app) {

		if (estado == false) {
			Componente anillo = new Anillo(app, 200, 200, 2, 1,
					(int) app.random((int) app.random(-5, 5), (int) app.random(6, 11)),
					(int) app.random((int) app.random(-11, 6), (int) app.random(12, 18)), 255, 195, 8, opacity, 100,
					100, 1);

			Componente dobleAnillo = new Anillos(app, 400, 200, 2, 1,
					(int) app.random((int) app.random(-5, 5), (int) app.random(6, 11)),
					(int) app.random((int) app.random(-11, 6), (int) app.random(12, 18)), 255, 153, 102, opacity, 100,
					100, 2);

			Componente carta = new Carta(app, 600, 100, 1, 2,
					(int) app.random((int) app.random(-5, 5), (int) app.random(6, 11)),
					(int) app.random((int) app.random(-11, 6), (int) app.random(12, 18)), 255, 255, 255, opacity, 120,
					150, 3);

			Componente copa = new Copa(app, 800, 100, 1, 2,
					(int) app.random((int) app.random(-5, 5), (int) app.random(6, 11)),
					(int) app.random((int) app.random(-11, 6), (int) app.random(12, 18)), 204, 255, 255, opacity, 100,
					100, 4);

			Componente corazon = new Corazon(app, 200, 400, 2, 1,
					(int) app.random((int) app.random(-5, 5), (int) app.random(6, 11)),
					(int) app.random((int) app.random(-11, 6), (int) app.random(12, 18)), 255, 0, 255, opacity, 100,
					100, 5);

			Componente corazonFlechado = new CorazonFlecha(app, 400, 400, 1, 2,
					(int) app.random((int) app.random(-5, 5), (int) app.random(6, 11)),
					(int) app.random((int) app.random(-11, 6), (int) app.random(12, 18)), 255, 0, 255, opacity, 100,
					100, 6);

			Componente flecha = new Flecha(app, 600, 400, 2, 1,
					(int) app.random((int) app.random(-5, 5), (int) app.random(6, 11)),
					(int) app.random((int) app.random(-11, 6), (int) app.random(12, 18)), 255, 0, 255, opacity, 100,
					100, 7);

			Componente emoji = new Emoji(app, 800, 400, 1, 2,
					(int) app.random((int) app.random(-5, 5), (int) app.random(6, 11)),
					(int) app.random((int) app.random(-11, 6), (int) app.random(12, 18)), 255, 255, 0, opacity, 100,
					100, 8);

			componentes.add(anillo);
			componentes.add(dobleAnillo);
			componentes.add(carta);
			componentes.add(copa);
			componentes.add(corazon);
			componentes.add(corazonFlechado);
			componentes.add(flecha);
			componentes.add(emoji);

			estado = true;
		}

		for (int i = 0; i < componentes.size(); i++) {

			Componente componente = componentes.get(i);
			componente.pintar();
			componente.mover();
		}

	}

	// BLOQUE DE METODOS
	public void Atravesar(PApplet app) {

		mouseClicked(app);
		ModificarTxt(MAYUSCULAS);
	}

	public void DobleClick(PApplet app, int i) {

		mouseWheel(app, i);
		ModificarTxt(ELIMINAR_A);

	}

	public void ClickSostenido() {

		// To-Do: Hacer girar esas cosas
		ModificarTxt(TEXTO_REVES);
	}

	public void Arrastrar(PApplet app) {

		mouseDrag(app);
		ModificarTxt(TEXTO_ALEAOTRIO);

	}

	public void TeclaC(PApplet app) {

		modificarColor(app);
		ModificarTxt(ELIMINAR_VOCALES);
	}

	public void TeclaEspacio(PApplet app) {

		modificarOpacidad(app);
		ModificarTxt(ELIMINAR_ESPACIOS);
	}

	public void TeclaSupr() {

		componentes = new ArrayList<Componente>();
		ModificarTxt(ELIMINAR_TEXTO);
	}

	public void TeclaR(PApplet app) {

		int id = (int) app.random(8);

		crearNuevaFigura(app, id);
		ModificarTxt(LAS_A_SON_O);
	}

	public void modificarOpacidad(PApplet app) {

		for (int i = 0; i < componentes.size(); i++) {
			componentes.get(i).setOpacity(127);
		}

	}

	public void modificarColor(PApplet app) {

		int r = (int) app.random(255);
		int g = (int) app.random(255);
		int b = (int) app.random(255);

		for (int i = 0; i < componentes.size(); i++) {
			if (app.dist(componentes.get(i).getX(), componentes.get(i).getY(), app.mouseX, app.mouseY) < 80) {
				componentes.get(i).setR(r);
				componentes.get(i).setG(g);
				componentes.get(i).setB(b);
			}

		}
	}

	public void mouseDrag(PApplet app) {

		if (app.mousePressed) {
			for (int i = 0; i < componentes.size(); i++) {
				if (app.dist(componentes.get(i).getX(), componentes.get(i).getY(), app.mouseX, app.mouseY) < 80) {
					componentes.get(i).setX((int) app.mouseX);
					componentes.get(i).setY((int) app.mouseY);
				}
			}
		}
	}

	public void mouseClicked(PApplet app) {

		if (app.mouseButton == app.RIGHT) {

			int id = 0;

			for (int i = 0; i < componentes.size(); i++) {

				if (app.dist(componentes.get(i).getX(), componentes.get(i).getY(), app.mouseX, app.mouseY) < 80) {

					id = componentes.get(i).getId();
					break;
				}

			}

			crearNuevaFigura(app, id);

		}
	}

	private void crearNuevaFigura(PApplet app, int id) {

		if (id == 1) {
			Componente anillo = new Anillo(app, app.mouseX, app.mouseY, 2, 1,
					(int) app.random((int) app.random(-5, 5), (int) app.random(6, 11)),
					(int) app.random((int) app.random(-11, 6), (int) app.random(12, 18)), 255, 195, 8, opacity, 100,
					100, 1);
			componentes.add(anillo);

		}
		if (id == 2) {
			Componente dobleAnillo = new Anillos(app, app.mouseX, app.mouseY, 2, 1,
					(int) app.random((int) app.random(-5, 5), (int) app.random(6, 11)),
					(int) app.random((int) app.random(-11, 6), (int) app.random(12, 18)), 255, 153, 102, opacity, 100,
					100, 2);
			componentes.add(dobleAnillo);

		}
		if (id == 3) {
			Componente carta = new Carta(app, app.mouseX, app.mouseY, 1, 2,
					(int) app.random((int) app.random(-5, 5), (int) app.random(6, 11)),
					(int) app.random((int) app.random(-11, 6), (int) app.random(12, 18)), 255, 255, 255, opacity, 120,
					150, 3);
			componentes.add(carta);

		}
		if (id == 4) {
			Componente copa = new Copa(app, app.mouseX, app.mouseY, 1, 2,
					(int) app.random((int) app.random(-5, 5), (int) app.random(6, 11)),
					(int) app.random((int) app.random(-11, 6), (int) app.random(12, 18)), 204, 255, 255, opacity, 100,
					100, 4);
			componentes.add(copa);

		}
		if (id == 5) {
			Componente corazon = new Corazon(app, app.mouseX, app.mouseY, 2, 1,
					(int) app.random((int) app.random(-5, 5), (int) app.random(6, 11)),
					(int) app.random((int) app.random(-11, 6), (int) app.random(12, 18)), 255, 0, 255, opacity, 100,
					100, 5);
			componentes.add(corazon);

		}
		if (id == 6) {
			Componente corazonFlechado = new CorazonFlecha(app, app.mouseX, app.mouseY, 1, 2,
					(int) app.random((int) app.random(-5, 5), (int) app.random(6, 11)),
					(int) app.random((int) app.random(-11, 6), (int) app.random(12, 18)), 255, 0, 255, opacity, 100,
					100, 6);
			componentes.add(corazonFlechado);

		}
		if (id == 7) {
			Componente flecha = new Flecha(app, app.mouseX, app.mouseY, 2, 1,
					(int) app.random((int) app.random(-5, 5), (int) app.random(6, 11)),
					(int) app.random((int) app.random(-11, 6), (int) app.random(12, 18)), 255, 0, 255, opacity, 100,
					100, 7);
			componentes.add(flecha);

		}
		if (id == 8) {

			Componente emoji = new Emoji(app, app.mouseX, app.mouseY, 1, 2,
					(int) app.random((int) app.random(-5, 5), (int) app.random(6, 11)),
					(int) app.random((int) app.random(-11, 6), (int) app.random(12, 18)), 255, 255, 0, opacity, 100,
					100, 8);
			componentes.add(emoji);

		}
	}

	public void mouseWheel(PApplet app, int x) {

		if (x < 0) {
			for (int i = 0; i < componentes.size(); i++) {

				if (app.dist(componentes.get(i).getX(), componentes.get(i).getY(), app.mouseX, app.mouseY) < 80) {

					int alto = componentes.get(i).getAlto();
					int ancho = componentes.get(i).getAncho();

					componentes.get(i).setAlto(alto + 10);
					componentes.get(i).setAncho(ancho + 10);

				}

			}
		} else {
			for (int i = 0; i < componentes.size(); i++) {

				if (app.dist(componentes.get(i).getX(), componentes.get(i).getY(), app.mouseX, app.mouseY) < 80) {

					int alto = componentes.get(i).getAlto();
					int ancho = componentes.get(i).getAncho();

					componentes.get(i).setAlto(alto - 10);
					componentes.get(i).setAncho(ancho - 10);

				}

			}
		}
	}

	public void LeerTxt(String rutaArchivo) throws IOException {

		FileReader fileReader = new FileReader(rutaArchivo);

		BufferedReader bufferReader = new BufferedReader(fileReader);

		String aux = bufferReader.readLine();

		while (aux != null) {
			cadena += aux;
			aux = bufferReader.readLine();
		}
		System.out.println(cadena);
		bufferReader.close();

	}

	public void ModificarTxt(int tipoModificacion) {

		switch (tipoModificacion) {
		case MAYUSCULAS:

			cadena = cadena.toUpperCase();
			// System.out.println(cadena);
			break;

		case ELIMINAR_A:

			cadena = cadena.replaceAll("(?iu)a", "");
			// System.out.println(cadena);
			break;

		case TEXTO_REVES:

			String invCadena = "";

			for (int contador = cadena.length() - 1; contador > 0; contador--) {
				invCadena = invCadena + cadena.charAt(contador);
			}

			cadena = invCadena;
			// System.out.println(cadena);
			break;
		case TEXTO_ALEAOTRIO:

			cadena = revolverCadena(cadena);
			// System.out.println(cadena);
			break;

		case ELIMINAR_VOCALES:

			cadena = cadena.replaceAll("(?iu)[aeiouáéíóúü]", "");
			// System.out.println(cadena);
			break;

		case ELIMINAR_ESPACIOS:

			cadena = cadena.replaceAll("\\s", "");
			// System.out.println(cadena);
			break;

		case ELIMINAR_TEXTO:

			cadena = " ";
			// System.out.println(cadena);
			break;

		case LAS_A_SON_O:

			cadena = cadena.replaceAll("(?iu)a", "o");
			// System.out.println(cadena);
			break;

		}

	}

	private String revolverCadena(String cadena) {

		char[] revolver = cadena.toCharArray();
		String palabraRevuelta = "";
		Random rgen = new Random();

		do {
			for (int i = 0; i < revolver.length; i++) {
				int randomPosition = rgen.nextInt(revolver.length);
				char temp = revolver[i];
				revolver[i] = revolver[randomPosition];
				revolver[randomPosition] = temp;
			}
			for (int i = 0; i < revolver.length; i++) {
				palabraRevuelta += revolver[i];
			}
		} while (palabraRevuelta.equals(cadena) == true);

		return palabraRevuelta;

	}

	public void GenerarTxts() throws IOException {

		Long tiempo = System.currentTimeMillis();

		FileWriter fileWriter = new FileWriter("./resources/modificacion-" + tiempo + ".txt");
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.write(cadena);
		bufferedWriter.close();

		System.out.println("Archivo creado satisfactoriamente como modificacion-" + tiempo
				+ ".txt en la carpeta resources del proyecto.");

		File file = new File("./resources/modificacion-" + tiempo + ".txt");
		Desktop.getDesktop().open(file);

		LeerTxt("./resources/song.txt");
	}

}
