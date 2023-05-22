package leverger.test;

import static org.junit.jupiter.api.Assertions.*;
import leverger.model.*;

import org.junit.jupiter.api.Test;
import leverger.model.Couleur;

class FruitTest {

	Fruit fruit = new Fruit(Couleur.BLEU);
	
	@Test
	void creerUnFruitAvecLaCouleurBleuEtAfficheCesCaracteristiques() {
		String resultat = fruit.toString();
		assertEquals("Je suis un fruit BLEU.", resultat);
	}
	
	@Test
	void afficheLaCouleurDUnFruit() {
		Couleur resultat = fruit.getCouleur();
		assertEquals(Couleur.BLEU, fruit.getCouleur());
	}

}
