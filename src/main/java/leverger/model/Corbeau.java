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
	
	public List<Rectangle> liste(){
		return this.faces;
	}
	
	public void devoile() {
		int numero = (int)(Math.random()*9); 
        while(this.faces.get(numero).getFill().equals(Color.TRANSPARENT)) {
            numero = (int)(Math.random()*9);
        }
		this.faces.get(numero).setFill(Color.TRANSPARENT);
	
	public void reinitialiser() {
		for (int compteur = 0; compteur <= 8; compteur++) {
			if (!faces.get(compteur).getFill().equals(Color.TRANSPARENT)) {
				this.faces.get(compteur).setFill(Color.BLUE);;
			}
		}
	}

}
