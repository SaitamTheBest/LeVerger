package leverger.test;

import static org.junit.jupiter.api.Assertions.*;
import leverger.model.Corbeau;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class CorbeauTest {
	private static final Color DEVOILE_PIECE = Color.TRANSPARENT;
	private Corbeau corbeau;
	
	@BeforeEach
	void initialisation() {
		List<Rectangle> listeRectangle = new ArrayList<>();
		for (int compteur = 0;compteur<9;compteur++) {
			listeRectangle.add(new Rectangle());
		}
		corbeau = new Corbeau(listeRectangle);
	}
	
	@Test
	void testCreationCorbeau() {
		int resultat = corbeau.taille();
		assertEquals(9, resultat);
	}
	@Test
	void testRecuperationListe() {
		List <Rectangle> resultat = corbeau.retourneListe();
		assertTrue(resultat instanceof List<Rectangle>);
	}
	
	@Test
	void testDevoilement() {
		corbeau.devoile();
		List<Rectangle> faceCorbeau = corbeau.retourneListe();
		Boolean pieceRetourner = false;
		for (Rectangle piece : faceCorbeau) {
			if (piece.getFill().equals(DEVOILE_PIECE)) {
				pieceRetourner = true;
			}
		}
		assertTrue(pieceRetourner);
	}
	
	@Test
	void testReinitialisation() {
		corbeau.devoile();
		List <Rectangle> faceCorbeau = corbeau.retourneListe();
		corbeau.reinitialiser();
		Boolean pieceRetourner = false;
		for (Rectangle piece : faceCorbeau) {
			if (piece.getFill().equals(DEVOILE_PIECE)) {
				pieceRetourner = true;
			}
		}
		assertFalse(pieceRetourner);
	}

}
