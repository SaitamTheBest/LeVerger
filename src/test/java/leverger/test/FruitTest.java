package leverger.test;

import static org.junit.jupiter.api.Assertions.*;
import leverger.model.*;

import org.junit.jupiter.api.Test;
import leverger.model.Couleur;

class FruitTest {

	@Test
	public void creerUnFruitAvecLaCouleurBleuEtAfficheCesCaracteristiques() {
		Fruit fruit = new Fruit(Couleur.BLEU);
		assertEquals(fruit.toString(), "Je suis un fruit BLEU.");
	}
	
	@Test
	public void afficheLaCouleurDUnFruit() {
		Fruit fruit = new Fruit(Couleur.BLEU);
		assertEquals(fruit.getCouleur(), Couleur.BLEU);
	}

}
