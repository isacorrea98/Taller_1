package paquete;

import processing.core.PApplet;

public class Flecha extends Componente {

	public Flecha(PApplet app, int x, int y, int velX, int velY, int direcX, int direcY, int ancho, int alto, int r,
			int g, int b, int opacity, int id) {
		super(app, x, y, velX, velY, direcX, direcY, ancho, alto, r, g, b, opacity, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void pintar() {

		// FLECHA
		app.strokeWeight(3);
		app.stroke(r, g, b, opacity);
		app.line(x - 44, y + 44, x + 54, y - 24);

		app.line(x + 44, y - 26, x + 55, y - 23);
		app.line(x + 55, y - 23, x + 55, y - 16);

		app.line(x - 54, y + 44, x - 44, y + 45);
		app.line(x - 44, y + 45, x - 45, y + 50);

		app.line(x - 41, y + 29, x - 27, y + 46);
		app.line(x - 30, y + 20, x - 17, y + 38);

	}

}
