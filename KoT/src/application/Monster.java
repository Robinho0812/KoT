package application;

import javafx.scene.image.Image;

public class Monster {
	
	/**
	 * 
	 * @author Michel Konrad
	 *
	 */
	
	private final int INITIALHP=10, INITIALVP=0, INITIALENERGY=0;
	private int currentHealthPoints, currentVictoryPoints, currentEnergy;
	private Image image;
	
	//Constructor
	public Monster(){
	this.currentHealthPoints=INITIALHP;
	this.currentVictoryPoints = INITIALVP;
	this.currentEnergy=INITIALENERGY;
	}

	// Damage affects HP directly --> no setter for currentHealthPoints
	public void setDamage(int damage){
		currentHealthPoints = currentHealthPoints - damage; 
	}
	
	// Add Heal to currentHealthPoints
	public void setHeal(int heal){
		currentHealthPoints = currentHealthPoints + heal;
	}
	
	// Add Victory points to currentVictoryPoints
	public void setVictoryPoints(int victorypoints){
		currentVictoryPoints = currentVictoryPoints + victorypoints;
	}
	
	public int getVictoryPoints(){
		return currentVictoryPoints;
	}
	
	public void clearVictoryPoints(){
		currentVictoryPoints = 0;
	}
	
	// Add Energy to current amount of Energy
	public void setEnergy (int energy){
		currentEnergy = currentEnergy + energy;
		
	}
	

	public int getCurrentHealthPoints() {
		return currentHealthPoints;
	}

	
	public int getCurrentVictoryPoints() {
		return currentVictoryPoints;
	}
	
	public int getCurrentEnergy(){
		return currentEnergy;
	}

	public String toString(){
		return "Player HP: "+ currentHealthPoints + "\nPlayer VP: " + currentVictoryPoints + "\nPlayer Energy: " + currentEnergy ;

	}
	

}
