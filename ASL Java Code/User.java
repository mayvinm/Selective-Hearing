public class User {
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	
	public User(String firstName, String lastName, String username, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public String getUsername() {
		return this.username;
	}
	public String getEmail() {
		return this.email;
	}
}
