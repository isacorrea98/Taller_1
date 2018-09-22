package paquete;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import processing.core.PApplet;

public class Logica {

	public final static int MAYUSCULAS = 1;
	public final static int ELIMINAR_A = 2;
	public final static int TEXTO_AL_REVES = 3;
	public final static int TEXTO_ALEATORIO = 4;
	public final static int ELIMINAR_VOCALES = 5;
	public final static int ELIMINAR_ESPACIOS = 6;
	public final static int TEXTO_BLANCO = 7;
	public final static int LAS_A_SON_O = 8;

	private ArrayList<Componente> componentes;
	private String cadena;
	private PApplet app;
	private int opacity;

	public Logica(PApplet app) {

		this.app = app;
		cadena = "";
		opacity = 255;
		componentes = new ArrayList<Componente>();
	}

	private void dividirFigura() {
		for (int i = 0; i < componentes.size(); i++) {
			if (app.dist(componentes.get(i).getX(), componentes.get(i).getY(), app.mouseX, app.mouseY) < 80) {
				crearNueva(componentes.get(i).getId());
				break;
			}
		}
	}

	private void aumentarTamano(int accion) {

		if (accion < 0) {

			for (int i = 0; i < componentes.size(); i++) {
				if (app.dist(componentes.get(i).getX(), componentes.get(i).getY(), app.mouseX, app.mouseY) < 80) {

					componentes.get(i).setAlto(componentes.get(i).getAlto() + 10);
					componentes.get(i).setAncho(componentes.get(i).getAncho() + 10);
				}
			}
		}

		else if (accion > 0) {

			for (int i = 0; i < componentes.size(); i++) {
				if (app.dist(componentes.get(i).getX(), componentes.get(i).getY(), app.mouseX, app.mouseY) < 80) {

					componentes.get(i).setAlto(componentes.get(i).getAlto() - 10);
					componentes.get(i).setAncho(componentes.get(i).getAncho() - 10);
				}
			}
		}
	}

	public void inicializar() {

		Componente anillo = new Anillo(app, 100, 200, 1, 2,
				(int) app.random((int) app.random(-5, 5), (int) app.random(6, 11)),
				(int) app.random((int) app.random(-11, 6), (int) app.random(12, 18)), 100, 100, 241, 196, 15, opacity,
				1);
		componentes.add(anillo);

		Componente anillos = new Anillos(app, 300, 200, 1, 2,
				(int) app.random((int) app.random(-5, 5), (int) app.random(6, 11)),
				(int) app.random((int) app.random(-11, 6), (int) app.random(12, 18)), 100, 100, 241, 196, 15, opacity,
				2);

		componentes.add(anillos);

		Componente carta = new Carta(app, 500, 100, 1, 2,
				(int) app.random((int) app.random(-5, 5), (int) app.random(6, 11)),
				(int) app.random((int) app.random(-11, 6), (int) app.random(12, 18)), 100, 150, 255, 255, 255, opacity,
				3);

		componentes.add(carta);

		Componente copa = new Copa(app, 700, 100, 1, 2,
				(int) app.random((int) app.random(-5, 5), (int) app.random(6, 11)),
				(int) app.random((int) app.random(-11, 6), (int) app.random(12, 18)), 100, 100, 203, 255, 255, opacity,
				4);

		componentes.add(copa);

		Componente corazon = new Corazon(app, 900, 100, 1, 2,
				(int) app.random((int) app.random(-5, 5), (int) app.random(6, 11)),
				(int) app.random((int) app.random(-11, 6), (int) app.random(12, 18)), 100, 100, 255, 0, 107, opacity,
				5);

		componentes.add(corazon);

		Componente corazonf = new CorazonFlecha(app, 1000, 100, 1, 2,
				(int) app.random((int) app.random(-5, 5), (int) app.random(6, 11)),
				(int) app.random((int) app.random(-11, 6), (int) app.random(12, 18)), 100, 100, 255, 0, 107, opacity,
				6);

		componentes.add(corazonf);

		Componente flecha = new Flecha(app, 1100, 100, 1, 2,
				(int) app.random((int) app.random(-5, 5), (int) app.random(6, 11)),
				(int) app.random((int) app.random(-11, 6), (int) app.random(12, 18)), 100, 100, 0, 0, 0, opacity, 7);

		componentes.add(flecha);

		Componente emoji = new Emoji(app, 200, 400, 1, 2,
				(int) app.random((int) app.random(-5, 5), (int) app.random(6, 11)),
				(int) app.random((int) app.random(-11, 6), (int) app.random(12, 18)), 200, 200, 255, 255, 0, opacity,
				8);

		componentes.add(emoji);
	}

