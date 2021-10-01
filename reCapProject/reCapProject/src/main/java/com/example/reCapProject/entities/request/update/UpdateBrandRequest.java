package com.example.reCapProject.entities.request.update;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBrandRequest {
	
	private int brandId;
	
	@NotNull
	@NotBlank
	private String brandName;

}
