package com.arkr.electronicstore.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="carousel")
public class Carousel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String imageFileName;
	private String imageFileName1;
	private String imageFileName2;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public String getImageFileName1() {
		return imageFileName1;
	}
	public void setImageFileName1(String imageFileName1) {
		this.imageFileName1 = imageFileName1;
	}
	public String getImageFileName2() {
		return imageFileName2;
	}
	public void setImageFileName2(String imageFileName2) {
		this.imageFileName2 = imageFileName2;
	}
	public Carousel(int id, String imageFileName, String imageFileName1, String imageFileName2) {
		super();
		this.id = id;
		this.imageFileName = imageFileName;
		this.imageFileName1 = imageFileName1;
		this.imageFileName2 = imageFileName2;
	}
	public Carousel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Carousel [id=" + id + ", imageFileName=" + imageFileName + ", imageFileName1=" + imageFileName1
				+ ", imageFileName2=" + imageFileName2 + "]";
	}
	
	
	
}
