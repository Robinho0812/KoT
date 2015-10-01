package application;

public class W�rfel {

	//Instanzvariablen
	private final int MAX = 6;
	private int faceValue;
	
	//Konstruktor
	public W�rfel(){
		faceValue = -1;
	}
	
	//Methode, um den W�rfel zu rollen und das Ergebnis zur�ckzugeben
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

