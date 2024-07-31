package com.arkr.electronicstore.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="navbar")
public class Navbar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String home;
	private String deals;
	private String aboutus;
	private String contactus;
	private String feedback;
	private String service;
	private String login;
	private String logout;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public Navbar(int id, String home, String deals, String aboutus, String contactus, String feedback, String service,
			String login, String logout) {
		super();
		this.id = id;
		this.home = home;
		this.deals = deals;
		this.aboutus = aboutus;
		this.contactus = contactus;
		this.feedback = feedback;
		this.service = service;
		this.login = login;
		this.logout = logout;
	}
	public Navbar() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Navbar [id=" + id + ", home=" + home + ", deals=" + deals + ", aboutus=" + aboutus + ", contactus="
				+ contactus + ", feedback=" + feedback + ", service=" + service + ", login=" + login + ", logout="
				+ logout + "]";
	}
	
}
