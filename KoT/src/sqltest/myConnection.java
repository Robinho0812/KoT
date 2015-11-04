package sqltest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import com.mysql.jdbc.ResultSet;

import sun.misc.BASE64Decoder;

public class myConnection {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	// Konstante DB_URL
	static final String DB_URL = "jdbc:mysql://sql4.freemysqlhosting.net:3306/sql495338";

	// Konstanter User Name
	static String USER = "sql495338";

	// Konstantes Passwort
	static String PASS = "Sl8tI1Zqn8Nrzi/AwPznXQ==";

	// Die DB-Connection
	public static Connection conn = null;

	public static PreparedStatement preparedStmt;
	
	

	// Verbindung herstellen
	public static void openDb() {
		try {
			// JDBC laden und registrieren
			System.out.println("Loading driver...");

			try {
				Class.forName(JDBC_DRIVER);
				System.out.println("Driver loaded!");
			} catch (ClassNotFoundException e) {
				throw new IllegalStateException(
						"Cannot find the driver in the classpath!", e);
			}

			// Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, getDBPW());
			System.out.println("Connected!");
		} catch (SQLException se2) {
			se2.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
	}

	public static boolean isAvailable(String playerName) {
		ResultSet rs = null;
		try {
			PreparedStatement preStatement = conn
					.prepareStatement("SELECT COUNT(*) AS total FROM spieler WHERE Nickname = '"
							+ playerName + "';");
			rs = (ResultSet) preStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int i = 1;
		try {
			rs.next();
			i = rs.getInt("total");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (i != 0) {
			System.out.println("Name wird bereits verwendet");
			return false;
		}

		if (i == 0)
			return true;

		System.out.println("Playername check failed");
		return false;

	}

	public static boolean isValidLogin(String playerName, String pWd) {
		if (isAvailable(playerName)) {
			System.out.println("Invalid Username");
			return false;
		}
		java.sql.ResultSet rs = null;
		String password = null;
		try {
			preparedStmt = conn
					.prepareStatement("SELECT nickname, passwort FROM spieler WHERE nickname = ?;");
			
			preparedStmt.setString(1, playerName);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				password = rs.getString("Passwort");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		if (password.equals(pWd)) {
			System.out.println("Server: Login valid");
			return true;
		} else {
			System.out.println("Server: Password invalid");
			return false;
		}

	}

	// Passwort-Überprüfung, hash mit hash vergleichen
	public static String hashPasswort(String passwort) {

		MessageDigest md = null;

		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(passwort.getBytes());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		byte byteData[] = md.digest();

		// Konvertiert das byteArray in den Hash-String
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
					.substring(1));
		}

		String hexFormat = sb.toString();

		return hexFormat;
	}

	// Source:
	// http://stackoverflow.com/questions/5220761/fast-and-simple-string-encrypt-decrypt-in-java
	private static String getDBPW() {
		SecretKey key;
		String pwd = null;
		try {
			SecretKeyFactory keyFactory;
			keyFactory = SecretKeyFactory.getInstance("DES");
			DESKeySpec keySpec = new DESKeySpec("DBConn Oida".getBytes("UTF8"));
			key = keyFactory.generateSecret(keySpec);
			sun.misc.BASE64Decoder base64decoder = new BASE64Decoder();

			byte[] encrypedPwdBytes = base64decoder.decodeBuffer(PASS);

			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] plainTextPwdBytes = (cipher.doFinal(encrypedPwdBytes));
			pwd = new String(plainTextPwdBytes);
		} catch (UnsupportedEncodingException e) {
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pwd;

	}

	private void validateEmailAddress(String newValue) {
		boolean valid = false;

		if (newValue.charAt(newValue.length() - 1) != '@') {
			String[] addressParts = newValue.split("@");
			if (addressParts.length == 2 && !addressParts[0].isEmpty()) {
				String[] domainParts = addressParts[1].split("\\.");
				if (domainParts.length >= 2) {
					valid = true;
					for (String s : domainParts) {
						if (s.length() < 2) {
							valid = false;
							break;
						}
					}
				}
			}
		}

	}

	public static void insertPlayer(String name, String pass, String mail) {

		String query = "INSERT INTO spieler (nickname, passwort, emailadresse)"
				+ " VALUES (?, SHA2(?,?), ?)";

		// create the mysql insert preparedstatement
		try {
			preparedStmt = conn.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			preparedStmt.setString(1, name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			preparedStmt.setString(2, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final String SHA_BITS = "256";
		try {
			preparedStmt.setString(3, SHA_BITS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			preparedStmt.setString(4, mail);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// execute the preparedstatement
		try {
			preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			preparedStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void insertStats(String name) {
		
		String query = "INSERT INTO spielerstatistik (nickname)"
				+ " VALUES (?)";
		
		try {
			preparedStmt = conn.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			preparedStmt.setString(1, name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// execute the preparedstatement
				try {
					preparedStmt.execute();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					preparedStmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}

	public static List<Integer> getPlayerStats(String Nickname) {

		java.sql.ResultSet rs = null;
		List<Integer> playerStats = new ArrayList<Integer>();
		int anzSpiele;
		int anzSiege;
		int anzNiederlagen;
		int anzVP;
		int demageGiven;
		int demageTaken;
		int healCounter;

		String query = "SELECT * FROM spielerstatistik WHERE Nickname = ? ";

		try {
			preparedStmt = conn.prepareStatement(query);

			try {
				preparedStmt.setString(1, Nickname);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				playerStats.add(anzSpiele = rs.getInt("AnzahlSpiele"));
				playerStats.add(anzSiege = rs.getInt("AnzahlSiege"));
				playerStats
						.add(anzNiederlagen = rs.getInt("AnzahlNiederlagen"));
				playerStats.add(anzVP = rs.getInt("VictoryPointsErhalten"));
				playerStats.add(demageGiven = rs.getInt("DemageGiven"));
				playerStats.add(demageTaken = rs.getInt("DemageTaken"));
				playerStats.add(healCounter = rs.getInt("HealCounter"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return playerStats;
	}

	public static void setPlayerStats(String Nickname) {

		String query1 = "UPDATE spielerstatistik SET AnzahlSpiele = ?, AnzahlSiege = ?, AnzahlNiederlagen = ? WHERE Nickname = ? ;";

		String query = "UPDATE Spielerstatistik SET AnzahlSpiele = ? ,"
				+ "AnzahlSiege = ? ," + "AnzahlNiederlagen = ? ,"
				+ "VictoryPointsErhalten = ? ," + "DemageGiven = ? ,"
				+ "DemageTaken = ? ," + "HealCounter = ? WHERE Nickname = ? ;";

		int anzSpiele = PlayerStats.getAnzSpiele();
		int anzSiege = PlayerStats.getAnzSiege();
		int anzNiederlagen = PlayerStats.getAnzNiederlagen();
		int anzVP = PlayerStats.getAnzVP();
		int demageGiven = PlayerStats.getDemageGiven();
		int demageTaken = PlayerStats.getDemageTaken();
		int healCounter = PlayerStats.getHealCounter();

		try {
			preparedStmt = conn.prepareStatement(query);

			try {
				preparedStmt.setInt(1, anzSpiele);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				preparedStmt.setInt(2, anzSiege);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				preparedStmt.setInt(3, anzNiederlagen);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				preparedStmt.setInt(4, anzVP);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				preparedStmt.setInt(5, demageGiven);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				preparedStmt.setInt(6, demageTaken);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				preparedStmt.setInt(7, healCounter);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				preparedStmt.setString(8, Nickname);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// execute the preparedstatement
		try {
			preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			preparedStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		openDb();

	}

}
