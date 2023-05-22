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
		assertTrue(resultat instanceof Couleur);
		
	}
	
	@Test
	void testNombreDeTour() {
		De de = new De();
		int resultat = de.nombreDeTour();
		assertEquals(0,resultat);
		
	}
	
	@Test
	void testNombreReinitialiserDeTour() {
		De de = new De();
		de.lancer();
		int resultatInt = de.nombreDeTour();
		de.reinitialiserLeNombreDeTour();
		int resultatFin = de.nombreDeTour();
		assertEquals(0,resultatFin);
		assertEquals(1, resultatInt);
		
	}

}