package lerverger.model;

import java.util.ArrayList;
import java.util.Collection;

public class Arbre {
	protected  ArrayList<Fruit> arbre;
	private Couleur couleur;

	public Arbre(ArrayList<Fruit> arbre,Couleur couleur) {
		this.arbre = arbre;
		this.couleur = couleur;
	}
	
	public void remplir() {
		int nombreDeFruit = 10;
		for (int compteur=0 ; compteur <= nombreDeFruit ; compteur++) {
			this.arbre.add(new Fruit(this.couleur));
		}
	}
	
	public void enlever() {
		//TODO Pas terminer 
		if (arbre.size()==0) {
			//TODO Message d'erreur
		}
		else {
			private Fruit fruit = arbre.get(0);
			this.arbre.remove(fruit);
		}
	}
}
