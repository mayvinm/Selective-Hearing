/*
 * Written by Ryan on 4/10/19
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DatabaseConnection {
	private Connection dbConnection;
	private int maxID;
	/*
	 * This constructor has a default localhost URL to a database named "loginDB". Change that to fit your database. 
	 */
	public DatabaseConnection() {		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			dbConnection = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/loginDB?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=America/New_York", "root", "");
			System.out.println("Database connection successful!");
		
			String maxIDQuery = "select max(id) from login";
			Statement stmt = dbConnection.createStatement();
			ResultSet maxID = stmt.executeQuery(maxIDQuery);
			maxID.next();
			this.maxID = maxID.getInt(1);

		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	/*
	 * Constructor that allows for a custom database URL, username and password
	 * @param dbURL The custom URL that points to the database, including database options
	 * @param dbUser The custom username used for the database
	 * @param dbPass The custom password used for the database
	 */
	public DatabaseConnection(String dbURL, String dbUser, String dbPass) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			dbConnection = DriverManager.getConnection(dbURL, dbUser, dbPass);
			System.out.println("Database connection successful!");
		
			String maxIDQuery = "select max(id) from login";
			Statement stmt = dbConnection.createStatement();
			ResultSet maxID = stmt.executeQuery(maxIDQuery);
			this.maxID = maxID.getInt("MaxValue");

		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	/*
	 * Used to verify that a user has entered a valid username and password combo
	 * @param uname The username that the user has entered
	 * @param pword The password that the user has entered
	 * @return True if the username/password combo exists, false if not. 
	 */
	public boolean login(String uname, String pword) {
		String queryString = "select username, password from login where username = '" 
				+ uname + "' and password = '" + pword + "'";
		try {
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery(queryString);
			if(rs.next() == false) {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	/*
	 * This function is ONLY EVER USED after the above returns true. It returns null if 
	 * some kind of mistake happened and the account doesn't exist. Returns a fully populated
	 * User object from information contained within the database.
	 */
	public User fetchUser(String username) {
		String queryString = "select * from login where username = '"
				+ username + "'";
		try {
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery(queryString);
			return new User(rs.getString("fName"),
							rs.getString("lName"),
							rs.getString("username"),
							rs.getString("email"));
		}catch(Exception e) {
			return null;
		}
	}
	/*
	 * Checks to see if the given username exists. Mostly used in the account 
	 * creation function. 
	 * @param userName The username to search for.
	 * @return True if it exists already in the database, false if not. 
	 */
	public boolean findAccount(String userName) {
		String queryString = "select username from login where username = '"
				+ userName + "'";
		try {
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery(queryString);
			if(rs.next() == false) {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	/*
	 * Adds a user into the login table of the database 
	 * @param newUser A User object containing the first name, last name, user name, and email address strings.
	 * @param pass 	  The password for that user
	 */
	public boolean addAccount(User newUser, String pass) {
		this.maxID++;
		String queryString = "insert into login values(" + this.maxID 
											+ ", '" + newUser.getFirstName()
											+ "', '" + newUser.getLastName()
											+ "', '" + newUser.getUsername()
											+ "', '" + pass
											+ "', '" + newUser.getEmail() + "')";
		try {
			Statement stmt = dbConnection.createStatement();
			stmt.executeUpdate(queryString);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	/*
	 * Closes out the connection to the database. ALWAYS call this when you are done using the database. 
	 */
	public void closeDatabaseConnection() {
		try {
			dbConnection.close();
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
}
