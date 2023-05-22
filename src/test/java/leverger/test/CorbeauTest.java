package leverger.test;

import static org.junit.jupiter.api.Assertions.*;
import leverger.model.Corbeau;


import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javafx.scene.shape.Rectangle;

class CorbeauTest {
	Corbeau corbeau = new Corbeau();
	
	@Test
	void testCreationCorbeau() {
		assertEquals(9, corbeau.taille());
	}
	@Test
	void testRecuperationListe() {
		List<Rectangle> faceCorbeau = corbeau.liste();
		assertTrue(faceCorbeau instanceof List<Boolean>);
	}
	
	@Test
	void testDevoilement() {
		corbeau.devoile();
		List<Rectangle> faceCorbeau = corbeau.liste();
		Boolean retourne = false;
		for (Boolean bool : faceCorbeau) {
			if (bool) {
				retourne = true;
			}
		}
		assertTrue(retourne);
	}
	
	@Test
	void testreinitialisation() {
		corbeau.devoile();
		List <Boolean> faceCorbeau = corbeau.liste();
		corbeau.reinitialiser();
		Boolean retourne = false;
		for (Boolean bool : faceCorbeau) {
			if (bool) {
				retourne = true;
			}
		}
		assertFalse(retourne);
	}

}