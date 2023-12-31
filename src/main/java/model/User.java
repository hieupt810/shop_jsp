package model;

public class User {

	private int user_id;
	private String username;
	private String password;
	private java.sql.Date date_of_birth;
	private String sex;
	private String email;
	private String phone_number;
	private String address;
	private String role;

	public User() {
	}

	public User(int user_id, String username, String password, java.sql.Date date_of_birth, String sex,
			String email,
			String phone_number, String address,
			String role) {
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.date_of_birth = date_of_birth;
		this.sex = sex;
		this.email = email;
		this.phone_number = phone_number;
		this.address = address;
		this.role = role;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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

	public java.sql.Date getNgaysinh() {
		return date_of_birth;
	}

	public void setNgaysinh(java.sql.Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getGioitinh() {
		return sex;
	}

	public void setGioitinh(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSdt() {
		return phone_number;
	}

	public void setSdt(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getDiachi() {
		return address;
	}

	public void setDiachi(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
