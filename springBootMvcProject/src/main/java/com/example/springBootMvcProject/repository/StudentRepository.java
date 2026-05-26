package com.example.springBootMvcProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springBootMvcProject.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
