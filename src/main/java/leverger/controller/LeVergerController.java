package leverger.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import leverger.model.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.List;
import java.util.ArrayList;

public class LeVergerController {

	private static final int PLUS_DE_FRUIT = 0;

	private static final int NOMBRE_DE_FRUIT_PRIS_MAX = 2;

	private static final Couleur PRENDRE_DEUX_FRUITS = Couleur.MARRON;

	@FXML
	private Circle cercleDeID;

	@FXML
	private ImageView imageCorbeauDeId;

	@FXML
	private ImageView imagePanierDeId;

	@FXML
	private Button lancerBouton;

	@FXML
	private Label nombreDeCeriseID;

	@FXML
	private Label nombreDeCerisePanierID;

	@FXML
	private Label nombreDePoireID;

	@FXML
	private Label nombreDePoirePanierID;

	@FXML
	private Label nombreDePommeID;

	@FXML
	private Label nombreDePommePanierID;

	@FXML
	private Label nombreDePruneID;

	@FXML
	private Label nombreDePrunePanierID;

	@FXML
	private Label nombreDeTourID;

	@FXML
	private Button reessayerBouton;

	@FXML
	private Button quitterBouton;

	@FXML
	private Label titreID;

	@FXML
	private Rectangle indicateurCerisierId;

	@FXML
	private Rectangle indicateurPoirierId;

	@FXML
	private Rectangle indicateurPommierId;

	@FXML
	private Rectangle indicateurPrunierId;

	@FXML
	private Rectangle piece0_0Id;

	@FXML
	private Rectangle piece0_1Id;

	@FXML
	private Rectangle piece0_2Id;

	@FXML
	private Rectangle piece1_0Id;

	@FXML
	private Rectangle piece1_1Id;

	@FXML
	private Rectangle piece1_2Id;

	@FXML
	private Rectangle piece2_0Id;

	@FXML
	private Rectangle piece2_1Id;

	@FXML
	private Rectangle piece2_2Id;

	// Liste des indicateurs
	List<Rectangle> listeIndicateur = new ArrayList<>();

	// Création Arbre
	Arbre poirier = new Arbre(Couleur.JAUNE);
	Arbre prunier = new Arbre(Couleur.BLEU);
	Arbre cerisier = new Arbre(Couleur.ROUGE);
	Arbre pommier = new Arbre(Couleur.VERT);

	// Création Dé
	De deJoueur = new De();

	// Création Panier
	Panier panierPoirier = new Panier();
	Panier panierPrunier = new Panier();
	Panier panierCerisier = new Panier();
	Panier panierPommier = new Panier();

	// Création liste piece corbeau
	List<Rectangle> pieces = new ArrayList<>();

	// Création corbeau
	Corbeau corbeau = new Corbeau(pieces);

	int nombreDeFruitPris = 0;

	Couleur faceDuDe;

	int fruitPris;

