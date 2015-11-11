package application;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Dice;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 * 
 * @author Robin Schmid
 *
 */
public class MapController implements Initializable {

	@FXML
	Button AttackButton;

	@FXML
	Text AttackText;

	@FXML
	ImageView AttackPicture;

	@FXML
	ImageView SwordAttack;

	@FXML
	Button rollButton;

	@FXML
	TextArea mainTextArea;

	@FXML
	HBox hbDices;

	@FXML
	Text RerollInfo;
	
	// Benötigte Variabeln
	final int ANZAHLSPIELWÜRFEL = 6;
	private int countAnzahlWürfe = 0;

	// Würfel-Objekte erzeugen
	Dice[] gameDices = new Dice[ANZAHLSPIELWÜRFEL];
	static ArrayList<Integer> faceValues = new ArrayList<Integer>();


	
	public static ArrayList<Integer> getFaceValues() {
		return faceValues;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Monster m1 =new Monster();
		Monster m2 =new Monster();
		

		rollButton.setDisable(false);

		for (int i = 0; i < ANZAHLSPIELWÜRFEL; i++) {
			gameDices[i] = new Dice();
			gameDices[i].setDisable(true);
			hbDices.getChildren().add(gameDices[i]);
		}

		gameDices[0].setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent ae) {
				if (gameDices[0].isSelected() && countAnzahlWürfe < 3) {
					gameDices[0].changeImageIfSelected();
				} else if (countAnzahlWürfe < 3) {
					gameDices[0].showToggleButton();
				}

			}

		});

		gameDices[1].setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent ae) {
				if (gameDices[1].isSelected() && countAnzahlWürfe < 3) {
					gameDices[1].changeImageIfSelected();
				} else if (countAnzahlWürfe < 3) {
					gameDices[1].showToggleButton();
				}

			}

		});

		gameDices[2].setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent ae) {
				if (gameDices[2].isSelected() && countAnzahlWürfe < 3) {
					gameDices[2].changeImageIfSelected();
				} else if (countAnzahlWürfe < 3) {
					gameDices[2].showToggleButton();
				}

			}

		});

		gameDices[3].setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent ae) {
				if (gameDices[3].isSelected() && countAnzahlWürfe < 3) {
					gameDices[3].changeImageIfSelected();
				} else if (countAnzahlWürfe < 3) {
					gameDices[3].showToggleButton();
				}

			}

		});

		gameDices[4].setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent ae) {
				if (gameDices[4].isSelected() && countAnzahlWürfe < 3) {
					gameDices[4].changeImageIfSelected();
				} else if (countAnzahlWürfe < 3) {
					gameDices[4].showToggleButton();
				}

			}

		});

		gameDices[5].setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent ae) {
				if (gameDices[5].isSelected() && countAnzahlWürfe < 3) {
					gameDices[5].changeImageIfSelected();
				} else if (countAnzahlWürfe < 3) {
					gameDices[5].showToggleButton();
				}

			}

		});

	}

	/**
	 * Methode, um alle sechs Würfel gleichzeitig zu Würfel und weitere Methoden
	 * auszuführen
	 * 
	 * @param ae
	 * @throws IOException
	 */

	@FXML
	public void roll(ActionEvent event) {
		rollButton.setText("Reroll");
		this.countAnzahlWürfe++;

		
			for (int i = 0; i < gameDices.length; i++) {
				gameDices[i].roll(countAnzahlWürfe);

				gameDices[i].showToggleButton();

				gameDices[i].setDisable(false);
				gameDices[i].setSelected(false);
			}

	
		if (countAnzahlWürfe == 3) {
			rollButton.setDisable(true);
		}

	}
	
	/*
	 * Michel Konrad
	 */
	
	@FXML
	public void endturnButtonAction (ActionEvent event) {
		
		rollButton.setDisable(true);
		
		for (Dice d:gameDices){
			d.setDisable(true);								// für jeden würfel: würfel disablen				
			faceValues.add(d.getFaceValue());				// für jeden würfel: würfel in die Arraylist "faceValues"
			
		}
		
		int dice1Value=gameDices[0].getFaceValue();
		int dice2Value=gameDices[1].getFaceValue();
		int dice3Value=gameDices[2].getFaceValue();			// Werte der Würfelindexe in einen int speichern
		int dice4Value=gameDices[3].getFaceValue();
		int dice5Value=gameDices[4].getFaceValue();
		int dice6Value=gameDices[5].getFaceValue();	
			
			System.out.println(dice1Value+" "+dice2Value+" "+dice3Value+ " "+ dice4Value+" "+dice5Value+" "+dice6Value );
			
		switch(dice1Value){
		
		case 3:
			 m1.setVictoryPoints(1);
			
			
		}
		
			
		
		}
	}



