package paquete;

import processing.core.PApplet;

public class Emoji extends Componente {

	public Emoji(PApplet app, int x, int y, int velX, int velY, int direcX, int direcY, int ancho, int alto, int r,
			int g, int b, int opacity, int id) {
		super(app, x, y, velX, velY, direcX, direcY, ancho, alto, r, g, b, opacity, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void pintar() {

		// CARA
		app.noStroke();
		app.fill(r, g, b, opacity);
		app.ellipse(x, y, alto, ancho);

		// OJOS

		int posX = x - 40;
		int posY = y - 40;
		app.smooth();
		app.noStroke();
		app.fill(255, 0, 255, opacity);
		app.beginShape();
		app.vertex(posX, posY);
		app.bezierVertex(posX, (posY - 40), (posX + 80), (posY + 10), posX, (posY + 45));
		app.vertex(posX, posY);
		app.bezierVertex(posX, (posY - 40), (posX - 80), (posY + 10), posX, (posY + 45));
		app.endShape();

		posX = x + 40;
		app.smooth();
		app.noStroke();
		app.fill(255, 0, 255, opacity);
		app.beginShape();
		app.vertex(posX, posY);
		app.bezierVertex(posX, (posY - 40), (posX + 80), (posY + 10), posX, (posY + 45));
		app.vertex(posX, posY);
		app.bezierVertex(posX, (posY - 40), (posX - 80), (posY + 10), posX, (posY + 45));
		app.endShape();

		// BOCA
		app.strokeWeight(2);
		app.stroke(0, 0, 0);
		app.fill(255, 255, 255, opacity);
		app.arc(x, y + 20, ancho - 100, alto - 100, 0, app.PI);
		app.line(x - 50, y + 19, x + 50, y + 19);

	}

}
