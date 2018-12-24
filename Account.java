package System;

public class Account {
	
	private String username;
	private String name;
	private String surname;
	private String email;
	private String password;
	private String birthdate;
	private String nationality;
	


	
	public Account(String username2, String name2,String surname2, String email2, String password2, String birthdate2,
			String nationality2) {
		username = username2;
		name = name2;
		surname = surname2;
		email = email2;
		password = password2;
		birthdate = birthdate2;
		nationality = nationality2;
	
	}
	public String getUsername() {
		return username;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
