package com.example.reCapProject.entities.request.update;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRepairRequest {
	
	
	@NotNull
	@NotBlank
	private int carRepairId;
	@NotNull
	@NotBlank
	private String repairDescription;
	
	@NotNull
	@NotBlank
	private String repairPrice;
	
	@NotNull
	@NotBlank
	private Date repairDate;
	
	

}
