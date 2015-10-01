package sql;

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

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import sun.misc.BASE64Decoder;




public class myConnection {
		  
		  
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
	
	// Konstante DB_URL
	static final String DB_URL = "jdbc:mysql://localhost:3306/brojektdb";

	// Konstanter User Name
	static final String USER = "root";

	// Konstantes Passwort
	static final String PASS = "wsh2xWjE+Ns=";

	// Die DB-Connection
	public static Connection conn = null;
	
	
	// Verbindung herstellen
	public static void openDb() {
		try {
			// JDBC laden und registrieren
			System.out.println("Loading driver...");

			try {
			    Class.forName(JDBC_DRIVER);
			    System.out.println("Driver loaded!");
			} catch (ClassNotFoundException e) {
			    throw new IllegalStateException("Cannot find the driver in the classpath!", e);
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
		java.sql.ResultSet rs = null;
		try {
			PreparedStatement preStatement = conn
					.prepareStatement("Select COUNT(*) AS total from Spieler where nickname = '"
							+ playerName + "';");
			rs = preStatement.executeQuery();
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
			System.out.println("Server: name in use");
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
			PreparedStatement preStatement = conn
					.prepareStatement("SELECT nickname, passwort FROM spieler WHERE nickname = '"
							+ playerName + "';");
			rs = preStatement.executeQuery();
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
		
		 String passworda = "asdg";
		 
		 MessageDigest md = null;
		 
			try {
				md = MessageDigest.getInstance("SHA-256");
				md.update(passworda.getBytes());
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 
	        byte byteData[] = md.digest();
	 
	        // Konvertiert das byteArray in den Hash-String 
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        
	        
	        
	        String hexFormat = sb.toString();
		
		return hexFormat;
	}
	
	// Source: http://stackoverflow.com/questions/5220761/fast-and-simple-string-encrypt-decrypt-in-java
	private static String getDBPW() {
		SecretKey key;
		String pwd=null;
		try {
			SecretKeyFactory keyFactory;
			keyFactory = SecretKeyFactory.getInstance("DES");
			DESKeySpec keySpec = new DESKeySpec(
					"DBConn Oida".getBytes("UTF8"));
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
        
        if (newValue.charAt(newValue.length()-1) != '@') {
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
	
	public static void main(String[] args) {
		
		openDb();
		
		isValidLogin("dsf", hashPasswort("rootpw"));
		
		
	}
	


}
