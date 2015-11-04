package application;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainMenuController { //michel k
	
	@FXML
	Button NewGameButton;
	
	@FXML
	Button ExitGameButton, JoinGameButton, OptionsButton;
	
	@FXML
	ImageView NewGameArrow, JoinGameArrow, ExitArrow, OptionsArrow;
	
	
	@FXML public void NewGameButtonAction (ActionEvent event) throws IOException {
		
		Stage stage;
		Parent root;
		
		stage = (Stage) NewGameButton.getScene().getWindow(); //NewGameButton
		root = FXMLLoader.load(getClass().getResource("MonsterSelect.fxml"));
		
		
		//Neue View wird eingefaded
		FadeTransition ft = new FadeTransition(Duration.millis(2000), root);
		ft.setFromValue(0.0);
		ft.setToValue(1.0);
		ft.play();
		
		//Neue View wird angezeigt
		Scene scene = new Scene(root,950,839);
		stage.setTitle("King Of Tokyo");
		stage.setX(450); 					//stage mittig anzeigen (links/rechts)
		stage.setY(60);						//stage mittig anzeigen (oben / unten)
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		
		
	}
	
	@FXML public void ExitGameButtonAction (ActionEvent ae) {
			System.exit(0);
}
	
	@FXML public void NewGameArrowEnter(MouseEvent event) {
		
		NewGameArrow.setVisible(true);
		
}
	
	@FXML public void NewGameArrowExit (MouseEvent event) {
		
		NewGameArrow.setVisible(false);
	}
	
	@FXML public void JoinGameArrowEnter (MouseEvent event) {
		
		JoinGameArrow.setVisible(true);
	}
	
	@FXML public void JoinGameArrowExit (MouseEvent event) {
		
		JoinGameArrow.setVisible(false);
	}
	
	@FXML public void OptionsArrowEnter (MouseEvent event) {
		
		OptionsArrow.setVisible(true);
	}
	
	@FXML public void OptionsArrowExit (MouseEvent event) {
		
		OptionsArrow.setVisible(false);
	}
	
	@FXML public void ExitArrowEnter (MouseEvent event) {
		
		ExitArrow.setVisible(true);
	}
	
	@FXML public void ExitArrowExit (MouseEvent event){
		
		ExitArrow.setVisible(false);
	}
	
}