	private void crearNueva(int id) {

		switch (id) {
		case 1:

			Componente anillo = new Anillo(app, app.mouseX, app.mouseY, 1, 2,
					(int) app.random((int) app.random(-5, 5), (int) app.random(6, 11)),
					(int) app.random((int) app.random(-11, 6), (int) app.random(12, 18)), 100, 100, 241, 196, 15,
					opacity, 1);
			componentes.add(anillo);
			break;
		case 2:
			Componente anillos = new Anillos(app, app.mouseX, app.mouseY, 1, 2,
					(int) app.random((int) app.random(-5, 5), (int) app.random(6, 11)),
					(int) app.random((int) app.random(-11, 6), (int) app.random(12, 18)), 100, 100, 241, 196, 15,
					opacity, 2);

			componentes.add(anillos);
			break;
		case 3:
			Componente carta = new Carta(app, app.mouseX, app.mouseY, 1, 2,
					(int) app.random((int) app.random(-5, 5), (int) app.random(6, 11)),
					(int) app.random((int) app.random(-11, 6), (int) app.random(12, 18)), 100, 150, 255, 255, 255,
					opacity, 3);

			componentes.add(carta);
			break;
		case 4:
			Componente copa = new Copa(app, app.mouseX, app.mouseY, 1, 2,
					(int) app.random((int) app.random(-5, 5), (int) app.random(6, 11)),
					(int) app.random((int) app.random(-11, 6), (int) app.random(12, 18)), 100, 100, 203, 255, 255,
					opacity, 4);

			componentes.add(copa);
			break;
		case 5:
			Componente corazon = new Corazon(app, app.mouseX, app.mouseY, 1, 2,
					(int) app.random((int) app.random(-5, 5), (int) app.random(6, 11)),
					(int) app.random((int) app.random(-11, 6), (int) app.random(12, 18)), 100, 100, 255, 0, 107,
					opacity, 5);

			componentes.add(corazon);
			break;
		case 6:
			Componente corazonf = new CorazonFlecha(app, app.mouseX, app.mouseY, 1, 2,
					(int) app.random((int) app.random(-5, 5), (int) app.random(6, 11)),
					(int) app.random((int) app.random(-11, 6), (int) app.random(12, 18)), 100, 100, 255, 0, 107,
					opacity, 6);

			componentes.add(corazonf);
			break;
		case 7:
			Componente flecha = new Flecha(app, app.mouseX, app.mouseY, 1, 2,
					(int) app.random((int) app.random(-5, 5), (int) app.random(6, 11)),
					(int) app.random((int) app.random(-11, 6), (int) app.random(12, 18)), 100, 100, 0, 0, 0, opacity,
					7);

			componentes.add(flecha);
			break;
		case 8:
			Componente emoji = new Emoji(app, app.mouseX, app.mouseY, 1, 2,
					(int) app.random((int) app.random(-5, 5), (int) app.random(6, 11)),
					(int) app.random((int) app.random(-11, 6), (int) app.random(12, 18)), 200, 200, 255, 255, 0,
					opacity, 8);

			componentes.add(emoji);
			break;
		}
	}

	private void arrastrarFigura() {
		for (int i = 0; i < componentes.size(); i++) {
			if (app.dist(componentes.get(i).getX(), componentes.get(i).getY(), app.mouseX, app.mouseY) < 80) {
				componentes.get(i).setX((int) app.mouseX);
				componentes.get(i).setY((int) app.mouseY);
			}
		}
	}

	private void cambiarColorFigura() {
		for (int i = 0; i < componentes.size(); i++) {
			if (app.dist(componentes.get(i).getX(), componentes.get(i).getY(), app.mouseX, app.mouseY) < 80) {
				componentes.get(i).setR((int) app.random(255));
				componentes.get(i).setG((int) app.random(255));
				componentes.get(i).setB((int) app.random(255));
			}
		}
	}

