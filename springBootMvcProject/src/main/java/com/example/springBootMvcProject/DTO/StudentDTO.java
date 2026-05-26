package com.example.springBootMvcProject.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
	
	private long id;
	@NotEmpty(message = "Student first name should not be empty")
	private String firstName;
	@NotEmpty(message = "Student last name should not be empty")
	private String lastName;
	@NotEmpty(message = "Student email should not be empty")
	@Email
	private String email;

}
