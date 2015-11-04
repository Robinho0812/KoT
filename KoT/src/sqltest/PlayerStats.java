package sqltest;

import java.util.List;

public class PlayerStats {

	static int anzSpiele = 0;
	static int anzSiege;
	static int anzNiederlagen;
	static int anzVP;
	static int demageGiven;
	static int demageTaken;
	static int healCounter;
	static int curVP;
	static int curDemageGiven;
	static int curDemageTaken;
	static int curHealCounter;

	public static int getAnzSpiele() {
		if (anzSpiele == 0) {
			myConnection.openDb();

			List<Integer> stats = myConnection.getPlayerStats("Rene");

			PlayerStats.anzSpiele = stats.get(0);
		}
		return anzSpiele;
	}

	public static void setAnzSpiele() {

		myConnection.openDb();

		List<Integer> stats = myConnection.getPlayerStats("Rene");

		PlayerStats.anzSpiele = stats.get(0);
	}

	public static int incAnzSpiele() {

		anzSpiele = anzSpiele + 1;

		return anzSpiele;

	}

	public static int getAnzSiege() {
		return anzSiege;
	}

	public static void setAnzSiege() {

		myConnection.openDb();

		List<Integer> stats = myConnection.getPlayerStats("Rene");

		PlayerStats.anzSiege = stats.get(1);
	}

	public static int incAnzSiege() {

		anzSiege = anzSiege + 1;

		return anzSiege;

	}

	public static int getAnzNiederlagen() {
		return anzNiederlagen;
	}

	public static void setAnzNiederlagen() {

		myConnection.openDb();

		List<Integer> stats = myConnection.getPlayerStats("Rene");

		PlayerStats.anzNiederlagen = stats.get(2);
	}

	public static int incAnzNiederlagen() {

		anzNiederlagen = anzNiederlagen + 1;

		return anzNiederlagen;

	}

	public static int getAnzVP() {
		return anzVP;
	}

	public static void setAnzVP() {

		myConnection.openDb();

		List<Integer> stats = myConnection.getPlayerStats("Rene");

		PlayerStats.anzVP = stats.get(3);
	}

	public static int incAnzVP() {

		anzVP = anzVP + 1;

		curVP = curVP + 1;

		return anzVP & curVP;

	}

	public static int getDemageGiven() {
		return demageGiven;
	}

	public static void setDemageGiven() {

		myConnection.openDb();

		List<Integer> stats = myConnection.getPlayerStats("Rene");

		PlayerStats.demageGiven = stats.get(4);
	}

	public static int incDemageGiven() {

		demageGiven = demageGiven + 1;

		curDemageGiven = curDemageGiven + 1;

		return demageGiven & curDemageGiven;

	}

	public static int getDemageTaken() {
		return demageTaken;
	}

	public static void setDemageTaken() {

		myConnection.openDb();

		List<Integer> stats = myConnection.getPlayerStats("Rene");

		PlayerStats.demageTaken = stats.get(5);
	}

	public static int incDemageTaken() {

		demageTaken = demageTaken + 1;

		curDemageTaken = curDemageTaken + 1;

		return demageTaken & curDemageTaken;

	}

	public static int getHealCounter() {
		return PlayerStats.healCounter;
	}

	public static void setHealCounter() {

		myConnection.openDb();

		List<Integer> stats = myConnection.getPlayerStats("Rene");

		PlayerStats.healCounter = stats.get(6);
	}

	public static int incHealCounter() {

		healCounter = healCounter + 1;

		return healCounter;
	}

	public static int getCurVP() {
		return curVP;
	}

	public static int getCurDemageGiven() {
		return curDemageGiven;
	}

	public static int getCurDemageTaken() {
		return curDemageTaken;
	}

	public static int getCurHealCounter() {
		return curHealCounter;
	}

	public static void setCurVP() {

		PlayerStats.curVP = 0;
	}

	public static void setCurDemageGiven() {

		PlayerStats.curDemageGiven = 0;

	}

	public static void setCurDemageTaken() {

		PlayerStats.curDemageTaken = 0;
	}

	public static void setCurHealCounter() {

		PlayerStats.curHealCounter = 0;
	}

}
