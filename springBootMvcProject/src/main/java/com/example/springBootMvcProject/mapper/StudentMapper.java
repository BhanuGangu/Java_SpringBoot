package com.example.springBootMvcProject.mapper;

import com.example.springBootMvcProject.DTO.StudentDTO;
import com.example.springBootMvcProject.entity.Student;

public class StudentMapper {
	
	public static StudentDTO mapToStudentDto(Student student) {
		
		StudentDTO studentDTO = new StudentDTO(
				student.getId(),
				student.getFirstName(),
				student.getLastName(),
				student.getEmail()
				);
		return studentDTO;
		
	}
	
	public static Student mapToStudent(StudentDTO studentDTO) {
		Student student = new Student(
				studentDTO.getId(),
				studentDTO.getFirstName(),
				studentDTO.getLastName(),
				studentDTO.getEmail()
				); 
		return student;
	}

}
