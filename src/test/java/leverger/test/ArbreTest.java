package leverger.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import leverger.model.*;

class ArbreTest {

	@Test
	public void creerUnArbreVideAvecUneCouleurBleuEtAfficheCesCaracteristiques() {
		Arbre arbre = new Arbre(Couleur.BLEU);
		assertEquals(arbre.toString(), "Un arbre contenant 0 fruit(s) BLEU.");
	}
	
	@Test
	public void remplirUnArbreVideDeDixFruitDeLaCouleurBleuEtAfficheCesCaracteristiques() {
		Arbre arbre = new Arbre(Couleur.BLEU);
		arbre.remplir();
		assertEquals(arbre.toString(), "Un arbre contenant 10 fruit(s) BLEU.");
	}
	
	@Test
	public void enleverUnArbreAvecDesFruitDeLaCouleurBleuEtAfficheCesCaracteristiques() {
		Arbre arbre = new Arbre(Couleur.BLEU);
		arbre.remplir();
		arbre.enlever();
		assertEquals(arbre.toString(), "Un arbre contenant 9 fruit(s) BLEU.");
	}

}
