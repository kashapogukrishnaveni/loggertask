package com.xworkz.signup.dto;

public class ForgotDTO {

	private String email;
	private String password;
	private String conformpassword;
	
	public ForgotDTO() {
		System.out.println("Created \t "+this.getClass().getSimpleName());
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "ForgotDTO [email=" + email + ", password=" + password + "]";
	}
	
	
}
