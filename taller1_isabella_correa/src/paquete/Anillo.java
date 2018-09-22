package paquete;

import processing.core.PApplet;

public class Anillo extends Componente {

	public Anillo(PApplet app, int x, int y, int velX, int velY, int direcX, int direcY, int ancho, int alto, int r,
			int g, int b, int opacity, int id) {
		super(app, x, y, velX, velY, direcX, direcY, ancho, alto, r, g, b, opacity, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void pintar() {

		// ARGOLLA
		app.strokeWeight(8);
		app.stroke(r, g, b, opacity);
		app.noFill();
		app.ellipse(x, y, ancho, alto);

		// GEMA
		app.noStroke();
		app.fill(0, 255, 255);
		app.triangle((x - 44), (y - 54), (x + 43), (y - 54), (x), (y - 100));
	}

}
