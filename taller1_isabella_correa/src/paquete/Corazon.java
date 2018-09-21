package paquete;

import processing.core.PApplet;

public class Corazon extends Componente {

	public Corazon(PApplet app, int x, int y, int velX, int velY, int directX, int directY, int r, int g, int b,
			int opacity, int ancho, int alto, int id) {
		super(app, x, y, velX, velY, directX, directY, r, g, b, opacity, ancho, alto, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pintar() {

		// CORAZON
		app.smooth();
		app.noStroke();
		app.fill(r, g, b, opacity);
		app.beginShape();
		app.vertex(x, y);
		app.bezierVertex(x, (y - 50), (x + 90), (y - 40), x, (y + 55));
		app.vertex(x, y);
		app.bezierVertex(x, (y - 50), (x - 90), (y - 40), x, (y + 55));
		app.endShape();

	}

}
