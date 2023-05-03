package leverger.application;

import javafx.scene.control.CheckBox;

import javafx.scene.input.*;

import java.io.File;
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.*;
import javafx.scene.image.Image;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import leverger.model.Arbre;
import leverger.model.Couleur;
import leverger.model.De;

public class MainLeVerger extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		// Création Arbre
		Arbre arbreJaune = new Arbre(Couleur.JAUNE);
		Arbre arbreBleu = new Arbre(Couleur.BLEU);
		Arbre arbreRouge = new Arbre(Couleur.ROUGE);
		Arbre arbreVert = new Arbre(Couleur.VERT);

		arbreJaune.remplir();
		arbreBleu.remplir();
		arbreRouge.remplir();
		arbreVert.remplir();

		// Création Dé

		De deJoueur = new De();

		// Label Application
		Label nombreDeTourLabel = new Label("Manche " + deJoueur.nombreDeTour());
		Label nombreDeFruitJauneLabel = new Label(arbreJaune.nombreDeFruit() + " fruit(s)");
		Label nombreDeFruitRougeLabel = new Label(arbreRouge.nombreDeFruit() + " fruit(s)");
		Label nombreDeFruitVertLabel = new Label(arbreVert.nombreDeFruit() + " fruit(s)");
		Label nombreDeFruitBleuLabel = new Label(arbreBleu.nombreDeFruit() + " fruit(s)");

		// Boutons
		Button lancerBouton = new Button("Lancer");

		// Canvas
		Circle circle = new Circle();
		circle.setFill(Color.TRANSPARENT);
		circle.setCenterX(50);
		circle.setCenterY(50);
		circle.setRadius(25);

		// Events

		lancerBouton.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {

				Couleur faceDuDe = deJoueur.lancer();
				nombreDeTourLabel.setText("Manche " + deJoueur.nombreDeTour());

				if (faceDuDe.equals(arbreBleu.getCouleur())) {
					arbreBleu.enlever();
					nombreDeFruitBleuLabel.setText(arbreBleu.nombreDeFruit() + " fruit(s)");
					circle.setFill(Color.BLUE);

				}
				if (faceDuDe.equals(arbreJaune.getCouleur())) {
					arbreJaune.enlever();
					nombreDeFruitJauneLabel.setText(arbreJaune.nombreDeFruit() + " fruit(s)");
					circle.setFill(Color.YELLOW);
				}
				if (faceDuDe.equals(arbreRouge.getCouleur())) {
					arbreRouge.enlever();
					nombreDeFruitRougeLabel.setText(arbreRouge.nombreDeFruit() + " fruit(s)");
					circle.setFill(Color.RED);
				}
				if (faceDuDe.equals(arbreVert.getCouleur())) {
					arbreVert.enlever();
					nombreDeFruitVertLabel.setText(arbreVert.nombreDeFruit() + " fruit(s)");
					circle.setFill(Color.GREEN);
				}

				if (arbreBleu.nombreDeFruit() == 0 && arbreJaune.nombreDeFruit() == 0 && arbreRouge.nombreDeFruit() == 0
						&& arbreVert.nombreDeFruit() == 0) {
					// Alerts gagnant
					Alert alertGagner = new Alert(AlertType.INFORMATION);
					alertGagner.setTitle("Résultat du jeu");
					alertGagner.setHeaderText("Vous avez gagné en " + deJoueur.nombreDeTour() + " manches !");
					alertGagner.showAndWait();
					lancerBouton.setDisable(true);
				}
			}
		});

		// GridPane Main
		GridPane root = new GridPane();
		root.add(nombreDeFruitBleuLabel, 0, 0);
		root.add(nombreDeFruitVertLabel, 1, 0);
		root.add(nombreDeFruitRougeLabel, 2, 0);
		root.add(nombreDeFruitJauneLabel, 3, 0);
		root.add(lancerBouton, 0, 1);
		root.add(nombreDeTourLabel, 3, 1);
		root.add(circle, 2, 1);

		root.setHgap(20);
		root.setVgap(20);
		root.setAlignment(Pos.CENTER);

		File fondFichier = new File("image/leverger-fond-image.jpep");
		Image fondImage = new Image(new FileInputStream(fondFichier));
		BackgroundImage backgroundImage = new BackgroundImage(fondImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		root.setBackground(new Background(backgroundImage));
		
		Scene scene = new Scene(root, 900, 600);
		stage.setScene(scene);
		stage.setTitle("Le Verger");
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}