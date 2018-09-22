package paquete;

import processing.core.PApplet;

public class Corazon extends Componente {

	public Corazon(PApplet app, int x, int y, int velX, int velY, int direcX, int direcY, int ancho, int alto, int r,
			int g, int b, int opacity, int id) {
		super(app, x, y, velX, velY, direcX, direcY, ancho, alto, r, g, b, opacity, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void pintar() {

		app.smooth();
		app.noStroke();
		app.fill(r, g, b, opacity);
		app.beginShape();
		app.vertex(x, y);
		app.bezierVertex(x, (y - 40), (x + 80), (y + 10), x, (y + 45));
		app.vertex(x, y);
		app.bezierVertex(x, (y - 40), (x - 80), (y + 10), x, (y + 45));
		app.endShape();
	}

}
