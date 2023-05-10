package leverger.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import leverger.model.Couleur;
import leverger.model.Fruit;
import leverger.model.Panier;

class PanierTest {
	Panier panier = new Panier();
	
	@Test
	void testTaillePanier() {
		assertEquals(0, panier.taillePanier());;
	}
	
	@Test
	void testAjoutFruit() {
		Fruit fruit = new Fruit(Couleur.BLEU);
		panier.ajout(fruit);
		assertEquals(1, panier.taillePanier());;
	}

}
