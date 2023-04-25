package leverger.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import leverger.model.*;

class ArbreTest {
	
	private Arbre arbre = new Arbre(Couleur.BLEU);

	@Test
	public void creerUnArbreVideAvecUneCouleurBleu() {
		assertEquals(arbre, arbre);
	}

}
