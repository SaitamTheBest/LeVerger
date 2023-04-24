package lerverger.model;

import java.lang.Math;

public class De {
	private Couleur face1;
	private Couleur face2;
	private Couleur face3;
	private Couleur face4;
	
	public De(Couleur face1, Couleur face2, Couleur face3, Couleur face4) {
		this.face1 = face1;
		this.face2 = face2;
		this.face3 = face3;
		this.face4 = face4;
	}
	
	public De() {
		this(Couleur.BLEU,Couleur.JAUNE,Couleur.ROUGE,Couleur.VERT);
	}
	
	public Couleur lancer() {
		int numero = (int)(Math.random()*4);
		switch(numero) {
		case 0:
			return this.face1;
		case 1:
			return this.face2;
		case 2:
			return this.face3;
		default:
			return this.face4;
		}
	}
}
