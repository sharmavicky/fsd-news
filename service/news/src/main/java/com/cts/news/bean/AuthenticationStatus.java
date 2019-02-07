package com.cts.news.bean;

public class AuthenticationStatus {

	private boolean authenticated;
	private boolean admin;
	private User user;
	private String message;
     private String token;
	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public AuthenticationStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "AuthenticationStatus [authenticated=" + authenticated + "]";
	}

}
