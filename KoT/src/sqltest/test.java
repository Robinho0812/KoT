package sqltest;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.*;
import java.util.prefs.Preferences;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class test {
	
	 

	public static void main(String[] args) throws SQLException, InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException  {
		// TODO Auto-generated method stub
		
//		myConnection.openDb();
		
		
//		System.out.println("Loading driver...");
//
//		try {
//		    Class.forName("com.mysql.jdbc.Driver");
//		    System.out.println("Driver loaded!");
//		} catch (ClassNotFoundException e) {
//		    throw new IllegalStateException("Cannot find the driver in the classpath!", e);
//		}
//		
//		    
//		
//		
//		
//		String url = "jdbc:mysql://localhost:3306/brojektdb";
//		String username = connectionHandler.getUsername();
//		String password = connectionHandler.getPassword();
//
//		System.out.println("Connecting database...");
//
//		try (Connection connection = (Connection) DriverManager.getConnection(url, username, password)) {
//		    System.out.println("Database connected!");
//		} catch (SQLException e) {
//		    throw new IllegalStateException("Cannot connect the database!", e);
//		}
//		
//		Connection connection = (Connection) DriverManager.getConnection(url, username, password);
//
//		
//	
//		
//		String query = " INSERT INTO Spieler (nickname, passwort, emailadresse)"
//		        + " VALUES (?, SHA2(?,?), ?)";
//		 
//		      // create the mysql insert preparedstatement
//		      PreparedStatement preparedStmt = connection.prepareStatement(query);
//		      String nickname = "Michel";
//		      preparedStmt.setString (1, nickname);
//		      String passwort = "rootpw";
//		      preparedStmt.setString(2, passwort);
//		      final String SHA_BITS = "256";
//		      preparedStmt.setString(3, SHA_BITS);
//		      String mail = "abc";
//		      preparedStmt.setString(4, mail);
//
//		 
//		      // execute the preparedstatement
//		      preparedStmt.execute();
//		      preparedStmt.close();

//		String query = " DELETE ? FROM Spieler WHERE SpielerID = ?";
//		PreparedStatement preparedStmt = connection.prepareStatement(query);
//		preparedStmt.setString (1, "vorname");
//		preparedStmt.setString (2, "1");
//		preparedStmt.execute();
		
//		String query = "SELECT ? FROM Spieler WHERE ? = ?";
//		 
//		      // create the mysql insert preparedstatement
//		      PreparedStatement preparedStmt = connection.prepareStatement(query);
//		      preparedStmt.setString (1, "Passwort");
//		      preparedStmt.setString (2, "SpielerID");
//		      preparedStmt.setString(3, "30");
//
//		 
//		      // execute the preparedstatement
//		      preparedStmt.execute();
//		      preparedStmt.close();
//		      
//		      ResultSet rs = preparedStmt.executeQuery(query);
//		      
//		      String userHashPW = rs.toString();
//		      
//		      System.out.println(userHashPW);
		
//		PreparedStatement preparedStatement = null;
//
//		String selectSQL = "SELECT Passwort FROM Spieler WHERE SpielerID = ?";
//
//		
//			
//			preparedStatement = connection.prepareStatement(selectSQL);
//			preparedStatement.setInt(1, 30);
//
//			// execute select SQL stetement
//			ResultSet rs = preparedStatement.executeQuery();
//
//			while (rs.next()) {
//
//				String db_pass = rs.getString("Passwort");
//
//				System.out.println("Passwort in DB : " + db_pass);
//				
//			}
//		
//		
//		
//		
//		
//		
//		 String passworda = "mypasswort1";
//		 
//	        MessageDigest md = MessageDigest.getInstance("SHA-256");
//	        md.update(passworda.getBytes());
//	 
//	        byte byteData[] = md.digest();
//	 
//	        //convert the byte to hex format method 1
//	        StringBuffer sb = new StringBuffer();
//	        for (int i = 0; i < byteData.length; i++) {
//	         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
//	        }
//	        
//	        
//	        
//	        String hexFormat = sb.toString();
//	        
//	       
//	      
//	 
//	        System.out.println("Gehashtes pw: " + hexFormat);
		
			
//	        
//	        PlayerStats.setAnzVP();
//		
//	        System.out.println(PlayerStats.getAnzVP());
//		
//			PlayerStats.incAnzVP();
//			
//			PlayerStats.incAnzVP();
//			
//			System.out.println(PlayerStats.getAnzVP());
//			
//			System.out.println(PlayerStats.getCurVP());
			
//			System.out.println(PlayerStats.getAnzNiederlagen());
//			
//			System.out.println(PlayerStats.getDemageGiven());
//			
//			System.out.println(PlayerStats.getHealCounter());
		
		String plainTextPassword = "hT4!vR9%";
		
		// only the first 8 Bytes of the constructor argument are used 
		// as material for generating the keySpec
		DESKeySpec keySpec = new DESKeySpec("DBConn Oida".getBytes("UTF8")); 
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey key = keyFactory.generateSecret(keySpec);
		sun.misc.BASE64Encoder base64encoder = new BASE64Encoder();
		sun.misc.BASE64Decoder base64decoder = new BASE64Decoder();
		

		// ENCODE plainTextPassword String
		byte[] cleartext = plainTextPassword.getBytes("UTF8");      

		Cipher cipher = Cipher.getInstance("DES"); // cipher is not thread safe
		cipher.init(Cipher.ENCRYPT_MODE, key);
		String encrypedPwd = base64encoder.encode(cipher.doFinal(cleartext));
		// now you can store it 
		
		System.out.println(encrypedPwd);
		

//		// DECODE encryptedPwd String
//		byte[] encrypedPwdBytes = base64decoder.decodeBuffer(encrypedPwd);
//
//		Cipher cipher = Cipher.getInstance("DES");// cipher is not thread safe
//		cipher.init(Cipher.DECRYPT_MODE, key);
//		byte[] plainTextPwdBytes = (cipher.doFinal(encrypedPwdBytes));
		
		Properties prop = new Properties();
		OutputStream output = null;
		
		String name = "Hallo";

		try {

			output = new FileOutputStream("db.properties");

			// set the properties value
			prop.setProperty("database", name);
			prop.setProperty("dbuser", "mkyong");
			prop.setProperty("dbpassword", "password");

			// save properties to project root folder
			prop.store(output, null);
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
		

	
	}

}
		
			InputStream input = null;
	
			try {

				input = new FileInputStream("config.properties");

				// load a properties file
				prop.load(input);

				// get the property value and print it out
				System.out.println(prop.getProperty("dbuser"));
				System.out.println(prop.getProperty("dbpassword"));

			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				if (input != null) {
					try {
						input.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}