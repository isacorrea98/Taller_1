package paquete;

import processing.core.PApplet;

public abstract class Componente {

	protected PApplet app;
	protected int x;
	protected int y;
	protected int velX;
	protected int velY;
	protected int directX;
	protected int directY;
	protected int r;
	protected int g;
	protected int b;
	protected int opacity;
	protected int ancho;
	protected int alto;
	protected int id;

	public Componente(PApplet app, int x, int y, int velX, int velY, int directX, int directY, int r, int g, int b,
			int opacity, int ancho, int alto, int id) {
		super();
		this.app = app;
		this.x = x;
		this.y = y;
		this.velX = velX;
		this.velY = velY;
		this.directX = directX;
		this.directY = directY;
		this.r = r;
		this.g = g;
		this.b = b;
		this.opacity = opacity;
		this.ancho = ancho;
		this.alto = alto;
		this.id = id;
	}

	public int getOpacity() {
		return opacity;
	}

	public void setOpacity(int opacity) {
		this.opacity = opacity;
	}

	public PApplet getApp() {
		return app;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public int getDirectX() {
		return directX;
	}

	public void setDirectX(int directX) {
		this.directX = directX;
	}

	public int getDirectY() {
		return directY;
	}

	public void setDirectY(int directY) {
		this.directY = directY;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public abstract void pintar();

	// Metodo que se encarga de usar los
	// atributos inyeectados en el constructor
	// para poder dar movimiento al elemento
	// dentro de la pantalla
	public void mover() {
		x = x + (velX * directX);
		y = y + (velY * directY);
		if (x > app.width - 20) {
			directX = -directX;
		}
		if (x < 20) {
			directX = -directX;
		}
		if (y > app.height - 20) {
			directY = -directY;
		}
		if (y < 20) {
			directY = -directY;
		}
	}

}
