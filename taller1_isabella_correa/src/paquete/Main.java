package paquete;

import java.io.IOException;

import processing.core.PApplet;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

public class Main extends PApplet {

	private Logica logica;

	public static void main(String[] args) {
		PApplet.main("paquete.Main");
	}

	private class SecondScreen extends PApplet {

		@Override
		public void setup() {
			smooth();
			background(loadImage("./resources/background2.png"));
		}

		@Override
		public void settings() {
			size(1200, 700);
		}
	}

	@Override
	public void setup() {

		logica = new Logica(this);

		String rutaArchivo = "./resources/song.txt";

		try {
			logica.LeerTxt(rutaArchivo);
			logica.inicializar();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void settings() {
		size(1200, 700);
	}

	@Override
	public void draw() {
		smooth();
		background(loadImage("./resources/background.png"));
		image(loadImage("./resources/instrucciones.png"), 0, 0);
		image(loadImage("./resources/guardar.png"), 170, 0);
		logica.mover();
	}

	@Override
	public void mouseClicked() {

		if (mouseX >= 0 && mouseX <= 158 && mouseY >= 0 && mouseY <= 53) {
			SecondScreen secondScreen = new SecondScreen();
			String[] args = { "TwoFrameTest" };
			PApplet.runSketch(args, secondScreen);
		}

		else if (mouseX >= 170 && mouseX <= 330 && mouseY >= 0 && mouseY <= 53) {
			try {
				logica.GenerarTxts();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else if (mouseButton == RIGHT) {
			logica.Atravesar();
		} else if (mouseButton == LEFT) {
			logica.ClickSostenido();
		}

	}

	@Override
	public void mouseDragged() {
		logica.Arrastrar();
	}

	@Override
	public void keyPressed(KeyEvent event) {
		if (event.getKeyCode() == 67) {
			logica.TeclaC();
		}

		else if (event.getKeyCode() == 32) {
			logica.TeclaEspacio();
		} else if (event.getKeyCode() == 127) {
			logica.TeclaSupr();
		} else if (event.getKeyCode() == 82) {
			logica.TeclaR();
		}
	}

	@Override
	public void mouseWheel(MouseEvent event) {
		logica.DobleClick(event.getCount());
	}

}
