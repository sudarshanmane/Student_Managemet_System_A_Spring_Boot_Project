package com.student.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class Address {
	
	@NotNull(message = "State can not be null!")
	@NotEmpty(message = "State can not be Empty!")
	@NotBlank(message = "State can not be Blank!")
	private String state;
	
	@NotNull(message = "City can not be null!")
	@NotEmpty(message = "City can not be Empty!")
	@NotBlank(message = "City can not be Blank!")
	private String city;
	
	@NotNull(message = "Pincode can not be null!")
	@NotEmpty(message = "Pincode can not be Empty!")
	@NotBlank(message = "Pincode can not be Blank!")
	private String pincode;

	public Address(
			@NotNull(message = "State can not be null!") @NotEmpty(message = "State can not be Empty!") @NotBlank(message = "State can not be Blank!") String state,
			@NotNull(message = "City can not be null!") @NotEmpty(message = "City can not be Empty!") @NotBlank(message = "City can not be Blank!") String city,
			@NotNull(message = "Pincode can not be null!") @NotEmpty(message = "Pincode can not be Empty!") @NotBlank(message = "Pincode can not be Blank!") String pincode) {
		super();
		this.state = state;
		this.city = city;
		this.pincode = pincode;
	}

	public Address() {
		super();
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [state=" + state + ", city=" + city + ", pincode=" + pincode + "]";
	}
	
	
	
	
}