	@FXML
	public void initialize() {
		// Remplir les arbres
		poirier.remplir();
		prunier.remplir();
		cerisier.remplir();
		pommier.remplir();

		// Cache les faces corbeau et panier
		imageCorbeauDeId.setVisible(false);
		imagePanierDeId.setVisible(false);

		// Rajoute les pièces du puzzle
		pieces.add(piece0_0Id);
		pieces.add(piece0_1Id);
		pieces.add(piece0_2Id);
		pieces.add(piece1_0Id);
		pieces.add(piece1_1Id);
		pieces.add(piece1_2Id);
		pieces.add(piece2_0Id);
		pieces.add(piece2_1Id);
		pieces.add(piece2_2Id);

		// Cache les indicateurs
		indicateurPommierId.setVisible(false);
		indicateurPoirierId.setVisible(false);
		indicateurPrunierId.setVisible(false);
		indicateurCerisierId.setVisible(false);

		// Label Application Arbre
		nombreDePommeID.setText(pommier.nombreDeFruit() + "");
		nombreDePoireID.setText(poirier.nombreDeFruit() + "");
		nombreDePruneID.setText(prunier.nombreDeFruit() + "");
		nombreDeCeriseID.setText(cerisier.nombreDeFruit() + "");

		// Label Application Panier
		nombreDePommePanierID.setText(panierPommier.taillePanier() + "");
		nombreDePoirePanierID.setText(panierPoirier.taillePanier() + "");
		nombreDePrunePanierID.setText(panierPrunier.taillePanier() + "");
		nombreDeCerisePanierID.setText(panierCerisier.taillePanier() + "");

		listeIndicateur.add(indicateurCerisierId);
		listeIndicateur.add(indicateurPoirierId);
		listeIndicateur.add(indicateurPommierId);
		listeIndicateur.add(indicateurPrunierId);

		// Bouton Reessaye
		reessayerBouton.setDisable(true);

		lancerBouton.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				imageCorbeauDeId.setVisible(false);
				imagePanierDeId.setVisible(false);
				faceDuDe = deJoueur.lancer();
				nombreDeTourID.setText("" + deJoueur.nombreDeTour());

				if (faceDuDe.equals(prunier.getCouleur())) {
					cercleDeID.setFill(Color.BLUE);

					if (prunier.nombreDeFruit() == PLUS_DE_FRUIT) {
						indicateurPrunierId.setVisible(false);
					} else {
						lancerBouton.setDisable(true);
						indicateurPrunierId.setOnMouseClicked(event -> ajouterUnePruneDansUnPanier(event));
						indicateurPrunierId.setVisible(true);
					}

				}
				if (faceDuDe.equals(poirier.getCouleur())) {
					cercleDeID.setFill(Color.YELLOW);
					if (poirier.nombreDeFruit() == PLUS_DE_FRUIT) {
						indicateurPoirierId.setVisible(false);
					} else {
						lancerBouton.setDisable(true);
						indicateurPoirierId.setOnMouseClicked(event -> ajouterUnePoireDansUnPanier(event));
						indicateurPoirierId.setVisible(true);
					}
				}
				if (faceDuDe.equals(cerisier.getCouleur())) {
					cercleDeID.setFill(Color.RED);
					if (cerisier.nombreDeFruit() == PLUS_DE_FRUIT) {
						indicateurCerisierId.setVisible(false);
					} else {
						lancerBouton.setDisable(true);
						indicateurCerisierId.setOnMouseClicked(event -> ajouterUneCeriseDansUnPanier(event));
						indicateurCerisierId.setVisible(true);
					}
				}
				if (faceDuDe.equals(pommier.getCouleur())) {
					cercleDeID.setFill(Color.GREEN);

					if (pommier.nombreDeFruit() == PLUS_DE_FRUIT) {
						indicateurPommierId.setVisible(false);
					} else {
						lancerBouton.setDisable(true);
						indicateurPommierId.setOnMouseClicked(event -> ajouterUnePommeDansUnPanier(event));
						indicateurPommierId.setVisible(true);
					}
				}

				if (faceDuDe.equals(PRENDRE_DEUX_FRUITS)) {
					cercleDeID.setFill(Color.WHITE);
					imagePanierDeId.setVisible(true);

					lancerBouton.setDisable(true);
					indicateurPommierId.setOnMouseClicked(event -> ajouterDeuxFruitsDansDesPaniers(event));
					indicateurPoirierId.setOnMouseClicked(event -> ajouterDeuxFruitsDansDesPaniers(event));
					indicateurPrunierId.setOnMouseClicked(event -> ajouterDeuxFruitsDansDesPaniers(event));
					indicateurCerisierId.setOnMouseClicked(event -> ajouterDeuxFruitsDansDesPaniers(event));
					afficherLesIndicateurs();
				}

				if (faceDuDe.equals(Couleur.NOIR) && !corbeau.toutEstDevoile()) {
					cercleDeID.setFill(Color.WHITE);
					imageCorbeauDeId.setVisible(true);
					corbeau.devoile();
				}

				if (corbeau.toutEstDevoile()) {
					Alert alertGagner = new Alert(AlertType.WARNING);
					alertGagner.setTitle("Résultat du jeu");
					alertGagner.setHeaderText("Vous avez perdu à partir la manche " + deJoueur.nombreDeTour() + " !");
					alertGagner.showAndWait();
					lancerBouton.setDisable(true);
					reessayerBouton.setDisable(false);
				}
			}
		});

		reessayerBouton.setOnMouseClicked(event -> handleReessaye());

	}
	
	private void casGagner() {
		if (prunier.nombreDeFruit() == PLUS_DE_FRUIT && poirier.nombreDeFruit() == PLUS_DE_FRUIT
				&& cerisier.nombreDeFruit() == PLUS_DE_FRUIT && pommier.nombreDeFruit() == PLUS_DE_FRUIT) {
			// Alerts gagnant
			Alert alertGagner = new Alert(AlertType.INFORMATION);
			alertGagner.setTitle("Résultat du jeu");
			alertGagner.setHeaderText("Vous avez gagné en " + deJoueur.nombreDeTour() + " manches !");
			alertGagner.showAndWait();
			cacherLesIndicateurs();
			lancerBouton.setDisable(true);
			reessayerBouton.setDisable(false);
		}
	}

	private boolean afficherLesIndicateurs() {
		for (Rectangle indicateur : listeIndicateur) {
			if ((indicateur.equals(indicateurCerisierId) && cerisier.nombreDeFruit() <= PLUS_DE_FRUIT)
					|| (indicateur.equals(indicateurPommierId) && pommier.nombreDeFruit() <= PLUS_DE_FRUIT)
					|| (indicateur.equals(indicateurPrunierId) && prunier.nombreDeFruit() <= PLUS_DE_FRUIT)
					|| (indicateur.equals(indicateurPoirierId) && poirier.nombreDeFruit() <= PLUS_DE_FRUIT)) {
				indicateur.setVisible(false);
			} else {
				indicateur.setVisible(true);
			}
		}
		return true;
	}

	private void cacherLesIndicateurs() {
		for (Rectangle indicateur : listeIndicateur) {
			indicateur.setVisible(false);
		}
	}

	private void handleReessaye() {
		deJoueur.reinitialiserLeNombreDeTour();

		panierCerisier.viderLePanier();
		panierPoirier.viderLePanier();
		panierPommier.viderLePanier();
		panierPrunier.viderLePanier();

		poirier.remplir();
		pommier.remplir();
		cerisier.remplir();
		prunier.remplir();

		corbeau.reinitialiser();

		nombreDePommeID.setText(pommier.nombreDeFruit() + "");
		nombreDePoireID.setText(poirier.nombreDeFruit() + "");
		nombreDePruneID.setText(prunier.nombreDeFruit() + "");
		nombreDeCeriseID.setText(cerisier.nombreDeFruit() + "");

		nombreDePommePanierID.setText(panierPommier.taillePanier() + "");
		nombreDePoirePanierID.setText(panierPoirier.taillePanier() + "");
		nombreDePrunePanierID.setText(panierPrunier.taillePanier() + "");
		nombreDeCerisePanierID.setText(panierCerisier.taillePanier() + "");

		cacherLesIndicateurs();

		cercleDeID.setFill(Color.WHITE);
		nombreDeTourID.setText("" + deJoueur.nombreDeTour());

		lancerBouton.setDisable(false);
		reessayerBouton.setDisable(true);
	}

	void ajouterDeuxFruitsDansDesPaniers(MouseEvent event) {
		if (nombreDeFruitPris < NOMBRE_DE_FRUIT_PRIS_MAX) {
			if (event.getSource().equals(indicateurCerisierId)) {
				ajouterCerisier();
			} else if (event.getSource().equals(indicateurPrunierId)) {
				ajouterPrunier();
			} else if (event.getSource().equals(indicateurPoirierId)) {
				ajouterPoirier();
			} else if (event.getSource().equals(indicateurPommierId)) {
				ajouterPommier();
			}
			
			afficherLesIndicateurs();
			nombreDeFruitPris++;

			if (nombreDeFruitPris >= NOMBRE_DE_FRUIT_PRIS_MAX) {
				cacherLesIndicateurs();
				lancerBouton.setDisable(false);
				nombreDeFruitPris = 0;
			}
		}
	}

	void ajouterUneCeriseDansUnPanier(MouseEvent event) {
		ajouterCerisier();
		indicateurCerisierId.setVisible(false);
		lancerBouton.setDisable(false);
	}

	private void ajouterCerisier() {
		if (cerisier.nombreDeFruit() != 0) {
			panierCerisier.recuperationFruit(cerisier);
			nombreDeCeriseID.setText(cerisier.nombreDeFruit() + "");
			nombreDeCerisePanierID.setText(panierCerisier.taillePanier() + "");
			casGagner();
		}
	}

	void ajouterUnePruneDansUnPanier(MouseEvent event) {
		ajouterPrunier();
		indicateurPrunierId.setVisible(false);
		lancerBouton.setDisable(false);
	}

	private void ajouterPrunier() {
		if (prunier.nombreDeFruit() != 0) {
			panierPrunier.recuperationFruit(prunier);
			nombreDePruneID.setText(prunier.nombreDeFruit() + "");
			nombreDePrunePanierID.setText(panierPrunier.taillePanier() + "");
			casGagner();
		}
	}

	void ajouterUnePoireDansUnPanier(MouseEvent event) {
		ajouterPoirier();
		indicateurPoirierId.setVisible(false);
		lancerBouton.setDisable(false);
	}

	private void ajouterPoirier() {
		if (poirier.nombreDeFruit() != 0) {
			panierPoirier.recuperationFruit(poirier);
			nombreDePoireID.setText(poirier.nombreDeFruit() + "");
			nombreDePoirePanierID.setText(panierPoirier.taillePanier() + "");
			casGagner();
		}
	}

	void ajouterUnePommeDansUnPanier(MouseEvent event) {
		ajouterPommier();
		indicateurPommierId.setVisible(false);
		lancerBouton.setDisable(false);
	}

	private void ajouterPommier() {
		if (pommier.nombreDeFruit() != 0) {
			panierPommier.recuperationFruit(pommier);
			nombreDePommeID.setText(pommier.nombreDeFruit() + "");
			nombreDePommePanierID.setText(panierPommier.taillePanier() + "");
			casGagner();
		}
	}

	@FXML
	void quitter(ActionEvent event) {
		Platform.exit();
	}

}
