package application;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class LoginController {
	
	@FXML 
	Button LoginAcceptButton, RegisterButton;
	@FXML TextField txtname;
	@FXML PasswordField txtpw;

	@FXML public void RegisterButtonAction (ActionEvent event) throws IOException {
		
		Stage stage;
		Parent root;
		
		stage = (Stage) RegisterButton.getScene().getWindow(); //REGISTER NEW ACC
		root = FXMLLoader.load(getClass().getResource("Register.fxml"));
		
		
		//Neue View wird eingefaded
		FadeTransition ft = new FadeTransition(Duration.millis(2000), root);
		ft.setFromValue(0.0);
		ft.setToValue(1.0);
		ft.play();
		
		
		
		
		//Neue View wird angezeigt
		Scene scene = new Scene(root,488,366);
		stage.setTitle("Account Registration");
		stage.setX(700); 					//stage mittig anzeigen (links/rechts)
		stage.setY(200);					//stage mittig anzeigen (oben / unten)
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		
	}

	
	
	
	
	
	
@FXML public void LoginAcceptButtonAction (ActionEvent event) throws IOException {
		
		Stage stage;
		Parent root;
		
		sqltest.myConnection.openDb();
		
		boolean bool;
		
		bool = sqltest.myConnection.isValidLogin(txtname.getText(), sqltest.myConnection.hashPasswort(txtpw.getText()));
		
		if(bool == true){
	
		stage = (Stage) LoginAcceptButton.getScene().getWindow(); //LoginAcceptButton
		root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
	
	
		//Neue View wird eingefaded
		FadeTransition ft = new FadeTransition(Duration.millis(2000), root);
		ft.setFromValue(0.0);
		ft.setToValue(1.0);
		ft.play();
	
	
	
	
		//Neue View wird angezeigt
		Scene scene = new Scene(root,780,580);
		stage.setTitle("King Of Tokyo");
		stage.setX(550); 					//stage mittig anzeigen (links/rechts)
		stage.setY(150);					//stage mittig anzeigen (oben / unten)
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		}
	else{
		JOptionPane.showMessageDialog(null, "BOAH bist du ein hässlicher Idiot!!",
				"Fehler", JOptionPane.ERROR_MESSAGE);
		
	}
	}

	}
