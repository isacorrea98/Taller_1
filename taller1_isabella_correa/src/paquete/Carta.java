package paquete;

import processing.core.PApplet;

public class Carta extends Componente {

	public Carta(PApplet app, int x, int y, int velX, int velY, int directX, int directY, int r, int g, int b,
			int opacity, int ancho, int alto, int id) {
		super(app, x, y, velX, velY, directX, directY, r, g, b, opacity, ancho, alto, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pintar() {

		// RECTANGULO
		app.noStroke();
		app.fill(r, g, b, opacity);
		app.rect(x, y, ancho, alto);

		// LINEAS
		app.strokeWeight(3);
		app.stroke(0, 0, 0);
		app.line((x + 20), (y + 20), (x + 100), (y + 20));
		app.line((x + 20), (y + 40), (x + 100), (y + 40));
		app.line((x + 20), (y + 60), (x + 100), (y + 60));
		app.line((x + 20), (y + 80), (x + 100), (y + 80));
		app.line((x + 20), (y + 100), (x + 100), (y + 100));
		app.line((x + 20), (y + 120), (x + 100), (y + 120));
	}

}
