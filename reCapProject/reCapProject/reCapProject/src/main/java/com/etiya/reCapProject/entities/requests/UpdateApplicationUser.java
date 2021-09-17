package com.etiya.reCapProject.entities.requests;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateApplicationUser {
	
	@NotNull
	@NotBlank
	private String firstName;
	
	
	@NotNull
	@NotBlank
	private String lastName;
	
	
	@NotNull
	@NotBlank
	private String eMail;
	
	
	@NotNull
	@NotBlank
	private String password;
}