	private void cambiarOpacidadFiguras() {

		opacity = 127;

		for (int i = 0; i < componentes.size(); i++) {
			componentes.get(i).setOpacity(opacity);
		}
	}

	public void Atravesar() {

		dividirFigura();
		ModificarTxt(MAYUSCULAS);
	}

	public void DobleClick(int accion) {
		aumentarTamano(accion);
		ModificarTxt(ELIMINAR_A);
	}

	public void ClickSostenido() {
		// FALTA HACER QUE GIRE LA FIGURA
		ModificarTxt(TEXTO_AL_REVES);
	}

	public void Arrastrar() {
		arrastrarFigura();
		ModificarTxt(TEXTO_ALEATORIO);
	}

	public void TeclaC() {
		cambiarColorFigura();
		ModificarTxt(ELIMINAR_VOCALES);
	}

	public void TeclaEspacio() {
		cambiarOpacidadFiguras();
		ModificarTxt(ELIMINAR_ESPACIOS);
	}

	public void TeclaSupr() {

		componentes = new ArrayList<Componente>();
		ModificarTxt(TEXTO_BLANCO);
	}

	public void TeclaR() {

		crearNueva((int) app.random(8));
		ModificarTxt(LAS_A_SON_O);
	}

	public void mover() {
		for (int i = 0; i < componentes.size(); i++) {
			componentes.get(i).mover();
			componentes.get(i).pintar();
		}
	}

	public void LeerTxt(String rutaArchivo) throws IOException {

		cadena = "";

		FileReader fileReader = new FileReader(rutaArchivo);

		BufferedReader bufferReader = new BufferedReader(fileReader);

		String aux = bufferReader.readLine();
		while (aux != null) {

			cadena += aux;
			aux = bufferReader.readLine();
		}
		bufferReader.close();

		System.out.println(cadena);
	}

	public void ModificarTxt(int tipoCambio) {

		switch (tipoCambio) {
		case MAYUSCULAS:
			cadena = cadena.toUpperCase();
			System.out.println(cadena);
			break;

		case ELIMINAR_A:
			cadena = cadena.replaceAll("a", "");
			cadena = cadena.replaceAll("A", "");
			cadena = cadena.replaceAll("α", "");
			cadena = cadena.replaceAll("Α", "");
			System.out.println(cadena);
			break;

		case TEXTO_AL_REVES:

			String sCadenaInvertida = "";
			for (int x = cadena.length() - 1; x >= 0; x--)
				sCadenaInvertida = sCadenaInvertida + cadena.charAt(x);
			cadena = sCadenaInvertida;
			System.out.println(cadena);
			break;

		case TEXTO_ALEATORIO:

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

			cadena = palabraRevuelta;
			System.out.println(cadena);

			break;

		case ELIMINAR_VOCALES:
			cadena = cadena.replaceAll("(?iu)[aeiouαινσϊό]", "");
			System.out.println(cadena);
			break;
		case ELIMINAR_ESPACIOS:
			cadena = cadena.replaceAll(" ", "");
			System.out.println(cadena);
			break;
		case TEXTO_BLANCO:
			cadena = "";
			break;
		case LAS_A_SON_O:
			cadena = cadena.replaceAll("a", "o");
			cadena = cadena.replaceAll("A", "O");
			cadena = cadena.replaceAll("α", "σ");
			cadena = cadena.replaceAll("Α", "Σ");
			System.out.println(cadena);
			break;
		}
	}

	public void GenerarTxts() throws IOException {

		long time = System.currentTimeMillis();

		FileWriter flwriter = new FileWriter("./resources/modificacion-" + time + ".txt");
		BufferedWriter bfwriter = new BufferedWriter(flwriter);

		bfwriter.write(cadena);
		bfwriter.close();

		System.out.println("Archivo creado satisfactoriamente como modificacion-" + time
				+ ".txt ****GUARDADO EN LA CARPETA RESOURCES DEL PROYECTO****");

		File objetofile = new File("./resources/modificacion-" + time + ".txt");
		Desktop.getDesktop().open(objetofile);

		LeerTxt("./resources/song.txt");
	}

}
