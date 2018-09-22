package paquete;

import processing.core.PApplet;

public abstract class Componente {

	protected PApplet app;
	protected int x;
	protected int y;
	protected int velX;
	protected int velY;
	protected int direcX;
	protected int direcY;
	protected int ancho;
	protected int alto;
	protected int r;
	protected int g;
	protected int b;
	protected int opacity;
	protected int id;



	public Componente(PApplet app, int x, int y, int velX, int velY, int direcX, int direcY, int ancho, int alto, int r,
			int g, int b, int opacity, int id) {
		super();
		this.app = app;
		this.x = x;
		this.y = y;
		this.velX = velX;
		this.velY = velY;
		this.direcX = direcX;
		this.direcY = direcY;
		this.ancho = ancho;
		this.alto = alto;
		this.r = r;
		this.g = g;
		this.b = b;
		this.opacity = opacity;
		this.id = id;
	}

	protected abstract void pintar();

	// Metodo que se encarga de usar los
	// atributos inyeectados en el constructor
	// para poder dar movimiento al elemento
	// dentro de la pantalla
	public void mover() {
		x = x + (velX * direcX);
		y = y + (velY * direcY);
		if (x > app.width - 20) {
			direcX = -direcX;
		}
		if (x < 20) {
			direcX = -direcX;
		}
		if (y > app.height - 20) {
			direcY = -direcY;
		}
		if (y < 20) {
			direcY = -direcY;
		}
	}

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}

	public int getAncho() {
		return ancho;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getDirecX() {
		return direcX;
	}

	public void setDirecX(int direcX) {
		this.direcX = direcX;
	}

	public int getDirecY() {
		return direcY;
	}

	public void setDirecY(int direcY) {
		this.direcY = direcY;
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

	public int getOpacity() {
		return opacity;
	}

	public void setOpacity(int opacity) {
		this.opacity = opacity;
	}

}