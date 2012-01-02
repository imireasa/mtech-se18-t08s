package sg.edu.nus.iss.vms.admin.vo;

public class UserManagementVo {

	private String email;
	private String password;
	private String confirmedPassword;
	private String currentPassword;
	private String message;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmedPassword() {
		return confirmedPassword;
	}

	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
	}

	public void setMessage(String string) {
		this.message = string;

	}

	public String getMessage() {
		return message;
	}

}
