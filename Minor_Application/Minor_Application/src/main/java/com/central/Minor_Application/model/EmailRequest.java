package com.central.Minor_Application.model;

public class EmailRequest {
	
	private String to;

	public EmailRequest(String to) {
		super();
		this.to = to;
	}

	public EmailRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	@Override
	public String toString() {
		return "EmailRequest [to=" + to + "]";
	}

}
