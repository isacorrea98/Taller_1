package paquete;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;

import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet {

	private static Logica logica;

	public static void main(String[] args) {
		PApplet.main("paquete.Main");
		logica = new Logica();
	}

	public void settings() {

		size(1200, 700);
	}

	public void setup() {

		fill(120, 50, 240);
	}

	public void draw() {

		smooth();

		PImage pImage = loadImage("./resources/background.png");
		background(pImage);

		PImage instrucciones = loadImage("./resources/instrucciones.png");
		PImage guardar = loadImage("./resources/guardar.png");

		image(instrucciones, 0, 0);
		image(guardar, 180, 0);

		logica.dibujar(this);

	}

	public void mousePressed() {


		if (mouseX >= 5 && mouseX <= 156 && mouseY >= 7 && mouseY <= 52) {
			// instrucciones
			SecondApplet secondApplet = new SecondApplet();

			String[] args = { "SecondSketch" };
			PApplet.runSketch(args, secondApplet);
		}

		if (mouseX >= 188 && mouseX <= 339 && mouseY >= 7 && mouseY <= 52) {
			// guardar
			try {
				logica.GenerarTxts();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

	public void mouseDragged() {

		logica.Arrastrar(this);
	}

	public void mouseClicked() {

		if (mouseButton == RIGHT) {
			logica.Atravesar(this);
		}

	}

	@Override
	public void mouseWheel(processing.event.MouseEvent event) {
		super.mouseWheel(event);

		float e = event.getClickCount();

		if (e < 0) {
			logica.DobleClick(this, -1);
		} else {
			logica.DobleClick(this, 1);
		}
	}

	@Override
	public void keyPressed(processing.event.KeyEvent event) {
		super.keyPressed(event);

		if (event.getKey() == 'C' || event.getKey() == 'c') {
			logica.TeclaC(this);
		}

		else if (event.getKey() == ' ') {
			logica.TeclaEspacio(this);
		}

		else if (event.getKeyCode() == 127) {
			logica.TeclaSupr();
		}

		if (event.getKey() == 'R' || event.getKey() == 'r') {
			logica.TeclaR(this);
		}
	}

	private class SecondApplet extends PApplet {

		public SecondApplet() {

		}

		public void settings() {

			size(1200, 700);
		}

		public void setup() {

			fill(120, 50, 240);
		}

		public void draw() {

			smooth();

			PImage pImage = loadImage("./resources/background2.png");
			background(pImage);
		}
	}
}
