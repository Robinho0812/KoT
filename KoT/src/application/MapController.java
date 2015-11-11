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
 * Controller for the main game
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
	
	// required values;
	final int numberOfDices = 6;
	private int countRolls = 0;

	// generate Dice array
	Dice[] gameDices = new Dice[numberOfDices];
	static ArrayList<Integer> faceValues = new ArrayList<Integer>();


	
	public static ArrayList<Integer> getFaceValues() {
		return faceValues;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Monster m1 =new Monster();
		Monster m2 =new Monster();
		

		rollButton.setDisable(false);

		// Generate new gameDices
		for (int i = 0; i < numberOfDices; i++) {
			gameDices[i] = new Dice();
			gameDices[i].setDisable(true);
			hbDices.getChildren().add(gameDices[i]);
		}

	// Action Events for each Dice
		gameDices[0].setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent ae) {
				if (gameDices[0].isSelected() && countRolls < 3) {
					gameDices[0].changeImageIfSelected();
				} else if (countRolls < 3) {
					gameDices[0].showToggleButton();
				}

			}

		});

		gameDices[1].setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent ae) {
				if (gameDices[1].isSelected() && countRolls < 3) {
					gameDices[1].changeImageIfSelected();
				} else if (countRolls < 3) {
					gameDices[1].showToggleButton();
				}

			}

		});

		gameDices[2].setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent ae) {
				if (gameDices[2].isSelected() && countRolls < 3) {
					gameDices[2].changeImageIfSelected();
				} else if (countRolls < 3) {
					gameDices[2].showToggleButton();
				}

			}

		});

		gameDices[3].setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent ae) {
				if (gameDices[3].isSelected() && countRolls < 3) {
					gameDices[3].changeImageIfSelected();
				} else if (countRolls < 3) {
					gameDices[3].showToggleButton();
				}

			}

		});

		gameDices[4].setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent ae) {
				if (gameDices[4].isSelected() && countRolls < 3) {
					gameDices[4].changeImageIfSelected();
				} else if (countRolls < 3) {
					gameDices[4].showToggleButton();
				}

			}

		});

		gameDices[5].setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent ae) {
				if (gameDices[5].isSelected() && countRolls < 3) {
					gameDices[5].changeImageIfSelected();
				} else if (countRolls < 3) {
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
		this.countRolls++;

		
			for (int i = 0; i < gameDices.length; i++) {
				gameDices[i].roll(countRolls);

				gameDices[i].showToggleButton();

				gameDices[i].setDisable(false);
				gameDices[i].setSelected(false);
			}

	
		if (countRolls == 3) {
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
			
			
		
			
		
		}
	}



