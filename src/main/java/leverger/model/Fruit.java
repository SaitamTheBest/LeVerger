package leverger.model;

public class Fruit {
	private final Couleur couleur;

	public Fruit(Couleur couleur) {
		this.couleur = couleur;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	@Override
	public String toString() {
		return "Je suis un fruit "+couleur+".";
	}
}
