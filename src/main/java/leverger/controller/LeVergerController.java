package leverger.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import leverger.model.*;

public class LeVergerController {

    @FXML
    private Circle cercleDeID;

    @FXML
    private Button lancerBouton;

    @FXML
    private Label nombreDeCeriseID;

    @FXML
    private Label nombreDePoireID;

    @FXML
    private Label nombreDePommeID;

    @FXML
    private Label nombreDePurneID;

    @FXML
    private Label nombreDeTourID;

    @FXML
    private Label titreID;
    
    @FXML
    public void initialize() {
    	// Création Arbre
        Arbre poirier = new Arbre(Couleur.JAUNE);
        Arbre prunier = new Arbre(Couleur.BLEU);
        Arbre cerisier = new Arbre(Couleur.ROUGE);
        Arbre pommier = new Arbre(Couleur.VERT);

        poirier.remplir();
        prunier.remplir();
        cerisier.remplir();
        pommier.remplir();
        
     // Label Application
        nombreDePommeID.setText(pommier.nombreDeFruit() + " fruit(s)");
        nombreDePoireID.setText(poirier.nombreDeFruit() + " fruit(s)");
    }
}
