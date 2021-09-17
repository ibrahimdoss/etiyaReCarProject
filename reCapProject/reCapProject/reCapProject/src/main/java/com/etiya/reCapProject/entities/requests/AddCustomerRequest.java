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
public class AddCustomerRequest {
	
	@NotNull
	@NotBlank
	private String companyName;
	
	
	@NotNull
	@NotBlank
	private int id;

}
