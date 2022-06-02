package com.springboot6772.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot6772.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>
{

		public Student findByStudentEmailAndStudentContact(String email, String password);
	}

