package application;

public class Würfel {

	//Instanzvariablen
	private final int MAX = 6;
	private int faceValue;
	
	//Konstruktor
	public Würfel(){
		faceValue = -1;
	}
	
	//Methode, um den Würfel zu rollen und das Ergebnis zurückzugeben
	public int roll(){
		faceValue = (int)(Math.random() * MAX) + 1;
		return faceValue;
	}
	
	//Getter
	public int getFaceValue(){
		return faceValue;
	}
	
	//Setter
	public void setFaceValue(int value){
		faceValue = value;
	}
	
	//toString
	public String toString(){
		String result = Integer.toString(faceValue);
		return result;
	}
}

