package leverger.controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import leverger.model.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class LeVergerController {

	@FXML
    private Circle cercleDeID;

    @FXML
    private Button lancerBouton;

    @FXML
    private Label nombreDeCeriseID;

    @FXML
    private Label nombreDeCerisierPanierID;

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

	// Création Arbre
	Arbre poirier = new Arbre(Couleur.JAUNE);
	Arbre prunier = new Arbre(Couleur.BLEU);
	Arbre cerisier = new Arbre(Couleur.ROUGE);
	Arbre pommier = new Arbre(Couleur.VERT);

	// Création Dé
	De deJoueur = new De();
	
	//Création Panier
	Panier panierPoirier = new Panier();
	Panier panierPrunier = new Panier();
	Panier panierCerisier = new Panier();
	Panier panierPommier = new Panier();

	@FXML
	public void initialize() {
		poirier.remplir();
		prunier.remplir();
		cerisier.remplir();
		pommier.remplir();

		// Label Application
		nombreDePommeID.setText(pommier.nombreDeFruit() + "");
		nombreDePoireID.setText(poirier.nombreDeFruit() + "");
		nombreDePruneID.setText(prunier.nombreDeFruit() + "");
		nombreDeCeriseID.setText(cerisier.nombreDeFruit() + "");

		// Bouton Reessaye
		reessayerBouton.setDisable(true);

		lancerBouton.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {

				Couleur faceDuDe = deJoueur.lancer();
				nombreDeTourID.setText("" + deJoueur.nombreDeTour());

				if (faceDuDe.equals(prunier.getCouleur())) {
					prunier.enlever();
					nombreDePruneID.setText(prunier.nombreDeFruit() + "");
					cercleDeID.setFill(Color.BLUE);

				}
				if (faceDuDe.equals(poirier.getCouleur())) {
					poirier.enlever();
					nombreDePoireID.setText(poirier.nombreDeFruit() + "");
					cercleDeID.setFill(Color.YELLOW);
				}
				if (faceDuDe.equals(cerisier.getCouleur())) {
					cerisier.enlever();
					nombreDeCeriseID.setText(cerisier.nombreDeFruit() + "");
					cercleDeID.setFill(Color.RED);
				}
				if (faceDuDe.equals(pommier.getCouleur())) {
					pommier.enlever();
					nombreDePommeID.setText(pommier.nombreDeFruit() + "");
					cercleDeID.setFill(Color.GREEN);
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
		
		nombreDePommeID.setText(pommier.nombreDeFruit()+"");
		nombreDePoireID.setText(poirier.nombreDeFruit()+"");
		nombreDePruneID.setText(prunier.nombreDeFruit() + "");
		nombreDeCeriseID.setText(cerisier.nombreDeFruit() + "");
		cercleDeID.setFill(Color.WHITE);
		nombreDeTourID.setText("" + deJoueur.nombreDeTour());
		lancerBouton.setDisable(false);
		reessayerBouton.setDisable(true);
	}

}
