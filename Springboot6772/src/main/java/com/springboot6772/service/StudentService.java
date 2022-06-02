package com.springboot6772.service;

import com.springboot6772.entity.Student;

public interface StudentService
{
	public void addStudent(Student student);
	public Student checkLogin(String email,String contact);

}
