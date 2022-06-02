package com.springboot6772.serviceimplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot6772.entity.Student;
import com.springboot6772.repository.StudentRepo;
import com.springboot6772.service.StudentService;

@Service
public class StudentServiceImplentation implements StudentService
{
		@Autowired
		StudentRepo studentRepo;
		

		@Override
		public void addStudent(Student student)
		{
			this.studentRepo.save(student);
			
		}


		@Override
		public Student checkLogin(String email, String contact)
		{
			return studentRepo.findByStudentEmailAndStudentContact(email, contact);
		
		}


		

	}

