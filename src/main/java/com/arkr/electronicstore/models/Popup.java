package com.arkr.electronicstore.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

	@Entity
	@Table(name="popup")

	public class Popup {
		
		
			@Id
			@GeneratedValue(strategy=GenerationType.IDENTITY)
			private int id;
			private String name;
			
			@Column(columnDefinition="TEXT")
			private String description;
			private String imageFileName;
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public String getDescription() {
				return description;
			}
			public void setDescription(String description) {
				this.description = description;
			}
			public String getImageFileName() {
				return imageFileName;
			}
			public void setImageFileName(String imageFileName) {
				this.imageFileName = imageFileName;
			}
			public Popup(int id, String name, String description, String imageFileName) {
				super();
				this.id = id;
				this.name = name;
				this.description = description;
				this.imageFileName = imageFileName;
			}
			public Popup() {
				super();
				// TODO Auto-generated constructor stub
			}
			@Override
			public String toString() {
				return "Popup [id=" + id + ", name=" + name + ", description=" + description + ", imageFileName="
						+ imageFileName + "]";
			}
			
			

}
