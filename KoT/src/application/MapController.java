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
		private int countAnzahlW�rfe = 0;
		
		//W�rfel-Objekte erzeugen
		W�rfel w1 = new W�rfel();
		W�rfel w2 = new W�rfel();
		W�rfel w3 = new W�rfel();
		W�rfel w4 = new W�rfel();
		W�rfel w5 = new W�rfel();
		W�rfel w6 = new W�rfel();
		
		//W�rfel Array erzeugen, W�rfel-Objekte hinzuf�gen
		W�rfel[] w�rfelArray = {w1,w2,w3,w4,w5,w6};
		
		//Integer Array erzeugen
		Integer[] integerArray = new Integer[w�rfelArray.length];
		
		//Images erzeugen
		Image imgDie1 = new Image("images/W�rfel1.png");
		Image imgDie2 = new Image("images/W�rfel2.png");
		Image imgDie3 = new Image("images/W�rfel3.png");
		Image imgDie4 = new Image("images/W�rfelAngriff.png");
		Image imgDie5 = new Image("images/W�rfelHerz.png");
		Image imgDie6 = new Image("images/W�rfelBlitz.png");
		Image imgDie1WithCross = new Image("images/W�rfel1_redx2.png");
		Image imgDie2WithCross = new Image("images/W�rfel2_redx2.png");
		Image imgDie3WithCross = new Image("images/W�rfel3_redx2.png");
		Image imgDie4WithCross = new Image("images/W�rfelAngriff_redx2.png");
		Image imgDie5WithCross = new Image("images/W�rfelHerz_redx2.png");
		Image imgDie6WithCross = new Image("images/W�rfelBlitz_redx2.png");
		

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
		
		/** Methode, um alle sechs W�rfel gleichzeitig zu W�rfel und
		 * weitere Methoden auszuf�hren
		 * @param ae
		 * @throws IOException
		 */
		@FXML public void roll (ActionEvent ae) throws IOException {
			
			rerollButton.setDisable(false);
			
			this.countAnzahlW�rfe++;
			tb1.setDisable(false);
			tb2.setDisable(false);
			tb3.setDisable(false);
			tb4.setDisable(false);
			tb5.setDisable(false);
			tb6.setDisable(false);
			
			for (int i = 0; i < w�rfelArray.length; i++){
				w�rfelArray[i].roll();
			}
			
					
			copyToIntArray(w�rfelArray);
			setImageOfDice(integerArray[0], integerArray[1], integerArray[2], integerArray[3], integerArray[4], integerArray[5]);
			
			
			
			for (int i = 0; i < integerArray.length; i++){
				
			}
			
			
			DiceButton.setDisable(true);
			//An dieser Stelle Benutzer fragen, ob er nochmals w�rfeln will
			//Wenn nein, rerollButton disablen!
		}
		
		/** Methode, um alle sechs W�rfel ein zweites und ein drittes Mal zu w�rfeln
		 * @param ae
		 * @throws IOException
		 */
		@FXML public void reroll (ActionEvent ae) throws IOException {
			this.countAnzahlW�rfe++;
			
			if (countAnzahlW�rfe<=2){
				for (int i = 0; i < w�rfelArray.length; i++){
					if (this.tb1.isSelected()){
						w�rfelArray[0].roll();
					} 
					if (this.tb2.isSelected()){
						w�rfelArray[1].roll();
					}
					if (this.tb3.isSelected()){
						w�rfelArray[2].roll();
					}
					if (this.tb4.isSelected()){
						w�rfelArray[3].roll();
					}
					if (this.tb5.isSelected()){
						w�rfelArray[4].roll();
					}
					if (this.tb6.isSelected()){
						w�rfelArray[5].roll();
					}
				}
				
				
				copyToIntArray(w�rfelArray);
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
				for (int i = 0; i < w�rfelArray.length; i++){
					if (this.tb1.isSelected()){
						w�rfelArray[0].roll();
					}
					if (this.tb2.isSelected()){
						w�rfelArray[1].roll();
					}
					if (this.tb3.isSelected()){
						w�rfelArray[2].roll();
					}
					if (this.tb4.isSelected()){
						w�rfelArray[3].roll();
					}
					if (this.tb5.isSelected()){
						w�rfelArray[4].roll();
					}
					if (this.tb6.isSelected()){
						w�rfelArray[5].roll();
					}
				}
				
				
				copyToIntArray(w�rfelArray);
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
		
		/**Methode, die die Werte der W�rfel-Objekte in
		 * ein neues Integer-Array kopieren. 
		 * @param array
		 * @return integerArray
		 */
		public Integer[] copyToIntArray (W�rfel[] array){
			for(int i = 0; i < array.length; i++){
				this.integerArray[i] = array[i].getFaceValue();
			}
			return integerArray;		
		}
		
		/**Methode, die das entsprechende W�rfel-Bild
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
		
		/**Methode, die entscheidet, in welchen F�llen
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
		
		/**Image des W�rfel mit einem Kreuz anzeigen, f�r ToggleButton 1 (1.W�rfel)
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
		
		/**Image des W�rfel mit einem Kreuz anzeigen, f�r ToggleButton 2 (2.W�rfel)
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

		/**Image des W�rfel mit einem Kreuz anzeigen, f�r ToggleButton 3 (3.W�rfel)
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

		/**Image des W�rfel mit einem Kreuz anzeigen, f�r ToggleButton 4 (4.W�rfel bzw. Attack-W�rfel)
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

		/**Image des W�rfel mit einem Kreuz anzeigen, f�r ToggleButton 5 (5.W�rfel bzw. Herz-W�rfel)
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

		/**Image des W�rfel mit einem Kreuz anzeigen, f�r ToggleButton 6 (6.W�rfel bzw. Energie-W�rfel)
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




		