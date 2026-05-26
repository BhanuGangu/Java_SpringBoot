package com.example.springBootMvcProject.service.imp;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springBootMvcProject.DTO.StudentDTO;
import com.example.springBootMvcProject.entity.Student;
import com.example.springBootMvcProject.mapper.StudentMapper;
import com.example.springBootMvcProject.repository.StudentRepository;
import com.example.springBootMvcProject.service.StudentServiceInterface;

import jakarta.validation.Valid;

@Service
public class StudentService implements StudentServiceInterface {
	
	@Autowired
	private StudentRepository studentRepository;
	
	/* this method is use to fetch all records from the DB*/
	@Override
	public List<StudentDTO> getAllStudents() {
		
		List<Student> students = studentRepository.findAll();
		List<StudentDTO> studentsDtos = students.stream().map((student)-> StudentMapper.mapToStudentDto(student)).collect(Collectors.toList());
		return studentsDtos;
	}
	
	
	/* this method is used to save the single record in DB*/
	public void createStudent(StudentDTO studentDto) {
		// TODO Auto-generated method stub
		
		Student student = StudentMapper.mapToStudent(studentDto);
		studentRepository.save(student);
		
	}

	/* this is used to get the single student record*/
	public StudentDTO getStudentById(Long studentId) {
		// TODO Auto-generated method stub
		
	Student student = studentRepository.findById(studentId).get();
	StudentDTO studentDTO = StudentMapper.mapToStudentDto(student);
		return studentDTO;
	}

	/* this is update the student record in the DB */
	public void updateStudent(@Valid StudentDTO studentDTO) {
		// TODO Auto-generated method stub
		studentRepository.save(StudentMapper.mapToStudent(studentDTO));
	}

	/* this method is used to remove the student record in the DB */
	public void deleteStudent(Long studentId) {
		// TODO Auto-generated method stub
		
		studentRepository.deleteById(studentId);
		
	}

}
