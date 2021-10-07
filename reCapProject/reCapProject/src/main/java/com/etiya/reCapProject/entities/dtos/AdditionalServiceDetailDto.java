package com.etiya.reCapProject.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdditionalServiceDetailDto {
	
	private int additionalId;

	private String additionalName;
	
	private double additionalPrice;

}