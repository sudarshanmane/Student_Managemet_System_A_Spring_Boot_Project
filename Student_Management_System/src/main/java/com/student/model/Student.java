package com.student.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roll;

	@NotNull(message = "First name can not be null!")
	@NotEmpty(message = "First Name can not be Empty!")
	@NotBlank(message = "First Name can not be Blank!")
	private String first_name;
	
	@NotNull(message = "Last Name can not be null!")
	@NotEmpty(message = "Last Name can not be Empty!")
	@NotBlank(message = "Last Name can not be Blank!")
	private String last_name;
	
	@NotNull(message = "Marks can not be null!")
	private Integer marks;
	
	@NotNull(message = "Status can not be null!")
	@NotEmpty(message = "Status can not be Empty!")
	@NotBlank(message = "Status can not be Blank!")
	private String status;
	
	@Embedded
	private Address address;
	
	public Integer getRoll() {
		return roll;
	}
	public void setRoll(Integer roll) {
		this.roll = roll;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Integer getMarks() {
		return marks;
	}
	public void setMarks(Integer marks) {
		this.marks = marks;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
	@Override
	public String toString() {
		return "Student [roll=" + roll + ", first_name=" + first_name + ", last_name=" + last_name + ", marks=" + marks
				+ ", status=" + status + ", address=" + address + "]";
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Student() {
		super();
	}
	public Student(Integer roll,
			@NotNull(message = "First name can not be null!") @NotEmpty(message = "First Name can not be Empty!") @NotBlank(message = "First Name can not be Blank!") String first_name,
			@NotNull(message = "Last Name can not be null!") @NotEmpty(message = "Last Name can not be Empty!") @NotBlank(message = "Last Name can not be Blank!") String last_name,
			@NotNull(message = "Marks can not be null!") Integer marks,
			@NotNull(message = "Status can not be null!") @NotEmpty(message = "Status can not be Empty!") @NotBlank(message = "Status can not be Blank!") String status,
			Address address) {
		super();
		this.roll = roll;
		this.first_name = first_name;
		this.last_name = last_name;
		this.marks = marks;
		this.status = status;
		this.address = address;
	}
	public Student(
			@NotNull(message = "First name can not be null!") @NotEmpty(message = "First Name can not be Empty!") @NotBlank(message = "First Name can not be Blank!") String first_name,
			@NotNull(message = "Last Name can not be null!") @NotEmpty(message = "Last Name can not be Empty!") @NotBlank(message = "Last Name can not be Blank!") String last_name,
			@NotNull(message = "Marks can not be null!") Integer marks,
			@NotNull(message = "Status can not be null!") @NotEmpty(message = "Status can not be Empty!") @NotBlank(message = "Status can not be Blank!") String status,
			Address address) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.marks = marks;
		this.status = status;
		this.address = address;
	}
	
	
	
	
	
	
	

}
