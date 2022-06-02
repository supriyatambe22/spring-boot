package com.springboot6772.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springboot6772.entity.Student;
import com.springboot6772.service.StudentService;
@Controller

public class StudentController {

	
		@Autowired
		StudentService studentService;
		
			@PostMapping("/checkLogin")
			public String checkLogin(@ModelAttribute Student student)
			{
				
				Student student2 = studentService.checkLogin(student.getStudentEmail(), student.getStudentContact());
				if(student2!=null)
				{
					return "dashboard";
				}
				else
				{
					return "login";
				}
			}
			
			@GetMapping("/login")
			public String login()
			{
				return "login";

			}
			
			@GetMapping("/home")
			public String home()
			{
				return "home";

			}

			@GetMapping("/signup")
			public String signup(Model model)
			{
				model.addAttribute("student", new Student());
				return "signup";

			}
			
			@GetMapping("/welcome")
			public String welcome()
			{
					return "welcome";
			}
			
		
			
			@PostMapping("/registerStudent")
			public String register(@Valid @ModelAttribute Student student,BindingResult result, 
					@RequestParam(value = "agreement", defaultValue = "false") boolean agreement,Model model,
					HttpSession session,@RequestParam("studentUploadImage")MultipartFile file)throws IOException
			{
				System.out.println(agreement);
					try
					{
						
					 if(result.hasErrors())
					 {
						model.addAttribute("student", student);
						 return "signup";
					 }
							 
						
						
						if(agreement)
						{
							if(file.isEmpty())
							{
								System.out.println("File is Empty !!");
							}
							else
							{
								student.setStudentImage(file.getOriginalFilename());
								File saveFile = new ClassPathResource("static/img").getFile();
								Path path = Paths.get(saveFile.getAbsolutePath()+File.separator+file.getOriginalFilename());
								Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
								System.out.println("File is Uploaded");
								
								
							}
							
							
							
							
							session.setAttribute("message1", new Message("User Is Registered Successfully !","alert-success"));
							this.studentService.addStudent(student);
							return "login";
						}
						else
						{
							session.setAttribute("message1", new Message("User Is Not Registered !!!","alert-danger"));
							throw new Exception("Kindly accept the terms and conditions !");
						}
					} 
					catch (Exception e) 
					{
						System.out.println(e);
					}

					
					return "signup";
			}
			
	}
