package com.arkr.electronicstore.models;

import org.springframework.web.multipart.MultipartFile;

public class CarouselDto {

	MultipartFile imageFileName;
	MultipartFile imageFileName1;
	MultipartFile imageFileName2;
	public MultipartFile getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(MultipartFile imageFileName) {
		this.imageFileName = imageFileName;
	}
	public MultipartFile getImageFileName1() {
		return imageFileName1;
	}
	public void setImageFileName1(MultipartFile imageFileName1) {
		this.imageFileName1 = imageFileName1;
	}
	public MultipartFile getImageFileName2() {
		return imageFileName2;
	}
	public void setImageFileName2(MultipartFile imageFileName2) {
		this.imageFileName2 = imageFileName2;
	}
	
	
}
