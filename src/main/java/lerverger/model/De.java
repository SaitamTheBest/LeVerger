package lerverger.model;

import java.util.ArrayList;
import java.util.List;

public class De {
<<<<<<< Updated upstream
	private List<Couleur> face;
=======
	private Couleur face1;
	private Couleur face2;
	private Couleur face3;
	private Couleur face4;
	private Couleur face5;
>>>>>>> Stashed changes
	
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
