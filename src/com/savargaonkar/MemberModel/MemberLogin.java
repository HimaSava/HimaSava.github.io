package com.savargaonkar.MemberModel;

public class MemberLogin {
	private int id;
	private String password;
	
	public MemberLogin() {
		super();
	}

	public MemberLogin(int id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
