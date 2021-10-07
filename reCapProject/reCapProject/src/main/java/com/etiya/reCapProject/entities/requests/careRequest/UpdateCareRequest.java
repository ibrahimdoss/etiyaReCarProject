package com.etiya.reCapProject.entities.requests.careRequest;

import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCareRequest {
	
	@NotNull(message = "Boş Geçilemez!")
	private int careId;
	
	
	private String location;
	
	
	
	@NotNull(message = "Boş Geçilemez!")
	private Date startDate;
	
	@NotNull(message = "Boş Geçilemez!")
	private Date finishDate;
	
	@NotNull(message = "Boş Geçilemez!")
	private int carId;
}
