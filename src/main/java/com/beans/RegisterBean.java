package com.beans;

public class RegisterBean {
	
	String firstName,lastName,email,password,subject;

	public RegisterBean() {
		super();
	}

	public RegisterBean(String firstName, String lastName, String password, String email, String subject) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.subject = subject;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	

}
