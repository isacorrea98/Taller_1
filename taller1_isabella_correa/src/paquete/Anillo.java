package paquete;

import processing.core.PApplet;

public class Anillo extends Componente {

	public Anillo(PApplet app, int x, int y, int velX, int velY, int directX, int directY, int r, int g, int b,
			int opacity, int ancho, int alto, int id) {
		super(app, x, y, velX, velY, directX, directY, r, g, b, opacity, ancho, alto, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pintar() {

		// ARGOLLA
		app.strokeWeight(10);
		app.stroke(r, g, b, opacity);
		app.noFill();
		app.ellipse(x, y, ancho, alto);

		// DIAMANTE
		app.noStroke();
		app.fill(0, 255, 255);
		app.triangle((x - 43), (y - 54), (x + 46), (y - 56), (x + 1), (y - 95));

	}

}
