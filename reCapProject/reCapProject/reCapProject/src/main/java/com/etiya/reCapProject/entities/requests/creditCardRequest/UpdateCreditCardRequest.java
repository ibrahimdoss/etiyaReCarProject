package com.etiya.reCapProject.entities.requests.creditCardRequest;

import java.util.Date;

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
public class UpdateCreditCardRequest {
	
	@NotNull
	@Size(min=2,max=30)
	private String cardName;
	

	@NotNull(message = "Boş Geçilemez!")
	@Size(min=2,max=30)
	private String cardNumber;
	
	
	private Date expiration;
	
	@NotNull(message = "Boş Geçilemez!")
	@Size(min=1,max=3)
	private String cvc;
	
	private int customerId;
	
}
