package application;

import java.util.ArrayList;

import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Dice class
 * 
 * @author Robin Schmid
 *
 */
public class Dice extends ToggleButton {

	// Instanzvariablen
	private final int MAXVALUE = 6;
	private int faceValue;

	/**
	 * Constructor for Dice
	 * 
	 * @author Robin Schmid
	 */
	public Dice() {
		faceValue = 1;
		this.roll(1);
		this.showToggleButton();
		;

	}

	/**
	 * Method to randomly set the value of the dice. {value 4 equals attack,
	 * value 5 equals heal, value 6 equals energy}
	 * 
	 * @return the dice value
	 * 
	 * @author Robin Schmid
	 */
	public int roll(int counterOfRolls) {

		if (counterOfRolls == 1) {
			faceValue = (int) (Math.random() * MAXVALUE) + 1;
		}

		else if (counterOfRolls > 1 && counterOfRolls < 4 && this.isSelected()) {
			faceValue = (int) (Math.random() * MAXVALUE) + 1;

		}

		return this.faceValue;

	}

	
	/**
	 * Method to show the image relating to the dicevalue
	 */
	public void showToggleButton() {

		Image[] images = new Image[MAXVALUE];
		ImageView[] imageViews = new ImageView[MAXVALUE];

		for (int i = 0; i < MAXVALUE; i++) {
			images[i] = new Image("images/Würfel" + (i + 1) + ".png");

			imageViews[i] = new ImageView(images[i]);

		}

		this.setGraphic(imageViews[this.faceValue - 1]);

	}

	/**
	 * Method to show an image with a cross if dice is selected
	 * 
	 * @author Robin Schmid
	 */
	public void changeImageIfSelected() {

		Image[] imagesOfSelectedDices = new Image[MAXVALUE];
		ImageView[] imageViews2 = new ImageView[MAXVALUE];

		for (int i = 0; i < MAXVALUE; i++) {
			imagesOfSelectedDices[i] = new Image("images/Würfel" + (i + 1)
					+ "_redx2.png");

			imageViews2[i] = new ImageView(imagesOfSelectedDices[i]);
		}
		this.setGraphic(imageViews2[this.faceValue - 1]);
	}

	// };

	/**
	 * Gets value of the dice
	 * 
	 * @return value of dice
	 * 
	 * @author Robin Schmid
	 */
	public int getFaceValue() {
		return faceValue;
	}

}
