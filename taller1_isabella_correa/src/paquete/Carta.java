package paquete;

import processing.core.PApplet;

public class Carta extends Componente {

	public Carta(PApplet app, int x, int y, int velX, int velY, int direcX, int direcY, int ancho, int alto, int r,
			int g, int b, int opacity, int id) {
		super(app, x, y, velX, velY, direcX, direcY, ancho, alto, r, g, b, opacity, id);
	}

	@Override
	protected void pintar() {

		// PAPEL
		app.noStroke();
		app.fill(r, g, b, opacity);
		app.rect(x, y, ancho, alto);

		// LINEAS
		app.strokeWeight(3);
		app.stroke(0, 0, 0);
		app.noFill();
		app.line((x + 15), (y + 20), (x + 80), (y + 20));
		app.line((x + 15), (y + 40), (x + 80), (y + 40));
		app.line((x + 15), (y + 60), (x + 80), (y + 60));
		app.line((x + 15), (y + 80), (x + 80), (y + 80));
		app.line((x + 15), (y + 100), (x + 80), (y + 100));
		app.line((x + 15), (y + 120), (x + 80), (y + 120));
	}

}
