package application;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.util.ResourceBundle;

import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

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
	ImageView Dice;
	
	@FXML
	Button DiceButton, rerollButton;
	
	@FXML
	Text RollText, RerollInfo;
	
	@FXML
	ToggleButton tb1, tb2, tb3, tb4, tb5, tb6;
	
	@FXML
	ImageView DicePicture;
	
	
	
	//Michel
	
	/**
	 * Uhr
	 */
	
    
    

	
	
		@FXML public void AttackButtonEnter(MouseEvent event) {
			
			SwordAttack.setVisible(true);
			AttackText.setVisible(true);
			
			}
		
		@FXML public void AttackButtonExit(MouseEvent event) {
			
			SwordAttack.setVisible(false);
			AttackText.setVisible(false);
		}
		
			//Display "Roll" on DiceButtonEnter
		@FXML public void DiceButtonEnter(MouseEvent event){
			DicePicture.setVisible(true);
			
		}
			
		@FXML public void DiceButtonExit(MouseEvent event){
			DicePicture.setVisible(false);
			RerollInfo.setVisible(false);
			
		}
		
		@FXML public void RerollButtonEnter(MouseEvent event){
			RerollInfo.setVisible(true);
			DicePicture.setVisible(true);
		}
		
		@FXML public void RerollButtonExit(MouseEvent event){
			RerollInfo.setVisible(false);
			DicePicture.setVisible(false);
		}
			
	
	//Fabian
		private int countAnzahlWürfe = 0;
		
		//Würfel-Objekte erzeugen
		Würfel w1 = new Würfel();
		Würfel w2 = new Würfel();
		Würfel w3 = new Würfel();
		Würfel w4 = new Würfel();
		Würfel w5 = new Würfel();
		Würfel w6 = new Würfel();
		
		//Würfel Array erzeugen, Würfel-Objekte hinzufügen
		Würfel[] würfelArray = {w1,w2,w3,w4,w5,w6};
		
		//Integer Array erzeugen
		Integer[] integerArray = new Integer[würfelArray.length];
		
		//Images erzeugen
		Image imgDie1 = new Image("images/Würfel1.png");
		Image imgDie2 = new Image("images/Würfel2.png");
		Image imgDie3 = new Image("images/Würfel3.png");
		Image imgDie4 = new Image("images/WürfelAngriff.png");
		Image imgDie5 = new Image("images/WürfelHerz.png");
		Image imgDie6 = new Image("images/WürfelBlitz.png");
		Image imgDie1WithCross = new Image("images/Würfel1_redx2.png");
		Image imgDie2WithCross = new Image("images/Würfel2_redx2.png");
		Image imgDie3WithCross = new Image("images/Würfel3_redx2.png");
		Image imgDie4WithCross = new Image("images/WürfelAngriff_redx2.png");
		Image imgDie5WithCross = new Image("images/WürfelHerz_redx2.png");
		Image imgDie6WithCross = new Image("images/WürfelBlitz_redx2.png");
		

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
	
		changeGraphic(tb1, imgDie1);							//Alle Images laden
		changeGraphic(tb2, imgDie2);
		changeGraphic(tb3, imgDie3);
		changeGraphic(tb4, imgDie4);
		changeGraphic(tb5, imgDie5);
		changeGraphic(tb6, imgDie6);
		tb1.setDisable(true);									//Toggle-Buttons disablen
		tb2.setDisable(true);
		tb3.setDisable(true);
		tb4.setDisable(true);
		tb5.setDisable(true);
		tb6.setDisable(true);
		
		}
		
		/** Methode, um alle sechs Würfel gleichzeitig zu Würfel und
		 * weitere Methoden auszuführen
		 * @param ae
		 * @throws IOException
		 */
		@FXML public void roll (ActionEvent ae) throws IOException {
			
			rerollButton.setDisable(false);
			
			this.countAnzahlWürfe++;
			tb1.setDisable(false);
			tb2.setDisable(false);
			tb3.setDisable(false);
			tb4.setDisable(false);
			tb5.setDisable(false);
			tb6.setDisable(false);
			
			for (int i = 0; i < würfelArray.length; i++){
				würfelArray[i].roll();
			}
			
					
			copyToIntArray(würfelArray);
			setImageOfDice(integerArray[0], integerArray[1], integerArray[2], integerArray[3], integerArray[4], integerArray[5]);
			
			
			
			for (int i = 0; i < integerArray.length; i++){
				
			}
			
			
			DiceButton.setDisable(true);
			//An dieser Stelle Benutzer fragen, ob er nochmals würfeln will
			//Wenn nein, rerollButton disablen!
		}
		
		/** Methode, um alle sechs Würfel ein zweites und ein drittes Mal zu würfeln
		 * @param ae
		 * @throws IOException
		 */
		@FXML public void reroll (ActionEvent ae) throws IOException {
			this.countAnzahlWürfe++;
			
			if (countAnzahlWürfe<=2){
				for (int i = 0; i < würfelArray.length; i++){
					if (this.tb1.isSelected()){
						würfelArray[0].roll();
					} 
					if (this.tb2.isSelected()){
						würfelArray[1].roll();
					}
					if (this.tb3.isSelected()){
						würfelArray[2].roll();
					}
					if (this.tb4.isSelected()){
						würfelArray[3].roll();
					}
					if (this.tb5.isSelected()){
						würfelArray[4].roll();
					}
					if (this.tb6.isSelected()){
						würfelArray[5].roll();
					}
				}
				
				
				copyToIntArray(würfelArray);
				setImageOfDice(integerArray[0], integerArray[1], integerArray[2], integerArray[3], integerArray[4], integerArray[5]);
				
				
				
				for (int i = 0; i < integerArray.length; i++){
					
				}
				
				tb1.setSelected(false);
				tb2.setSelected(false);
				tb3.setSelected(false);
				tb4.setSelected(false);
				tb5.setSelected(false);
				tb6.setSelected(false);
			} else {
				for (int i = 0; i < würfelArray.length; i++){
					if (this.tb1.isSelected()){
						würfelArray[0].roll();
					}
					if (this.tb2.isSelected()){
						würfelArray[1].roll();
					}
					if (this.tb3.isSelected()){
						würfelArray[2].roll();
					}
					if (this.tb4.isSelected()){
						würfelArray[3].roll();
					}
					if (this.tb5.isSelected()){
						würfelArray[4].roll();
					}
					if (this.tb6.isSelected()){
						würfelArray[5].roll();
					}
				}
				
				
				copyToIntArray(würfelArray);
				setImageOfDice(integerArray[0], integerArray[1], integerArray[2], integerArray[3], integerArray[4], integerArray[5]);
				
				
				
				for (int i = 0; i < integerArray.length; i++){
					
				}
				rerollButton.setDisable(true);
				tb1.setSelected(false);
				tb2.setSelected(false);
				tb3.setSelected(false);
				tb4.setSelected(false);
				tb5.setSelected(false);
				tb6.setSelected(false);
				tb1.setStyle("-fx-border-color: green;"+"-fx-border-width: 2;");
				tb2.setStyle("-fx-border-color: green;"+"-fx-border-width: 2;");
				tb3.setStyle("-fx-border-color: green;"+"-fx-border-width: 2;");
				tb4.setStyle("-fx-border-color: green;"+"-fx-border-width: 2;");
				tb5.setStyle("-fx-border-color: green;"+"-fx-border-width: 2;");
				tb6.setStyle("-fx-border-color: green;"+"-fx-border-width: 2;");
			}
			
		}
		
		/**Methode, die die Werte der Würfel-Objekte in
		 * ein neues Integer-Array kopieren. 
		 * @param array
		 * @return integerArray
		 */
		public Integer[] copyToIntArray (Würfel[] array){
			for(int i = 0; i < array.length; i++){
				this.integerArray[i] = array[i].getFaceValue();
			}
			return integerArray;		
		}
		
		/**Methode, die das entsprechende Würfel-Bild
		 * auf den entsprechenden Toggle-Button setzt
		 * @param toggleButton
		 * @param img
		 */
		public void changeGraphic(ToggleButton toggleButton, Image img){
			ImageView iv = new ImageView(img);
			iv.setFitHeight(60.0);
			iv.setFitWidth(60.0);		
			toggleButton.setGraphic(iv);
		}
		
		/**Methode, die entscheidet, in welchen Fällen
		 * welches Bild auf den Toggle-Button gesetzt wird
		 * @param index0
		 * @param index1
		 * @param index2
		 * @param index3
		 * @param index4
		 * @param index5
		 */
		@FXML public void setImageOfDice (int index0, int index1, int index2, int index3, int index4, int index5){
			switch (index0){
			case 0: 
				break;
			case 1:
				changeGraphic(tb1, imgDie1);
				break;
			case 2:
				changeGraphic(tb1, imgDie2);
				break;
			case 3:
				changeGraphic(tb1, imgDie3);
				break;
			case 4:
				changeGraphic(tb1, imgDie4);
				break;
			case 5:
				changeGraphic(tb1, imgDie5);
				break;
			case 6:
				changeGraphic(tb1, imgDie6);
				break;
			}
			switch (index1){
			case 0: 
				break;
			case 1:
				changeGraphic(tb2, imgDie1);
				break;
			case 2:
				changeGraphic(tb2, imgDie2);
				break;
			case 3:
				changeGraphic(tb2, imgDie3);
				break;
			case 4:
				changeGraphic(tb2, imgDie4);
				break;
			case 5:
				changeGraphic(tb2, imgDie5);
				break;
			case 6:
				changeGraphic(tb2, imgDie6);
				break;
			}
			switch (index2){
			case 0: 
				break;
			case 1:
				changeGraphic(tb3, imgDie1);
				break;
			case 2:
				changeGraphic(tb3, imgDie2);
				break;
			case 3:
				changeGraphic(tb3, imgDie3);
				break;
			case 4:
				changeGraphic(tb3, imgDie4);
				break;
			case 5:
				changeGraphic(tb3, imgDie5);
				break;
			case 6:
				changeGraphic(tb3, imgDie6);
				break;
			}
			switch (index3){
			case 0: 
				break;
			case 1:
				changeGraphic(tb4, imgDie1);
				break;
			case 2:
				changeGraphic(tb4, imgDie2);
				break;
			case 3:
				changeGraphic(tb4, imgDie3);
				break;
			case 4:
				changeGraphic(tb4, imgDie4);
				break;
			case 5:
				changeGraphic(tb4, imgDie5);
				break;
			case 6:
				changeGraphic(tb4, imgDie6);
				break;
			}
			switch (index4){
			case 0: 
				break;
			case 1:
				changeGraphic(tb5, imgDie1);
				break;
			case 2:
				changeGraphic(tb5, imgDie2);
				break;
			case 3:
				changeGraphic(tb5, imgDie3);
				break;
			case 4:
				changeGraphic(tb5, imgDie4);
				break;
			case 5:
				changeGraphic(tb5, imgDie5);
				break;
			case 6:
				changeGraphic(tb5, imgDie6);
				break;
			}
			switch (index5){
			case 0: 
				break;
			case 1:
				changeGraphic(tb6, imgDie1);
				break;
			case 2:
				changeGraphic(tb6, imgDie2);
				break;
			case 3:
				changeGraphic(tb6, imgDie3);
				break;
			case 4:
				changeGraphic(tb6, imgDie4);
				break;
			case 5:
				changeGraphic(tb6, imgDie5);
				break;
			case 6:
				changeGraphic(tb6, imgDie6);
				break;
			}
		}
		
		/**Image des Würfel mit einem Kreuz anzeigen, für ToggleButton 1 (1.Würfel)
		 * @param ae
		 */
		@FXML public void setImageOfDice1WithCross(ActionEvent ae){
			
			if ( tb1.isSelected()){
				switch (integerArray[0]){
				case 0: 
					break;
				case 1:
					changeGraphic(tb1, imgDie1WithCross);
					break;
				case 2:
					changeGraphic(tb1, imgDie2WithCross);
					break;
				case 3:
					changeGraphic(tb1, imgDie3WithCross);
					break;
				case 4:
					changeGraphic(tb1, imgDie4WithCross);
					break;
				case 5:
					changeGraphic(tb1, imgDie5WithCross);
					break;
				case 6:
					changeGraphic(tb1, imgDie6WithCross);
					break;
				}
			} else {
				switch (integerArray[0]){
				case 0: 
					break;
				case 1:
					changeGraphic(tb1, imgDie1);
					break;
				case 2:
					changeGraphic(tb1, imgDie2);
					break;
				case 3:
					changeGraphic(tb1, imgDie3);
					break;
				case 4:
					changeGraphic(tb1, imgDie4);
					break;
				case 5:
					changeGraphic(tb1, imgDie5);
					break;
				case 6:
					changeGraphic(tb1, imgDie6);
					break;
				}

			}	
		
		}
		
		/**Image des Würfel mit einem Kreuz anzeigen, für ToggleButton 2 (2.Würfel)
		 * @param ae
		 */
		@FXML public void setImageOfDice2WithCross(ActionEvent ae){
			
			if ( tb2.isSelected()){
				switch (integerArray[1]){
				case 0: 
					break;
				case 1:
					changeGraphic(tb2, imgDie1WithCross);
					break;
				case 2:
					changeGraphic(tb2, imgDie2WithCross);
					break;
				case 3:
					changeGraphic(tb2, imgDie3WithCross);
					break;
				case 4:
					changeGraphic(tb2, imgDie4WithCross);
					break;
				case 5:
					changeGraphic(tb2, imgDie5WithCross);
					break;
				case 6:
					changeGraphic(tb2, imgDie6WithCross);
					break;
				}
			} else {
				switch (integerArray[1]){
				case 0: 
					break;
				case 1:
					changeGraphic(tb2, imgDie1);
					break;
				case 2:
					changeGraphic(tb2, imgDie2);
					break;
				case 3:
					changeGraphic(tb2, imgDie3);
					break;
				case 4:
					changeGraphic(tb2, imgDie4);
					break;
				case 5:
					changeGraphic(tb2, imgDie5);
					break;
				case 6:
					changeGraphic(tb2, imgDie6);
					break;
				}

			}	
		
		}

		/**Image des Würfel mit einem Kreuz anzeigen, für ToggleButton 3 (3.Würfel)
		 * @param ae
		 */
		@FXML public void setImageOfDice3WithCross(ActionEvent ae){
		
		if ( tb3.isSelected()){
			switch (integerArray[2]){
			case 0: 
				break;
			case 1:
				changeGraphic(tb3, imgDie1WithCross);
				break;
			case 2:
				changeGraphic(tb3, imgDie2WithCross);
				break;
			case 3:
				changeGraphic(tb3, imgDie3WithCross);
				break;
			case 4:
				changeGraphic(tb3, imgDie4WithCross);
				break;
			case 5:
				changeGraphic(tb3, imgDie5WithCross);
				break;
			case 6:
				changeGraphic(tb3, imgDie6WithCross);
				break;
			}
		} else {
			switch (integerArray[2]){
			case 0: 
				break;
			case 1:
				changeGraphic(tb3, imgDie1);
				break;
			case 2:
				changeGraphic(tb3, imgDie2);
				break;
			case 3:
				changeGraphic(tb3, imgDie3);
				break;
			case 4:
				changeGraphic(tb3, imgDie4);
				break;
			case 5:
				changeGraphic(tb3, imgDie5);
				break;
			case 6:
				changeGraphic(tb3, imgDie6);
				break;
			}

		}	

	}

		/**Image des Würfel mit einem Kreuz anzeigen, für ToggleButton 4 (4.Würfel bzw. Attack-Würfel)
		 * @param ae
		 */
		@FXML public void setImageOfDiceAttackWithCross(ActionEvent ae){
		
		if ( tb4.isSelected()){
			switch (integerArray[3]){
			case 0: 
				break;
			case 1:
				changeGraphic(tb4, imgDie1WithCross);
				break;
			case 2:
				changeGraphic(tb4, imgDie2WithCross);
				break;
			case 3:
				changeGraphic(tb4, imgDie3WithCross);
				break;
			case 4:
				changeGraphic(tb4, imgDie4WithCross);
				break;
			case 5:
				changeGraphic(tb4, imgDie5WithCross);
				break;
			case 6:
				changeGraphic(tb4, imgDie6WithCross);
				break;
			}
		} else {
			switch (integerArray[3]){
			case 0: 
				break;
			case 1:
				changeGraphic(tb4, imgDie1);
				break;
			case 2:
				changeGraphic(tb4, imgDie2);
				break;
			case 3:
				changeGraphic(tb4, imgDie3);
				break;
			case 4:
				changeGraphic(tb4, imgDie4);
				break;
			case 5:
				changeGraphic(tb4, imgDie5);
				break;
			case 6:
				changeGraphic(tb4, imgDie6);
				break;
			}

		}
	}

		/**Image des Würfel mit einem Kreuz anzeigen, für ToggleButton 5 (5.Würfel bzw. Herz-Würfel)
		 * @param ae
		 */
		@FXML public void setImageOfDiceHealWithCross(ActionEvent ae){
		
		if ( tb5.isSelected()){
			switch (integerArray[4]){
			case 0: 
				break;
			case 1:
				changeGraphic(tb5, imgDie1WithCross);
				break;
			case 2:
				changeGraphic(tb5, imgDie2WithCross);
				break;
			case 3:
				changeGraphic(tb5, imgDie3WithCross);
				break;
			case 4:
				changeGraphic(tb5, imgDie4WithCross);
				break;
			case 5:
				changeGraphic(tb5, imgDie5WithCross);
				break;
			case 6:
				changeGraphic(tb5, imgDie6WithCross);
				break;
			}
		} else {
			switch (integerArray[4]){
			case 0: 
				break;
			case 1:
				changeGraphic(tb5, imgDie1);
				break;
			case 2:
				changeGraphic(tb5, imgDie2);
				break;
			case 3:
				changeGraphic(tb5, imgDie3);
				break;
			case 4:
				changeGraphic(tb5, imgDie4);
				break;
			case 5:
				changeGraphic(tb5, imgDie5);
				break;
			case 6:
				changeGraphic(tb5, imgDie6);
				break;
			}

		}
	}

		/**Image des Würfel mit einem Kreuz anzeigen, für ToggleButton 6 (6.Würfel bzw. Energie-Würfel)
		 * @param ae
		 */
		@FXML public void setImageOfDiceEnergyWithCross(ActionEvent ae){
		
		if ( tb6.isSelected()){
			switch (integerArray[5]){
			case 0: 
				break;
			case 1:
				changeGraphic(tb6, imgDie1WithCross);
				break;
			case 2:
				changeGraphic(tb6, imgDie2WithCross);
				break;
			case 3:
				changeGraphic(tb6, imgDie3WithCross);
				break;
			case 4:
				changeGraphic(tb6, imgDie4WithCross);
				break;
			case 5:
				changeGraphic(tb6, imgDie5WithCross);
				break;
			case 6:
				changeGraphic(tb6, imgDie6WithCross);
				break;
			}
		} else {
			switch (integerArray[5]){
			case 0: 
				break;
			case 1:
				changeGraphic(tb6, imgDie1);
				break;
			case 2:
				changeGraphic(tb6, imgDie2);
				break;
			case 3:
				changeGraphic(tb6, imgDie3);
				break;
			case 4:
				changeGraphic(tb6, imgDie4);
				break;
			case 5:
				changeGraphic(tb6, imgDie5);
				break;
			case 6:
				changeGraphic(tb6, imgDie6);
				break;
			}

		}	

	}

	}




		