package com.beans;

public class StudentsBean {
	
	private int apogee;
	private String firstName,lastName,email;
	private double jee_mark,cs_mark,administration_system_mark,maths_mark,mobile_dev_mark,frameworks_mark;
	public StudentsBean() {
		super();
	}
	public StudentsBean(int apogee, String firstName, String lastName, String email) {
		super();
		this.apogee = apogee;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public int getApogee() {
		return apogee;
	}
	public void setApogee(int apogee) {
		this.apogee = apogee;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	public double getJee_mark() {
		return jee_mark;
	}
	public void setJee_mark(double jee_mark) {
		this.jee_mark = jee_mark;
	}
	public double getCs_mark() {
		return cs_mark;
	}
	public void setCs_mark(double cs_mark) {
		this.cs_mark = cs_mark;
	}
	public double getAdministration_system_mark() {
		return administration_system_mark;
	}
	public void setAdministration_system_mark(double administration_system_mark) {
		this.administration_system_mark = administration_system_mark;
	}
	public double getMaths_mark() {
		return maths_mark;
	}
	public void setMaths_mark(double maths_mark) {
		this.maths_mark = maths_mark;
	}
	public double getMobile_dev_mark() {
		return mobile_dev_mark;
	}
	public void setMobile_dev_mark(double mobile_dev_mark) {
		this.mobile_dev_mark = mobile_dev_mark;
	}
	public double getFrameworks_mark() {
		return frameworks_mark;
	}
	public void setFrameworks_mark(double frameworks_mark) {
		this.frameworks_mark = frameworks_mark;
	}
	
	
	
	
	
	

}
