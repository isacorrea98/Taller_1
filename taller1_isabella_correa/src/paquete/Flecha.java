package paquete;

import processing.core.PApplet;

public class Flecha extends Componente {

	public Flecha(PApplet app, int x, int y, int velX, int velY, int directX, int directY, int r, int g, int b,
			int opacity, int ancho, int alto, int id) {
		super(app, x, y, velX, velY, directX, directY, r, g, b, opacity, ancho, alto, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pintar() {

		// FLECHA
		app.strokeWeight(3);
		app.stroke(0, 0, 0, opacity);
		app.line((x - 52), (y + 46), (x + 73), (y - 45));
		app.line((x + 58), (y - 47), (x + 73), (y - 45));
		app.line((x + 71), (y - 31), (x + 73), (y - 45));
		app.line((x - 63), (y + 43), (x - 52), (y + 46));
		app.line((x - 52), (y + 55), (x - 52), (y + 46));
		app.line((x - 50), (y + 32), (x - 39), (y + 35));
		app.line((x - 39), (y + 44), (x - 39), (y + 35));
		app.line((x - 39), (y + 24), (x - 28), (y + 27));
		app.line((x - 28), (y + 36), (x - 28), (y + 27));

	}

}
