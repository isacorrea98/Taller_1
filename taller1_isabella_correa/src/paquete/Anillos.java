package paquete;

import processing.core.PApplet;

public class Anillos extends Componente {

	public Anillos(PApplet app, int x, int y, int velX, int velY, int directX, int directY, int r, int g, int b,
			int opacity, int ancho, int alto, int id) {
		super(app, x, y, velX, velY, directX, directY, r, g, b, opacity, ancho, alto, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pintar() {

		// ARGOLLA 1
		app.strokeWeight(10);
		app.stroke(r, g, b, opacity);
		app.noFill();
		app.ellipse(x, y, ancho, alto);

		// DIAMANTE 1
		app.noStroke();
		app.fill(0, 255, 255);
		app.triangle((x - 43), (y - 54), (x + 46), (y - 56), (x + 1), (y - 95));

		// ARGOLLA 2
		app.strokeWeight(10);
		app.stroke(r, g, b, opacity);
		app.noFill();
		app.ellipse(x + 50, y + 50, ancho, alto);

		// DIAMANTE 2
		app.noStroke();
		app.fill(102, 255, 255);
		app.triangle((x - 7), (y - 4), (x + 96), (y - 6), (x + 51), (y - 45));
	}

}
