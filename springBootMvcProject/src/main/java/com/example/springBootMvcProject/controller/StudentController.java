package com.example.springBootMvcProject.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springBootMvcProject.DTO.StudentDTO;
import com.example.springBootMvcProject.service.imp.StudentService;

import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	/* this method is used to provide list of students */
	@GetMapping("/students")
	public String listStudents(Model model) {
		
		List<StudentDTO> students = studentService.getAllStudents();
		model.addAttribute("students", students);
		return "students";
		
	}
	
	/* this is method is used to create students*/
	@GetMapping("/students/new")
	public String newStudent(Model model) {
		
		StudentDTO student = new StudentDTO();
		model.addAttribute("student", student);
		return "create_student";
		
	}
	
	/* add the record in DB from the form*/
	@PostMapping("/students")
	public String saveStudent(@Valid @ModelAttribute StudentDTO student, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("student", student);
			return "create_student";
		}
		
		studentService.createStudent(student);
		return "redirect:/students";
	}
	
	/* this method is used to edit student */
	@GetMapping("/students/{studentId}/edits")
	public String editStudent(@PathVariable Long studentId, Model model) {
		
		StudentDTO student = studentService.getStudentById(studentId);
		model.addAttribute("student", student);
		return "edit_student";
		
	}
	
	/*this method is used to update the record in DB*/

	@PostMapping("/students/{studentId}")
	public String updateStudent(@PathVariable Long studentId, 
			@Valid @ModelAttribute StudentDTO studentDTO, 
			BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("student", studentDTO);
			return "edit_student";
		}
		
		studentDTO.setId(studentId);
		studentService.updateStudent(studentDTO);
		return "redirect:/students";
		
	}
	
	/* this is used to remove the record in DB*/
	@GetMapping("/students/{studentId}/delete")
	public String deleteStudent(@PathVariable Long studentId) {
		
		studentService.deleteStudent(studentId);
		return "redirect:/students";
	}
	
	/* this is used to view the record */
	@GetMapping("/students/{studentId}/view")
	public String viewStudent(@PathVariable Long studentId,
			Model model) {
		
		StudentDTO studentDto = studentService.getStudentById(studentId);
		model.addAttribute("student", studentDto);
		return "view_student";
	}
}
