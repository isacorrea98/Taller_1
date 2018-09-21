package paquete;

import processing.core.PApplet;

public class Copa extends Componente {

	public Copa(PApplet app, int x, int y, int velX, int velY, int directX, int directY, int r, int g, int b,
			int opacity, int ancho, int alto, int id) {
		super(app, x, y, velX, velY, directX, directY, r, g, b, opacity, ancho, alto, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pintar() {

		// COPA
		app.strokeWeight(2);
		app.stroke(r, g, b, opacity);
		app.fill(r, g, b);
		app.arc(x, y, (ancho), y, (y - y), app.PI);

		// AGARRADERA
		app.strokeWeight(4);
		app.stroke(r, g, b, opacity);
		app.noFill();
		app.line(x, (y + 50), x, (y + 150));

		// BASE
		app.line((x - 50), (y + 150), (x + 50), (y + 150));
	}

}
