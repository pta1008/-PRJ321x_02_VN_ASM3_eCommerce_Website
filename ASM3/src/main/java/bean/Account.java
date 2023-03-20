package bean;

public class Account {
	private String mail;
	private String username;
	private String password;
	private String address;
	private String phonenumber;	
	private int role;
	
	public Account() {
		
	}
																	                               
		
	


	public Account(String mail, String password, int role, String username , String address, String phonenumber) {
		super();
		this.mail = mail;
		this.username = username;
		this.password = password;
		this.address = address;
		this.phonenumber = phonenumber;
		this.role = role;
	}





	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "Account [mail=" + mail + ", username=" + username + ", password=" + password + ", address=" + address
				+ ", phonenumber=" + phonenumber + ", role=" + role + "]";
	}
	
}
