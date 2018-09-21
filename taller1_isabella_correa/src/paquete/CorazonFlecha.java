package paquete;

import processing.core.PApplet;

public class CorazonFlecha extends Componente {

	public CorazonFlecha(PApplet app, int x, int y, int velX, int velY, int directX, int directY, int r, int g, int b,
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

		// FLECHA
		app.strokeWeight(3);
		app.stroke(0, 0, 0);
		app.line((x - 52), (y + 46), (x - 1), (y + 10));
		app.line((x + 39), (y - 20), (x + 73), (y - 45));
		app.line((x + 58), (y - 47), (x + 73), (y - 45));
		app.line((x + 71), (y - 31), (x + 73), (y - 45));
		app.line((x - 63), (y + 43), (x - 52), (y + 46));
		app.line((x - 52), (y + 55), (x - 52), (y + 46));
	}

}
