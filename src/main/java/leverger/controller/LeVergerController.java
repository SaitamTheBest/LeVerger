package leverger.controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import leverger.model.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class LeVergerController {

	private static final Couleur PRENDRE_DEUX_FRUITS = Couleur.MARRON;

	@FXML
	private Circle cercleDeID;

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

	@FXML
	public void initialize() {
		// Remplir les arbres
		poirier.remplir();
		prunier.remplir();
		cerisier.remplir();
		pommier.remplir();

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

		// Bouton Reessaye
		reessayerBouton.setDisable(true);

		lancerBouton.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {

				Couleur faceDuDe = deJoueur.lancer();
				nombreDeTourID.setText("" + deJoueur.nombreDeTour());

				if (faceDuDe.equals(prunier.getCouleur())) {
					cercleDeID.setFill(Color.BLUE);
					lancerBouton.setDisable(true);
					indicateurPrunierId.setVisible(true);
					indicateurPrunierId.setOnMouseClicked(event -> ajouterPrunier(event));

				}
				if (faceDuDe.equals(poirier.getCouleur())) {
					cercleDeID.setFill(Color.YELLOW);
					lancerBouton.setDisable(true);
					indicateurPoirierId.setVisible(true);
					indicateurPoirierId.setOnMouseClicked(event -> ajouterPoirier(event));
				}
				if (faceDuDe.equals(cerisier.getCouleur())) {
					cercleDeID.setFill(Color.RED);
					lancerBouton.setDisable(true);
					indicateurCerisierId.setVisible(true);
					indicateurCerisierId.setOnMouseClicked(event -> ajouterCerisier(event));
				}
				if (faceDuDe.equals(pommier.getCouleur())) {
					cercleDeID.setFill(Color.GREEN);
					lancerBouton.setDisable(true);
					indicateurPommierId.setVisible(true);
					indicateurPommierId.setOnMouseClicked(event -> ajouterPommier(event));
				}

				if (faceDuDe.equals(PRENDRE_DEUX_FRUITS)) {
					cercleDeID.setFill(Color.BROWN);
					lancerBouton.setDisable(true);
					
					lancerBouton.setDisable(true);
					indicateurPommierId.setVisible(true);
					indicateurPoirierId.setVisible(true);
					indicateurPrunierId.setVisible(true);
					indicateurCerisierId.setVisible(true);
					
					//TODO faire une liste qui vérifie que deux fruits sont clickés?
					
					indicateurPommierId.setOnMouseClicked(event -> ajouterPommier(event));
					indicateurPoirierId.setOnMouseClicked(event -> ajouterPoirier(event));
					indicateurPrunierId.setOnMouseClicked(event -> ajouterPrunier(event));
					indicateurCerisierId.setOnMouseClicked(event -> ajouterCerisier(event));

				}

				if (faceDuDe.equals(Couleur.NOIR) && !corbeau.toutEstDevoile()) {
					cercleDeID.setFill(Color.BLACK);
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

				if (prunier.nombreDeFruit() == 0 && poirier.nombreDeFruit() == 0 && cerisier.nombreDeFruit() == 0
						&& pommier.nombreDeFruit() == 0) {
					// Alerts gagnant
					Alert alertGagner = new Alert(AlertType.INFORMATION);
					alertGagner.setTitle("Résultat du jeu");
					alertGagner.setHeaderText("Vous avez gagné en " + deJoueur.nombreDeTour() + " manches !");
					alertGagner.showAndWait();
					lancerBouton.setDisable(true);
					reessayerBouton.setDisable(false);
				}
			}
		});

		reessayerBouton.setOnMouseClicked(event -> handleReessaye());

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

		cercleDeID.setFill(Color.WHITE);
		nombreDeTourID.setText("" + deJoueur.nombreDeTour());

		lancerBouton.setDisable(false);
		reessayerBouton.setDisable(true);
	}

	@FXML
	void ajouterCerisier(MouseEvent event) {
		if (cerisier.nombreDeFruit() != 0) {
			panierCerisier.recuperationFruit(cerisier);
			nombreDeCeriseID.setText(cerisier.nombreDeFruit() + "");
			nombreDeCerisePanierID.setText(panierCerisier.taillePanier() + "");
		}
		indicateurCerisierId.setVisible(false);
		lancerBouton.setDisable(false);
	}

	@FXML
	void ajouterPoirier(MouseEvent event) {
		if (poirier.nombreDeFruit() != 0) {
			panierPoirier.recuperationFruit(poirier);
			nombreDePoireID.setText(poirier.nombreDeFruit() + "");
			nombreDePoirePanierID.setText(panierPoirier.taillePanier() + "");
		}
		indicateurPoirierId.setVisible(false);
		lancerBouton.setDisable(false);
	}

	@FXML
	void ajouterPommier(MouseEvent event) {
		if (pommier.nombreDeFruit() != 0) {
			panierPommier.recuperationFruit(pommier);
			nombreDePommeID.setText(pommier.nombreDeFruit() + "");
			nombreDePommePanierID.setText(panierPommier.taillePanier() + "");
		}
		indicateurPommierId.setVisible(false);
		lancerBouton.setDisable(false);
	}

	@FXML
	void ajouterPrunier(MouseEvent event) {
		if (prunier.nombreDeFruit() != 0) {
			panierPrunier.recuperationFruit(prunier);
			nombreDePruneID.setText(prunier.nombreDeFruit() + "");
			nombreDePrunePanierID.setText(panierPrunier.taillePanier() + "");
		}
		indicateurPrunierId.setVisible(false);
		lancerBouton.setDisable(false);
	}

}
