package sql;

public class Player {
	
	/**Instanzvariablen 
	 */
	
	private int spielerID;
	private String nickname;
	private int hp;
	private int rp;
	
	
	
	
	
	/**Konstruktor
	 */
	public Player(int pID, String n, int hp, int rp){
		this.spielerID = pID;
		this.nickname = n;
		this.hp = hp;
		this.rp = rp;
	}
	public Player(int pID, String n){
		this.spielerID = pID;
		this.nickname = n;
	}
	
	/**To-String Methode
	 */
	public String toString(){
		return "Player ID: "+this.spielerID+"\nName: "+this.nickname+"\nLeben: "+this.hp+"\nRuhmespunkte: "+this.rp;
	}

	/**Getter und Setter
	 */
	public int getPlayerID() {
		return spielerID;
	}

	public void setPlayerID(int playerID) {
		this.spielerID = playerID;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getRp() {
		return rp;
	}

	public void setRp(int rp) {
		this.rp = rp;
	}

	public String getName() {
		return nickname;
	}

	public void setName(String name) {
		this.nickname = name;
	}

}