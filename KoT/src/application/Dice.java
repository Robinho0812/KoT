package application;

import java.util.ArrayList;

import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Dice Klasse
 * @author Robin Schmid
 *
 */
public class Dice extends ToggleButton{

	//Instanzvariablen
	private final int MAXVALUE = 6;
	private int faceValue;
	
	
	/**
	 * Konstruktor für Dice-Objekte
	 * 
	 * @author Robin Schmid
	 */
	public Dice(){
		faceValue = 1;
		this.roll(1);
		this.showToggleButton();
		;
		
	}
	
	/**
	 * Methode um dem Würfel eine zufällige Zahl zwischen 1 und 6 zuzuweisen. {4= Angriff, 5= Heilung, 6 = Energie}
	 * 
	 * @return Der gewürfelte Wert
	 * 
	 * @author Robin Schmid
	 */
	public int roll(int counterOfRolls){
		
		if(counterOfRolls == 1){
			faceValue = (int)(Math.random() * MAXVALUE) + 1;
		}
		
		else if(counterOfRolls>1 && counterOfRolls< 4 && this.isSelected()){
			faceValue = (int)(Math.random() * MAXVALUE) + 1;
				
		} 
		
		
		return this.faceValue;
		
		
		
	}
	
	
	/**Methode, die das entsprechende Dice-Bild
	 * auf den entsprechenden Toggle-Button setzt.
	 * 
	 * @param Ein ToggleButton, der den Würfelwert grafisch wiederspiegelt
	 * 
	 * @author Robin Schmid
	 */
	public void showToggleButton(){
		
			
			Image[] images = new Image[MAXVALUE];
			ImageView[] imageViews = new ImageView[MAXVALUE];
			
			for(int i= 0; i<MAXVALUE; i++){
			images[i] = new Image ("images/Würfel"+(i+1)+".png");
			
			
			imageViews[i] = new ImageView(images[i]);
			
			
			
			}
			
			this.setGraphic(imageViews[this.faceValue-1]);
			
			}
	
	/**
	 * Methode, die das Anzeigebild des Wüfels ändert, sobald er angeklickt wird.
	 * 
	 * @author Robin Schmid
	 */
	public void changeImageIfSelected(){
		
		Image[] imagesOfSelectedDices = new Image[MAXVALUE];
		ImageView[] imageViews2 = new ImageView[MAXVALUE];
		
		for(int i= 0; i<MAXVALUE; i++){
			imagesOfSelectedDices[i] = new Image ("images/Würfel"+(i+1)+"_redx2.png");
			
			imageViews2[i] = new ImageView(imagesOfSelectedDices[i]);
		}
		this.setGraphic(imageViews2[this.faceValue-1]);
	}
			
		
		
		
				
		//};
	
	
	/**
	 * Methode, die den aktuellen Würfelwert zurückgibt.
	 * @return aktueller Würfelwert
	 * 
	 * @author Robin Schmid
	 */
	public int getFaceValue(){
		return faceValue;
	}
		
	
}
