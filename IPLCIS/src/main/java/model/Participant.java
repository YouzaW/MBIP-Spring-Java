package model;

import java.io.Serializable;

public class Participant implements Serializable {
	private int id;
	private String email;
	private String password;
	private long icNum;
	private long phoneNum;
	private String status;
	private String address;
	private String category;
	private int accessLevel;
	
	
	private boolean loggedIn = false;
	
	public Participant() {
		email = "";
	}
	public Participant(String email, String password, long icNum, long phoneNum, String status, String address, String category, int accessLevel) {
		super();
		this.email = email;
		this.password = password;
		this.icNum = icNum;
		this.phoneNum = phoneNum;
		this.status = status;
		this.address = address;
		this.category = category;
		this.accessLevel = accessLevel;
		
	}
	
	
	public int getAccessLevel() {
		return accessLevel;
	}
	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;
	}
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public long getIcNum() {
		return icNum;
	}
	public void setIcNum(long icNum) {
		this.icNum = icNum;
	}
	public long getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(long phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}