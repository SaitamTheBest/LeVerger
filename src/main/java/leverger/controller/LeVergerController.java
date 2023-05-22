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
		poirier.remplir();
		prunier.remplir();
		cerisier.remplir();
		pommier.remplir();
		
		pieces.add(piece0_0Id);
		pieces.add(piece0_1Id);
		pieces.add(piece0_2Id);
		pieces.add(piece1_0Id);
		pieces.add(piece1_1Id);
		pieces.add(piece1_2Id);
		pieces.add(piece2_0Id);
		pieces.add(piece2_1Id);
		pieces.add(piece2_2Id);

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
					panierPrunier.recuperationFruit(prunier);
					nombreDePruneID.setText(prunier.nombreDeFruit() + "");
					nombreDePrunePanierID.setText(panierPrunier.taillePanier() + "");
					cercleDeID.setFill(Color.BLUE);

				}
				if (faceDuDe.equals(poirier.getCouleur())) {
					panierPoirier.recuperationFruit(poirier);
					nombreDePoireID.setText(poirier.nombreDeFruit() + "");
					nombreDePoirePanierID.setText(panierPoirier.taillePanier() + "");
					cercleDeID.setFill(Color.YELLOW);
				}
				if (faceDuDe.equals(cerisier.getCouleur())) {
					panierCerisier.recuperationFruit(cerisier);
					nombreDeCeriseID.setText(cerisier.nombreDeFruit() + "");
					nombreDeCerisePanierID.setText(panierCerisier.taillePanier() + "");
					cercleDeID.setFill(Color.RED);
				}
				if (faceDuDe.equals(pommier.getCouleur())) {
					panierPommier.recuperationFruit(pommier);
					nombreDePommeID.setText(pommier.nombreDeFruit() + "");
					nombreDePommePanierID.setText(panierPommier.taillePanier() + "");
					cercleDeID.setFill(Color.GREEN);
				}
				if (faceDuDe.equals(Couleur.NOIR)) {
					cercleDeID.setFill(Color.BLACK);
					corbeau.devoile();
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

}
