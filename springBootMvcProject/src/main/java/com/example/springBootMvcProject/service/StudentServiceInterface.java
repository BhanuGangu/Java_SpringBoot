package com.example.springBootMvcProject.service;

import java.util.List;

import com.example.springBootMvcProject.DTO.StudentDTO;

import jakarta.validation.Valid;

public interface StudentServiceInterface {
	
	List<StudentDTO> getAllStudents();
	
	void createStudent(StudentDTO student);
	
	StudentDTO getStudentById(Long studentId);
	
	void updateStudent(@Valid StudentDTO studentDTO);
	
	void deleteStudent(Long studentId);

}
