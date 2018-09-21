package paquete;

import processing.core.PApplet;

public class Emoji extends Componente {

	public Emoji(PApplet app, int x, int y, int velX, int velY, int directX, int directY, int r, int g, int b,
			int opacity, int ancho, int alto, int id) {
		super(app, x, y, velX, velY, directX, directY, r, g, b, opacity, ancho, alto, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pintar() {

		// CARA
		app.fill(r, g, b, opacity);
		app.noStroke();
		app.ellipse(x, y, ancho, alto);

		// OJOS

		app.smooth();
		app.noStroke();
		app.fill(255, 0, 0);
		app.beginShape();
		app.vertex((x - 20), (y - 15));
		app.bezierVertex((x - 20), (y - 20), (x + 20), (y - 25), (x - 20), (y + 10));
		app.vertex((x - 20), (y - 15));
		app.bezierVertex((x - 20), (y - 20), (x - 60), (y - 25), (x - 20), (y + 10));
		app.endShape();

		app.smooth();
		app.noStroke();
		app.fill(255, 0, 0);
		app.beginShape();
		app.vertex((x + 20), (y - 15));
		app.bezierVertex((x + 20), (y - 20), (x + 60), (y - 25), (x + 20), (y + 10));
		app.vertex((x + 20), (y - 15));
		app.bezierVertex((x + 20), (y - 20), (x - 20), (y - 25), (x + 20), (y + 10));
		app.endShape();

		// BOCA
		app.strokeWeight(2);
		app.stroke(1);
		app.fill(255);
		app.bezier((x - 27), (y + 15), (x - 14), (y + 40), (x + 8), (y + 40), (x + 26), (y + 15));
		app.line((x - 27), (y + 15), (x + 26), (y + 15));
	}

}
