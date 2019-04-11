import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DatabaseConnection {
	private Connection dbConnection;
	private int maxID;
	public DatabaseConnection() {		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			dbConnection = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/loginDB?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=America/New_York", "root", "");
			System.out.println("Database connection successful!");
		
			String maxIDQuery = "select max(id) from login as 'MaxValue'";
			Statement stmt = dbConnection.createStatement();
			ResultSet maxID = stmt.executeQuery(maxIDQuery);
			this.maxID = maxID.getInt("MaxValue");

		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
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
		return null;
	}
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
	public boolean addAccount(User newUser, String pass) {
		this.maxID++;
		String queryString = "insert into login (id, fName, lName, username, password, email)"
						   + " values (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement prepStmt = dbConnection.prepareStatement(queryString);
			prepStmt.setInt(1,  this.maxID);
			prepStmt.setString(2, newUser.getFirstName());
			prepStmt.setString(3, newUser.getLastName());
			prepStmt.setString(4, newUser.getUsername());
			prepStmt.setString(5, pass);
			prepStmt.setString(6, newUser.getEmail());
			prepStmt.execute();
			return true;
		}catch(Exception e) {
			return false;
		}
		return false;
	}
	public void closeDatabaseConnection() {
		try {
			dbConnection.close();
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
}
