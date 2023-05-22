package leverger.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import leverger.model.*;

class ArbreTest {
	
	Arbre arbre = new Arbre(Couleur.BLEU);

	@Test
	void creerUnArbreVideAvecUneCouleurBleuEtAfficheCesCaracteristiques() {
		String resultat = arbre.toString();
		assertEquals("Un arbre contenant 0 fruit(s) BLEU.", resultat);
	}
	
	@Test
	void remplirUnArbreVideDeDixFruitDeLaCouleurBleuEtAfficheCesCaracteristiques() {
		arbre.remplir();
		String resultat = arbre.toString();
		assertEquals("Un arbre contenant 10 fruit(s) BLEU.", resultat);
	}
	
	@Test
	void enleverUnArbreAvecDesFruitDeLaCouleurBleuEtAfficheCesCaracteristiques() {
		arbre.remplir();
		arbre.enlever();
		String resultat = arbre.toString();
		assertEquals("Un arbre contenant 9 fruit(s) BLEU.", resultat);
	}
	
	@Test
	void renvoieLeNombreDeFruitDUnArbre() {
		arbre.remplir();
		int resultat = arbre.nombreDeFruit();
		assertEquals(10, resultat);
	}
	
	@Test
	void renvoieLaCouleurDUnArbre() {
		Couleur resultat = arbre.getCouleur();
		assertEquals(Couleur.BLEU, resultat);
	}
	
	@Test
	void retireUnFruit() {
		arbre.remplir();
		arbre.enlever();
		int resultat = arbre.nombreDeFruit();
		assertEquals(9, resultat);
	}

}
