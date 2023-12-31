package leverger.model;

import java.util.List;
import java.util.ArrayList;

public class Arbre {
	protected List<Fruit> arbre;
	private Couleur couleur;

	public Arbre(List<Fruit> arbre, Couleur couleur) {
		this.arbre = arbre;
		this.couleur = couleur;
	}

	public Arbre(Couleur couleur) {
		this(new ArrayList<>(),couleur);
	}

	public void remplir() {
		int nombreDeFruit = 10;
		int nombreDeFruitActuelle = arbre.size();
		nombreDeFruit = nombreDeFruit - nombreDeFruitActuelle;
		for (int compteur = 0; compteur <= nombreDeFruit-1; compteur++) {
			this.arbre.add(new Fruit(this.couleur));
		}
	}

	public void enlever() {
		if (!arbre.isEmpty()) {
			Fruit fruit = arbre.get(0);
			arbre.remove(fruit);
		}
	}
	
	public Couleur getCouleur() {
		return couleur;
	}
	
	public int nombreDeFruit() {
		return arbre.size();
	}

	@Override
	public String toString() {
		return "Un arbre contenant "+ arbre.size() + " fruit(s) "+ couleur + ".";
	}
	
	
}
