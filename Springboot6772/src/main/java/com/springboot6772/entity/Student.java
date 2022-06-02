package com.springboot6772.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor


public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	
	
	@Column(length = 25,nullable = false)
	@NotBlank(message = "Please Enter Student Name")
	@Size(min = 4, max = 12, message = "Minimum character must be 4 and Maximum character should be 12")
	private String studentName;
	
	
	
	@Column(length = 25,nullable = false)
	@NotBlank(message = "Please Enter Student Email Address")
	@Email(message = "Please Enter Correct Email Address")
	private String studentEmail;
	
	
	@Column(length = 25,nullable = false)
	@NotBlank(message = "Please Enter Student Contact Number")
	@Size(min = 10, max=10, message = "Student Contact Number length should be 10 only")
	private String studentContact;
	
	@Column
	private String studentImage;
	
}