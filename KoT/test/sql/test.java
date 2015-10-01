package sql;

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

public class test {
	
	 

	public static void main(String[] args) throws SQLException  {
		// TODO Auto-generated method stub
		
//		myConnection.openDb();
		
		
		System.out.println("Loading driver...");

		try {
		    Class.forName("com.mysql.jdbc.Driver");
		    System.out.println("Driver loaded!");
		} catch (ClassNotFoundException e) {
		    throw new IllegalStateException("Cannot find the driver in the classpath!", e);
		}
		
		    
		
		
		
		String url = "jdbc:mysql://localhost:3306/brojektdb";
		String username = connectionHandler.getUsername();
		String password = connectionHandler.getPassword();

		System.out.println("Connecting database...");

		try (Connection connection = (Connection) DriverManager.getConnection(url, username, password)) {
		    System.out.println("Database connected!");
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
		
		Connection connection = (Connection) DriverManager.getConnection(url, username, password);

		
	
		
		String query = " INSERT INTO Spieler (vorname, nickname, passwort)"
		        + " VALUES (?, ?, SHA2(?,?))";
		 
		      // create the mysql insert preparedstatement
		      PreparedStatement preparedStmt = connection.prepareStatement(query);
		      String vorname = "Rene";
		      preparedStmt.setString (1, vorname);
		      String nickname = "Sterniii";
		      preparedStmt.setString (2, nickname);
		      String passwort = "test";
		      preparedStmt.setString(3, passwort);
		      final String SHA_BITS = "256";
		      preparedStmt.setString(4, SHA_BITS);

		 
		      // execute the preparedstatement
		      preparedStmt.execute();
		      preparedStmt.close();

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
	        	        
	        
		

	
	}

}
