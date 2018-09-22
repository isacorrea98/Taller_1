package paquete;

import processing.core.PApplet;

public class CorazonFlecha extends Componente {

	public CorazonFlecha(PApplet app, int x, int y, int velX, int velY, int direcX, int direcY, int ancho, int alto,
			int r, int g, int b, int opacity, int id) {
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

		// FLECHA
		app.strokeWeight(2);
		app.stroke(0, 0, 0);
		app.line(x - 44, y + 44, x - 5, y + 17);
		app.line(x + 29, y - 6, x + 54, y - 24);

		app.line(x + 44, y - 26, x + 55, y - 23);
		app.line(x + 55, y - 23, x + 55, y - 16);

		app.line(x - 54, y + 44, x - 44, y + 45);
		app.line(x - 44, y + 45, x - 45, y + 50);

	}

}
