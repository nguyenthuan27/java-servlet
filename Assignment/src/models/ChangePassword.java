package models;

public class ChangePassword {
	private String username;
	private String password;
	private String newpass;
	private String comfirmpass;
	public ChangePassword() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChangePassword(String username, String password, String newpass, String comfirmpass) {
		super();
		this.username = username;
		this.password = password;
		this.newpass = newpass;
		this.comfirmpass = comfirmpass;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNewpass() {
		return newpass;
	}
	public void setNewpass(String newpass) {
		this.newpass = newpass;
	}
	public String getComfirmpass() {
		return comfirmpass;
	}
	public void setComfirmpass(String comfirmpass) {
		this.comfirmpass = comfirmpass;
	}
	
	
	
}
