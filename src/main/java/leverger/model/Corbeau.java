package leverger.model;

import java.util.List;
import java.util.ArrayList;


public class Corbeau {
	
	private List<Boolean> faces;
	
	public Corbeau(List<Boolean> faces) {
		this.faces = faces;
	}
	
	public Corbeau() {
		this(new ArrayList<>());
		for (int compteur = 0; compteur <= 8; compteur++) {
			this.faces.add(false);
		}
	}
	
	public int taille() {
		return this.faces.size();
	}
	
	public List<Boolean> liste(){
		return this.faces;
	}
	
	public void devoile() {
		int numero = (int)(Math.random()*9);
		this.faces.set(numero, true);
	}
	
	public void reinitialiser() {
		for (int compteur = 0; compteur <= 8; compteur++) {
			if (faces.get(compteur)) {
				this.faces.set(compteur, false);
			}
		}
	}

}
