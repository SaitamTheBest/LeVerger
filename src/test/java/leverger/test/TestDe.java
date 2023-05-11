package leverger.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import leverger.model.Couleur;
import leverger.model.De;

class TestDe {

	@Test
	void testLancerDet() {
		De de = new De();
		Couleur resultat = de.lancer();
		assertEquals(resultat instanceof Couleur,true);
		
	}

}