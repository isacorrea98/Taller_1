package paquete;

import processing.core.PApplet;

public class Copa extends Componente {

	public Copa(PApplet app, int x, int y, int velX, int velY, int direcX, int direcY, int ancho, int alto, int r,
			int g, int b, int opacity, int id) {
		super(app, x, y, velX, velY, direcX, direcY, ancho, alto, r, g, b, opacity, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void pintar() {

		// COPA
		app.noStroke();
		app.fill(r, g, b, opacity);
		app.arc(x, y, ancho, alto, 0, app.PI);

		// MANGO
		app.strokeWeight(3);
		app.stroke(r, g, b, opacity);
		app.noFill();
		app.line(x, (y + 47), x, (y + 150));
		app.line((x - 45), (y + 150), (x + 45), (y + 150));
	}

}
