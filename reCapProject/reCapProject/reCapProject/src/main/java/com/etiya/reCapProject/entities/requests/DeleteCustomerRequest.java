package com.etiya.reCapProject.entities.requests;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeleteCustomerRequest {
	
	
	private String companyName;
	
	
	private int id;

}
