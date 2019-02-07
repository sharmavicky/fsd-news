package com.cts.news.bean;

public class SignupStatus {

	private boolean signupStatus;
	private String message;

	public boolean isSignupStatus() {
		return signupStatus;
	}

	public void setSignupStatus(boolean signupStatus) {
		this.signupStatus = signupStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SignupStatus other = (SignupStatus) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (signupStatus != other.signupStatus)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SignupStatus [signupStatus=" + signupStatus + ", message=" + message + "]";
	}

}
