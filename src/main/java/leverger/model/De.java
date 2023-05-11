package leverger.model;

import java.util.ArrayList;
import java.util.List;

public class De {
	private List<Couleur> face;
	private int compteurDeTour;
	
	public De(List<Couleur> face,int compteurDeTour) {
		this.face = face;
		this.compteurDeTour = compteurDeTour;
	}
	
	public De() {
		this(new ArrayList<>(),0);
		this.face.add(Couleur.BLEU);
		this.face.add(Couleur.JAUNE);
		this.face.add(Couleur.ROUGE);
		this.face.add(Couleur.VERT);
		this.face.add(Couleur.NOIR);
	}
	
	public Couleur lancer() {
		int numero = (int)(Math.random()*5);
		this.compteurDeTour++;
		return this.face.get(numero);
	}
	
	public int nombreDeTour() {
		return compteurDeTour;
	}
	
	public void reinitialiserLeNombreDeTour() {
		this.compteurDeTour=0;
	}

}
