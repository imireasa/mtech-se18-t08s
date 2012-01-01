package sg.edu.nus.iss.vms.web.security;

public class LoginCommand {

	private String username;
	private String password;
	private String requestedUrl;

	public String getRequestedUrl() {
		return requestedUrl;
	}

	public void setRequestedUrl(String requestedUrl) {
		this.requestedUrl = requestedUrl;
	}

	public LoginCommand() {
	}


	public LoginCommand(String username, String password, String requestedUrl) {
		super();
		this.username = username;
		this.password = password;
		this.requestedUrl = requestedUrl;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;

	}

}
