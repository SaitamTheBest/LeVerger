package leverger.model;

import java.util.List;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Corbeau {

	private List<Rectangle> faces;

	public Corbeau(List<Rectangle> faces) {
		this.faces = faces;
	}

	public int taille() {
		return this.faces.size();
	}

	public List<Rectangle> retourneListe() {
		return this.faces;
	}

	public boolean devoile() {
		boolean peutPasEtreDevoiler = this.toutEstDevoile();
		if (peutPasEtreDevoiler) {
			return false;
		} else {
			int compteur = (int) (Math.random() * 9);
			while (this.faces.get(compteur).getFill().equals(Color.TRANSPARENT)) {
				compteur = (int) (Math.random() * 9);
			}
			this.faces.get(compteur).setFill(Color.TRANSPARENT);
			return true;
		}
	}

	public boolean toutEstDevoile() {
		boolean estDevoile = true;
		for (Rectangle rectangle : faces) {
			if (!rectangle.getFill().equals(Color.TRANSPARENT)) {
				estDevoile = false;
			}
		}
		return estDevoile;
	}

	public void reinitialiser() {
		for (Rectangle rectangle : faces) {
			rectangle.setFill(Color.YELLOW);
		}
	}

}
