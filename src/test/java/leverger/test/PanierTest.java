package leverger.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import leverger.model.Arbre;
import leverger.model.Couleur;
import leverger.model.Fruit;
import leverger.model.Panier;

class PanierTest {
	private static final Arbre ARBRE_BLEU = new Arbre(Couleur.BLEU);
	private static final Fruit FRUIT_BLEU = new Fruit(Couleur.BLEU);
	Panier panier = new Panier();
	
	@Test
	void testTaillePanier() {
		int resultat = panier.taillePanier();
		assertEquals(0, resultat);
	}
	
	@Test
	void testAjoutFruit() {
		Fruit fruit = FRUIT_BLEU;
		panier.ajout(fruit);
		int resultat = panier.taillePanier();
		assertEquals(1, resultat);
	}
	
	@Test
	void testViderPanier() {
		Fruit fruit = FRUIT_BLEU;
		panier.ajout(fruit);
		panier.viderLePanier();
		int resultat = panier.taillePanier();
		assertEquals(0, resultat);
	}
	
	@Test
	void testRecuperationFruit() {
		Arbre arbre = ARBRE_BLEU;
		arbre.remplir();
		panier.recuperationFruit(arbre);
		int resultatPanier = panier.taillePanier();
		int resultatArbre = arbre.nombreDeFruit();
		assertEquals(1, resultatPanier);
		assertEquals(9, resultatArbre);
	}

}
