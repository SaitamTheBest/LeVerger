package leverger.model;

import java.util.ArrayList;
import java.util.List;

public class De {
	private List<Couleur> face;
	
	public De(List<Couleur> face) {
		this.face = face;
	}
	
	public De() {
		this(new ArrayList<>());
		this.face.add(Couleur.BLEU);
		this.face.add(Couleur.JAUNE);
		this.face.add(Couleur.ROUGE);
		this.face.add(Couleur.VERT);
	}
	
	public Couleur lancer() {
		int numero = (int)(Math.random()*4);
		return this.face.get(numero);
	}
}
