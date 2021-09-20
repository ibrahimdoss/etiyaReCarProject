package com.etiya.reCapProject.entities.requests;



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
public class AddCustomerRequest {
	
	@NotNull(message = "Boş Geçilemez!")
	@NotBlank
	@Size(min=2,max=40)
	private String companyName;
	
	
	@NotNull(message = "Boş Geçilemez!")
	private int id;

}
