package com.etiya.reCapProject.entities.requests;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateApplicationUser {
	
	@NotBlank
	@NotNull(message = "Boş Geçilemez!")
	@Size(min=2,max=35)
	private String firstName;
	
	
	@NotBlank
	@NotNull(message = "Boş Geçilemez!")
	@Size(min=2,max=35)
	private String lastName;
	
	@NotBlank
	@NotNull(message = "Boş Geçilemez!")
	@Email
	private String eMail;
	

	@NotBlank
	@NotNull
	@Size(min=4,max=25)
	private String password;
}
