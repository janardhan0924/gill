package com.arkr.electronicstore.models;

import jakarta.validation.constraints.NotEmpty;

public class VerticalNavbarDto {

	@NotEmpty(message="This field is required")
	private String heading1;
	
	@NotEmpty(message="This field is required")
	private String heading2;
	
	@NotEmpty(message="This field is required")
	private String heading3;
	
	@NotEmpty(message="This field is required")
	private String heading4;
	
	@NotEmpty(message="This field is required")
	private String heading5;
	
	@NotEmpty(message="This field is required")
	private String heading6;

	public String getHeading1() {
		return heading1;
	}

	public void setHeading1(String heading1) {
		this.heading1 = heading1;
	}

	public String getHeading2() {
		return heading2;
	}

	public void setHeading2(String heading2) {
		this.heading2 = heading2;
	}

	public String getHeading3() {
		return heading3;
	}

	public void setHeading3(String heading3) {
		this.heading3 = heading3;
	}

	public String getHeading4() {
		return heading4;
	}

	public void setHeading4(String heading4) {
		this.heading4 = heading4;
	}

	public String getHeading5() {
		return heading5;
	}

	public void setHeading5(String heading5) {
		this.heading5 = heading5;
	}

	public String getHeading6() {
		return heading6;
	}

	public void setHeading6(String heading6) {
		this.heading6 = heading6;
	}
	
	
}
