package com.arkr.electronicstore.models;

import jakarta.validation.constraints.NotEmpty;

public class NavitemsDto {

	@NotEmpty(message="This field is required")
	private String home;
	
	@NotEmpty(message="This field is required")
	private String deals;
	
	@NotEmpty(message="This field is required")
	private String aboutus;
	
	@NotEmpty(message="This field is required")
	private String contactus;
	
	@NotEmpty(message="This field is required")
	private String feedback;
	
	@NotEmpty(message="This field is required")
	private String service;
	
	@NotEmpty(message="This field is required")
	private String login;
	
	@NotEmpty(message="This field is required")
	private String logout;

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getDeals() {
		return deals;
	}

	public void setDeals(String deals) {
		this.deals = deals;
	}

	public String getAboutus() {
		return aboutus;
	}

	public void setAboutus(String aboutus) {
		this.aboutus = aboutus;
	}

	public String getContactus() {
		return contactus;
	}

	public void setContactus(String contactus) {
		this.contactus = contactus;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLogout() {
		return logout;
	}

	public void setLogout(String logout) {
		this.logout = logout;
	}
	
	
}
