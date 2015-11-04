package application;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MonsterSelectController {

	@FXML
	Button AlienoidButton;
	
	@FXML
	Text AlienoidText,CyberBunnyText,GigaZaurText,KrakenText,MekaDragonText,TheKingText;

	@FXML
	public void AlienoidAction(ActionEvent event) throws IOException {

		Stage stage;
		Parent root;

		stage = (Stage) AlienoidButton.getScene().getWindow(); // NewGameButton
		root = FXMLLoader.load(getClass().getResource("Map.fxml"));

		// Neue View wird eingefaded
		FadeTransition ft = new FadeTransition(Duration.millis(2000), root);
		ft.setFromValue(0.0);
		ft.setToValue(1.0);
		ft.play();

		// Neue View wird angezeigt
		Scene scene = new Scene(root, 1500, 950);
		stage.setTitle("King Of Tokyo");
		stage.setX(200); // stage mittig anzeigen (links/rechts)
		stage.setY(30); // stage mittig anzeigen (oben / unten)
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();

	}

	@FXML
	public void CyberBunnyAction(ActionEvent event) throws IOException {

		Stage stage;
		Parent root;

		stage = (Stage) AlienoidButton.getScene().getWindow(); // NewGameButton
		root = FXMLLoader.load(getClass().getResource("Map.fxml"));

		// Neue View wird eingefaded
		FadeTransition ft = new FadeTransition(Duration.millis(2000), root);
		ft.setFromValue(0.0);
		ft.setToValue(1.0);
		ft.play();

		// Neue View wird angezeigt
		Scene scene = new Scene(root, 1500, 950);
		stage.setTitle("King Of Tokyo");
		stage.setX(200); // stage mittig anzeigen (links/rechts)
		stage.setY(30); // stage mittig anzeigen (oben / unten)
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();

	}

	@FXML
	public void GigaZaurAction(ActionEvent event) throws IOException {

		Stage stage;
		Parent root;

		stage = (Stage) AlienoidButton.getScene().getWindow(); // NewGameButton
		root = FXMLLoader.load(getClass().getResource("Map.fxml"));

		// Neue View wird eingefaded
		FadeTransition ft = new FadeTransition(Duration.millis(2000), root);
		ft.setFromValue(0.0);
		ft.setToValue(1.0);
		ft.play();

		// Neue View wird angezeigt
		Scene scene = new Scene(root, 1500, 950);
		stage.setTitle("King Of Tokyo");
		stage.setX(200); // stage mittig anzeigen (links/rechts)
		stage.setY(30); // stage mittig anzeigen (oben / unten)
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();

	}

	@FXML
	public void KrakenAction(ActionEvent event) throws IOException {

		Stage stage;
		Parent root;

		stage = (Stage) AlienoidButton.getScene().getWindow(); // NewGameButton
		root = FXMLLoader.load(getClass().getResource("Map.fxml"));

		// Neue View wird eingefaded
		FadeTransition ft = new FadeTransition(Duration.millis(2000), root);
		ft.setFromValue(0.0);
		ft.setToValue(1.0);
		ft.play();

		// Neue View wird angezeigt
		Scene scene = new Scene(root, 1500, 950);
		stage.setTitle("King Of Tokyo");
		stage.setX(200); // stage mittig anzeigen (links/rechts)
		stage.setY(30); // stage mittig anzeigen (oben / unten)
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	@FXML
	public void MekaDragonAction(ActionEvent event) throws IOException {

		Stage stage;
		Parent root;

		stage = (Stage) AlienoidButton.getScene().getWindow(); // NewGameButton
		root = FXMLLoader.load(getClass().getResource("Map.fxml"));

		// Neue View wird eingefaded
		FadeTransition ft = new FadeTransition(Duration.millis(2000), root);
		ft.setFromValue(0.0);
		ft.setToValue(1.0);
		ft.play();

		// Neue View wird angezeigt
		Scene scene = new Scene(root, 1500, 950);
		stage.setTitle("King Of Tokyo");
		stage.setX(200); // stage mittig anzeigen (links/rechts)
		stage.setY(30); // stage mittig anzeigen (oben / unten)
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	@FXML
	public void TheKingAction(ActionEvent event) throws IOException {

		Stage stage;
		Parent root;

		stage = (Stage) AlienoidButton.getScene().getWindow(); // NewGameButton
		root = FXMLLoader.load(getClass().getResource("Map.fxml"));

		// Neue View wird eingefaded
		FadeTransition ft = new FadeTransition(Duration.millis(2000), root);
		ft.setFromValue(0.0);
		ft.setToValue(1.0);
		ft.play();

		// Neue View wird angezeigt
		Scene scene = new Scene(root, 1500, 950);
		stage.setTitle("King Of Tokyo");
		stage.setX(200); // stage mittig anzeigen (links/rechts)
		stage.setY(30); // stage mittig anzeigen (oben / unten)
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
@FXML public void AlienoidEnter (MouseEvent event) {
		
		AlienoidText.setVisible(true);
	}

@FXML public void AlienoidExit (MouseEvent event) {
	
	    AlienoidText.setVisible(false);
	
}
@FXML public void CyberBunnyEnter (MouseEvent event) {
	
		CyberBunnyText.setVisible(true);
}

@FXML public void CyberBunnyExit (MouseEvent event) {

    	CyberBunnyText.setVisible(false);

}
@FXML public void GigaZaurEnter (MouseEvent event) {
	
	GigaZaurText.setVisible(true);
}

@FXML public void GigaZaurExit (MouseEvent event) {

	GigaZaurText.setVisible(false);

}
@FXML public void KrakenEnter (MouseEvent event) {
	
	KrakenText.setVisible(true);
}


@FXML public void KrakenExit (MouseEvent event) {

	KrakenText.setVisible(false);

}
@FXML public void MekaDragonEnter (MouseEvent event) {
	
	MekaDragonText.setVisible(true);
}

@FXML public void MekaDragonExit (MouseEvent event) {

	MekaDragonText.setVisible(false);
	
}
@FXML public void TheKingEnter (MouseEvent event) {
	
	TheKingText.setVisible(true);
}

@FXML public void TheKingExit (MouseEvent event) {

	TheKingText.setVisible(false);
}
}
