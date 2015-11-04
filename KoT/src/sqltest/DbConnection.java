package sqltest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.*;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import sun.misc.BASE64Decoder;


// TODO: Auto-generated Javadoc
/**
 * The Class DbConnection.
 */
public abstract class DbConnection {
	// JDBC driver name and database URL
	/** The Constant JDBC_DRIVER. */
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	/** The Constant DB_URL. */
	static final String DB_URL = "jdbc:mysql://db4free.net:3306/stickmantd";

	// Database credentials
	/** The Constant USER. */
	static final String USER = "stickadmin";

	/** The Constant PASS. */
	static final String PASS = "jdsAFGS7YSu/Vxt3nDkD0g==";

	/** The conn. */
	public static Connection conn = null;


	/**
	 * Connects to the Database.
	 */
	public static void openDb() {
		try {
			// Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			// Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, getPWd());
			System.out.println("Connected");
		} catch (SQLException se2) {
			se2.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
	}

	/**
	 * Close the database connection.
	 */
	public static void closeDb() {
		try {
			conn.close();
			System.out.println("Disconnected");
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();

		} finally {
			// close resources
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try
		System.out.println("Goodbye!");
	}

	/**
	 * Get a Rsult set from a query.
	 *
	 * @param query            the query
	 * @return Resultset from query
	 */
	public static java.sql.ResultSet getRs(String query) {
		java.sql.ResultSet rs = null;

		try {
			PreparedStatement preStatement = conn.prepareStatement(query);
			rs = preStatement.executeQuery();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		if (rs != null) {
			return rs;
		} else
			return null;

	}

	/**
	 * Execute update.
	 *
	 * @param query
	 *            update query
	 */
	public static void executeUpdate(String query) {
		try {
			PreparedStatement preStatement = conn.prepareStatement(query);
			preStatement.execute();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	/**
	 * Checks if a Playername is available.
	 *
	 * @param playerName
	 *            the player name
	 * @return true, if is available
	 */
	public static boolean isAvailable(String playerName) {
		java.sql.ResultSet rs = null;
		try {
			PreparedStatement preStatement = conn
					.prepareStatement("Select COUNT(*) AS total from Player where playername = '"
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
			
			return false;
		}
		if (i == 0)
			return true;
		
		
		return false;

	}

	/**
	 * Checks if is valid login.
	 *
	 * @param playerName
	 *            the player name
	 * @param pWd
	 *            the Password
	 * @return true, if is valid login
	 */
	public static boolean isValidLogin(String playerName, String pWd) {
		if (isAvailable(playerName)) {
			System.out.println("Invalid Username");
			return false;
		}
		java.sql.ResultSet rs = null;
		String password = null;
		try {
			PreparedStatement preStatement = conn
					.prepareStatement("Select playername, password from Player where playername = '"
							+ playerName + "';");
			rs = preStatement.executeQuery();
			while (rs.next()) {
				password = rs.getString("Password");
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

	/**
	 * Truncate player table.
	 */
	public static void TruncatePlayer() {

		try {
			PreparedStatement preStatement = conn
					.prepareStatement("Truncate Table Player;");
			preStatement.execute();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		System.out.println("Cleared Player Table");

	}

	/**
	 * Decodes the PAssword
	 *Source: http://stackoverflow.com/questions/5220761/fast-and-simple-string-encrypt-decrypt-in-java
	 * @return the p wd
	 */
	private static String getPWd() {
		SecretKey key;
		String pwd=null;
		try {
			SecretKeyFactory keyFactory;
			keyFactory = SecretKeyFactory.getInstance("DES");
			DESKeySpec keySpec = new DESKeySpec(
					"This is our Towerdefense".getBytes("UTF8"));
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
}